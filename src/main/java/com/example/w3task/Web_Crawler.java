package com.example.w3task;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Web_Crawler {
    private static final int MAX_DEPTH = 50;
    private static final int MAX_Threads = 100;

    private final static Set<String> visitedUrls = new HashSet<>();

    public void crawl (String url , int depth){
        if(depth>MAX_DEPTH || visitedUrls.contains(url)){
            return;
        }

        visitedUrls.add(url);

        System.out.println("Crawling : " + url);
        try{
            Document docks = Jsoup.connect(url).get();
            processPage(docks);

            Elements links = docks.select("a[href]");
            for(Element link :links){
                String nextUrl =link.absUrl("href");
                crawl(nextUrl,depth+1);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void processPage(Document document){
        System.out.println("Procesing page: " + document.title());
    }

    public void startCrawling(String[] seedUrls){
        ExecutorService service = Executors.newFixedThreadPool(MAX_Threads);
        for(String url:seedUrls){
            service.execute(() -> crawl(url , 0));
        }

        service.shutdown();
        try{
            service.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        }catch (InterruptedException  e){
            e.printStackTrace();
        }
        System.out.println("Crawling created");
    }

    public static void main(String[] args) {
        String[] seedUrls = {
                "https://www.w3resource.com/java-exercises/thread/index.php",
                "https://www.youtube.com/watch?v=1Qta-Wmeh5Y&t=912s",
                "https://portal.bitlab.kz/my/courses.php",
                "https://www.youtube.com/watch?v=1Qta-Wmeh5Y&t=912s",
                "https://2gis.kz/almaty/search/%D1%88%D0%BA%D0%BE%D0%BB%D0%B0%20%D0%BF%D1%80%D0%BE%D0%B3%D1%80%D0%B0%D0%BC%D0%BC%D0%B8%D1%80%D0%BE%D0%B2%D0%B0%D0%BD%D0%B8%D1%8F/rubricId/678?m=76.936219%2C43.260778%2F16.66",
                "https://web.telegram.org/k/#@FreeZnanijaArchive",
        };


        Web_Crawler w1 = new Web_Crawler();
        w1.startCrawling(seedUrls);
    }
}

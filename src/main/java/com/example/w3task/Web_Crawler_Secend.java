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

public class Web_Crawler_Secend {
    // так
    private static final int Max_Depth = 5;
    private static final int Mex_Thread = 10;


    private static final Set<String> visitUrls = new HashSet<>();

    public void crawl(String url , int depth){
        if(depth >Max_Depth ||visitUrls.contains(url)){
            return;
        }
        visitUrls.add(url);
        System.out.println("Ссылки :" + url);

        try{
            Document doc = Jsoup.connect(url).get();

            processPage(doc);
            Elements links = doc.select("a[href]");
            for(Element link :links){
                String nextUrl = link.absUrl("href");
                crawl(nextUrl,depth+1);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void processPage(Document document){
        System.out.println("Ссылка : " + document.title());
    }

    public void startCrawling(String[] seedUrls){
        ExecutorService service = Executors.newFixedThreadPool(Mex_Thread);
        for (String url : seedUrls){
            service.execute(() -> crawl(url , 0));
        }
        service.shutdown();

        try{
            service.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Crawling created");


    }


    public static void main(String[] args) {
        String[] urls ={
                "https://www.w3resource.com/java-exercises/thread/index.php",
                "https://www.youtube.com/watch?v=1Qta-Wmeh5Y&t=912s",
                "https://portal.bitlab.kz/my/courses.php",
                "https://www.youtube.com/watch?v=1Qta-Wmeh5Y&t=912s",
                "https://2gis.kz/almaty/search/%D1%88%D0%BA%D0%BE%D0%BB%D0%B0%20%D0%BF%D1%80%D0%BE%D0%B3%D1%80%D0%B0%D0%BC%D0%BC%D0%B8%D1%80%D0%BE%D0%B2%D0%B0%D0%BD%D0%B8%D1%8F/rubricId/678?m=76.936219%2C43.260778%2F16.66",
                "https://web.telegram.org/k/#@FreeZnanijaArchive",
                "https://almaty.hh.kz/search/vacancy?text=java&salary=&ored_clusters=true&enable_snippets=true&area=160&hhtmFrom=vacancy_search_list&hhtmFromLabel=vacancy_search_line",
        };
        Web_Crawler_Secend w1 = new Web_Crawler_Secend();
        w1.startCrawling(urls);
    }
}

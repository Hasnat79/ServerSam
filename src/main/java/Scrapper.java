import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Scrapper {
    public static void main(String[] args) {

        Document doc = null;
        try {
            //doc = Jsoup.connect("http://172.16.50.4/FTP-2/English%20Movies%20%281080p%29/%282017%29%201080p/")
            doc = Jsoup.connect("https://larsjung.de/h5ai/demo/").get();
            //doc = Jsoup.connect("http://en.wikipedia.org").get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Elements names = doc.select("li.item").not("li.folder-parent");
        Elements names = doc.getElementsByTag("a");
        //Elements names = doc.select("li.item.folder");
        //System.out.println( names.first().text() );

        for (Element name : names) {
            System.out.println( (name.text()) );

            //ParseData movie = new ParseData(name.text());
            //System.out.println("Name : " + movie.getName());
        }

    }
}

package SCRAPPER;

import DBMS.DBConnect;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class Scrapper {
    public static void main(String[] args) {

        String baseURL = "http://172.16.50.4/FTP-2/English%20Movies%20%281080p%29/";

        Document doc;
        File file = new File("src/main/resources/DataBase.db");
        file.delete();
        DBConnect.createNewDatabase();

        for (int year = 1996; year <= 2018; year++) {

            String finalURL = baseURL + "%28" + year + "%29%201080p/";
            doc = null;

            try {
                //doc = Jsoup.connect("http://172.16.50.4/FTP-2/English%20Movies%20%281080p%29/%282017%29%201080p/").get();
                doc = Jsoup.connect(finalURL).get();
                //doc = Jsoup.connect("https://larsjung.de/h5ai/demo/").get();

            } catch (IOException e) {
                e.printStackTrace();
            }


            Elements names = doc.getElementsByTag("a");

            for (Element name : names) {
                //SCRAPPER.ParseData movie = new SCRAPPER.ParseData(name.text());
                //System.out.println( name.text() );

                SCRAPPER.ParseData movie = new SCRAPPER.ParseData(name.text());
                movie.pushData();

            }
        }

    }
}

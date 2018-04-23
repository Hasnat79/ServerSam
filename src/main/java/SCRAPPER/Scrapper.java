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

        File file = new File("src/main/resources/DataBase.db");
        file.delete();
        DBConnect.createNewDatabase();

        // For 1080p Video
        // Special Case
        scrap("http://172.16.50.4/FTP-2/English%20Movies%20%281080p%29/%281995%29%201080p%20%26%20Before/");
        // Regular
        for (int year = 1996; year <= 2018; year++) {
            String finalURL = baseURL + "%28" + year + "%29%201080p/";
            scrap(finalURL);
        }


        baseURL = "http://172.16.50.4/FTP-2/English%20Movies/";


        // For 720p
        //Special Case
        scrap("http://172.16.50.4/FTP-2/English%20Movies/%281995%29%20%26%20Before/");
        //Regular
        for (int year = 1996; year <= 2018; year++) {
            String finalURL = baseURL + "%28" + year + "%29/";
            scrap(finalURL);
        }

    }


    public static void scrap(String URL) {
        Document doc = null;

        try {
            doc = Jsoup.connect(URL).get();
        } catch (IOException e) {
            e.printStackTrace();
        }


        Elements names = doc.getElementsByTag("a");

        for (Element name : names) {
            //SCRAPPER.ParseData movie = new SCRAPPER.ParseData(name.text());
            System.out.println(name.text());

            SCRAPPER.ParseData movie = new SCRAPPER.ParseData(name.text());
            movie.pushData();

        }

    }
}

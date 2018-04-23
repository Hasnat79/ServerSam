package TMDB;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class TMDBconnect {

    public static void main(String[] args) {

        Gson gson = new Gson();

        try {
            //URL url = new URL("https://api.themoviedb.org/3/movie/550?api_key=909af28891cff6bfe9ea2fea81fc5426");
            URL url = new URL("https://api.themoviedb.org/3/search/movie?api_key=909af28891cff6bfe9ea2fea81fc5426&query=Oldboy&year=2003");
            //URL url = new URL("https://api.themoviedb.org/3/search/movie?api_key=909af28891cff6bfe9ea2fea81fc5426&query=up&year=2009");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            BufferedReader jsonFile = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String json = jsonFile.readLine().trim();

            System.out.println(json);

            Response response = gson.fromJson(json, Response.class);


            System.out.println(response.getResults().get(0).getTitle());
            System.out.println();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}

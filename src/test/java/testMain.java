import TMDB.TMDBconnect;

public class testMain {

    public static void main(String[] args) {

        TMDBconnect tmdb = new TMDBconnect("909af28891cff6bfe9ea2fea81fc5426");

        tmdb.findMovie("Oldboy", 2013);
    }
}

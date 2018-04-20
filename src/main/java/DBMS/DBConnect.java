package DBMS;

import java.sql.*;

public class DBConnect {

    public static Connection getConnection() throws SQLException {

        try {
            Class.forName("org.sqlite.JDBC");
            return DriverManager.getConnection("jdbc:sqlite:src/main/resources/DataBase.db");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static void createNewDatabase() {

        try {
            getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String url = "jdbc:sqlite:src/main/resources/DataBase.db";

        String createTable = "    CREATE TABLE Movie_List                   " +
                "            (                                              " +
                "                    ID INTEGER PRIMARY KEY AUTOINCREMENT,  " +
                "                    Movie_Name TEXT,                       " +
                "                    Year int,                              " +
                "                    Quality TEXT                           " +
                "            );                                             ";

        try (Connection conn = DriverManager.getConnection(url)) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");

            Statement state = conn.createStatement();
            state.execute(createTable);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

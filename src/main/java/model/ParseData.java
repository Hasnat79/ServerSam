package model;

import util.DBConnect;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ParseData {

    private String name;

    private int year;

    private String quality;

    private boolean validData = false;

    public ParseData(String _fullTitle) {
        if (_fullTitle.contains("(") && _fullTitle.contains(")")) {
            String[] splitted = _fullTitle.split("[\\(\\)]");
            name = splitted[0].trim();

            try {
                year = Integer.parseInt(splitted[1].trim());
            } catch (NumberFormatException e) {
                year = Integer.parseInt(splitted[3]);
            }
            try {
                quality = splitted[2].trim().split(" ")[0].replaceAll("[\\[\\]]", "");

            } catch (ArrayIndexOutOfBoundsException e) {
                quality = "";
            }
            validData = true;
        }
    }

    public void pushData() {
        if (validData) {
            Connection connect;
            try {
                connect = DBConnect.getConnection();
                //System.out.println("Inside SQL :" + name + " " + year + " " + quality);
                Statement state = connect.createStatement();
                state.execute(" INSERT INTO Movie_List (Movie_Name, Year, Quality) VALUES ( \"" + name + "\"" + "," + year + ", \"" + quality + "\")");

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public String getQuality() {
        return quality;
    }

    public boolean getDataValidity() {
        return validData;
    }
}

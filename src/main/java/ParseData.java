public class ParseData {

    private String name;
    private int year;
    private String quality;
    private boolean validData = false;

    ParseData(String _fullTitle) {
        if (_fullTitle.contains("(") && _fullTitle.contains(")")) {
            String[] splitted = _fullTitle.split("[\\(\\)]");
            name = splitted[0].trim();
            //year = Integer.parseInt(splitted[1].trim());
            quality = splitted[2].trim();
            validData = true;
        } else {
            name = "Error !";
            validData = false;
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

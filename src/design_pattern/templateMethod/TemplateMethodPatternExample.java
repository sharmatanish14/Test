package design_pattern.templateMethod;

abstract class DataParserTemplate {

    public final void parse() {
        openFile();
        parseData();
        closeFile();
    }

    protected void openFile() {
        System.out.println("Opening the file");
    }

    protected void closeFile() {
        System.out.println("Closing the file");
    }

    abstract void parseData();
}

class CSVParser extends DataParserTemplate{
    @Override
    void parseData() {
        System.out.println("Parsing the CSV file");
    }
}

class JsonParser extends DataParserTemplate{
    @Override
    void parseData() {
        System.out.println("Parsing the json file");
    }
}

public class TemplateMethodPatternExample {

    public static void main(String[] args) {

        DataParserTemplate csvParser = new CSVParser();
        DataParserTemplate jsonParser = new JsonParser();

        csvParser.parse();
        jsonParser.parse();
    }
}

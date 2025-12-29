package utilites;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class datautils {
    private static final String Test_data_path = "src/test/resources/testdata/";

    //Todo: reading data from json file
    public static String getjsondata(String jsonfilename, String filed) throws FileNotFoundException {
        try {
            FileReader reader = new FileReader(Test_data_path + jsonfilename + ".json");
            JsonElement jsonElement = JsonParser.parseReader(reader);
            return jsonElement.getAsJsonObject().get(filed).getAsString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    // Todo: reading data from properties file
    public static String propertiesfile(String filename, String value) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream(Test_data_path + filename + ".properties"));
        return properties.getProperty(value);
    }
}
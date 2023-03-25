package data;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class AddCustomerData {
    private WebDriver driver;
    public AddCustomerData(WebDriver driver){
        this.driver = driver;
    }

    public String firstName , lastName , postCode;

    public void UserData() throws IOException, ParseException {
        String srcFilePath = System.getProperty("user.dir")+"/src/test/java/data/AddCustomerData.json";
        File file = new File(srcFilePath);

        JSONParser parser = new JSONParser();
        JSONArray JArray = (JSONArray) parser.parse(new FileReader(file));

        for (Object object : JArray){
            JSONObject person = (JSONObject) object;
            firstName = (String) person.get("firstName");
            lastName = (String) person.get("lastName");
            postCode = (String) person.get("postCode");

        }
    }
}

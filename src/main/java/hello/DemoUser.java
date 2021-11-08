package hello;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DemoUser {
    public static void process() throws IOException {
        String fileName = "./src/test/resources/user.json";
        String json = DemoUser.readJsonAsString(fileName);
        String xml = DemoUser.jsonToInlineXml(json);
        System.out.println(xml);
    }

    private static String readJsonAsString(String fileName) throws IOException {
        String json = new String(Files.readAllBytes(Paths.get(fileName)));
        return json;
    }

    private static String jsonToInlineXml(String json){
        final  String arrayElement = "Item";
        String inlineXml = "";
        json = json.replaceAll("\\s+",""); // remove all space and break line
        String items = json.substring(1, json.length()-1);//remove "{}"
        System.out.println(items);
        for (String item : items.split(",") ){
            String[] parts = item.split(":");
            item = " " + parts[0].replace("\"","") + "=" + parts[1];
            inlineXml = inlineXml + item;
        };
        inlineXml = "<"+arrayElement + inlineXml + "/>";
        return inlineXml;
    }
}

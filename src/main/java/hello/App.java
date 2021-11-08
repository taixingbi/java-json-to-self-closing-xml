package hello;

//import org.json.JSONObject;
//import org.json.XML;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        System.out.println("----------app----------");
        DemoInventory.process();
//        DemoUser.process();

        System.out.println("----------app end----------");
    }
}

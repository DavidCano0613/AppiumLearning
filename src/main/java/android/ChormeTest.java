package android;

import io.appium.java_client.android.AndroidDriver;
public class ChormeTest extends BaseChorme {
    // Tu código aquí
    public static void main(String[] args) throws Exception {
        AndroidDriver driver = Capabilities();

        driver.get("https://www.google.com/");


    }
}
package ios;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;

public class testTwo extends iOSXCUITestOptions {
    public static void main(String[] args) throws Exception {
        IOSDriver driver = capabilities();
        System.out.println(driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == \"Alert Views\"`]")).isDisplayed());
    }
}
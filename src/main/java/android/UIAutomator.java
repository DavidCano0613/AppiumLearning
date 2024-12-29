package android;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

import java.util.concurrent.TimeUnit;

public class UIAutomator extends BaseAndroidRealDeviceCapabilities {
    public static void main(String[] args) throws Exception {
        AndroidDriver driver = capabilities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Views\")")).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        System.out.println(driver.findElements(AppiumBy.androidUIAutomator("new UiSelector().clickable(true)")).size());
        System.out.println(driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().textContains(\"Drop\")")).isDisplayed());
        System.out.println(driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().textStartsWith(\"Drag\")")).isDisplayed());
        System.out.println(driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().textMatches(\"^Expandable.*\")")).isDisplayed());

    }
}
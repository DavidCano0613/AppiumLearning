package android;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WebViews extends UIAutomator2Options {
    public static void main(String[] args) throws Exception {
        AndroidDriver driver = capabilities();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Views\")")).click();

        WebElement scrollTextIntoView = driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollTextIntoView(\"WebView\")"));
        System.out.println(scrollTextIntoView.isDisplayed());

        scrollTextIntoView.click();

        Set<String> contexts = driver.getContextHandles();
        for (String contextName : contexts) {
            System.out.println(contextName);
        }

        driver.context("WEBVIEW_io.appium.android.apis");

        System.out.println(driver.findElement(new By.ByCssSelector("h1")).getText());

        driver.switchTo().defaultContent();
        driver.navigate().back();
    }
}
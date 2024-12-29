package gestures.script;

import android.BaseAndroidRealDeviceCapabilities;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class executeScriptWithAppiumDriver extends BaseAndroidRealDeviceCapabilities {
    public static void main(String[] args) throws Exception {
        AppiumDriver driver = capabilities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Views\")")).click();

        WebElement scrollableElement = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().scrollable(true)"));
        System.out.println(((RemoteWebElement) scrollableElement).getId());

        Map<String, Object> argumentos = new HashMap<>();
        argumentos.put("elementId", ((RemoteWebElement) scrollableElement).getId());
        argumentos.put("direction", "down");
        argumentos.put("percent", "1");
        driver.executeScript("mobile: scrollGesture", argumentos);
    }
}
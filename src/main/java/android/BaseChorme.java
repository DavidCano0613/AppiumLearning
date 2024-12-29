package android;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseChorme {
    public static AndroidDriver Capabilities() throws MalformedURLException {
        // Configuración de DesiredCapabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browserName", "Chrome");
        caps.setCapability("appium:deviceName", "Android Device");
        caps.setCapability("appium:automationName", "uiautomator2");
        caps.setCapability("appium:platformVersion", "13");
        caps.setCapability("appium:chromedriverExecutable", "/Users/juandavidpaniaguacano/Downloads/chromedriver-mac-arm64/chromedriver");

        return new AndroidDriver(new URL("http://127.0.0.1:4723"), caps);

    }

    // Tu código aquí
    public static void main(String[] args) throws Exception {
    }
}
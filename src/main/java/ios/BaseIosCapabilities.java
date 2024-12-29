package ios;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseIosCapabilities {
    public static IOSDriver capabilities() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("appium:deviceName", "iPhone 16 Pro Max");
        capabilities.setCapability("appium:platformVersion", "18.0");
        capabilities.setCapability("appium:app", "/Users/juandavidpaniaguacano/UIKitCatalog.app");
        capabilities.setCapability("appium:automationName", "XCUITest");
        return new IOSDriver(new URL("http://127.0.0.1:4723"), capabilities);
    }

}
package android;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class WithActivity {
    public static AndroidDriver Capabilities() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:automationName", "uiautomator2");
        caps.setCapability("appium:deviceName", "Galaxy_A14");
        caps.setCapability("appium:platformVersion", "13");
        caps.setCapability("appPackage", "io.appium.android.apis");  // Paquete de la aplicación
        caps.setCapability("appActivity", "io.appium.android.apis.preference.PreferenceDependencies");  // Actividad principal de la aplicación

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);

        return driver;
    }

    public static void main(String[] args) throws Exception {
        Capabilities();
    }
}

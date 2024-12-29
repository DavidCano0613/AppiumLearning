package android;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseAndroidRealDeviceCapabilities {
    public static AndroidDriver capabilities() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();

//      Required capabilities
        caps.setCapability("platformName", "Android"); //Specifies the operating system. Example: "Android".
        caps.setCapability("appium:platformVersion", "13"); //Android version on the device.
        caps.setCapability("appium:app", "/Users/juandavidpaniaguacano/src/appium_learning/src/main/java/resources/ApiDemos-debug.apk"); //Path or URL of the APK file of the application to test.
        caps.setCapability("appium:automationName", "uiautomator2"); // Defines the automation engine. For Android, UiAutomator2 or Espresso are commonly used. Example: "UiAutomator2".

//      Optional capabilities
//        caps.setCapability("appium:deviceName", "Android Device"); // Device name, use "adb devices" in console to see your devices
//        caps.setCapability("appPackage", "io.appium.android.apis"); // Application package, use an app like apk info or apk analyzer to find it
//        caps.setCapability("appActivity", "io.appium.android.apis.preference.PreferenceDependencies"); // Main Activity (Screen) to be launched when opening the app. (App package, use an app like apk info or apk analyzer to find it)
//        caps.setCapability("appium:fullContextList", "false"); // Whether to search for all available WebView contexts.
//        caps.setCapability("appium:fullReset", "true"); // Reinstall the app and clear data, cache, etc. to test from a clean state, ideal for onboarding or initial setup tests.
//        caps.setCapability("appium:noReset", "false"); // If set to true, application data will not be cleared when the test starts.
//        caps.setCapability("appium:disableAndroidWatchers", "false"); // Disables Android watchers, enhancing performance in long tests and preventing interruptions when no alerts are expected.
//        caps.setCapability("appium:", "");

        return new AndroidDriver(new URL("http://127.0.0.1:4723"), caps);
    }
}
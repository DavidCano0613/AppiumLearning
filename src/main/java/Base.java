import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Base {

    public static AndroidDriver Capabilities(String appPath) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        return  new AndroidDriver(new URL("http://127.0.0.1:4723"), caps);
    }
}

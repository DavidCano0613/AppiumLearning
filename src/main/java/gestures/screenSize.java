package gestures;

import android.BaseAndroidRealDeviceCapabilities;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.PointerInput;

import java.util.concurrent.TimeUnit;

public class screenSize extends BaseAndroidRealDeviceCapabilities {
    public static void main(String[] args) throws Exception {
        AndroidDriver driver = capabilities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Views\")")).click();

        System.out.println(driver.manage().window().getSize());
        System.out.println(PointerInput.Origin.viewport());

        Dimension dimension = driver.manage().window().getSize();
        System.out.println(dimension.getHeight());
        System.out.println(dimension.getWidth());
        System.out.println(dimension.height);
        System.out.println(dimension.width);

    }
}

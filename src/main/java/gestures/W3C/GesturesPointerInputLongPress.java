package gestures.W3C;

import android.BaseAndroidRealDeviceCapabilities;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class GesturesPointerInputLongPress extends BaseAndroidRealDeviceCapabilities {
    public static void main(String[] args) throws Exception {
        AppiumDriver driver = capabilities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Views\")")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Expandable Lists\")")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"1. Custom Adapter\")")).click();

        WebElement element = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"People Names\")"));

        // Obtener la posición del elemento en la pantalla
        Point elementLocation = element.getLocation();
        int x = elementLocation.getX() + (element.getSize().getWidth() / 2);
        System.out.println(x);
        int y = elementLocation.getY() + (element.getSize().getHeight() / 2);
        System.out.println(y);

        // Long Press:
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence longPress = new Sequence(finger, 1);
        longPress.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), x, y));
        longPress.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        longPress.addAction(new Pause(finger, Duration.ofSeconds(2)));
        longPress.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(longPress));

        System.out.println(driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Sample menu\")")).isDisplayed());
    }
}

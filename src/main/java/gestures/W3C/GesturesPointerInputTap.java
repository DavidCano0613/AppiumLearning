package gestures.W3C;

import android.BaseAndroidRealDeviceCapabilities;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class GesturesPointerInputTap extends BaseAndroidRealDeviceCapabilities {
    public static void main(String[] args) throws Exception {
        AppiumDriver driver = capabilities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Views\")")).click();

        WebElement element = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Expandable Lists\")"));

        // Obtener la posición del elemento en la pantalla
        Point elementLocation = element.getLocation();
        int x = elementLocation.getX() + (element.getSize().getWidth() / 2);
        System.out.println(x);
        int y = elementLocation.getY() + (element.getSize().getHeight() / 2);
        System.out.println(y);

        // Tap:
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence tap = new Sequence(finger, 1);
        tap.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), x, y));
        tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(tap));



    }
}

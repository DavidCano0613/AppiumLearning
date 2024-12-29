package gestures.W3C;

import android.BaseAndroidRealDeviceCapabilities;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class PointerScroll2 extends BaseAndroidRealDeviceCapabilities {
    public static void main(String[] args) throws Exception {
        AndroidDriver driver = capabilities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Views\")")).click();

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

        Sequence sequenceOfActions = new Sequence(finger, 1);

        Dimension dimension = driver.manage().window().getSize();
        Point center = new Point(dimension.width / 2, dimension.height / 2);
        Dimension dimension2 = new Dimension(dimension.width / 2, dimension.height / 2);

        sequenceOfActions.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), center.getX(), center.getY()));

        sequenceOfActions.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

        sequenceOfActions.addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), center.getX(), center.getY() - 1800));

        sequenceOfActions.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(sequenceOfActions));
    }
}
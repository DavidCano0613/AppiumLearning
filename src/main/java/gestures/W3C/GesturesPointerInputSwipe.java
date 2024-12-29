package gestures.W3C;

import android.BaseAndroidRealDeviceCapabilities;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class GesturesPointerInputSwipe extends BaseAndroidRealDeviceCapabilities {
    public static void main(String[] args) throws Exception {
        AndroidDriver driver = capabilities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Views\")")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Date Widgets\")")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().description(\"2. Inline\")")).click();

        // Localizar los elementos de inicio y fin del swipe
        WebElement startElement = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().description(\"12\")"));
        WebElement endElement = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().description(\"7\")"));

        // Obtener las coordenadas del primer elemento (inicio del swipe)
        int startX = startElement.getLocation().getX() + (startElement.getSize().getWidth() / 2);
        int startY = startElement.getLocation().getY() + (startElement.getSize().getHeight() / 2);

        // Obtener las coordenadas del segundo elemento (final del swipe)
        int endX = endElement.getLocation().getX() + (endElement.getSize().getWidth() / 2);
        int endY = endElement.getLocation().getY() + (endElement.getSize().getHeight() / 2);

        // Crear el PointerInput para representar el "dedo"
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

        // Crear la secuencia de acciones para el swipe
        Sequence swipe = new Sequence(finger, 1);

        // Mover el "dedo" al punto inicial
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, startY));

        // Presionar la pantalla
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

        // Mover el "dedo" al punto final
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), endX, endY));

        // Levantar el "dedo"
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        // Ejecutar la secuencia
        driver.perform(Collections.singletonList(swipe));

    }
}

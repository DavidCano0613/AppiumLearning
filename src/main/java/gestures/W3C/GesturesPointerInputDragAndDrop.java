package gestures.W3C;

import android.BaseAndroidRealDeviceCapabilities;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class GesturesPointerInputDragAndDrop extends BaseAndroidRealDeviceCapabilities {
    public static void main(String[] args) throws Exception {
        AppiumDriver driver = capabilities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Views\")")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Drag and Drop\")")).click();

        // Localizar los elementos del drag y el drop
        WebElement source = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));
        WebElement target = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_2"));

        // Obtener las coordenadas del elemento origen
        int startX = source.getLocation().getX() + (source.getSize().getWidth() / 2);
        int startY = source.getLocation().getY() + (source.getSize().getHeight() / 2);

        // Obtener las coordenadas del elemento destino
        int endX = target.getLocation().getX() + (source.getSize().getWidth() / 2);
        int endY = target.getLocation().getY() + (source.getSize().getHeight() / 2);

        // Crear el PointerInput para representar el "dedo"
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

        // Crear la secuencia de acciones para el swipe
        Sequence dragAndDrop = new Sequence(finger, 1);

        // Mover el "dedo" al punto inicial
        dragAndDrop.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, startY));

        // Presionar la pantalla
        dragAndDrop.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        dragAndDrop.addAction(new Pause(finger, Duration.ofSeconds(2)));

        // Mover el "dedo" al punto final
        dragAndDrop.addAction(finger.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), endX, endY));

        // Levantar el "dedo"
        dragAndDrop.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        // Ejecutar la secuencia
        driver.perform(Collections.singletonList(dragAndDrop));
    }
}
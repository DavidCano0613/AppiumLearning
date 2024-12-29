package gestures.W3C;

import android.BaseAndroidRealDeviceCapabilities;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class PointerScroll extends BaseAndroidRealDeviceCapabilities {
    public static void main(String[] args) throws Exception {
        AndroidDriver driver = capabilities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Views\")")).click();

        // PointerInput: Representa un dispositivo de entrada, un dedo en este caso
        // PointerInput.Kind.TOUCH: Indica que es un dispositivo táctil.
        // "finger": Es un identificador para este dispositivo (puede ser cualquier string, pero aquí se usa "finger" para representar un dedo).
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

        // Crear una secuencia de acciones para el gesto de scroll
        Sequence sequenceOfActions = new Sequence(finger, 1);

        // Punto inicial del scroll (centro de la pantalla)
        int startX = driver.manage().window().getSize().width / 2;
        System.out.println(driver.manage().window().getSize().width);
        System.out.println(startX);
        int startY = (int) (driver.manage().window().getSize().height * 0.8);
        System.out.println(driver.manage().window().getSize().height);
        System.out.println(startY);

        // Punto final del scroll (hacia arriba, más arriba en la pantalla)
        int endX = startX;
        int endY = (int) (driver.manage().window().getSize().height * 0.2);
        System.out.println(endY);

        // Mover el "dedo" al punto inicial
        sequenceOfActions.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));

        // Presionar la pantalla
        sequenceOfActions.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

        // Mover el "dedo" al punto final
        sequenceOfActions.addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), endX, endY));

        // Levantar el "dedo"
        sequenceOfActions.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        // Ejecutar la secuencia
        driver.perform(Collections.singletonList(sequenceOfActions));
    }
/*
    4. ¿Por qué es necesario usar la clase Sequence?

    La clase Sequence permite definir una serie de acciones consecutivas (en este caso, para simular un gesto táctil).

    Sin Sequence: Cada acción como createPointerMove, createPointerDown, y createPointerUp es independiente, por lo que sería difícil coordinar gestos complejos como swipes, zoom, o gestos multitáctiles.

    Con Sequence: Puedes combinar múltiples acciones (mover, presionar, levantar) en un solo flujo lógico y ejecutarlas como un gesto continuo. Esto es especialmente importante para gestos táctiles que requieren una ejecución precisa.
*/
}
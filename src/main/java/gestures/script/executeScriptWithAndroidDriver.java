package gestures.script;

import android.BaseAndroidRealDeviceCapabilities;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class executeScriptWithAndroidDriver extends BaseAndroidRealDeviceCapabilities {
    public static void main(String[] args) throws Exception {
        AndroidDriver driver = capabilities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Views\")")).click();

        WebElement scrollableElement = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().scrollable(true)"));
        System.out.println(((RemoteWebElement) scrollableElement).getId());

//      Se crea un contenedor de pares clave valor para almacenar los parametros necesarios para ejecutar el gesto
        Map<String, Object> argumentos = new HashMap<>();

//      Se obtiene el id del elemento desplazable, es necesario hacer el casteo ya que RemoteWebElement contiene el metodo getId()
        argumentos.put("elementId", ((RemoteWebElement) scrollableElement).getId());

//      Indica la direccion en la que se hagara el gesto
        argumentos.put("direction", "down");

//       Valor: "1", que indica el porcentaje de la pantalla que se desplazará.
//        "1" desplaza tpdo el tamaño visible del contenedor desplazable.
//        "0.5" desplazará solo el 50% del tamaño visible.
        argumentos.put("percent", "1");

//      El primer argumento ("mobile: scrollGesture") indica que se ejecutará un gesto de desplazamiento móvil y el segundo argumento son los parametros construidos anteriormente con los que se hara ese gesto
        driver.executeScript("mobile: scrollGesture", argumentos);
    }
}
package broswerStack;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class BrowserStackTest {
    public static void main(String[] args) throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();

        // Credenciales de BrowserStack
        caps.setCapability("browserstack.user", "davidpaniaguacan_HfozNc");
        caps.setCapability("browserstack.key", "zx64VEL25nZiuDfGVkeT");

        // Configuración de dispositivo y app
        caps.setCapability("device", "Samsung Galaxy A14");
        caps.setCapability("os_version", "13.0");
        caps.setCapability("app", "bs://4c7b75ac00aed946bb0b64372ffc17bbd6d4093a");

        // URL del servidor BrowserStack
        URL url = new URL("http://hub.browserstack.com");

        // Iniciar driver
        AndroidDriver driver = new AndroidDriver(url, caps);

        // Prueba simple
        System.out.println("Lanzando la app...");
        Thread.sleep(5000);

        driver.quit();
        System.out.println("Prueba completada");
    }
}

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;

import java.net.URL;

public class iOSXCUITestOptions {

    public static IOSDriver capabilities() throws Exception {
        // Configuramos las opciones para iOS
        XCUITestOptions options = new XCUITestOptions();
        options.setPlatformName("iOS");
        options.setDeviceName("iPhone 15 Pro Max");
        options.setPlatformVersion("16.4"); // Versión de iOS
        options.setApp("/Users/juandavidpaniaguacano/UIKitCatalog.app"); // Ruta de tu aplicación
        options.setAutomationName("XCUITest");
        options.setNoReset(false); // Para no resetear la app en cada inicio

        // Creamos el driver con las opciones
        IOSDriver driver = new IOSDriver(new URL("http://localhost:4723/wd/hub"), options);

        // Tu código de automatización
        System.out.println("iOS automation started!");

        return driver;
    }
}

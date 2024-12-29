package ios;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import java.net.URL;

public class iOSXCUITestOptions {
    public static IOSDriver capabilities() throws Exception {
        // Crear un objeto de tipo XCUITestOptions
        XCUITestOptions options = new XCUITestOptions();

        // Configuración de las capacidades
        options.setDeviceName("iPhone 16 Pro Max");
        options.setPlatformVersion("18.0");
        options.setApp("/Users/juandavidpaniaguacano/UIKitCatalog.app");
        options.setAutomationName("XCUITest");

        // Crear la instancia de IOSDriver con las opciones configuradas
        return new IOSDriver(new URL("http://127.0.0.1:4723/"), options);
    }

}

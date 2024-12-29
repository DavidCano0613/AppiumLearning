package android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.URL;

public class UIAutomator2Options {
    public static AndroidDriver capabilities() throws Exception {
        // Crear las opciones para UiAutomator2
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("Samsung_A14"); // Nombre del dispositivo/emulador
        options.setPlatformVersion("13.0"); // Versión de Android
        options.setApp("/Users/juandavidpaniaguacano/src/appium_learning/src/main/java/resources/ApiDemos-debug.apk"); // Ruta al APK de tu app
        options.setAutomationName("UiAutomator2"); // Opcional, ya que se asume por defecto
        options.setNoReset(false); // No reiniciar los datos de la app

        // Crear el driver de Appium
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

        // Realiza tus acciones aquí
        System.out.println("Sesión iniciada con éxito!");
        return driver;
    }
}
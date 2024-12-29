package ios;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;

public class testOne extends BaseIosCapabilities {
    public static void main(String[] args) throws Exception {
        IOSDriver driver = capabilities();

        System.out.println(driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == \"Alert Views\"`]")).isDisplayed());

//        1. Desplazamiento con scroll usando Appium (con iOS)
//        driver.findElement(By.id("element_id")).sendKeys(Keys.DOWN);  // Desplazar hacia abajo

//        2. Usando XCUITest (para aplicaciones iOS con Appium)
//        Desplazamiento hacia arriba o abajo:
//        driver.executeScript("mobile: scroll", ImmutableMap.of("direction", "down"));

//        Usando el comando mobile: swipe de Appium:
//        Map<String, Object> swipeObject = new HashMap<>();
//        swipeObject.put("startX", 300);
//        swipeObject.put("startY", 1000);
//        swipeObject.put("endX", 300);
//        swipeObject.put("endY", 300);
//        swipeObject.put("duration", 1000);
//        driver.executeScript("mobile: swipe", swipeObject);

//        3. Desplazamiento en un WebView (para aplicaciones híbridas o web));
//        String script = "window.scrollBy(0, 250);";  // Desplazarse 250 píxeles hacia abajo
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript(script);

//        4. Desplazamiento con UIScrollView (si es una app nativa de iOS)
//        driver.executeScript("mobile: scroll", ImmutableMap.of("direction", "down", "element", elementId));
    }
}

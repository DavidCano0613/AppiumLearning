package android;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class UIAutomatorScroll extends BaseAndroidRealDeviceCapabilities {
    public static void main(String[] args) throws Exception {
        AndroidDriver driver = capabilities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Views\")")).click();

//        WebElement scrollIntoView = driver.findElement(AppiumBy.androidUIAutomator(
//                "new UiScrollable(new UiSelector().scrollable(true))" +
//                        ".scrollIntoView(new UiSelector().text(\"WebView\"))"));
//        System.out.println(scrollIntoView.isDisplayed());

//        WebElement scrollTextIntoView = driver.findElement(AppiumBy.androidUIAutomator(
//                "new UiScrollable(new UiSelector().scrollable(true))" +
//                        ".scrollTextIntoView(\"WebView\")"));
//        System.out.println(scrollTextIntoView.isDisplayed());

//        WebElement scrollDescriptionIntoView = driver.findElement(AppiumBy.androidUIAutomator(
//                "new UiScrollable(new UiSelector().scrollable(true))" +
//                        ".scrollDescriptionIntoView(\"WebView\")"));
//        System.out.println(scrollDescriptionIntoView.isDisplayed());

//        WebElement scrollForward = driver.findElement(AppiumBy.androidUIAutomator(
//                "new UiScrollable(new UiSelector().scrollable(true)).scrollForward()"));
//        System.out.println(scrollForward.isDisplayed());

//        WebElement scrollBackward = driver.findElement(AppiumBy.androidUIAutomator(
//                "new UiScrollable(new UiSelector().scrollable(true)).scrollBackward()"));
//        System.out.println(scrollBackward.isDisplayed());
//
//        WebElement flingForward = driver.findElement(AppiumBy.androidUIAutomator(
//                "new UiScrollable(new UiSelector().scrollable(true)).flingForward()"));
//        System.out.println(flingForward.isDisplayed());
//
//        WebElement flingBackward = driver.findElement(AppiumBy.androidUIAutomator(
//                "new UiScrollable(new UiSelector().scrollable(true)).flingBackward()"));
//        System.out.println(flingBackward.isDisplayed());
//
//        WebElement flingToEnd = driver.findElement(AppiumBy.androidUIAutomator(
//                "new UiScrollable(new UiSelector().scrollable(true)).flingToEnd(5)"));
//        System.out.println(flingToEnd.isDisplayed());
//
//        WebElement flingToBeginning = driver.findElement(AppiumBy.androidUIAutomator(
//                "new UiScrollable(new UiSelector().scrollable(true)).flingToBeginning(5)"));
//        System.out.println(flingToBeginning.isDisplayed());
//
//        WebElement scrollToEnd = driver.findElement(AppiumBy.androidUIAutomator(
//                "new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(5)"));
//        System.out.println(scrollToEnd.isDisplayed());
//
//        WebElement scrollToBeginning = driver.findElement(AppiumBy.androidUIAutomator(
//                "new UiScrollable(new UiSelector().scrollable(true)).scrollToBeginning(5)"));
//        System.out.println(scrollToBeginning.isDisplayed());


        List<WebElement> list = driver.findElements(AppiumBy.androidUIAutomator("new UiSelector().clickable(true)"));
        for (WebElement i : list){
            System.out.println(i.getText());
        }

//        Investigar:
//        getChildByText()

//        setAsHorizontalList()
//        Cambia la orientación del desplazamiento a horizontal.
//        Uso típico:
//        Trabajar con galerías, carruseles de imágenes, o listas horizontales.
//

//        setSwipeDeadZonePercentage
//        setMaxSearchSwipes

//
    }
}

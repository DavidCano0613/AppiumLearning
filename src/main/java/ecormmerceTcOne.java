import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class ecormmerceTcOne extends Base {
    public static void main(String[] args) throws Exception {
        AndroidDriver driver = Capabilities("/Users/juandavidpaniaguacano/src/appium_learning/src/main/java/General-Store.apk");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Hello");
        driver.hideKeyboard();
        driver.findElement(By.xpath("//*[@text='Female']")).click();
        driver.findElement(By.id("android:id/text1")).click();

        WebElement element = driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().textContains(\"Argentina\"))"));

        element.click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

//        String message = driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");
//        System.out.println(message);

        WebElement productElement = driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\"))" +
                        ".scrollIntoView(new UiSelector().textMatches(\"Jordan 6 Rings\").instance(0))"));

        System.out.println(productElement.isDisplayed());

        int count = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
        String textProductList = "";

        for (int i = 0; i <= count; i++) {
             textProductList = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
            if (textProductList.equalsIgnoreCase("Jordan 6 Rings")) {
                driver.findElement(By.id("com.androidsample.generalstore:id/productAddCart")).click();
                break;
            }
        }
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

        String textCheckOutProduct = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();

        System.out.println(textProductList.equalsIgnoreCase(textCheckOutProduct));


        WebElement checkBox = driver.findElement(By.className("android.widget.CheckBox"));

        Point elementLocation = checkBox.getLocation();
        int x = elementLocation.getX() + (checkBox.getSize().getWidth() / 2);
        int y = elementLocation.getY() + (checkBox.getSize().getHeight() / 2);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence tap = new Sequence(finger, 1);
        tap.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), x, y));
        tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(tap));

//        WebElement terms = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
//        Sequence longPress = new Sequence(finger, 2);
//        longPress.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), (terms.getLocation().getX() + (terms.getSize().getWidth())), (terms.getLocation().getY() + (terms.getSize().getHeight()))));
//        longPress.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//        longPress.addAction(new Pause(finger, Duration.ofSeconds(3)));
//        longPress.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//        driver.perform(Collections.singletonList(longPress));
//        driver.findElement(By.id("android:id/button1")).click();

        driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();

        Thread.sleep(3000);
        Set<String> contextHandles = driver.getContextHandles();
        for (String contextName : contextHandles) {
            System.out.println(contextName);
        }
        driver.context("WEBVIEW_com.androidsample.generalstore");
        driver.findElement(By.name("q")).sendKeys("hello");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.switchTo().defaultContent();
    }
}
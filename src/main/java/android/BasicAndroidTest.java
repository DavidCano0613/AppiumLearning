package android;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class BasicAndroidTest extends UIAutomator2Options {
    public static void main(String[] args) throws Exception {
//      Invoca las capabilities
        AndroidDriver driver = capabilities();
        driver.findElement(By.xpath("//android.widget.TextView[@text='Preference']")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text='3. Preference dependencies']")).click();
        driver.findElement(By.id("android:id/checkbox")).click();

//      click on second index
        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();

        driver.findElement(By.className("android.widget.EditText")).sendKeys("Testing");

        driver.findElements(By.className("android.widget.Button")).get(1).click();
    }
}
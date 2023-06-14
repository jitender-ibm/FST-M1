package activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.security.Key;
import java.time.Duration;

public class Activity2 {
    AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.noReset();

        URL serverURL = new URL("http://localhost:4724/wd/hub");
        driver = new AndroidDriver(serverURL, options);
        driver.get("https://www.training-support.net/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @Test
    public void multiplyTest() throws InterruptedException {

        /*driver.findElement(AppiumBy.id("url_bar")).sendKeys("https://www.training-support.net/"+"\n");
        Thread.sleep(5000);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));*/
        String heading = driver.findElement(AppiumBy.xpath("//android.view.View/android.widget.TextView[@index='2']")).getText();
        System.out.println("The heading is: " + heading);
        driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc=\"About Us\"]")).click();
        String heading2 = driver.findElement(AppiumBy.xpath("//android.view.View/android.widget.TextView[@index='2']")).getText();
        System.out.println("The new heading is: " + heading2);
    }
    
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

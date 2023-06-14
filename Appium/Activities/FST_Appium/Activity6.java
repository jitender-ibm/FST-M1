package activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class Activity6 {
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
        driver.get("https://www.training-support.net/selenium/lazy-loading");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @Test
    public void multiplyTest() throws InterruptedException {
        Thread.sleep(5000);
        List<WebElement> imageElements = driver.findElements(AppiumBy.xpath("//android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.widget.Image"));
        System.out.println("The number of images before scrolling was: " + imageElements.size());
        String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
        driver.findElement(AppiumBy.androidUIAutomator(UiScrollable + ".scrollIntoView(new UiSelector().xpath(\"android.widget.TextView[@text = ' helen']\")"));

        List<WebElement> newImageElements = driver.findElements(AppiumBy.xpath("//android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.widget.Image"));
        System.out.println("The number of images before scrolling was: " + newImageElements.size());
        Thread.sleep(3000);
        //Assertion
        Assert.assertEquals(newImageElements.size(), 5);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

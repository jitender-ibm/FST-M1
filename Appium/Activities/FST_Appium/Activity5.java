package activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Activity5 {
    AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.apps.messaging");
        options.setAppActivity("com.google.android.apps.messaging.ui.ConversationListActivity");
        options.noReset();

        URL serverURL = new URL("http://localhost:4724/wd/hub");

        driver = new AndroidDriver(serverURL, options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void multiplyTest() {
        driver.findElement(AppiumBy.id("start_chat_fab")).click();
        driver.findElement(AppiumBy.id("recipient_text_view")).sendKeys("9876543210");
        //driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        driver.pressKey(new KeyEvent(AndroidKey.TAB));
        driver.findElement(AppiumBy.id("compose_message_text")).sendKeys("Hello from Appium");
        driver.findElement(AppiumBy.id("message_indicator")).click();
        String sentMessage = driver.findElement(AppiumBy.id("message_text")).getText();

        // Assertion
        Assert.assertEquals(sentMessage, "Hello from Appium");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

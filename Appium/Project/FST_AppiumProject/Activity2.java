package testPackage;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Activity2 {
    AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.keep");
        options.setAppActivity(".activities.BrowseActivity");
        options.noReset();

        URL serverURL = new URL("http://localhost:4724/wd/hub");
        driver = new AndroidDriver(serverURL, options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void addingFirstTask() {
        String title = "Test title";
        String note = "Test Note";
        driver.findElement(AppiumBy.id("new_note_button")).click();
        driver.findElement(AppiumBy.id("editable_title")).sendKeys(title);
        driver.findElement(AppiumBy.id("edit_note_text")).sendKeys(note);
        driver.findElement(AppiumBy.accessibilityId("Navigate up")).click();
        String resultTitle = driver.findElement(AppiumBy.xpath("//androidx.cardview.widget.CardView[@content-desc=\""+title+". "+note+". \"]/android.widget.LinearLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.TextView[1]")).getText();
        String resultNote = driver.findElement(AppiumBy.xpath("//androidx.cardview.widget.CardView[@content-desc=\""+title+". "+note+". \"]/android.widget.LinearLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.TextView[2]")).getText();

        // Assertion
        Assert.assertEquals(resultTitle, title);
        Assert.assertEquals(resultNote, note);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

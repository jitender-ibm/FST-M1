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

public class Activity1 {
    AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.apps.tasks");
        options.setAppActivity(".ui.TaskListsActivity");
        options.noReset();

        URL serverURL = new URL("http://localhost:4724/wd/hub");

        driver = new AndroidDriver(serverURL, options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void addingFirstTask() {
        String task = "Complete Activity with Google Tasks";
        driver.findElement(AppiumBy.id("tasks_fab")).click();
        driver.findElement(AppiumBy.id("add_task_title")).sendKeys(task);
        driver.findElement(AppiumBy.id("add_task_done")).click();
        String result = driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@content-desc=\""+task+"\"]/android.view.ViewGroup/android.widget.TextView")).getText();
        System.out.println("The result text is: " + result);
        // Assertion
        Assert.assertEquals(result, task);
    }

    @Test
    public void addingSecondTask() {
        String task = "Complete Activity with Google Keep";
        driver.findElement(AppiumBy.id("tasks_fab")).click();
        driver.findElement(AppiumBy.id("add_task_title")).sendKeys(task);
        driver.findElement(AppiumBy.id("add_task_done")).click();
        String result = driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@content-desc=\""+task+"\"]/android.view.ViewGroup/android.widget.TextView")).getText();
        System.out.println("The result text is: " + result);
        // Assertion
        Assert.assertEquals(result, task);
    }

    @Test
    public void addingThirdTask() {
        String task = "Complete the second Activity Google Keep";
         driver.findElement(AppiumBy.id("tasks_fab")).click();
        driver.findElement(AppiumBy.id("add_task_title")).sendKeys(task);
        driver.findElement(AppiumBy.id("add_task_done")).click();
        String result = driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@content-desc=\""+task+"\"]/android.view.ViewGroup/android.widget.TextView")).getText();
        System.out.println("The result text is: " + result);
        // Assertion
        Assert.assertEquals(result, task);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

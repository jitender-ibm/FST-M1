package testPackage;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Activity3 {
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
        driver.get("https://www.training-support.net/selenium");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @Test
    public void multiplyTest() throws InterruptedException {
        String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
        String task1 = "Add tasks to list";
        String task2 = "Get number of tasks";
        String task3 = "Clear the list";

        driver.findElement(AppiumBy.androidUIAutomator(UiScrollable + ".scrollTextIntoView(\"To-Do List\")")).click();
        //driver.findElement(AppiumBy.androidUIAutomator(UiScrollable + ".scrollIntoView(new UiSelector().text(\"To-Do List\"))")).click();
        Thread.sleep(5000);
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id= 'taskInput']")).sendKeys(task1);
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text= 'Add Task']")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id= 'taskInput']")).sendKeys(task2);
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text= 'Add Task']")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id= 'taskInput']")).sendKeys(task3);
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text= 'Add Task']")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\""+task1+"\"]")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\""+task2+"\"]")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\""+task3+"\"]")).click();
        Thread.sleep(3000);
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Clear List']")).click();

        boolean temp = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\""+task1+"\"]")).isDisplayed();
        if (!temp)
            System.out.println("Test is passed");
        else
            System.out.println("Test is failed");
    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

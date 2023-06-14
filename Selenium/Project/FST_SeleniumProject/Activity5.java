package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity5 {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void initialization() {
        //Disabling logs
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        //Set up for the firefox driver
        WebDriverManager.firefoxdriver().setup();
        //Initializing the firefox driver
        driver = new FirefoxDriver();
        //Initializing the WebDriverWait for explicit wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        //implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        //Navigating to the website
        driver.get("https://alchemy.hguy.co/crm/");
    }

    @Test
    public void gettingColorsOfTheElement(){
        //explicit wait for the company logo to be displayed on landing page
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.companylogo")));
        //Entering value in the fields of login screen
        driver.findElement(By.cssSelector("#user_name")).sendKeys("admin");
        driver.findElement(By.cssSelector("#username_password")).sendKeys("pa$$w0rd");
        //Clicking on Submit button
        driver.findElement(By.id("bigbutton")).click();
        //explicit wait for the nav planner on dashboard to be displayed
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("ul.nav-dashboard")));
        WebElement element = driver.findElement(By.cssSelector("div.desktop-toolbar"));
        //Getting the color value of menubar using getcssvalue
        String colorValue = element.getCssValue("color");
        System.out.println("The color value of the menu bar is: " + colorValue);
    }

    @AfterClass
    public void closeBrowser(){
        //closing the driver
        driver.close();

    }
}

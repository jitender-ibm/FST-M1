package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity1 {

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
    public void verifyTheWebsiteTitle(){
        //explicit wait for the company logo to be displayed on landing page
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.companylogo")));
        //Getting the Page Title
        String websiteTitle =  driver.getTitle();
        System.out.println("The website title is: " + websiteTitle);
        //Verifying the title with expected value
        Assert.assertEquals(websiteTitle, "SuiteCRM");
    }

    @AfterClass
    public void closeBrowser(){
        //closing the driver
        driver.close();
    }
}

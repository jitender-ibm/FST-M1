package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity3 {

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
    public void GetTheCopyrightText(){
        //explicit wait for the company logo to be displayed on landing page
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.companylogo")));
        //Getting the copyright text of the element
        String copyrightText =  driver.findElement(By.id("admin_options")).getText();
        System.out.println("The copyright text is: " + copyrightText);
    }

    @AfterClass
    public void closeBrowser(){
        //closing the driver
        driver.close();
    }
}

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
import java.util.List;

public class Activity7 {

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
    public void gettingPhoneNumbers(){
        //explicit wait for the company logo to be displayed on landing page
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.companylogo")));
        //Entering value in the fields of login screen
        driver.findElement(By.cssSelector("#user_name")).sendKeys("admin");
        driver.findElement(By.cssSelector("#username_password")).sendKeys("pa$$w0rd");
        //Clicking on Submit button
        driver.findElement(By.id("bigbutton")).click();
        //explicit wait for the nav planner on dashboard to be displayed
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("ul.nav-dashboard")));
        //Clicking on the sales button in menu bar
        driver.findElement(By.xpath("//li[@class = 'topnav']/span/a[text() = 'Sales']")).click();
        //Clicking on the Leads option under Sales menu
        driver.findElement(By.xpath("//a[text() = 'Sales']/following-sibling::ul/li/a[text() = 'Leads']")).click();
        //explicit wait for the data table to be displayed
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.suitepicon-action-info")));
        //Getting all info icons and saving to a list of webelements
        List<WebElement> infoIcon = driver.findElements(By.cssSelector("span.suitepicon-action-info"));
        int counter = 1;
        for(WebElement icon: infoIcon) {
            icon.click();
            //Getting the mobile number displayed in the opened popup
            String mobileNumber = driver.findElement(By.xpath("(//div[@id = 'content']//b[contains(text(), 'Mobile:')]/following-sibling::span)[" + counter + "]")).getText();
            System.out.println("The mobile number for row " + counter + " is: " + mobileNumber);
            //Click on the close button of the opened popup
            driver.findElement(By.xpath("(//div[text()= 'Additional Details']/parent::span/following-sibling::button[@title= 'Close'])[" + counter + "]")).click();
            counter = counter + 1;
        }
    }

    @AfterClass
    public void closeBrowser(){
        //closing the driver
        driver.close();
    }
}

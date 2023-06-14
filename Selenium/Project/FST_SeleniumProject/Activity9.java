package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Activity9 {

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
    public void gettingNameWithLeads(){
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
        //Getting all names and saving to a list of webelements
        List<WebElement> names = driver.findElements(By.xpath("//a[@class= 'edit-link']/parent::td/following-sibling::td[@field= 'name']"));
        for(WebElement name: names) {
            String nameOfTheLeads = name.getText();
            //Getting the assigned user corresponding to the names
            String assignedUserForLead = driver.findElement(By.xpath("//a[contains(text(), '"+nameOfTheLeads+"')]/ancestor::td/following-sibling::td[@field= 'assigned_user_name']/a")).getText();
            System.out.println("The lead name is: " + nameOfTheLeads + " and the assigned user is : " + assignedUserForLead);
        }
    }

    @AfterTest
    public void quitingDriver(){
        //quitting the driver
        driver.quit();
    }
}

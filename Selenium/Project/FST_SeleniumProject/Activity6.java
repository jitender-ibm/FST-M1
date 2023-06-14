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

public class Activity6 {

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
    public void checkingTheMenuOption(){
        //explicit wait for the company logo to be displayed on landing page
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.companylogo")));
        //Entering value in the fields of login screen
        driver.findElement(By.cssSelector("#user_name")).sendKeys("admin");
        driver.findElement(By.cssSelector("#username_password")).sendKeys("pa$$w0rd");
        //Clicking on Submit button
        driver.findElement(By.id("bigbutton")).click();
        //explicit wait for the nav planner on dashboard to be displayed
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("ul.nav-dashboard")));
        WebElement element = driver.findElement(By.xpath("//li[@class = 'topnav']/span/a[text() = 'Activities']"));
        //Verifying if the element named 'Activities' is displayed in the menubar
        Boolean flag = element.isDisplayed();
        if (flag) {
            System.out.println("'Activities' in the menu option has been displayed");
        } else {
            System.out.println("'Activities' in the menu option is not being displayed");
        }
    }

    @AfterClass
    public void closeBrowser(){
        //closing the driver
        driver.close();
    }
}

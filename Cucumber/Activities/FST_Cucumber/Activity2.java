package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity2 {
    WebDriver driver;
    WebDriverWait wait;

    @Given("^User is on Login page$")
    public void userIsOnGooglePage() throws Throwable {
        System.setProperty("webdriver.gecko.driver","C:\\Users\\meins\\Downloads\\geckodriver\\geckodriver.exe");
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        WebDriverManager.firefoxdriver().setup();
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        //Open the browser
        driver.get("https://www.training-support.net/selenium/login-form");
    }

    @When("^User enters username and password$")
    public void userTypesInCheeseAndHitsENTER() throws Throwable {
        driver.findElement(By.cssSelector("#username")).sendKeys("admin");
        driver.findElement(By.cssSelector("#password")).sendKeys("password");
        driver.findElement(By.xpath("//button[text() = 'Log in']")).click();
    }

    @Then("^Read the page title and confirmation message$")
    public void showHowManySearchResultsWereShown() throws Throwable {
        System.out.println("The page title is: " + driver.getTitle());
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#action-confirmation")));
        System.out.println("The login message is: " + driver.findElement(By.cssSelector("#action-confirmation")).getText());
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
    }
}
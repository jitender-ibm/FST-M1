package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity3 {
    WebDriver driver;
    WebDriverWait wait;
    Alert alert;

    @Given("User is on the page")
    public void userIsOnThePage() {
        {
            System.setProperty("webdriver.gecko.driver","C:\\Users\\meins\\Downloads\\geckodriver\\geckodriver.exe");
            System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
            //Create a new instance of the Firefox driver
            driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            wait = new WebDriverWait(driver, Duration.ofSeconds(15));

            //Open the browser
            driver.get("https://www.training-support.net/selenium/javascript-alerts");
        }
    }

    @When("User clicks the Simple Alert button")
    public void userClicksTheSimpleAlertButton() {
        driver.findElement(By.id("simple")).click();
    }

    @Then("Alert opens")
    public void alertOpens() {
        alert = driver.switchTo().alert();
    }

    @And("Read the text from it and print it")
    public void readTheTextFromItAndPrintIt() {
        String alertText = alert.getText();
        System.out.println("The text of the alert is: " + alertText);
    }

    @And("Close the alert")
    public void closeTheAlert() {
        alert.accept();
    }

    /*@And("Read the result text")
    public void readTheResultText() {
        String resultText = driver.findElement(By.cssSelector("p#result")).getText();
        System.out.println(resultText);
    }*/

    @And("Close Browser")
    public void closeBrowser() {
        driver.close();
    }

    @When("User clicks the Confirm Alert button")
    public void userClicksTheConfirmAlertButton() {
        driver.findElement(By.id("confirm")).click();
    }

    @And("Close the alert with Cancel")
    public void closeTheAlertWithCancel() {
        alert.dismiss();
    }

    @And("Write a custom message in it")
    public void writeACustomMessageInIt() {
        alert.sendKeys("Test Message");
    }

    @When("User clicks the Prompt Alert button")
    public void userClicksThePromptAlertButton() {
        driver.findElement(By.id("prompt")).click();
    }
}

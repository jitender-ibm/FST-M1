import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Assignment16 {
    public static <WebElements> void main(String[] args) throws InterruptedException {
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        driver.get("https://training-support.net/selenium/dynamic-attributes");
        System.out.println("Main page title: " + driver.getTitle());

        WebElement usrName = driver.findElement(By.cssSelector("input[class$=username]"));
        WebElement passWrd = driver.findElement(By.cssSelector("input[class$=password]"));
        WebElement cnfrmPasswrd = driver.findElement(By.xpath("//label[text()= 'Confirm Password']/../input"));
        WebElement email = driver.findElement(By.cssSelector("input[name^=email]"));
        WebElement signUpBtn = driver.findElement(By.cssSelector("button[onclick^=signUp]"));

        usrName.sendKeys("test");
        passWrd.sendKeys("password");
        cnfrmPasswrd.sendKeys("password");
        email.sendKeys("test@email.com");
        signUpBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#action-confirmation")));
        if (driver.findElement(By.cssSelector("#action-confirmation")).isDisplayed())
            System.out.println("Message is displayed: " + driver.findElement(By.cssSelector("#action-confirmation")).getText());
        else
            System.out.println("Message isn't displayed");

        driver.close();
        driver.quit();
    }
}

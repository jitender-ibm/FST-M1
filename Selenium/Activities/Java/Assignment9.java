import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Assignment9 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        driver.get("https://training-support.net/selenium/ajax");
        System.out.println("Main page title: " + driver.getTitle());

        WebElement changeCntntBtn = driver.findElement(By.cssSelector("button.violet"));
        wait.until(ExpectedConditions.elementToBeClickable(changeCntntBtn)).click();
        WebElement headerFirst = driver.findElement(By.cssSelector("#ajax-content>h1"));
        wait.until(ExpectedConditions.textToBePresentInElement(headerFirst, "HELLO!"));
        //WebElement headerSecond = driver.findElement(By.cssSelector("#ajax-content>h3"));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("#ajax-content>h3"), "I'm late!"));
        driver.close();
        driver.quit();
    }
}

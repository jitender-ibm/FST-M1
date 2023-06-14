import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Assignment12 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("https://training-support.net/selenium/dynamic-controls");
        System.out.println("Main page title: " + driver.getTitle());

        WebElement inputField = driver.findElement(By.cssSelector("#input-text"));
        WebElement enableField = driver.findElement(By.cssSelector("#toggleInput"));
        if(inputField.isEnabled())
            System.out.println("The checkbox is enabled");
        else
            System.out.println("The checkbox is not enabled");
        enableField.click();
        if(inputField.isEnabled())
            System.out.println("The checkbox is enabled");
        else
            System.out.println("The checkbox is not enabled");

        driver.close();
        driver.quit();
    }
}

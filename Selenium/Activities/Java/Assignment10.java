import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Assignment10 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        driver.get("https://training-support.net/selenium/dynamic-controls");
        System.out.println("Main page title: " + driver.getTitle());

        WebElement checkboxBtn = driver.findElement(By.cssSelector("#toggleCheckbox"));
        WebElement checkbox = driver.findElement(By.cssSelector("input.willDisappear"));
        if(checkbox.isDisplayed())
            System.out.println("The checkbox is displayed");
        checkboxBtn.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("input.willDisappear")));

        driver.close();
        driver.quit();
    }
}

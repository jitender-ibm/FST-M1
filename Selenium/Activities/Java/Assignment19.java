import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Assignment19 {
    public static <WebElements> void main(String[] args) throws InterruptedException {
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("https://training-support.net/selenium/javascript-alerts");
        System.out.println("Main page title: " + driver.getTitle());

        WebElement confirmAlert  = driver.findElement(By.cssSelector("button#confirm"));

        confirmAlert.click();
        Alert alert = driver.switchTo().alert();
        System.out.println(driver.switchTo().alert().getText());
        alert.accept();

        confirmAlert.click();
        alert.dismiss();

        driver.close();
        driver.quit();
    }
}

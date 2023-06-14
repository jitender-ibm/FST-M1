import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Assignment20 {
    public static <WebElements> void main(String[] args) throws InterruptedException {
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("https://training-support.net/selenium/javascript-alerts");
        System.out.println("Main page title: " + driver.getTitle());

        WebElement promptAlert  = driver.findElement(By.cssSelector("button#prompt"));

        promptAlert.click();
        Alert alert = driver.switchTo().alert();
        System.out.println(driver.switchTo().alert().getText());
        alert.sendKeys("Awesome!");

        alert.accept();

        driver.close();
        driver.quit();
    }
}

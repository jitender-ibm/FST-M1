import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class Assignment22 {
    public static <WebElements> void main(String[] args) throws InterruptedException {
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        driver.get("https://www.training-support.net/selenium/popups");
        System.out.println("Main page title: " + driver.getTitle());

        WebElement singInBtn = driver.findElement(By.cssSelector("button[onclick^=openModal]"));

        Actions actions = new Actions(driver);
        actions.moveToElement(singInBtn).build().perform();

        String tooltip = singInBtn.getAttribute("data-tooltip");
        System.out.println("Tooltip of SignIn button is: " + tooltip);

        singInBtn.click();
        WebElement usrname = driver.findElement(By.cssSelector("input#username"));
        WebElement passwrd = driver.findElement(By.cssSelector("input#password"));
        WebElement loginBtn = driver.findElement(By.xpath("//button[text()='Log in']"));
        usrname.sendKeys("admin");
        passwrd.sendKeys("password");
        loginBtn.click();
        String successMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#action-confirmation"))).getText();
        System.out.println("Success message is: " + successMsg);

        driver.close();
        driver.quit();
    }
}

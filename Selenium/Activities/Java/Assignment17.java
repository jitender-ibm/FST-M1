import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Assignment17 {
    public static <WebElements> void main(String[] args) throws InterruptedException {
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("https://training-support.net/selenium/selects");
        System.out.println("Main page title: " + driver.getTitle());

        WebElement ddl  = driver.findElement(By.cssSelector("select#single-select"));

        Select select = new Select(ddl);
        select.selectByVisibleText("Option 2");
        System.out.println(select.getFirstSelectedOption().getText());
        select.selectByIndex(3);
        System.out.println(select.getFirstSelectedOption().getText());
        select.selectByValue("4");
        System.out.println(select.getFirstSelectedOption().getText());

        List<WebElement> allElemnts = select.getOptions();
        for (WebElement allElemnt : allElemnts) {
            System.out.println(allElemnt.getText());
        }


        driver.close();
        driver.quit();
    }
}

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Assignment18 {
    public static <WebElements> void main(String[] args) throws InterruptedException {
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("https://training-support.net/selenium/selects");
        System.out.println("Main page title: " + driver.getTitle());

        WebElement ddl  = driver.findElement(By.cssSelector("select#multi-select"));

        Select select = new Select(ddl);
        select.selectByVisibleText("Javascript");
        System.out.println(select.getFirstSelectedOption().getText());

        for (int i=4; i<=6; i++){
            select.selectByIndex(i);
        }
        List<WebElement> allselected = select.getAllSelectedOptions();
        for (WebElement temp : allselected) {
            System.out.println(temp.getText());
        }

        select.selectByValue("node");
        System.out.println(select.getFirstSelectedOption().getText());

        select.deselectByIndex(5);
        List<WebElement> selected = select.getAllSelectedOptions();

        for (WebElement temp : selected) {
            System.out.println(temp.getText());
        }

        driver.close();
        driver.quit();
    }
}

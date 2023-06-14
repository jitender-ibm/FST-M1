import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;

public class Assignment6 {
    public static void main(String[] args) {
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        Actions actions = new Actions(driver);

        driver.get("https://www.training-support.net/selenium/input-events");
        System.out.println("Main page title: " + driver.getTitle());
        actions.sendKeys("J").build().perform();
        WebElement element1 = driver.findElement(By.xpath("#keyPressed"));

        actions.moveToElement(element1).keyDown(Keys.CONTROL).sendKeys("a").sendKeys("c").build().perform();
        driver.close();
        driver.quit();
    }
}

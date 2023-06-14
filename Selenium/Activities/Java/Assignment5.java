import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Assignment5 {
    public static void main(String[] args) {
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        Actions actions = new Actions(driver);

        driver.get("https://www.training-support.net/selenium/input-events");
        System.out.println("Main page title: " + driver.getTitle());
        WebElement element1 = driver.findElement(By.xpath("//div[text() = 'Mouse and Keyboard events.']"));
        actions.moveToElement(element1).click().pause(1000).build().perform();
        System.out.println("Displayed text of cube: " +driver.findElement(By.cssSelector("#D3Cube>.active")).getText());
        actions.moveToElement(element1).doubleClick().pause(1000).build().perform();
        System.out.println("Displayed text of cube: " +driver.findElement(By.cssSelector("#D3Cube>.active")).getText());
        actions.moveToElement(element1).contextClick().pause(1000).build().perform();
        System.out.println("Displayed text of cube: " +driver.findElement(By.cssSelector("#D3Cube>.active")).getText());
        driver.close();
        driver.quit();
    }
}

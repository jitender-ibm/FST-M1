import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Assignment4 {
    public static void main(String[] args) {
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.training-support.net/selenium/target-practice");
        System.out.println("Main page title: " + driver.getTitle());
        System.out.println("Text of 3rd header: " +driver.findElement(By.xpath("//h3")).getText());
        System.out.println("Color of 5th header: " +driver.findElement(By.xpath("//h5")).getCssValue("color"));
        System.out.println("Class values of Violet button: " + driver.findElement(By.cssSelector("button.violet")).getAttribute("class"));
        System.out.println("Text of button: " + driver.findElement(By.cssSelector("button.grey")).getText());
        driver.close();
        driver.quit();
    }
}

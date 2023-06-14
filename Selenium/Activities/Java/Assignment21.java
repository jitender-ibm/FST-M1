import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class Assignment21 {
    public static <WebElements> void main(String[] args) throws InterruptedException {
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        driver.get("https://www.training-support.net/selenium/tab-opener");
        System.out.println("Main page title: " + driver.getTitle());

        WebElement openTabBtn  = driver.findElement(By.cssSelector("a#launcher"));

        String parentHandle = driver.getWindowHandle();
        openTabBtn.click();

        String childHandle = null;
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        Set<String> windowHandles = driver.getWindowHandles();
        for(String handle: windowHandles){
            System.out.println(handle);
            if (handle!=parentHandle)
                childHandle = handle;
        }
        driver.switchTo().window(childHandle);
        String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class= 'content']"))).getText();
        System.out.println("New page title: " + driver.getTitle());
        //String heading = driver.findElement(By.xpath("//div[@class= 'content']")).getText();
        System.out.println("Heading is: " + heading);
        driver.findElement(By.cssSelector("a#actionButton")).click();

        String secondChildHandle = null;
        wait.until(ExpectedConditions.numberOfWindowsToBe(3));
        Set<String> newCountOfHandles = driver.getWindowHandles();
        for(String handle: newCountOfHandles){
            System.out.println(handle);
            if (handle!=parentHandle && handle!=childHandle)
                secondChildHandle = handle;
        }

        driver.switchTo().window(secondChildHandle);
        String newHeading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class= 'content']"))).getText();
        System.out.println("New child page title: " + driver.getTitle());
        //String newHeading = driver.findElement(By.xpath("//div[@class= 'content']")).getText();
        System.out.println("Heading is: " + newHeading);

        driver.close();
        driver.quit();
    }
}

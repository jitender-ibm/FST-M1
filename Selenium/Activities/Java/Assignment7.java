import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Assignment7 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        Actions actions = new Actions(driver);

        driver.get("https://training-support.net/selenium/drag-drop");
        System.out.println("Main page title: " + driver.getTitle());

        WebElement ball = driver.findElement(By.cssSelector("#draggable"));
        WebElement dropArea1 = driver.findElement(By.cssSelector("#droppable"));
        WebElement dropArea2 = driver.findElement(By.cssSelector("#dropzone2"));

        actions.clickAndHold(ball).moveToElement(dropArea1).release().pause(2000).build().perform();
        if(driver.findElement(By.cssSelector("#droppable>p")).isDisplayed());
        System.out.println("First: Dropped text is diplayed");

        actions.clickAndHold(ball).moveToElement(dropArea2).release().pause(2000).build().perform();
        if(driver.findElement(By.cssSelector("#dropzone2>p")).isDisplayed());
        System.out.println("Second: Dropped text is diplayed");
        driver.close();
        driver.quit();
    }
}

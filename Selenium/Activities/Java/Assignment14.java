import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Assignment14 {
    public static <WebElements> void main(String[] args) throws InterruptedException {
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("https://training-support.net/selenium/tables");
        System.out.println("Main page title: " + driver.getTitle());

        List<WebElement> staticTableRows = driver.findElements(By.xpath("//div[text()= 'Sortable Table']/following-sibling::div/table/tbody/tr"));
        List<WebElement> thirdRowColumn = driver.findElements(By.xpath("//div[text()= 'Sortable Table']/following-sibling::div/table/tbody/tr[3]/td"));
        WebElement secndRowSecndColumn = driver.findElement(By.xpath("//div[text()= 'Sortable Table']/following-sibling::div/table/tbody/tr[2]/td[2]"));
        WebElement firstColumnHeader = driver.findElement(By.xpath("//div[text()= 'Sortable Table']/following-sibling::div/table/thead/tr/th[1]"));
        List<WebElement> footerRow = driver.findElements(By.xpath("//div[text()= 'Sortable Table']/following-sibling::div/table/tfoot/tr/th"));


        System.out.println("The number of rows are: "+staticTableRows.size());
        System.out.println("The number of columns in a row are: "+thirdRowColumn.size());

        System.out.println("The column value of second row and second column is: " + secndRowSecndColumn.getText());

        firstColumnHeader.click();

        WebElement secndRowSecndColumnNew = driver.findElement(By.xpath("//div[text()= 'Sortable Table']/following-sibling::div/table/tbody/tr[2]/td[2]"));
        System.out.println("The new column value of second row and second column is: " + secndRowSecndColumnNew.getText());

        System.out.println("The values of third row are: ");
        for (WebElement temp: footerRow) {
            System.out.println(temp.getText());
        }

        driver.close();
        driver.quit();
    }
}

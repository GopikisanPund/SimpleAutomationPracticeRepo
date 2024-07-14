import java.time.Duration;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Case_7_FluentWait {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to the website
            driver.get("https://omayo.blogspot.com/");
            driver.manage().window().maximize();

            // Click the drop-down button
            driver.findElement(By.xpath("//button[@class='dropbtn']")).click();

            // Create a FluentWait instance with a timeout of 30 seconds, polling every 5 seconds
            Wait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(30))
                    .pollingEvery(Duration.ofSeconds(5))
                    .ignoring(NoSuchElementException.class);

            // Wait for the Gmail link to be visible and clickable
            WebElement gmailLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Gmail']")));

            // Click the Gmail link
            gmailLink.click();

        } finally {
            // Close the browser
            driver.quit();
        }
    }
}

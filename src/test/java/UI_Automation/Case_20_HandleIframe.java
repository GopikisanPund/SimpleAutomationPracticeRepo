package UI_Automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Case_20_HandleIframe {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://developer.mozilla.org/en-US/docs/Web/HTML/Element/iframe");

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

        try {
            // Locate the iframe element and switch to it
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("inlineFrameExample")));

            // Locate the element inside the iframe and click it
            WebElement linkInsideIframe = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@class='leaflet-control-attribution leaflet-control'])[1]/a")));
            linkInsideIframe.click();

            // Switch back to the main content
            driver.switchTo().defaultContent();

            // Add any further interactions with the main content if needed

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the driver
            driver.quit();
        }
    }
}

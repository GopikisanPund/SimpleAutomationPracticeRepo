package UI_Automation;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Case_6_WebDriverWait {

    public static void main(String[] args) {
        // Set up the WebDriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to the website
            driver.get("https://omayo.blogspot.com/");
            driver.manage().window().maximize();
            
            // Click the drop-down button
            driver.findElement(By.xpath("//button[@class='dropbtn']")).click();
            
            // Create a WebDriverWait object with a timeout of 50 seconds
            WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(50));
            
            // Wait until the Gmail link is visible
            WebElement gmailLink = driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Gmail']")));
            
            // Click the Gmail link
            gmailLink.click();
            
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}

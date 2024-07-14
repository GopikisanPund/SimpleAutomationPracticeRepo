package UI_Automation;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Case_9_WebDriverWait {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://the-internet.herokuapp.com/");
            driver.manage().window().maximize();

            driver.findElement(By.cssSelector("a[href='/dynamic_loading']")).click();
            driver.findElement(By.xpath("//a[normalize-space()='Example 1: Element on page that is hidden']")).click();
            driver.findElement(By.xpath("//button[normalize-space()='Start']")).click();

            WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(50));
            driverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading")));

            String text = driver.findElement(By.id("finish")).getText();
            System.out.println("Text is: " + text);
        } finally {
            driver.quit();
        }
    }
}

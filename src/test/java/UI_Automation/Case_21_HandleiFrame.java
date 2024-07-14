package UI_Automation;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Case_21_HandleiFrame {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.globalsqa.com/demo-site/frames-and-windows/#iFrame");

        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Wait for the iFrame to be available and switch to it
        driverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//div[@class='resp-tabs-container']/div[1]//iframe")));

        // Ensure the elements inside the iFrame are visible
        WebElement portfolioFilter = driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("portfolio_filter")));
        portfolioFilter.findElement(By.xpath("//span[text()='Performance Testing']")).click();

        // Additional steps to interact with the clicked item if necessary
        // For example, validating that the click worked correctly

        // Quit the driver
        driver.quit();
    }
}

package UI_Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Case_23_MultiIHandleiFrame {

    public static void main(String[] args) {
        // Setup WebDriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Navigate to the target URL
        driver.get("https://the-internet.herokuapp.com/nested_frames");

        // Switch to the parent frame (frame-top)
        driver.switchTo().frame("frame-top");

        // Switch to the left frame within the parent frame
        driver.switchTo().frame("frame-left");

        // Get the text inside the left frame
        String textString = driver.findElement(By.tagName("body")).getText();
        System.out.println(textString);

        // Switch back to the parent frame (frame-top)
        driver.switchTo().parentFrame();

        // Switch to the middle frame within the parent frame
        driver.switchTo().frame("frame-middle");

        // Get the text inside the middle frame
        String midleString = driver.findElement(By.id("content")).getText();
        System.out.println(midleString);

        // Switch back to the parent frame (frame-top)
        driver.switchTo().parentFrame();

        // Switch to the right frame within the parent frame
        driver.switchTo().frame("frame-right");

        // Get the text inside the right frame
        String rightText = driver.findElement(By.xpath("//body")).getText();
        System.out.println(rightText);

        // Switch back to the main content
        driver.switchTo().defaultContent();

        // Switch to the bottom frame
        driver.switchTo().frame("frame-bottom");

        // Get the text inside the bottom frame
        String BottomText = driver.findElement(By.xpath("//body")).getText();
        System.out.println(BottomText);

        // Close the driver
        driver.quit();
    }
}

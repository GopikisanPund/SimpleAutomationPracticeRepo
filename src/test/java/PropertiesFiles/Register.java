package PropertiesFiles;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Register extends BaseClass {

    public static void main(String[] args) throws IOException {

        // Load properties from the file
        loadPropertiesFile();

        // Set up WebDriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // Maximize the browser window
        driver.manage().window().maximize();

        // Navigate to the URL from properties file
        driver.get(prop.getProperty("URL"));

        // Perform registration actions
        driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
        driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']")).click();

        driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys(prop.getProperty("FirstName"));
        driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys(prop.getProperty("LastName"));
        driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(prop.getProperty("Email"));
        driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys(prop.getProperty("PhoneNumber"));
        driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(prop.getProperty("Password"));
        driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys(prop.getProperty("ConfirmPassword"));
        driver.findElement(By.xpath("//input[@value='Continue']")).click();

        // Close the browser
        driver.close();
    }
}

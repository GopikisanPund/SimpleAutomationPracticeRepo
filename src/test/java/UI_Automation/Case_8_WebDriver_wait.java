package UI_Automation;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Case_8_WebDriver_wait {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://omayo.blogspot.com/");

		driver.manage().window().maximize();

		driver.findElement(By.xpath("//input[@id=\"alert1\"]")).click();

		WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(50));

		driverWait.until(ExpectedConditions.alertIsPresent());

		Alert alert = driver.switchTo().alert();

		String nameString = alert.getText();

		System.out.println(nameString);

		alert.accept();

	}

}

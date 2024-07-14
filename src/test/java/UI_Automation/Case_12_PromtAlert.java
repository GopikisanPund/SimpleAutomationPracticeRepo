package UI_Automation;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Case_12_PromtAlert {

	public static void main(String[] args) {

		WebDriver driver = null;
		try {
			WebDriverManager.chromedriver().setup();

			driver = new ChromeDriver();

			driver.get("https://the-internet.herokuapp.com/javascript_alerts");

			driver.manage().window().maximize();

			driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();

			WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(50));

			driverWait.until(ExpectedConditions.alertIsPresent());

			Alert promptAlert = driver.switchTo().alert();

			String alertText = promptAlert.getText();
			System.out.println(alertText);

			promptAlert.sendKeys("Gpopikisan");
			promptAlert.accept(); // Accept the alert after sending keys

			// Wait for the result text to be updated
			driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result")));

			String resultText = driver.findElement(By.id("result")).getText();

			System.out.println(resultText);
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.quit();
	}

}

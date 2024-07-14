package UI_Automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Case_19_AutoDropDownBx {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Close any pop-up that might appear
		try {
			WebElement closeModal = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='commonModal__close']")));
			closeModal.click();
		} catch (Exception e) {
			System.out.println("No modal found, proceeding...");
		}

		By fromCity = By.id("fromCity");

		WebElement fromField = wait.until(ExpectedConditions.elementToBeClickable(fromCity));
		fromField.click();

		// Click on the 'fromCity' field to activate it
		WebElement fromInputField = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='From']")));
		fromInputField.sendKeys("Sh");

		// Wait for the suggestions to load and then navigate through the dropdown
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@role='listbox']")));

		for (int i = 1; i <= 4; i++) {
			Thread.sleep(1000);
			fromInputField.sendKeys(Keys.ARROW_DOWN);

		}
		fromInputField.sendKeys(Keys.ENTER);

		// Add any additional steps here

		// Close the browser
		driver.quit();
	}
}

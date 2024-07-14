package UI_Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Case_24_ActionsClass {

	public static void main(String[] args) {
		// Setup WebDriver
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Navigate to the target URL
		driver.get("https://omayo.blogspot.com/");

		WebElement Blog = driver.findElement(By.xpath("//span[@id='blogsmenu']"));
		
		Actions actions = new Actions(driver);
		
		actions.moveToElement(Blog).perform();
		
		WebElement element=driver.findElement(By.xpath("//span[normalize-space()='SeleniumOneByArun']"));
		
		
		actions.moveToElement(element).click().perform();
		
		driver.quit();

	}

}

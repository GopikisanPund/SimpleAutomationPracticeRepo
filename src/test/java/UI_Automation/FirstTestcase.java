package UI_Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.fasterxml.jackson.core.sym.Name;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstTestcase {

	public static void main(String[] args) {
		
		String CurrentURL,getpagesource;

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.saucedemo.com/");
		
		driver.manage().window().maximize();

		WebElement Username = driver.findElement(By.id("user-name"));
		

		if (Username.isDisplayed()) 
		{
			Username.sendKeys("standard_user");
			
		} 
		else 
		{
			System.out.println("Username field not found.");
			return; // Exit the test if the user name field is not found
		}

		WebElement Password = driver.findElement(By.id("password"));
		if (Password.isDisplayed()) 
		{
			Password.sendKeys("secret_sauce");
		} 
		else 
		{
			System.out.println("password field not found.");
			return; // Exit the test if the password field is not found
		}

		WebElement loginButton = driver.findElement(By.id("login-button"));
		if (loginButton.isDisplayed()) 
		{
			loginButton.click();
		}
		else 
		{
			System.out.println("Login button not found.");
			return; // Exit the test if the login button is not found
		}
		
		CurrentURL = driver.getCurrentUrl();
		
		getpagesource = driver.getPageSource();
		
		System.out.print("Page Source " + getpagesource);
		
		System.out.println("Current URL" + CurrentURL);

		System.out.println("Login Successfulyy ");

		// Close the browser
		driver.quit();

	}

}

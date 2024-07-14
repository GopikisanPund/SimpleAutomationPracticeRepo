package UI_Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Case_2_findElement {

	public static void main(String[] args) {

		String URL = "https://practice.automationtesting.in/my-account/";
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get(URL);

		WebElement emailElement = driver.findElement(By.id("reg_email"));

		WebElement passwordElement = driver.findElement(By.id("reg_password"));

		emailElement.sendKeys("gopikisan@gmail.com");

		passwordElement.sendKeys("Gopi@231790");

		WebElement enterElement = driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[1]/form/p[3]/input[3]"));
		
		enterElement.click();
		
		System.out.println("Login Success");

	}

}

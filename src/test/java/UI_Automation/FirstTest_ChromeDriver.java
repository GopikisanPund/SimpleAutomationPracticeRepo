package UI_Automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTest_ChromeDriver {

	public static void main(String[] args) throws InterruptedException

	{
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Gopi\\eclipse-workspace\\Selenium\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
//		driver.get("https://www.google.com/?hl=en");

		// ChromeDriver driver = new ChromeDriver();

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Gopi\\eclipse-workspace\\Selenium\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.google.com/");

		driver.manage().window().maximize();

		Thread.sleep(1000);

		driver.close();

	}

}

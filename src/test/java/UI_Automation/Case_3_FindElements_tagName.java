package UI_Automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Case_3_FindElements_tagName {

	public static void main(String[] args) {
		String URL = "https://omayo.blogspot.com/";

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get(URL);

		driver.manage().window().maximize();

		List<WebElement> allAttribute = driver.findElements(By.tagName("a"));

		// int noOfLinks = links.size();

		for (WebElement e : allAttribute) 
		{
			System.out.println(e.getAttribute("href"));

		}

		driver.quit();

	}

}

package UI_Automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Case_2_FindElements {

	public static void main(String[] args) {

		String URL = "https://omayo.blogspot.com/";

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get(URL);

		driver.manage().window().maximize();

		List<WebElement> links = driver.findElements(By.xpath("//a"));

		// int noOfLinks = links.size();

		for (WebElement e : links) {
			if (e.getAttribute("href") != null) {

				System.out.println("Link Href: " + e.getAttribute("href"));
			}
			else if (e.getAttribute("href")==null) 
			{
				System.out.println("This link is Null please check from your side"
						+ ""+ e.getAttribute("href"));
			}
		}

		driver.quit();
	}

}

package UI_Automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Case_1_FindElements {

	public static void main(String[] args) {

		String URL = "https://omayo.blogspot.com/";

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get(URL);

		List<WebElement> options = driver.findElements(By.cssSelector("#multiselect1"));

		for (WebElement e : options) {
			System.out.println(e.getText());

		}
		driver.quit();

	}

}

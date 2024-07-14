package UI_Automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

	public class Case_36_StaticTable {

		static WebDriver driver;

		public static void main(String[] args) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();

			// Navigate to the target URL
			driver.get("https://omayo.blogspot.com/");

			List<WebElement> Text = driver.findElements(By.xpath("//table[@id=\"table1\"]/tbody/tr"));

			System.out.println(Text.size());
			

//			for (WebElement Heading : Text) {
//				System.out.print(Heading.getText());
//
//			}

		}
	

}

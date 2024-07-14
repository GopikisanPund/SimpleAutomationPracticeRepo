package UI_Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Case_37_DynamicTable {

	static WebDriver driver;

	public static void main(String[] args) {
		try {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();

			// Navigate to the target URL
			driver.get("https://demo.guru99.com/test/web-table-element.php");

			String name = "Marico Ltd";
			String xpath = "//div[@id='leftcontainer']//table//tbody//tr[td/a[text()='" + name + "']]";

			WebElement rowElement = driver.findElement(By.xpath(xpath));

			String companyName = rowElement.findElement(By.xpath("./td/a")).getText();

			if (companyName.equals(name)) {
				// Fetch the third column value of the same row
				String value = rowElement.findElement(By.xpath("./td[3]")).getText();
				System.out.println("Company: " + companyName);
				System.out.println("Value: " + value);
				System.out.println("Name is already present");
			} else {
				System.out.println("Name is not present");
			}
		} catch (Exception e) {
			e.printStackTrace();
			
			System.out.println("Name is Continuassly changed");
		}

		driver.quit();
	}
}

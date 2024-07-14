package PropertiesFiles;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Search extends BaseClass {

	public static void main(String[] args) throws IOException {

		loadPropertiesFile();

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();

		driver.get(prop.getProperty("URL"));

		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(prop.getProperty("SearchIteam"));

		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
		
		driver.close();
	}

}

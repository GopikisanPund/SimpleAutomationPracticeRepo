package UI_Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Case_24_sliderBar {

	public static void main(String[] args) {
		// Setup WebDriver
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Navigate to the target URL
		driver.get("http://omayo.blogspot.com/p/page3.html");

		WebElement bar = driver.findElement(By.xpath("//a[@title='200']"));
		
		Actions actions=new Actions(driver);
		
		actions.dragAndDropBy(bar, 100,0).perform();
		
		//driver.quit();

	}

}

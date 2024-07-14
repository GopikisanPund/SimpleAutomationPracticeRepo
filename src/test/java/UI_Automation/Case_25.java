package UI_Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Case_25 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Navigate to the target URL
		driver.get("http://dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");

		WebElement element = driver.findElement(By.xpath("//div[@id='box2']"));

		WebElement element2 = driver.findElement(By.xpath("//div[@id='box106']"));

		Actions actions = new Actions(driver);
		
		actions.clickAndHold(element).moveToElement(element2).release().build().perform();
		
		

	}

}

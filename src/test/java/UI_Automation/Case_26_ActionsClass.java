package UI_Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Case_26_ActionsClass {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Navigate to the target URL
		driver.get("https://omayo.blogspot.com/");

		WebElement Text = driver.findElement(By.xpath("//*[@id=\"LinkList1\"]/div/ul/li[1]/a"));
		
		Actions actions=new Actions(driver);
		
		actions.keyDown(Keys.CONTROL).moveToElement(Text).click().keyUp(Keys.CONTROL).release().build().perform();
		
		
	}

}

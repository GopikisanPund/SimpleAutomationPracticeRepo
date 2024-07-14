package UI_Automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Case_28_Actions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Navigate to the target URL
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");

		WebElement FirstName = driver.findElement(By.id("input-firstname"));

		Actions actions = new Actions(driver);

		FirstName.sendKeys("GopikisanPUnd");
		actions.sendKeys(Keys.TAB).pause(Duration.ofSeconds(1));
		actions.sendKeys("pund").pause(Duration.ofSeconds(1));
		actions.sendKeys(Keys.TAB).pause(Duration.ofSeconds(1));
		actions.sendKeys("Gopi@123").pause(Duration.ofSeconds(1));
		actions.sendKeys(Keys.TAB).pause(Duration.ofSeconds(1));
		actions.sendKeys("123345678909").pause(Duration.ofSeconds(1));
		actions.sendKeys(Keys.TAB).pause(Duration.ofSeconds(1));
		actions.sendKeys("sagar@123").pause(Duration.ofSeconds(1));
		actions.sendKeys(Keys.TAB).pause(Duration.ofSeconds(1));
		actions.sendKeys("sagar@123").pause(Duration.ofSeconds(1));
		actions.sendKeys(Keys.TAB).pause(Duration.ofSeconds(1));
		actions.sendKeys(Keys.TAB).pause(Duration.ofSeconds(1));
		actions.sendKeys(Keys.TAB).sendKeys(Keys.SPACE);
		actions.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).build().perform();


		

		
		

	}
}

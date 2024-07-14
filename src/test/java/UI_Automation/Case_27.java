package UI_Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Case_27 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Navigate to the target URL
		driver.get("https://jqueryui.com/resizable/");

		WebElement dragElement = driver.findElement(By.className("demo-frame"));

		driver.switchTo().frame(dragElement);

		WebElement resize = driver.findElement(By.xpath("//*[@id=\"resizable\"]/div[3]"));

		Actions actions = new Actions(driver);
		actions.dragAndDropBy(resize, 100, 130).perform();

	}

}

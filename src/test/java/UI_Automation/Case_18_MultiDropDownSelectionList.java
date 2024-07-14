package UI_Automation;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Case_18_MultiDropDownSelectionList {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		try {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");

			By multiSelect = By.id("justAnInputBox");
			driver.findElement(multiSelect).click();

			By multiSelectionCheckboxes = By.xpath("//span[@class='comboTreeItemTitle']");
			List<WebElement> listOfCheckboxes = driver.findElements(multiSelectionCheckboxes);

			for (WebElement element : listOfCheckboxes) 
			{
				if (element.isDisplayed() && element.isEnabled()) 
				{
					String text = element.getText();
					element.click();
					System.out.println("Selected: " + text);
				} else {
					System.out.println("Element not interactable: " + element.getText());
				}
			}

			// Sleep to allow visual verification
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}
	}
}

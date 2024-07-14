package UI_Automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Case_15_DropDown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://omayo.blogspot.com/");

		driver.manage().window().maximize();

		WebElement dropdownlist = driver.findElement(By.id("multiselect1"));
	    
        // Creating a Select object
        Select select = new Select(dropdownlist);

        // Selecting options
        select.selectByVisibleText("Volvo");
        select.selectByIndex(1);
        select.selectByValue("Hyundaix");
        
        List<WebElement> list = select.getAllSelectedOptions();
        
        for (WebElement webElement : list) 
        {
        	System.out.println(webElement.getText());
			
		}
        
        driver.quit(); 
	}
	

}

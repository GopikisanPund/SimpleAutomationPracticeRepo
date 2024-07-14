package UI_Automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Case_16_GenericMethod_HandleMultiDropDown {
	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://letcode.in/dropdowns");

		By fruits = By.id("fruits");
		By superHero = By.id("superheros");
		By language = By.id("lang");
		By country = By.id("country");

		selectDropDownOptionFiled(fruits, "VisibleText", "Mango");
		selectDropDownOptionFiled(superHero, "Value", "ca");
		selectDropDownOptionFiled(language, "Index", "1");
		selectDropDownOptionFiled(country, "VisibleText", "Bolivia");
		// selectDropDownOptionFiled();
		
		getSelectedOption(fruits);
		getSelectedOption(language);
		getSelectedOption(country);
		getSelectedOption(superHero);
		
		

	}

	public static WebElement getWebElement(By filed) {
		return driver.findElement(filed);

	}

	public static void selectDropDownOptionFiled(By filed, String OptionType, String ValueType) {
		Select select = new Select(getWebElement(filed));

		switch (OptionType) {
		case "VisibleText":
			select.selectByVisibleText(ValueType);
			break;

		case "Value":
			select.selectByValue(ValueType);
			break;

		case "Index":
			select.selectByIndex(Integer.parseInt(ValueType));
			break;

		default:
			System.out.println("Wrong Selection");
			break;
		}

	}

	public static void getSelectedOption(By field) {

		Select select = new Select(getWebElement(field));
		List<WebElement> iteams = select.getAllSelectedOptions();
		for (WebElement element : iteams) {
			System.out.println(element.getText());
		}

	}

}

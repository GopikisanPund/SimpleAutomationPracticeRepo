package UI_Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Case_38_javascriptExecutor {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		try {
			driver.get("https://tutorialsninja.com/demo/");
			WebElement CartBtn = driver.findElement(By.xpath("//div[@id='cart']/button"));
			WebElement textFiled = driver.findElement(By.name("search"));

			// comments the curreent call method
			// javascriptflashing(driver, CartBtn);
			// Border(driver, CartBtn);
			Title(driver);
			Url(driver);
		textEnter(driver, textFiled,"Nokiya");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//driver.quit();
		}

	}

	public static void textEnter(WebDriver driver, WebElement element, String text) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].value='" + text + "'", element);
	}

	public static String Url(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		String url = jsExecutor.executeScript("return document.URL").toString();
		System.out.println("URL of page" + url);
		// return Title;
		return url;

	}

	public static String Title(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		// String Title = jsExecutor.executeScript("return document.title").toString();
		String Title = jsExecutor.executeScript("return document.title").toString();
		System.out.println("Title of page" + Title);
		return Title;

	}

	public static void Border(WebDriver driver, WebElement element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].style.border='3px solid red';", element);

	}

	public static void javascriptflashing(WebDriver driver, WebElement element) {
		String defaultColor = element.getCssValue("background-color");
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		for (int i = 0; i <= 10; i++) { // Reduced iterations for debugging
			jsExecutor.executeScript("arguments[0].style.background = 'green';", element);
			try {
				Thread.sleep(50); // Increased sleep duration for better visualization
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			jsExecutor.executeScript("arguments[0].style.background = arguments[1];", element, defaultColor);
			try {
				Thread.sleep(50); // Increased sleep duration for better visualization
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

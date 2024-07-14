package UI_Automation;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleMultiwindow {

	static WebDriver driver;
	static Set<String> AllWindows;

	public static void main(String[] args) {

		String URL = "https://omayo.blogspot.com/";

		WebDriverManager.chromedriver().setup();

		// Initialize the WebDriver
		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get(URL);

		driver.findElement(By.xpath("//*[@id=\"ta1\"]")).sendKeys("Gopikisan pund");

		String ParentWindow = driver.getWindowHandle();

		// Correct title as per the new window
		driver.findElement(By.xpath("//a[normalize-space()='Open a popup window']")).click();

		// Correct title as per the new window
		driver.findElement(By.xpath("//a[normalize-space()='Blogger']")).click();

		AllWindows = driver.getWindowHandles();

		reUsedCode("New Window");

		String Text = driver.findElement(By.xpath("/html/body/div/h3")).getText();

		System.out.println("chiled Windows Text is " + Text);
		
		driver.close();

		reUsedCode("Blogger.com - Create a unique and beautiful blog easily.");

		driver.findElement(By.xpath("//span[normalize-space()='Sign in']")).click();

		// Switch back to the parent window
		driver.switchTo().window(ParentWindow);

		driver.findElement(By.className("gsc-input")).sendKeys("QAFOX");

		// Close the driver
		driver.quit();

	}

	public static void reUsedCode(String Title) {
		Iterator<String> itr = AllWindows.iterator();
		while (itr.hasNext()) {
			String window = itr.next();

			driver.switchTo().window(window);

			if (driver.getTitle().equals(Title)) {
				break;
			}
		}

	}

}

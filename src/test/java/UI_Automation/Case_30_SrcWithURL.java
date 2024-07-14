package UI_Automation;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Case_30_SrcWithURL {

	static WebDriver driver;

	public static void main(String[] args) throws IOException {
		try {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();

			// Navigate to the target URL
			driver.get("https://omayo.blogspot.com/");

			WebElement element = driver.findElement(By.id("multiselect1"));
			// Take the screenshot
			//TakesScreenshot src = (TakesScreenshot) driver;
			File srcFile = element.getScreenshotAs(OutputType.FILE);

			// Define the path where the screenshot will be saved
			File screenshotDirectory = new File(
					"C:\\Users\\Gopi\\eclipse-workspace\\SeleniumProject_Maven\\Screenshots");
			if (!screenshotDirectory.exists()) {
				screenshotDirectory.mkdirs(); // Create the directory if it does not exist
			}

			// Define the full path with the file name
			File destFile = new File(screenshotDirectory, "WebElements.png");

			// Copy the screenshot to the destination file
			FileUtils.copyFile(srcFile, destFile);

			System.out.println("Screenshot saved to " + destFile.getAbsolutePath());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// Close the browser
			if (driver != null) {
				driver.quit();
			}
		}
	}
}
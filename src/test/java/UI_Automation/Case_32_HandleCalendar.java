package UI_Automation;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Case_32_HandleCalendar {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Navigate to the target URL
		driver.get("https://demo.automationtesting.in/Datepicker.html");

		WebElement dateclickElement = driver.findElement(By.id("datepicker1"));
		dateclickElement.click();

		WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ui-datepicker-div")));

		selectDateInCalendar("32", "February", "2025"); // Use a valid date

		// Close the browser after operation
		// driver.quit();
	}

	public static void selectDateInCalendar(String selectDay, String selectMonth, String selectYear)
	{
		if ((Integer.parseInt(selectDay)) > 28) {
			System.out.println("Invalide argumensts" + selectDay);
			return;

		}
		if ((selectMonth.equals("February")) && (Integer.parseInt(selectMonth) > 29)) {
			System.out.println("Invalide date selection");
			
			return;

		}

		while (true) {
			String monthYear = driver.findElement(By.className("ui-datepicker-title")).getText();

			// Split Text: The text is split to separate the month and year.
			String Month = monthYear.split(" ")[0];
			String Year = monthYear.split(" ")[1];

			if (Month.equals(selectMonth) && Year.equals(selectYear)) {
				break;
			}

			driver.findElement(By.xpath("//span[text()='Next']")).click();
		}

		String xpathString = "//td[@data-handler='selectDay']/a[text()='" + selectDay + "']";
		driver.findElement(By.xpath(xpathString)).click();
	}
}

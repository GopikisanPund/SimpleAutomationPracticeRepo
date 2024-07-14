package UI_Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Case_33_DatePicker {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Navigate to the target URL
		driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");

		driver.findElement(By.id("third_date_picker")).click();

		selectDateInPicker("22", "Jan", "2024");

	}

	public static void selectDateInPicker(String selectDays, String SelectMonth, String SelectYear) {
		WebElement MonthFiled = driver.findElement(By.className("ui-datepicker-month"));

		Select select1 = new Select(MonthFiled);

		select1.selectByVisibleText(SelectMonth);

		WebElement YearFiled = driver.findElement(By.className("ui-datepicker-year"));

		Select select2 = new Select(YearFiled);

		select2.selectByVisibleText(SelectYear);

		String xpathText = "//table[@class=\"ui-datepicker-calendar\"]//td[@data-handler=\"selectDay\"]/a[text()='"
				+ selectDays + "']";

		driver.findElement(By.xpath(xpathText)).click();

	}

}

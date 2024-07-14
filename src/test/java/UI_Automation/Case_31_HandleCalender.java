package UI_Automation;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Case_31_HandleCalender {
    static WebDriver driver;

    public static void main(String[] args) {
        try {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();

            // Navigate to the target URL
            driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");

            WebElement dateclickElement = driver.findElement(By.id("datepicker"));

            dateclickElement.click();

            WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ui-datepicker-div")));

            selectDateInCalendar("30", "February", "2025");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }

    public static void selectDateInCalendar(String selectDay, String selectMonth, String selectYear) {
        // Validate the day for the given month and year
        List<String> months31Days = Arrays.asList("January", "March", "May", "July", "August", "October", "December");
        List<String> months30Days = Arrays.asList("April", "June", "September", "November");

        int day;
        int year;

        try {
            day = Integer.parseInt(selectDay);
            year = Integer.parseInt(selectYear);
        } catch (NumberFormatException e) {
            System.out.println("Invalid day or year format provided.");
            return;
        }

        if ((months31Days.contains(selectMonth) && day > 31) || (months30Days.contains(selectMonth) && day > 30)
                || (selectMonth.equals("February") && day > 29) || (selectMonth.equals("February") && day == 29
                        && (year % 4 != 0 || (year % 100 == 0 && year % 400 != 0))))
        {
            System.out.println("Invalid date provided.");
            return;
        }

        try {
            while (true) {
                String monthYear = driver.findElement(By.className("ui-datepicker-title")).getText();
                String month = monthYear.split(" ")[0];
                String yearText = monthYear.split(" ")[1];

                if (month.equals(selectMonth) && yearText.equals(selectYear)) {
                    break;
                } else {
                    driver.findElement(By.xpath("//a[@title='Next']")).click();
                }
            }

            String xpathString = "//td[@data-handler='selectDay']/a[text()='" + selectDay + "']";
            driver.findElement(By.xpath(xpathString)).click();
        } catch (Exception e) {
            System.out.println("Error occurred while selecting the date: " + e.getMessage());
        }
    }
}

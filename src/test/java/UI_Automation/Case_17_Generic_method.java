package UI_Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Case_17_Generic_method {
    static WebDriver driver;

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.hdfcbank.com/");

        By productTypeDropDown = By.xpath("(//*[@class='btn-primary dropdown-toggle btn-block'])[1]");
        By productDropDownBy = By.xpath("(//*[@class='btn-primary dropdown-toggle btn-block'])[2]");

        selectedDropDownOption(productTypeDropDown, "Credit Cards");
        selectedDropDownOption(productDropDownBy, "Select Product");

        getSelectedOption(productTypeDropDown);
        getSelectedOption(productDropDownBy);

        driver.quit();
    }

    public static WebElement getWebElement(By field) {
        return driver.findElement(field);
    }

    public static void selectedDropDownOption(By field, String optionText) {
        // Click on the dropdown to open it
        getWebElement(field).click();
        
        // Create the dynamic XPath for the option
        String xpath = String.format("//li[text()='%s']", optionText);
        
        // Click on the desired option
        getWebElement(By.xpath(xpath)).click();
    }

    public static void getSelectedOption(By field) {
        // Since the dropdown is custom, we need to retrieve the selected text directly
        WebElement dropdownElement = getWebElement(field);
        String selectedOptionText = dropdownElement.getText();
        
        System.out.println("Selected option for element with locator " + field + ": " + selectedOptionText);
    }
}

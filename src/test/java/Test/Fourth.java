package Test;

import java.net.MalformedURLException;
import Base.Base;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Fourth extends Base {

    public WebDriver driver;

    @Test
    public void test() {
        driver.get("https://the-internet.herokuapp.com/");
        System.out.println("Title of the page in Safari: " + driver.getTitle());
    }

    @BeforeMethod
    public void setup() throws MalformedURLException {
        driver = initializeBrowser("ie");
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

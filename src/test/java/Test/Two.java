package Test;

import java.net.MalformedURLException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Base.Base;

public class Two extends Base {

    public WebDriver driver;

    @BeforeMethod
    public void setup() throws MalformedURLException {
        System.out.println("Initializing Firefox browser");
        driver = initializeBrowser("firefox");
    }

    @Test
    public void test() {
        System.out.println("Navigating to the test website");
        driver.get("https://the-internet.herokuapp.com/");
        System.out.println("Title of the page in Firefox: " + driver.getTitle());
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            System.out.println("Closing the browser");
            driver.quit();
        }
    }
}

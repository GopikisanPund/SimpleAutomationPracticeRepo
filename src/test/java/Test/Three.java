package Test;

import java.net.MalformedURLException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.Base;

public class Three extends Base {

    public WebDriver driver;

    @Test
    public void test() {
        driver.get("https://the-internet.herokuapp.com/");
        System.out.println("Title of the page in Edge: " + driver.getTitle());
    }

    @BeforeMethod
    public void setup() throws MalformedURLException {
        driver = initializeBrowser("edge");
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

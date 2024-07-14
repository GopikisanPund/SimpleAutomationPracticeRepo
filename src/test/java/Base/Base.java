package Base;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Base {

	public WebDriver initializeBrowser(String browserName) throws MalformedURLException {
		WebDriver driver;

		DesiredCapabilities ds = new DesiredCapabilities();

		if (browserName.equals("chrome")) {
			ds.setBrowserName("chrome");

		} else if (browserName.equals("firefox")) {
			ds.setBrowserName("firefox");

		} else if (browserName.equals("edge")) {
			ds.setBrowserName("MicrosoftEdge");

		} else if (browserName.equals("ie")) {
			ds.setBrowserName("internet explorer");

		} else if (browserName.equals("opera")) {
			ds.setBrowserName("opera");

		} else if (browserName.equals("safari")) {
			ds.setBrowserName("safari");

		}
		return driver=new RemoteWebDriver(new URL("http://localhost:4444"),ds);

	}
}

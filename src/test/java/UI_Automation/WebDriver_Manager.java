package UI_Automation;

import org.openqa.selenium.chrome.ChromeDriver;

import com.github.dockerjava.api.exception.NotAcceptableException;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriver_Manager {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		String URL,titleString = "https://demoqa.com/";
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://demoqa.com/");
	
		URL = driver.getCurrentUrl();
		
		System.out.println("URL " + URL);
		
		
		if (URL .equals(titleString)) 
		{
			System.out.println("URL is same");
		}
		else {
			System.out.println("URL is not same");
		}
		System.out.println("Title " + driver.getTitle());
		
		

		
		Thread.sleep(3000);

	}

}

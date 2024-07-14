package UI_Automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Case_5_Implicit_wait {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		//implicite wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));

		driver.get("https://omayo.blogspot.com/");

		driver.findElement(By.xpath("//button[@class=\"dropbtn\"]")).click();

		//Thread.sleep(5000);Hard wait 
		
		driver.findElement(By.xpath("//a[normalize-space()='Gmail']")).click();

	}

}

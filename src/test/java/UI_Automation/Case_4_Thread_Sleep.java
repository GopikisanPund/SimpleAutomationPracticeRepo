package UI_Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Case_4_Thread_Sleep {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://omayo.blogspot.com/");
		
		driver.findElement(By.xpath("//button[@class=\"dropbtn\"]")).click();
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//a[normalize-space()='Gmail']")).click();
		
	}

}

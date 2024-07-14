package UI_Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Case_22_iFrame {

	public static void main(String[] args) {
	
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://letcode.in/frame");
		
		driver.switchTo().frame("firstFr");
		
		driver.findElement(By.xpath("//input[@placeholder='Enter name']")).sendKeys("Gopikisan");
		
		driver.findElement(By.xpath("//input[@placeholder='Enter email']")).sendKeys("pund");
		
		
		WebElement innnerframe = driver.findElement(By.xpath("//iFrame[@class=\"has-background-white\"]"));
		
		driver.switchTo().frame(innnerframe);
		
		driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys("Gopikisa");
		
		driver.close();
		
		
		

	}

}

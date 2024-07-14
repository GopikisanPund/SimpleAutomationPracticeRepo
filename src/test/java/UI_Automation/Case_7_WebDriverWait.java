package UI_Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Case_7_WebDriverWait {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://verifalia.com/validate-email");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@id=\"inputData\"]")).sendKeys("Gopikisan");
		
		driver.findElement(By.xpath("//*[@id=\"main-wrapper\"]/div[2]/div/div[1]/div/div[1]/div[2]/app-root/div[2]/form/div[3]/button")).click();
		
		

	}

}

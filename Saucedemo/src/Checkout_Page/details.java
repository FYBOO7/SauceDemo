package Checkout_Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class details {
	WebDriver driver;
	@BeforeTest
	public void setup() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		Thread.sleep(2000);
		//Login
		driver.findElement(By.name("user-name")).sendKeys("standard_user");
		
		driver.findElement(By.name("password")).sendKeys("secret_sauce");
		Thread.sleep(2000);
		
		driver.findElement(By.name("login-button")).click();
		
		//Product Add
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@name=\"add-to-cart-sauce-labs-backpack\"]")).click();
		//checkout
		Thread.sleep(1000);		
		driver.findElement(By.xpath("//div[@id=\"shopping_cart_container\"]/child::a")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("checkout")).click();
	}
	
	@DataProvider(name ="checkoutInfo")
	public Object[][]  dataSet()
	{
		Object[][] checkoutInfo=new Object[1][3];
		checkoutInfo[0][0]="Farhan";
		checkoutInfo[0][1]="Bijapure";
		checkoutInfo[0][2]="123456";
		return checkoutInfo;
	}
	
	@Test(dataProvider="checkoutInfo")
	public void  testCheckout(String name, String sn,  String zip) throws InterruptedException
	{
		
		Thread.sleep(2000);
		driver.findElement(By.id("first-name")).sendKeys(name);
		driver.findElement(By.id("last-name")).sendKeys(sn);
		driver.findElement(By.id("postal-code")).sendKeys(zip);
		driver.findElement(By.id("continue")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.id("finish")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.id("back-to-products")).click();
		
		Thread.sleep(2000);
	}
	@AfterTest
	public void close() {
		driver.close();
	}


	
}

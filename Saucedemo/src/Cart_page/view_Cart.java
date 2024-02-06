package Cart_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class view_Cart {
	WebDriver driver;
	@BeforeTest
	public void initilize() throws InterruptedException
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		Thread.sleep(2000);
		driver.findElement(By.name("user-name")).sendKeys("standard_user");
		
		driver.findElement(By.name("password")).sendKeys("secret_sauce");
		Thread.sleep(2000);
		
		driver.findElement(By.name("login-button")).click();
	}
	
	@Test
	public void cart() throws InterruptedException  {
		
	
		driver.findElement(By.xpath("//button[@name=\"add-to-cart-sauce-labs-backpack\"]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@name=\"add-to-cart-sauce-labs-bike-light\"]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@name=\"add-to-cart-sauce-labs-bolt-t-shirt\"]")).click();
		Thread.sleep(1000);		
		driver.findElement(By.xpath("//div[@id=\"shopping_cart_container\"]/child::a")).click();
		
	}
	
	@Test(dependsOnMethods = "cart")
	public void removeItem() throws InterruptedException {
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@name=\"remove-sauce-labs-backpack\"]")).click();	
		Thread.sleep(2000);
		
	}
	
	@Test(dependsOnMethods = "removeItem") 
	public void contiShop() throws InterruptedException {		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@name=\"continue-shopping\"]")).click();	
		Thread.sleep(2000);	
	}
	
	@Test(dependsOnMethods = "contiShop") 
	public void checkout() throws InterruptedException {		
		Thread.sleep(1000);		
		driver.findElement(By.xpath("//div[@id=\"shopping_cart_container\"]/child::a")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("checkout")).click();
		
	}
	
	@AfterTest
	public void close() {
		driver.close();
	}

}

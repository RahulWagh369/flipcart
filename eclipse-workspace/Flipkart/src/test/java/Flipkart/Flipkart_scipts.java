package Flipkart;

import java.time.Duration;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Flipkart_scipts {
	
	
	
	
	@Test
		public void AppOpening() throws InterruptedException {
			
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		Thread.sleep(6000);
		
		driver.get("https://www.flipkart.com/");
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(9));
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//img[@src=\"https://static-assets-web.flixcart.com/batman-returns/batman-returns/p/images/fkheaderlogo_exploreplus-44005d.svg\"]"))));
		
	boolean result =	driver.findElement(By.xpath("//img[@src=\"https://static-assets-web.flixcart.com/batman-returns/batman-returns/p/images/fkheaderlogo_exploreplus-44005d.svg\"]")).isDisplayed();
		
	
	Assert.assertTrue(result);
	
	
	
		}
	
	
	
		@Test
		public void login() throws InterruptedException {
			
			WebDriverManager.chromedriver().setup();
			
			WebDriver driver = new ChromeDriver();
			
			driver.get("https://www.flipkart.com/");
			
			driver.manage().window().maximize();
			
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			
			WebElement loginButton = driver.findElement(By.xpath("//span[contains(text(),\"Login\")]"));
			
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(9));
			wait.until(ExpectedConditions.visibilityOf(loginButton));
			
			loginButton.click();

			WebElement enterNumber = driver.findElement(By.xpath("//input[@class=\"r4vIwl BV+Dqf\"]"));
			
			enterNumber.sendKeys("9112026858");
			
			WebElement RequestOTP_button = driver.findElement(By.xpath("//button[@class=\"QqFHMw twnTnD _7Pd1Fp\"]"));
			
			RequestOTP_button.click();
			
			Thread.sleep(30000);
			
			WebElement VerifyButton = driver.findElement(By.xpath("//button[@class=\"QqFHMw llMuju M5XAsp\"]"));
		
			VerifyButton.click();
		
//			Scanner sc = new Scanner(System.in);
//			System.out.println("Entrer the OTP");
//			String OTP = sc.next();
//			
//			String otpC = OTP;
//			int count = 0;
//			
//			String [] arr = new String[5];
//			
//			for(int i = 0 ; i<arr.length ; i++) {
//				
//				arr[count]= otpC.charAt(i);
//				
//			}
//			
//			for(String x : arr) {
//				
//				String xp = "+x+";
//				
//				driver.findElement(By.xpath("//div[@class=\"I-qZ4M _3oB0MF\"][1]")).sendKesy(x);
//				
//			}
			
			
			WebElement account = driver.findElement(By.xpath("//span[contains(text(),\"Account\")]"));
			
			boolean result = account.isDisplayed()	;
			
			Thread.sleep(3000);
			
			Reporter.log("");
			
			Assert.assertTrue(result);
			
		}
	
		@Test
		public void productAddToCart() throws InterruptedException {
			
//			Apple iPhone 15 (Black, 128 GB)
			
			
			WebDriverManager.chromedriver().setup();
			
			WebDriver driver = new ChromeDriver();
			
			driver.manage().window().maximize();
			
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			
			
			driver.get("https://www.flipkart.com/");
			
			Thread.sleep(120000);
			
			WebElement searchBox = driver.findElement(By.xpath("//input[@title=\"Search for Products, Brands and More\"]"));
			searchBox.sendKeys("iphon 15");
			
			WebElement iphon15 = driver.findElement(By.xpath("//div[@data-tkid=\"523abfbf-71b5-40ac-bae6-36a80ff55a47.MOBGTAGPTB3VS24W.SEARCH\"]"));
			iphon15.click();
			
			WebElement serchButton = driver.findElement(By.xpath("//button[@title=\"Search for Products, Brands and More\"]"));
			serchButton.click();
			
			WebElement productFullName = driver.findElement(By.xpath("//h1[@class=\"_6EBuvT\"]//span[@class=\"VU-ZEz\"]"));
			String pName = productFullName.getText();
			
			WebElement productPrice = driver.findElement(By.xpath("class=\"hl05eU\""));
			String pPrice = productPrice.getText();
			
			WebElement addCartButton = driver.findElement(By.xpath("//button[@class=\"QqFHMw vslbG+ In9uk2\"]"));
			addCartButton.click();
			
			driver.navigate().to("https://www.flipkart.com/");
			
			WebElement Cart = driver.findElement(By.xpath("href=\"/viewcart?exploreMode=true&preference=FLIPKART\""));
			Cart.click();
			
			WebElement cartProductName = driver.findElement(By.xpath("//a[@class=\"T2CNXf QqLTQ-\"]"));
			String cPName  = cartProductName.getText();
			
			WebElement cartProductPrice = driver.findElement(By.xpath("//span[@class=\"LAlF6k re6bBo\"]"));
			String cPPrice = cartProductPrice.getText();
			
			
			Assert.assertEquals(pName, cPName);
			Reporter.log("product name is same");
			
			Assert.assertEquals(pPrice ,cPPrice);
			Reporter.log("Price also equal");
			
			System.out.println("tc get pass");
		}
		
		
		
		
		
		
		
		
		
	
	
	
}

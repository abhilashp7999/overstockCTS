package testingChallenge;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class OverStock {
	WebDriver driver;
	@BeforeTest
	public void setup() throws InterruptedException
	{
		System.setProperty("webdriver.gecko.driver", "c:\\selenium\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.overstock.com/");
	
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath(".//*[@id='cboxClose']")).click();
       
        
       Thread.sleep(2000);
        WebElement account = driver.findElement(By.className("hd-sub-title-container"));
        Actions act1 = new Actions(driver);
        act1.moveToElement(account).perform();

        WebElement userSignIn = driver.findElement(By.xpath("//div[@id='dropdown-user-temp']/ul/li[1]/a"));
        userSignIn.click();
        
        Thread.sleep(5000);	   
        int size = driver.findElements(By.tagName("iframe")).size();
        System.out.println(size);
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='LoginLayer']/div/div[2]/div/iframe")));
        WebElement email = driver.findElement(By.xpath("html/body/div/div[4]/div[2]/form/div[1]/input"));
        email.sendKeys("ctschallenge20@gmail.com");
        WebElement password = driver.findElement(By.xpath(".//*[@id='loginPasswordInput']"));
        password.sendKeys("Challenge2018");
        WebElement signInButton = driver.findElement(By.xpath(".//*[@id='sign-in-button']"));
        signInButton.click();
        
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.switchTo().defaultContent();
              		
     }
        
        @AfterMethod
        public void clearSearch()
        {
        	WebElement searchBar = driver.findElement(By.xpath(".//*[@id='search-input']"));
        	searchBar.clear();
        }
  
	//@Test
	public void addSanDisk256GBUltraToCart()
	{
		
		 
	        
	               
	        WebElement searchBar = driver.findElement(By.xpath(".//*[@id='search-input']"));
	        searchBar.sendKeys("Micro SD Card");
	        
	       WebElement searchIcon = driver.findElement(By.xpath(".//*[@id='search-form']/fieldset[2]/label/i"));
	       searchIcon.click();
	       
	     
	          
	             
	       WebElement SanDisk256GBUltra = driver.findElement(By.xpath("//div[contains(text(), 'San Disk 256GB Ultra')]"));
	      
	     
	    	  SanDisk256GBUltra.click();
	    	  
	    	  WebElement addToCart = driver.findElement(By.xpath(".//*[@id='addCartMain_addCartButton']"));
	    	  addToCart.click();
	      
	 	}
	
	@Test 
	public void addPS4gameToCart() throws InterruptedException
	{
		 WebElement searchBar = driver.findElement(By.xpath(".//*[@id='search-input']"));
	        searchBar.sendKeys("PS4 games");
	        Thread.sleep(3000);;
	       WebElement searchIcon = driver.findElement(By.xpath(".//*[@id='search-form']/fieldset[2]/label/i"));
	       searchIcon.click();
	       
	       WebElement PS4game = driver.findElement(By.xpath("//div[contains(text(), 'Uncharted: The Lost Legacy')]"));
		     
		    	  PS4game.click();
		    	  
		    	  WebElement addToCart = driver.findElement(By.xpath(".//*[@id='addCartMain_addCartButton']"));
		    	  addToCart.click();
		      }
	      

	
	
	//@Test 
	public void addSmartThermostat()
	{
		 WebElement searchBar = driver.findElement(By.xpath(".//*[@id='search-input']"));
	        searchBar.sendKeys("Smart Thermostats");
	        
	       WebElement searchIcon = driver.findElement(By.xpath(".//*[@id='search-form']/fieldset[2]/label/i"));
	       searchIcon.click();
	       
	       WebElement SmartThermostat = driver.findElement(By.xpath("//div[contains(text(), 'INSTEON Thermostat (2441TH)')]"));
		      
	      
		    	  SmartThermostat.click();
		    	  
		    	  WebElement addToCart = driver.findElement(By.xpath(".//*[@id='addCartMain_addCartButton']"));
		    	  addToCart.click();
		      
	       

	       
	}
	
	@Test
	public void cartButton() throws InterruptedException
	{
		Actions act1 = new Actions(driver);
		
		WebElement cart = driver.findElement(By.xpath("//a[@class='hd-cart-link']"));
		act1.doubleClick(cart).perform();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		String finalCost = driver.findElement(By.xpath("//span[@class='cr-total-value']")).getText();
		Assert.assertEquals("$0.00", finalCost);
		
					
	}
	
	
	@Test
	public void logout() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement account = driver.findElement(By.xpath("//div[@class='hd-account-icon-container']"));
		Actions act1 = new Actions(driver);
		act1.moveToElement(account).perform();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement signOut = driver.findElement(By.xpath(".//*[@id='sign-in-out']"));
		signOut.click();
		
	}
		
	
	
}

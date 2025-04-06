package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Searching {
	  WebDriver driver;

	    @BeforeTest
	    public void setup(){
	        driver = new ChromeDriver();
	        driver.get("https://www.urbanladder.com/");
	        driver.manage().window().maximize();
	    }

	    @Test(priority = 1)
	    public void search(){
	        WebElement search_box = driver.findElement(By.id("search"));
	        search_box.sendKeys("Sofa");
	        search_box.sendKeys(Keys.ENTER);
	    }

	    @Test(priority = 2)
	    public void view(){
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-gaaction=\"popup.auth.close\"]")));
	       WebElement element = driver.findElement(By.xpath("//a[@data-gaaction=\"popup.auth.close\"]"));
	       if(element.isDisplayed()){
	           element.click();
	       }
	    }

	    @Test(priority = 3)
	    public void prod(){
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
	        WebElement Prod = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()=\"Weston Half Leather Sofa \"])[1]")));
	        Prod.click();
	    }

	    @Test(priority = 4)
	    public void check(){
	        WebElement p_title = driver.findElement(By.xpath("//h1[@itemprop=\"name\"]"));
	        boolean visible = p_title.isDisplayed();
	        WebElement price = driver.findElement(By.xpath("//div[@itemprop=\"price\"]"));
	        boolean price_visible = price.isDisplayed();
	        SoftAssert ast = new SoftAssert();
	        ast.assertTrue(visible);
	        ast.assertTrue(price_visible);
	        ast.assertAll();
	    }

	    @Test(priority = 5)
	    public void add(){
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
	        WebElement cart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@id=\"add-to-cart-button\"])[1]")));
	        cart.click();
	    }

	    @AfterTest
	    public void close(){
	        driver.quit();
}
}
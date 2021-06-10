package test;


import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class FirstTest {

	static WebDriver driver;
	String url = "https://www.google.com";
	
	@BeforeClass
	public static void init() {
//		System.setProperty("webdriver.gecko.driver", "src/test/resources/driver/FireFox/geckodriver");
		driver = new FirefoxDriver();
		driver.manage().window().fullscreen();
	}
	
	@Before
	public void setup() {
		driver.get(url);
	}
	
	@AfterClass
	public static void tearDown() {
		driver.quit();
	}
	
	@Test
	public void test1() throws InterruptedException {
		WebElement kittenSearch = driver.findElement(By.name("q"));
		kittenSearch.sendKeys("kittens");
		kittenSearch.submit();
		System.out.println(driver.getTitle());
		assertEquals("Google", driver.getTitle());
	}
	
}

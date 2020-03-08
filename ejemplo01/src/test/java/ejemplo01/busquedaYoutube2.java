package ejemplo01;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class busquedaYoutube2 {
private WebDriver driver;
		By segundaopcion = By.xpath("//*[@id=\"rso\"]/div/div/div[2]/div/div/div[1]/a/h3");
	
	@Before
	public void setUp() {
		
		
		System.setProperty("webdriver.chrome.driver","./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		
		
	}
	
	@Test
	public void testGooglePage() {
		
		WebElement searchbox = driver.findElement(By.name("q"));
		
		searchbox.clear();
		searchbox.sendKeys("rock de los 80s");
		searchbox.submit();
		driver.findElement(segundaopcion).click();
		String actualTitle = driver.getTitle();
		
		
		System.out.println(actualTitle);
		
		
		
		///driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
	//	assertEquals("vandal - Buscar con Google",driver.getTitle());
	}
}

package ejemplo01;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class practica02 {
private WebDriver driver;
	
	
	@Before
	public void setUp() {
		
		
		System.setProperty("webdriver.chrome.driver","./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://startingwithseleniumwebdriver.blogspot.com/2013/12/frmset1.html");
		
		
	}
	//
	@Test
	public void testGooglePage() {
		//enviar texto por nombre name	
		WebElement textbox1 = driver.findElement(By.name("txtbox1"));
		
		textbox1.clear();
		textbox1.sendKeys("hola como estas");
		
		// seleccionar radio button
		 List<WebElement> elements = driver.findElements(By.name("radioGroup1"));
         for (WebElement e : elements) {
             System.out.println(e.getAttribute("value").toString());
                 if (e.getAttribute("value").equals("Radio Button 2 Selected")) {
                     e.click();
        }
    }  
		
      // seleccionar check button el numero 2 y 4
      		 List<WebElement> elements2 = driver.findElements(By.name("chkbox"));
               for (WebElement e2 : elements2) {
                   System.out.println(e2.getAttribute("value").toString());
                       if (e2.getAttribute("value").equals("Check Box 3 Selected")) {
                           e2.click();
              }
                       if (e2.getAttribute("value").equals("Check Box 4 Selected")) {
                           e2.click();
              }
                       
                       
          }  
              
      //seleccionar lista desplegable Item 5
               
               WebElement dropdownlist = driver.findElement(By.name("dropdownlist"));
               Select listboxelements = new Select(dropdownlist);
              listboxelements.selectByIndex(8);
               //listboxelements.selectByVisibleText("Item 8");
              // listboxelements.selectByValue("Item 7");
               System.out.println(listboxelements.getFirstSelectedOption().getText());
               
               //seleccionar multi lista desplegable
               WebElement dropdownlist2 = driver.findElement(By.name("multiselectdropdown"));
               Select listboxelements2 = new Select(dropdownlist2);
               listboxelements2.selectByIndex(4);
              
               if (listboxelements2.isMultiple()) {
                   listboxelements2.selectByVisibleText("Item 8");
                   listboxelements2.selectByIndex(2);
               }
              /*
               if (listboxelements2.isMultiple()){
               listboxelements2.selectByValue("Item 7");
               }
               listboxelements2.deselectAll();
               listboxelements2.deselectByIndex(5);
               listboxelements2.deselectByValue("Item 8");
               listboxelements2.deselectByVisibleText("Item 8");        
                  */     
          
       
           
	
		
		
		
		
		///driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
	//	assertEquals("vandal - Buscar con Google",driver.getTitle());
	}
	
	//Seleccionar iframe
	 public static void main(String[] args) {

	        // TODO Auto-generated method stub
	        WebDriver driver = new ChromeDriver();
	        driver.get("http://startingwithseleniumwebdriver.blogspot.in/2013/12/frmset1.html");
	        // textbox(driver);
	        // radioButton(driver);
	        // checkBox(driver);
	        // singleSelect(driver);
	        // multipleSelect(driver);
	        // linkCheck(driver);
	        // partialLink(driver);
	        // clickAlert(driver);
	        // clickConfirm(driver);
	        // clickPrompt(driver);
	        // iFrame(driver);
	    }
	  public static void iFrame(WebDriver driver){
	        WebDriver frame =driver.switchTo().frame(driver.findElements(By.tagName("iframe")).get(2));
	        frame.switchTo().frame("navbar-iframe");
	        frame.findElement(By.name("q")).sendKeys("Test");
	        //We switch to iframe 2 from current iframe
	        //frame.switchTo().defaultContent();
	        //frame.switchTo().frame(2);
	        //frame.findElement(By.linkText("Learn HTML")).click();
	  }
		
	
}

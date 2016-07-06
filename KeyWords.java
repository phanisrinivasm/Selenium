package Utility;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KeyWords {
    static WebDriver driver = null;
    WebDriverWait wait = null;
    	
    
	
		public  void openBrowser(String browser){
		
			if (browser.equalsIgnoreCase("Mozilla")){
				driver = new FirefoxDriver();
			}
			else if(browser.equalsIgnoreCase("Chrome")){
				System.setProperty("WebDriver.chrome.driver","Q:\\Phani\\Automation\\Selenium");
				driver = new ChromeDriver();
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		}
    
		// Navigate to page
		public  void navigate(String url){
			driver.navigate().to(url);
		}
		// Open Page
    	public void openbrowser_url(String url){
    		driver.get(url);
    	}
    
    	// find element with name locator and click
    	public void Name_click(String name){
			driver.findElement(By.name(name)).click();
		}
    
    	// find element with name locator and enter value in the field
 		public void Name_input(String name, String data){
 			driver.findElement(By.name(name)).sendKeys(data);
 		}
 	
 		//Click element by tagname
 		public void tagname_Click(String tag_Name){
 			driver.findElement(By.tagName(tag_Name)).click();
 		}
 	
 		// find element with id locator and click
 		public void id_click(String Id){
 			driver.findElement(By.id(Id)).click();
 		}
	
    
    	// find element with id locator and enter value in the field
		public  void id_input(String Id, String data){
			driver.findElement(By.id(Id)).sendKeys(data);
		}
		
		public void id_input(String Id, Keys enter) {
			driver.findElement(By.id(Id)).sendKeys(enter);
		}
	
		// find element with link text locator and click
		public void link_text_click(String link_text){
			driver.findElement(By.linkText(link_text)).click();
		}
	
		// find element with class name and click
		public void className_click(String class_name){
			driver.findElement(By.className(class_name)).click();
		}
	
	
		// find element with xpath and enter text
		public void xpath_click(String xPath, String data){
			driver.findElement(By.xpath(xPath)).sendKeys(data);
		}
	
		// find element with xpath and click
		public void xpath_click(String xPath){
			driver.findElement(By.xpath(xPath)).click();
		}
		
		// Read text - find element by class
		public String classname_readText(String class_locator){
			return driver.findElement(By.className(class_locator)).getText();
		}
		
		// Read text - find element by id
		public String id_readText(String id_locator){
			return driver.findElement(By.id(id_locator)).getText();
		}
		
		// Read text - find element by class
		public String name_readText(String name_locator){
			return driver.findElement(By.name(name_locator)).getText();
				}
		
		public void Name_input(String name, Keys enter) {
			driver.findElement(By.name(name)).sendKeys(enter);
			
		}
		// Read text - find element by xpath
		public String xpath_ReadText(String text_xpath){
		
			return driver.findElement(By.xpath(text_xpath)).getText();
		
		}
		
		// find elements by xpath
		public List<WebElement> xpath_elements(String elements_xpath){
			 
			return driver.findElements(By.xpath(elements_xpath));
			
		}
		
		
		// find elements by xpath and get size
		public int xpath_elements_size(String elementsxpath){
			
			return driver.findElements(By.xpath(elementsxpath)).size();
		}
		
		
		// find element with css selector and click
		public void css_selector(String csspath){
			driver.findElement(By.cssSelector(csspath)).click();
		}
	
		
		// identify webelements from select list using id locator and select the value by visible text
		public void select_Id_visibleText(String id_text, String visbile_text ){
			WebElement element = driver.findElement(By.id(id_text));
			Select sel = new Select(element);
			sel.selectByVisibleText(visbile_text);		
		}
	
		// identify webelements from select list using name locator and select the value by visible text
		public void select_Name_visibleText(String name_text, String visbile_text ){
			WebElement element = driver.findElement(By.name(name_text));
			Select sel = new Select(element);
			sel.selectByVisibleText(visbile_text);		
		}
		
		// Webelement by id locator
		public WebElement webelment_id(String id_locator){
			return driver.findElement(By.id(id_locator));
		}
		
		// Find element by Id and clear text
		public void webelment_id_clear(String id_locator){
			driver.findElement(By.id(id_locator)).clear();
		}
		
		
		// Webelement by name locator
		public WebElement webelment_name(String name_locator){
			return driver.findElement(By.id(name_locator));
		}
		
		// Webelement by name locator
		public WebElement webelment_xpath(String xpath_locator){
			return driver.findElement(By.xpath(xpath_locator));
		}
		
	
		// Web driver wait for element to be clickable using id locator
		public void Wait_ElementToBeClickable(int wait_time, WebElement wed_element){
			 wait = new WebDriverWait(driver, wait_time);
			wait.until(ExpectedConditions.elementToBeClickable(wed_element));	
		}
		
		
		// web driver wait for element to be visible using webelement
		public void Wait_xpath_ElementToBeVisible(int wait_time, WebElement web_element){
			wait = new WebDriverWait(driver, wait_time);
			wait.until(ExpectedConditions.visibilityOf(web_element));
					
		}
		
		public void Wait_PresenceofElement_name(String locator, int time){
			wait = new WebDriverWait(driver, time);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.name(locator)));
		}
		
		// web driver wait for element to be visible using webelement
		public void Wait_xpath_ElementtobeSelected(int wait_time, WebElement web_element){
			wait = new WebDriverWait(driver, wait_time);
			wait.until(ExpectedConditions.elementToBeSelected(web_element));
		}
		
		public void cssSelector_Click(String cssselector){
			driver.findElement(By.cssSelector(cssselector)).click();
			
		}
		
		// handling alert pop-up 
		public void swith_to_alert_accept(){
			Alert alert = driver.switchTo().alert();
			alert.accept();
		}
		
		public int total_Windows(){
			Set<String> windowhandles = driver.getWindowHandles();
			return windowhandles.size();
			
		}
		
		
		// Handling pop-ups and multi windows
		public void switch_To_Window(){
			Set<String> windowhandles = driver.getWindowHandles();
			Iterator<String> iter = windowhandles.iterator();
			String firstWindowHandle = iter.next();
			String secondWindowHandle = iter.next();
			driver.switchTo().window(secondWindowHandle);
			driver.close();
			driver.switchTo().window(firstWindowHandle);			
		} // switch_To_Window
	
		public void take_ScreenShot(int i){
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		// Now you can do whatever you need to do with it, for example copy somewhere
		try {
			FileUtils.copyFile(scrFile, new File("Q:\\screenshot"+i+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		} // take_ScreenShot
	
		
		// Creating logs
		public Logger initLogs(String append){
			FileAppender appender = new FileAppender();
			// Configure append
			appender.setFile("Q:\\Logs\\"+append+".log");
			appender.setLayout(new PatternLayout("%d %-5p [%c{1}] %m%n"));
			appender.setAppend(false);
			appender.activateOptions();
			
			Logger application_Log = Logger.getLogger(append);
			application_Log.setLevel(Level.DEBUG);
			application_Log.addAppender(appender);
			
			return application_Log;
			
		} // initLogs
		
		public void execute_Javascript(WebElement webelement){
			JavascriptExecutor jse = (JavascriptExecutor)driver;

			jse.executeScript("arguments[0].scrollIntoView()", webelement); 
		}
		
		public void actions_MovetoElement_Click(WebElement webelement){
			Actions actions = new Actions(driver);

			actions.moveToElement(webelement).click().perform();
		}
		
		
		public boolean elementPresence_id(String elementid){
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			int size=0;
			 size =driver.findElements(By.id(elementid)).size();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			if (size==0)
				return false;
			else
				return true;
		}
		
		public void wait_elemntDataToBeFilled(){
			
		}
		
		

		//*************************Application Dependent *********************************
		

		public void login_QA41(String browser, String url){
			openBrowser(browser);
			navigate(url);
			id_input("username", "jbarnes");
			id_input("password", "Test1234");
			
		}

		
		


	
	} // class
	

	
	
	
	
	
	
	
	
	


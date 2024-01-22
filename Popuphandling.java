package automation;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Popuphandling {
	public static void main(String[] args) throws Exception {
		// setting the property of chrome browser and passing chromedriver path
		System.setProperty("webdriver.chrome.driver", "D:\\Training Materials\\workspace\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://demoqa.com/browser-windows");
        
        //tab handling
        Thread.sleep(2000);
        driver.findElement(By.id("tabButton")).click();
        
        //get the total no. of open tab/window
        Set<String> allWindowsID = driver.getWindowHandles();
        System.out.println(allWindowsID);
        
        Iterator<String> abc = allWindowsID.iterator();
        String win1 = abc.next();
        String win2 = abc.next();
        
        //print the title of parent window
        driver.switchTo().window(win1);
        System.out.println("parent Windows id:- "+ win1);//alphanumeric id of parent window
        System.out.println(driver.getTitle()); //title of parent window
        
      //print the current url of child window
        driver.switchTo().window(win2);
        System.out.println("child Windows id:- "+ win2);//alphanumeric id of parent window
        System.out.println(driver.getCurrentUrl()); //title of child window
       
        //windows popup handling
        Thread.sleep(2000);
        driver.switchTo().window(win1);
        Thread.sleep(2000);
        driver.findElement(By.id("windowButton")).click();
        
        //print the tile of child window
        Set<String> allWindowsID2 = driver.getWindowHandles();
        System.out.println(allWindowsID2);
        Iterator<String> abc1 = allWindowsID2.iterator();
        String win3 = abc1.next();
        String win4 = abc1.next();
        Thread.sleep(2000);
        driver.switchTo().window(win4);
        Thread.sleep(2000);
        System.out.println("Child Window ID :- "+ win4);
        System.out.println(driver.getTitle());
        Thread.sleep(2000);
        driver.quit();//close parent window as well as all associated window
        System.out.println("windows popup and tab handled");    
	}}

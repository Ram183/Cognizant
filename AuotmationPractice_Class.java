package AutomationPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AuotmationPractice_Class {
	
    	public static void main(String[] args){
    
    		System.setProperty("webdriver.chrome.driver", "F:\\Ramkumar\\Software\\chromedriver.exe");
    		WebDriver driver=new ChromeDriver();
    		driver.get("http://automationpractice.com/index.php");
    		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    		driver.manage().window().maximize();
    		String title=driver.getTitle();
    		System.out.println(title);
    	
		//************DRESSES**************
    	
		WebElement dress=driver.findElement(By.xpath("//*[@id=\'block_top_menu\']/ul/li[2]/a"));
        dress.click();
        System.out.println(driver.getTitle());
        
        WebElement scroll=driver.findElement(By.xpath("//a[contains(@href,\'product=3\')]/img"));
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true);", scroll);
        
        WebElement mouseover=driver.findElement(By.xpath("//a[contains(@href,\'product=3\')]/img"));
        Actions act= new Actions(driver);
        act.moveToElement(mouseover).build().perform();
       
        WebElement mouseclick=driver.findElement(By.xpath("//a[contains(@href,'cart&add=1&id_product=3')]"));
        act.doubleClick(mouseclick).build().perform();
        
        WebElement proced=driver.findElement(By.xpath("//a[@title=\'Proceed to checkout\']"));
        proced.click();
        System.out.println("Click into Homepage");
        
        WebElement Total=driver.findElement(By.xpath("//div[@id='order-detail-content']/table/tfoot/tr[7]/td[1]"));
       
        WebElement price=Total.findElement(By.xpath(".//following::td[1]"));
        System.out.println(Total.getText()+ "=" + price.getText());
        
	}

}
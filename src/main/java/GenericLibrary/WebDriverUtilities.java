package GenericLibrary;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtilities 
{
	
   public void RightClick(WebDriver driver , WebElement target)
   {
	   Actions a = new Actions(driver);
	   a.contextClick(target).perform();
   }
   
   public void DoubleClick(WebDriver driver , WebElement target )
   {
	   Actions a = new Actions(driver);
	   a.doubleClick(target).perform();  
   }
   
   public void MouseHover(WebDriver driver , WebElement target)
   {
	   Actions a = new Actions(driver);
	   a.moveToElement(target).perform();
   }
    
   public void DropDown(WebElement ele , String text)
   {
	   Select s = new Select(ele);
	   s.selectByVisibleText(text); 
   }
   
   
   public void SwitchBack(WebDriver driver)
   {
	   driver.switchTo().defaultContent();
   }
   
   public void alertPopupAccept(WebDriver driver) 
   {
	   driver.switchTo().alert().accept();
   }
   
   public void alertPopupDismiss(WebDriver driver)
   {
	   driver.switchTo().alert().dismiss();
   }
   
   
   public void ScrollToElement(WebDriver driver,WebElement ele)
   {
	   JavascriptExecutor js = (JavascriptExecutor) driver;
	   js.executeScript("arguments[0].scrollIntoView();", ele);
   }
   
   
}

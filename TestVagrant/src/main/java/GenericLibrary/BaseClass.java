package GenericLibrary;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass 
{
	
 public WebDriver driver;
 public PropertyFileData p = new PropertyFileData();
 public WebDriverUtilities utilities= new WebDriverUtilities();
	 
  @BeforeMethod
  public void OpenApp() throws IOException
  {
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
  }
  
  @AfterMethod
  public void CloseApp()
  {
	  driver.close();
  }
}

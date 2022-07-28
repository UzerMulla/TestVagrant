package POMpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IMDBMovieReleaseDateInfo {
	
	@FindBy(xpath="//a[contains(text(),'India')]/parent::td[@class='release-date-item__country-name']//following-sibling::td[1]")
	  private WebElement txt_release_date_india;	
	
	//Constructor to initiate the Webelements
		public IMDBMovieReleaseDateInfo(WebDriver driver)
		  {
			  PageFactory.initElements(driver, this);
		  }
	

		public WebElement getReleaseIndiaDate() 
		  {
				return txt_release_date_india;
		  }
}

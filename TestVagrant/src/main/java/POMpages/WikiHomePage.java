package POMpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class WikiHomePage {
	

	@FindBy(xpath="//input[@type='search']")
	  private WebElement txt_searchbox;
	
	@FindBy(xpath="//input[@id='searchButton']")
	  private WebElement btn_search;
	
	
	@FindBy(xpath="//div[contains(text(),'Release date')]/parent::th//following-sibling::td//li")
	  private WebElement tab_release_date;
	
	@FindBy(xpath="//th[contains(text(),'Country')]/following-sibling::td")
	  private WebElement tab_country;
	
	public WikiHomePage(WebDriver driver)
	  {
		  PageFactory.initElements(driver, this);
	  }
	
	
	// Method to search the content on IMDB page
		public void SearchOnWikipedia(String content) {
			txt_searchbox.sendKeys(content);
			btn_search.click();
		}
		
		public WebElement getReleaseDate() 
		  {
				return tab_release_date;
		  }
		
		public WebElement getCountry() 
		  {
				return tab_country;
		  }
		
}

package POMpages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericLibrary.PropertyFileData;


public class IMDBHomePage { 
	
	public PropertyFileData p = new PropertyFileData();
	
	@FindBy(xpath="//input[@type='text']")
	  private WebElement txt_searchbox;
	
	@FindBy(xpath="//button[@id='suggestion-search-button']")
	  private WebElement btn_search;
	
	
	@FindBy(xpath="//td[@class='result_text']/a")
	  private List<WebElement> lnk_movies;
	
	@FindBy(xpath="//h3[contains(text(),'Details')]")
	  private WebElement tab_details;
	
	@FindBy(xpath="//li[@data-testid='title-details-releasedate']//div//a")
	  private WebElement tab_release_date;
	
	@FindBy(xpath="//li[@data-testid='title-details-origin']//div//a")
	  private WebElement tab_country;
	
	
	
	
	//Constructor to initiate the Webelements
	public IMDBHomePage(WebDriver driver)
	  {
		  PageFactory.initElements(driver, this);
	  }
	
	
	// Method to search the content on IMDB page
	public void SearchOnImdb(String content) {
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
	
	public WebElement Details_Tab() 
	  {
			return tab_details;
	  }
	
	public void ClickOnMovieLink(String MovieNameToClick) throws Exception {
		
		for (int i = 0; i < lnk_movies.size(); i++) {
			WebElement Movie = lnk_movies.get(i);
			String MovieName=Movie.getText();
			
			if (MovieName.equalsIgnoreCase(MovieNameToClick)) {
				Movie.click();
                break;
			}
		}
		
	}
	
	
	
	
}

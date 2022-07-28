import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import GenericLibrary.BaseClass;
import GenericLibrary.WebDriverUtilities;
import POMpages.IMDBHomePage;
import POMpages.IMDBMovieReleaseDateInfo;
import POMpages.WikiHomePage;

public class VerifyMovieDetails extends BaseClass {

	String IMDB_ReleaseDate;
	String IMDB_Country;
	String Wiki_ReleaseDate;
	String Wiki_Country;
    String MovieName = p.getData("movie_name");
    
    WebDriverUtilities webUtil = new WebDriverUtilities();
	
	public VerifyMovieDetails() {
		
	}
	
	@Test(priority = 0)
	public void GetMovieDetailsFromIMDB()  {
		try {
			//Open the IMDB Page
			IMDBHomePage imdb = new IMDBHomePage(driver);
			String ImdbPage=p.getData("imdb_url");
			driver.get(ImdbPage);
			
			//Search the movie name into searchbox
			imdb.SearchOnImdb(MovieName);
			imdb.ClickOnMovieLink(MovieName);
			
			//Scroll until the Details Tab 
			webUtil.ScrollToElement(driver, imdb.Details_Tab());
			
			//Get the Details of Country of Origin of Movie
			IMDB_Country=imdb.getCountry().getText();
			System.out.println("IMDB:: Country Of Origin of Movie:"+MovieName+" is :"+IMDB_Country);
			
			//Wait until the Element is clickable and Click on realease date link
			imdb.getReleaseDate().click();
			
			//Creating the Object for Release date infor page 
			IMDBMovieReleaseDateInfo releaseDateInfo = new IMDBMovieReleaseDateInfo(driver);
			
			//Scroll until the releaseDate Of India tab 
			webUtil.ScrollToElement(driver, releaseDateInfo.getReleaseIndiaDate());
			
			//Get the Details of Release Date of movie in INDIA
			IMDB_ReleaseDate=releaseDateInfo.getReleaseIndiaDate().getText();
			System.out.println("IMDB:: Release Date Of Movie:"+MovieName+" is :"+IMDB_ReleaseDate);

			
		} catch (Exception e) {
			System.out.println("Unable to get the Movie Details from IMDB Page due to::"+e.getMessage().toString());
		}
		
	}
	
	@Test(priority = 1)
	public void GetMovieDetailsFromWiki() {
		
		try {
			//Open the Wikipedia Page
			WikiHomePage wiki = new WikiHomePage(driver);
			String WikiPage=p.getData("wiki_url");
			driver.get(WikiPage);
			
			//Search the Movie on Wikipedia and Scroll until the required details get
			wiki.SearchOnWikipedia(MovieName);
			webUtil.ScrollToElement(driver, wiki.getReleaseDate());
		
			//Get the Details of Release Date
			Wiki_ReleaseDate=wiki.getReleaseDate().getText();
			System.out.println("WikiPedia:: Release Date Of Movie:"+MovieName+" is :"+Wiki_ReleaseDate);
			
			//Get the Details of Country of Origin
			Wiki_Country=wiki.getCountry().getText();
			System.out.println("WikiPedia:: Country Of Origin of Movie:"+MovieName+" is :"+Wiki_Country);
			
		} catch (Exception e) {
			
			System.out.println("Unable to get the Movie Details from WikiPedia due to::"+e.getMessage().toString());
		}
	}

	@Test(priority = 2)
	public void VerifyTheDetails() {
		
		//Verify the Country
	   assertEquals(IMDB_ReleaseDate, Wiki_ReleaseDate,"The Release Date is not Matching");
	   
	   //Verify The Release Date
	   assertEquals(IMDB_Country, Wiki_Country, "The Country is not Matching");
	}

}

package scenarios;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.FavouritePage;
import pages.HomePage;
import pages.ListingPage;
import pages.LoginPage;
import pages.MobilPage;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import ru.yandex.qatools.allure.annotations.Title;

@Listeners({ScreenshootsListener.class})
@Features("Favourite Feature")
public class FavouritePageTest extends AndroidSetup {
    private FavouritePage favourite;
	private String emailValid="frengky.sheeran@gmail.com";
	private String passValid="frengky123.,";

	
	 @Test(priority=1)
	 @Stories("As A User I Am Able to Click Favourite Ads")
	 @TestCaseId("TC_ADR_007_001")
	 @Title("Verify User  Able to Add Ads into Favourite Ads")
	 public void userIsAbleToAddAdsIntoFavourite() throws Exception{
		 System.out.println("Verify User  Able to Add Ads into Favourite Ads");
		 HomePage homepage = new HomePage(driver);
		 homepage.clickLocationNotif();
		 MobilPage mobil = homepage.clickMobilPage();
		 ListingPage listing = mobil.clickSemuaMobilLink();
	     listing.clickFaveAds();
		 favourite = homepage.clickFavePage();
		 favourite.verifyFaveListed();
	 }
	 
	 @Test(priority=2)
	 @Stories("As A User I Am Able to Remove Ads From Favourite")
	 @TestCaseId("TC_ADR_007_002")
	 @Title("Verify User Able to Remove Ads From Favorite")
	 public void userIsAbleToRemoveAdsFromFavourite(){
		 System.out.println("Verify User Able to Remove Ads From Favorite");
		 favourite.clickUnFave();
		 favourite.verifyFaveUnlisted(); 
		 favourite.clickBackToHomePage();
	 }
	 
	 @Test(priority=3)
	 @Stories("As A User I am Able to Save Favourite After Login")
	 @TestCaseId("TC_ADR_007_003")
	 @Title("Verify User Able to Save Favourite After Login")
	 public void userIsAbleToSaveFaveAfterLogin(){
		 System.out.println("Verify User Able to Save Favourite After Login");
		 HomePage homepage = new HomePage(driver);
		 LoginPage login = homepage.clickLoginPage();
		 login.inputEmail(emailValid);
		 login.inputPassword(passValid);
		 login.clickSubmitLoginButton();
		 login.clickBackButton();
		 MobilPage mobil = homepage.clickMobilPage();
		 ListingPage listing = mobil.clickSemuaMobilLink(); 
	     listing.clickFaveAds();
		 favourite = homepage.clickFavePage();
		 favourite.verifyFaveListed();	    
		 homepage = favourite.clickBackToHomePage();
		 login = homepage.openNav();
		 login.clickLogout();
	 }
}

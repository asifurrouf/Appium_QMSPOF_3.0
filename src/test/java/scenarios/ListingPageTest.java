package scenarios;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ListingPage;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;

/**
 * Created by buddyarifin on 8/11/16.
 */

@Listeners(ScreenshootsListener.class)
public class ListingPageTest extends AndroidSetup {

    @Title("Verify Contents and Category")
    @Test(priority = 1)
    public void verifyAllContensOfListingPage() {
        HomePage homePage = new HomePage(driver);
        ListingPage listingPage = homePage.clickSkipButton();
        listingPage.verifyAllContentsOfListingPage();
    }

}

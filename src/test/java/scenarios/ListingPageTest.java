package scenarios;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ListingPage;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import ru.yandex.qatools.allure.annotations.Title;

/**
 * Created by buddyarifin on 8/11/16.
 */

@Listeners(ScreenshootsListener.class)
@Features("Listing Feature")
public class ListingPageTest extends AndroidSetup {

    @Stories("Verify Category can be Accessed after Login")
    @Title("Verify Contents and Category accessible after Login")
    @TestCaseId("TC_CATEGORY_04_001")
    @Test(priority = 1)
    public void verifyAllContensOfListingPage() {
        HomePage homePage = new HomePage(driver);
        ListingPage listingPage = homePage.clickSkipButton();
        listingPage.verifyAllContentsOfListingPage();
    }

}

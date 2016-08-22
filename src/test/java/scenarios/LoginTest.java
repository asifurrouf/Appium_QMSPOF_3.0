package scenarios;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginWithGplus;
import ru.yandex.qatools.allure.annotations.Features;

/**
 * Created by buddyarifin on 8/15/16.
 */
@Listeners(ScreenshootsListener.class)
@Features("Login Page Processing")
public class LoginTest extends AndroidSetup {

    @Test
    public void userAbleToRedirectToGmailLogin() {
        HomePage homePage = new HomePage(driver);
        LoginWithGplus gplus = homePage.clickLoginWithGPlus();
        gplus.verifyAccountExist();
    }

    // login With OLX Login Page
    public void userNotAbleToLoginWithUnregisteredEmail() {}
    public void userNotAbleToLoginWithIncorrectEmailFormat() {}
    public void userNotAbleToLoginWithInvalidCredentials() {}
    public void userAbleToLoginWithValidCredentials() {}
    public void userNotAbleToLoginWithBlankCredentials() {}

    // login with FB
    public void userNotAbleToLoginWithInvalidFBCredentials() {}
    public void userAbleToGiveGrantedAccessToFB() {}
    public void userAbleToLoginWithValidFBCredentials() {}
    public void userAbleToSetPreferencesAfterSuccessFBLogin() {}

    // login with Gplus
    public void userNotAbleToLoginWithInvalidGplusCredentials() {}
    public void userAbleToGiveGrantedAccessToGplus() {}
    public void userAbleToLoginWithValidGplusCredentials() {}
    public void userAbleToSetPreferencesAfterSuccessGplusLogin() {}

    // login with SMS
    public void userNotAbleToLoginWithBlankPIN() {}
    public void userAbleToMintaPIN() {}
    public void userAbleToMintaUlangPIN() {}
    public void userNotAbleToLoginWithInvalidPIN() {}
    public void userNotAbleToLoginWithInvalidPhoneNumber() {}
    public void userAbleToLoginWithValidPIN() {}

}

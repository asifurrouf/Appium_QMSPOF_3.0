package scenarios;

import org.testng.annotations.Listeners;

/**
 * Created by buddyarifin on 8/5/16.
 */

@Listeners(ScreenshootsListener.class)
public class LoginWithOlxTest extends AndroidSetup {

    // login With OLX Login Page
    public void userNotAbleToLoginWithUnregisteredEmail() {}
    public void userNotAbleToLoginWithIncorrectEmailFormat() {}
    public void userNotAbleToLoginWithInvalidCredentials() {}
    public void userAbleToLoginWithValidCredentials() {}
    public void userNotAbleToLoginWithBlankCredentials() {}

    // login with FB
    public void userNotAbleToLoginWithInvalidFBCredentials() {}
    public void userAbleToLoginWithValidFBCredentials() {}

    // login with Gplus
    public void userNotAbleToLoginWithInvalidGPlusCredentials() {}
    public void userAbleToLoginWithValidGplusCredentials() {}

    // login with SMS
    public void userNotAbleToLoginWithBlankPIN() {}
    public void userAbleToMintaPIN() {}
    public void userAbleToMintaUlangPIN() {}
    public void userNotAbleToLoginWithInvalidPIN() {}
    public void userNotAbleToLoginWithInvalidPhoneNumber() {}
    public void userAbleToLoginWithValidPIN() {}





}

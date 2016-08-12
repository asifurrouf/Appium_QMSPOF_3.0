package pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by buddyarifin on 8/4/16.
 */
public class HomePage extends BasePage {
    protected static final String facebookBtnID = "com.app.tokobagus.betterb:id/entrance_btnGp";
    protected static final String googleBtnID = "com.app.tokobagus.betterb:id/entrance_btnGp";
    protected static final String smsBtnID = "com.app.tokobagus.betterb:id/entrance_btnLoginSms";
    protected static final String olxLoginID = "com.app.tokobagus.betterb:id/entrance_btnLoginOlx";
    protected static final String skipBtnID = "com.app.tokobagus.betterb:id/entrance_btnSkip";
    protected static final String olxLogoID = "";
    protected static final String presentationTextID = "com.app.tokobagus.betterb:id/entrance_bottomSubContainer1";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Step("Verify All Contents of HomePage")
    public void verifyContentsOfLoginPage() {
        verifySkipBtn();
        verifyPresentationText();
        verifyFacebookBtn();
        verifyGmailBtn();
        verifyOlxBtn();
        verifySmsBtn();
    }

    @Step("Verify Facebook Login Button")
    public void verifyFacebookBtn() {
        Assert.assertTrue(isElementPresent(getIdLocator(facebookBtnID)));
    }

    @Step("Verify Google Plus Button")
    public void verifyGmailBtn() {
        Assert.assertTrue(isElementPresent(getIdLocator(googleBtnID)));
    }

    @Step("Verify Login with SMS Button")
    public void verifySmsBtn() {
        Assert.assertTrue(isElementPresent(getIdLocator(smsBtnID)));
    }

    @Step("Verify OLX Login Button")
    public void verifyOlxBtn() {
        Assert.assertTrue(isElementPresent(getIdLocator(olxLoginID)));
    }

    @Step("Verify Skip Button")
    public void verifySkipBtn() {
        Assert.assertTrue(isElementPresent(getIdLocator(skipBtnID)));
    }

    @Step("Verify Text Presentations")
    public void verifyPresentationText() {
        Assert.assertTrue(isElementPresent(getIdLocator(presentationTextID)));
    }

    @Step("Click Facebook Login Button")
    public void clickLoginWithFacebook() {
        clickElement(getIdLocator(facebookBtnID));
    }

    @Step("Click Google Plus Login Button")
    public void clickLoginWithGPlus() {
        clickElement(getIdLocator(googleBtnID));
    }

    @Step("Click SMS Login Button")
    public LoginWithSMSPage clickLoginWithSms() {
        clickElement(getIdLocator(smsBtnID));
        return new LoginWithSMSPage(driver);
    }

    @Step("Click OLX Login Button")
    public LoginWithOlxPage clickLoginWithOlx() {
        clickElement(getIdLocator(olxLoginID));
        return new LoginWithOlxPage(driver);
    }

    @Step("Click Skip Login Button")
    public ListingPage clickSkipButton() {
        clickElement(getIdLocator(skipBtnID));
        return new ListingPage(driver);
    }
}

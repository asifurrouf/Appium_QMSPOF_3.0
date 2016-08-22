package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;
import utils.Log;

import java.util.List;

/**
 * Created by buddyarifin on 8/4/16.
 */
public class HomePage extends BasePage {
    protected static final String facebookBtnID = "com.app.sulley:id/entrance_btnGp";
    protected static final String googleBtnID = "com.app.sulley:id/entrance_btnGp";
    protected static final String smsBtnID = "com.app.sulley:id/entrance_btnLoginSms";
    protected static final String olxLoginID = "com.app.sulley:id/entrance_btnLoginOlx";
    protected static final String skipBtnID = "com.app.sulley:id/entrance_btnSkip";
    protected static final String olxLogoID = "";
    protected static final String presentationTextID = "com.app.sulley:id/entrance_bottomSubContainer1";
    public static final String paginationsID = "com.app.sulley:id/entrance_indicatorContainer";
    public static final String linearLayout = "android.widget.LinearLayout";
    public static final String imageView = "android.widget.ImageView";
    public static final String introTitleID = "com.app.sulley:id/intro_tv";
    AndroidDriver androidDriver;

    @AndroidFindBys({
            @AndroidFindBy(id = paginationsID),
            @AndroidFindBy(className = linearLayout),
            @AndroidFindBy(className = imageView)
    })
    public List<AndroidElement> paginations;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Step("Verify All Contents of HomePage")
    public void verifyContentsOfLoginPage() {
        Log.info("Verify All Contents of HomePage");
        verifySkipBtn();
        verifyPresentationText();
        verifyFacebookBtn();
        verifyGmailBtn();
        verifyOlxBtn();
        verifySmsBtn();
    }

    @Step("Verify Facebook Login Button")
    public void verifyFacebookBtn() {
        Log.info("Verify Facebook Login Button");
        Assert.assertTrue(isElementPresent(getIdLocator(facebookBtnID)));
    }

    @Step("Verify Google Plus Button")
    public void verifyGmailBtn() {
        Log.info("Verify Google Plus Button");
        Assert.assertTrue(isElementPresent(getIdLocator(googleBtnID)));
    }

    @Step("Verify Login with SMS Button")
    public void verifySmsBtn() {
        Log.info("Verify Login with SMS Button");
        Assert.assertTrue(isElementPresent(getIdLocator(smsBtnID)));
    }

    @Step("Verify OLX Login Button")
    public void verifyOlxBtn() {
        Log.info("Verify OLX Login Button");
        Assert.assertTrue(isElementPresent(getIdLocator(olxLoginID)));
    }

    @Step("Verify Skip Button")
    public void verifySkipBtn() {
        Log.info("Verify Skip Button");
        Assert.assertTrue(isElementPresent(getIdLocator(skipBtnID)));
    }

    @Step("Verify Text Presentations")
    public void verifyPresentationText() {
        Log.info("Verify Text Presentations");
        Assert.assertTrue(isElementPresent(getIdLocator(presentationTextID)));
    }

    @Step("Click Facebook Login Button")
    public LoginWithFB clickLoginWithFacebook() {
        Log.info("Click Facebook Login Button");
        clickElement(getIdLocator(facebookBtnID));
        return new LoginWithFB(driver);
    }

    @Step("Click Google Plus Login Button")
    public LoginWithGplus clickLoginWithGPlus() {
        Log.info("Click Google Plus Login Button");
        clickElement(getIdLocator(googleBtnID));
        return new LoginWithGplus(driver);
    }

    @Step("Click SMS Login Button")
    public LoginWithSMSPage clickLoginWithSms() {
        Log.info("Click SMS Login Button");
        clickElement(getIdLocator(smsBtnID));
        return new LoginWithSMSPage(driver);
    }

    @Step("Click OLX Login Button")
    public LoginWithOlxPage clickLoginWithOlx() {
        Log.info("Click OLX Login Button");
        clickElement(getIdLocator(olxLoginID));
        return new LoginWithOlxPage(driver);
    }

    @Step("Click Skip Login Button")
    public ListingPage clickSkipButton() {
        Log.info("Click Skip Login Button");
        clickElement(getIdLocator(skipBtnID));
        return new ListingPage(driver);
    }

    @Step("Verify Sliders Contents")
    public void verifySlidersContents() {
        Log.info("Sliders available size : "+paginations.size());
        Log.info(" intro title : ");
        for (int i=0; i < paginations.size() ;i++) {
            Log.info("  * "+getStringText(getIdLocator(introTitleID)));
            androidDriver = ((AndroidDriver) driver);
            androidDriver.swipe(androidDriver.manage().window().getSize().getWidth()-10,
                    300, 20, 300, 10000);
            Assert.assertNotNull(getStringText(getIdLocator(introTitleID)));
        }
    }
}

package pages;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;
import utils.Log;

import java.util.List;

/**
 * Created by buddyarifin on 8/12/16.
 */
public class LoginWithGplus extends BasePage {

    public static final String listAccountID = "android:id/list";
    public static final String accountName = "com.google.android.gms:id/account_display_name";
    public static final String accountEmail = "com.google.android.gms:id/account_name";
    public static final String addAccount = "android:id/button2";
    public static final String permissionDetailsInfo = "";
    public static final String allowBtn = "";
    public static final String denyBtn = "";

    public LoginWithGplus(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBys({
            @AndroidFindBy(id = listAccountID),
            @AndroidFindBy(className = Constants.linearLayout),
            @AndroidFindBy(className = Constants.linearLayout)
    })
    protected List<AndroidElement> listAccount;

    @Step("Verify Existing Google Account on Devices")
    public void verifyAccountExist() {
        Log.info("Account Available ["+listAccount.size()+"]: ");
        for (int i = 0 ; i < listAccount.size() ; i++) {
            String text = listAccount.get(i).findElementById(accountEmail).getText();
            Log.info("- "+text);
        }
    }
    public void verifyPermissionDetailsInfo() {}
    public void verifyAllowBtn() {}
    public void clickAllowBtn() {}
    public void verifyDenyBtn() {}
    public void clickDenyBtn() {}
    public void verifySetCategoryPrefefences() {}
}

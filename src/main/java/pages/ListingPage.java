package pages;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

/**
 * Created by buddyarifin on 8/11/16.
 */
public class ListingPage extends BasePage {

    protected static String titleListingText = "Pilih Kategori Favorit Kamu";
    protected static final String categoryListingID = "com.app.tokobagus.betterb:id/rvCategory";
    protected static final String cardViewID = "com.app.tokobagus.betterb:id/card_view";
    protected static final String categoryTitle = "com.app.tokobagus.betterb:id/tvCategoryTitle";
    protected static String buttonSimpanID = "";

    public ListingPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBys({
            @AndroidFindBy( id = cardViewID ),
            @AndroidFindBy(className = "android.widget.RelativeLayout"),
            @AndroidFindBy(className = "android.widget.LinearLayout"),
            @AndroidFindBy(id = categoryTitle)
    })
    protected List<AndroidElement> categoryContainers;

    @Step("Verify All Contents of Listing Page")
    public void verifyAllContentsOfListingPage() {
        verifyTitleListing();
        verifyCategoryListing();
    }

    @Step("Verify Title Listing Page")
    public void verifyTitleListing() {
        Assert.assertTrue(isElementPresent(getTextLocator(titleListingText)));
    }

    @Step("Verify Category Listing")
    public void verifyCategoryListing() {
        System.out.println("Category Available ");
        isWaitElementPresent(getIdLocator(cardViewID));
        for (int i = 0 ; i < categoryContainers.size() ; i++) {
            String category = categoryContainers.get(i).getText();
            System.out.println(category + " ");
            Assert.assertNotNull(category);
        }
    }

}

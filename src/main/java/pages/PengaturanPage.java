package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

/**
 * Created by buddyarifin on 6/29/16.
 */
public class PengaturanPage extends BasePage {
    public static final String ANDROID_WIDGET_LINEAR_LAYOUT = "android.widget.LinearLayout";
    public static final String ANDROID_WIDGET_FRAME_LAYOUT = "android.widget.FrameLayout";
    public static final String ANDROID_WIDGET_EDIT_TEXT = "android.widget.EditText";
    public static final String _NEWCONTACT = "085718893452";
    public static final String _NEWNAME = "Frengky Sheeran New";
    public static String navigationListId = "com.app.tokobagus.betterb:id/navigation_drawer";
    public static String notifEmailText = "Notifikasi melalui email";
    public static String ubahNotifEmailId = "com.app.tokobagus.betterb:id/doneButton";
    public static String newsLetterChxBoxText = "Ya, saya ingin menerima newsletter";
    public static String pesanNotifEmailText = "Ya, saya ingin menerima pesan notifikasi melalui email";
    public static String iklanInfoEmailText = "Ya, saya ingin menerima informasi iklan baru melalui email";
    public static String gantiPassText = "Ganti password";
    public static String ubahPassBtnId = "com.app.tokobagus.betterb:id/doneButton";
    public static String gantiProfileText = "Ganti profil";
    public static String lokasiEditId = "com.app.tokobagus.betterb:id/chooserBtn";
    public static String notifSwitchId = "com.app.tokobagus.betterb:id/settings_enable_notification_switch";
    public static String alertNotifyId = "com.app.tokobagus.betterb:id/buttonPanel";
    public static String disableNotifBtnId = "android:id/button2";
    public static String enableNotifBtnId = "android:id/button1";
    public static String offStatusText = "Notifikasi OFF";
    public static String onStatusText = "Notifikasi ON";

    public static String usernameFieldId = "com.app.tokobagus.betterb:id/contactNameInput";
    public static String pinBBFieldId = "com.app.tokobagus.betterb:id/bbpinInput";
    public static String contactFieldId = "com.app.tokobagus.betterb:id/contactPhoneInput";
    public static String whatsappFieldId = "com.app.tokobagus.betterb:id/checkbox";


    private String logoutButtonText="Log out";
    private String backArrowButton = "Navigate up";

    public PengaturanPage(WebDriver driver) { super(driver); }

    @Step("Verify All Contents of Pengaturan")
    public void verifyAllPengaturanContents() {
        verifySwitchNotifDisplay();
        verifyGantiPassDisplay();
        verifyGantiProfileDisplay();
        verifyNotificationByEmailDisplay();
    }

    @Step("Verify Switch Notification Display")
    public void verifySwitchNotifDisplay() {
        System.out.println("Verify Switch Notification Display");
        Assert.assertTrue(isWaitElementPresent(getIdLocator(notifSwitchId)));
    }

    @Step("Verify Ganti Password Display")
    public void verifyGantiPassDisplay() {
        System.out.println("Verify Ganti Password Display");
        Assert.assertTrue(isWaitElementPresent(getTextLocator(gantiPassText)));
    }

    @Step("Verify Ganti Profile Display")
    public void verifyGantiProfileDisplay() {
        System.out.println("Verify Ganti Profile Display");
        Assert.assertTrue(isWaitElementPresent(getTextLocator(gantiProfileText)));
    }

    @Step("Verify Notification by Email Display")
    public void verifyNotificationByEmailDisplay() {
        System.out.println("Verify Notification by Email Display");
        Assert.assertTrue(isWaitElementPresent(getTextLocator(notifEmailText)));
    }

    @Step("Switch Off Notifikasi")
    public void switchOffNotif() {
        System.out.println("Click Notifikasi Toggle Switch");
        clickElement(getIdLocator(notifSwitchId));
        clickElement(getIdLocator(enableNotifBtnId));
        Assert.assertTrue(isWaitElementPresent(getSwitchTextLocator(offStatusText)), "Notification Status ON Already");
    }

    @Step("Switch On Notifikasi")
    public void switchONNotif() {
        System.out.println("Click Notifikasi Toggle Switch");
        clickElement(getIdLocator(notifSwitchId));
        clickElement(getIdLocator(enableNotifBtnId));
        Assert.assertTrue(isWaitElementPresent(getSwitchTextLocator(onStatusText)), "Notification Status OFF Already");
    }

    @Step("Click Ganti Password")
    public void clickGantiPass() {
        System.out.println("Click Ganti Password");
        clickElement(getTextLocator(gantiPassText));
        Assert.assertTrue(isWaitElementPresent(getIdLocator(ubahPassBtnId)));
    }

    @Step("Click Ganti Profile")
    public void clickGantiProfile() {
        System.out.println("Click Ganti Profile");
        clickElement(getTextLocator(gantiProfileText));
        Assert.assertTrue(isWaitElementPresent(getIdLocator(lokasiEditId)));
        changeName(_NEWNAME);
        changeContact(_NEWCONTACT);
        availableInWhatsApp();
    }

    @Step("Ganti Profile - Change Name to {0}")
    public void changeName(String name){
        WebElement username = textField(usernameFieldId);
        Assert.assertTrue(username.isDisplayed(), "Username not display on the screen");
        System.out.print("Existing Name "+username.getText());
        username.sendKeys(name);
        System.out.print(" Update to "+username.getText());
        Assert.assertTrue(name.equalsIgnoreCase(username.getText()));
    }

    @Step("Ganti Profile - Change Contact Number to {0}")
    public void changeContact(String phone){
        WebElement contact = textField(contactFieldId);
        Assert.assertTrue(contact.isDisplayed(), "Username not display on the screen");
        System.out.println("Existing Contact "+contact.getText());
        contact.sendKeys(phone);
        System.out.println(" Update to "+phone);
        Assert.assertTrue(phone.equalsIgnoreCase(contact.getText()));
    }

    @Step("Ganti Profile - Check 'Saya bisa dihubungi lewat WhatsApp'")
    public void availableInWhatsApp() {
        Assert.assertTrue(isElementPresent(getIdLocator(whatsappFieldId)));
        clickElement(getIdLocator(whatsappFieldId));
    }

    @Step("Click Notifikasi Melalui Email")
    public void clickNotifEmail() {
        System.out.println("Click Notifikasi Melalui Email");
        clickElement(getTextLocator(notifEmailText));
        Assert.assertTrue(isWaitElementPresent(getIdLocator(ubahNotifEmailId)));
    }

    @Step("Back to Home Page")
    public HomePage clickBackButton(){
        clickElement(getContentLocator(backArrowButton));
        return new HomePage(driver);
    }

    public List<WebElement> listProfileElement(String id) {
        return getListElements(getIdLocator(id)).iterator().next()
                .findElements(By.className(ANDROID_WIDGET_LINEAR_LAYOUT)).iterator().next()
                .findElements(By.className(ANDROID_WIDGET_FRAME_LAYOUT)).iterator().next()
                .findElements(By.className(ANDROID_WIDGET_LINEAR_LAYOUT)).get(0)
                .findElements(By.className(ANDROID_WIDGET_FRAME_LAYOUT));
    }

    public WebElement textField(String id){
        List<WebElement> textField = listProfileElement(id);
        WebElement textfield = textField.get(0).findElement(By.className(ANDROID_WIDGET_EDIT_TEXT));
        return textfield;
    }

}

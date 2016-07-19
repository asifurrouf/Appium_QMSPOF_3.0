package scenarios;

import junit.framework.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.PengaturanPage;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import ru.yandex.qatools.allure.annotations.Title;

/**
 * Created by buddyarifin on 6/30/16.
 */

@Listeners({ScreenshootsListener.class})
@Features("Pengaturan Page Feature")
public class PengaturanPageTest extends AndroidSetup {
    private String emailValid="frengky.sheeran@gmail.com";
    private String passValid="frengky123.,";
    private LoginPage loginpage;
    private PengaturanPage pengaturanPage;
    private HomePage homepage;

    @Test(priority=1)
    @Title("Verify Unregistered User able to Switch Notification Off or On")
    public void unregisteredUserAbleToSwitchNotif(){
        System.out.println("Verify Unregistered User able to Switch Notification Off or On");
        homepage = new HomePage(driver);
        homepage.clickLocationNotif();
        pengaturanPage = homepage.clickPengaturanBtn();
        pengaturanPage.switchOffNotif();
        pengaturanPage.clickBackButton();
    }

    @Test(priority=2)
    @Title("Verify System able to Display All Pengaturan Options")
    public void checkPengaturanContents(){
        System.out.println("Verify System able to Pengaturan Contents");
        homepage = new HomePage(driver);
        loginpage = homepage.clickLoginPage();
        loginpage.inputEmail(emailValid);
        loginpage.inputPassword(passValid)                                                                                                                                                                          ;
        loginpage.clickSubmitLoginButton();
        loginpage.verifySuccessLogin();
        homepage.clickBackButton();
        pengaturanPage = homepage.clickPengaturanBtn();
        pengaturanPage.verifyAllPengaturanContents();
        pengaturanPage.clickBackButton();
    }

    @Test(priority=3)
    @Title("Verify Registered User able to Switch Notification Off")
    public void registeredUserAbleToSwitchNotifOff(){
        System.out.println("Verify Registered User able to Switch Notification Off");
        homepage = new HomePage(driver);
        pengaturanPage = homepage.clickPengaturanBtn();
        pengaturanPage.switchONNotif();
        pengaturanPage.clickBackButton();
    }

    @Test(priority=4)
    @Title("Verify Registered User able to Update Profile")
    public void registeredUserAbleUpdateProfile(){
        System.out.println("Verify Registered User able to Update Profile");
        homepage = new HomePage(driver);
        pengaturanPage = homepage.clickPengaturanBtn();
        pengaturanPage.clickGantiProfile();
        pengaturanPage.clickBackButton();
    }

}

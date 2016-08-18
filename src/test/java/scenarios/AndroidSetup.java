package scenarios;


import io.appium.java_client.android.AndroidDriver;
import pages.Constant;

import org.json.JSONArray;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.BasePage;
import tracking.NetClient;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;


public class AndroidSetup {

    public AndroidDriver driver;
    public static JSONArray array;
    public NetClient net;
    
    public void prepareAndroidForAppium(String udid) throws MalformedURLException, Exception {
        File appDir = new File(Constant.apkDir);
        File app = new File(appDir, "olxid-6.4.2.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("device","Android");

        capabilities.setCapability("appPackage", "com.app.tokobagus.betterb");
        capabilities.setCapability("appActivity", "sea.olx.activities.SplashscreenActivity");

        capabilities.setCapability("deviceName","Galaxy S4");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("newCommandTimeout", 60 * 5);
        //capabilities.setCapability("udid", udid);
        
        //No Reset Apps
        capabilities.setCapability("noReset", false);
        capabilities.setCapability("fullReset", true);
        
        //other caps
        capabilities.setCapability("app", app.getAbsolutePath());
        driver =  new AndroidDriver(new URL(Constant.hubIP), capabilities);
        System.out.println("SESSION CREATED : "+driver.getSessionId().toString()+" "+udid+" ");
    }

    public void scrollTo(String text){
        driver.scrollTo(text);	
    }
    
    
    @Parameters({"udid"})
    @BeforeClass
    public void setUp(String udid, ITestContext ctx) throws Exception{
        prepareAndroidForAppium(udid);
        ctx.setAttribute("WebDriver", this.driver);
    }

    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();
    }
}

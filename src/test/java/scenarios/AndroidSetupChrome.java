package scenarios;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;


public class AndroidSetupChrome {
    public AndroidDriver driver;
    
    @BeforeMethod
    public void prepareAndroidForAppium() throws MalformedURLException {

       DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "4.4");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        driver =  new AndroidDriver(new URL("http://192.168.99.100:4444/wd/hub"), capabilities);
       
    }
    
    @Test
    public void openUri(){
    	driver.get("http://www.google.com");
 		System.out.println("Android Title is: " + driver.getTitle());
    }
    
    
}

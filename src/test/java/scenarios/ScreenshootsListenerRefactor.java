package scenarios;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import pages.BasePage;

public class ScreenshootsListenerRefactor extends TestListenerAdapter  {
    private BasePage base;
    private WebDriver driver;

    @Override
    public void onTestSuccess(ITestResult testResult){
    	driver = DriverInstance.getDriver();
        base = new BasePage(driver);
        try {
        	System.out.println("FailedOn_"+testResult.getTestClass().getName()+testResult.getMethod().getMethodName()+".png");
            base.getAttachment("FailedOn_"+testResult.getTestClass().getName()+testResult.getMethod().getMethodName()+".png");
        } catch (Exception e){
            System.out.print("-->Unable to screen capture");
            e.printStackTrace();
        }
    }

}

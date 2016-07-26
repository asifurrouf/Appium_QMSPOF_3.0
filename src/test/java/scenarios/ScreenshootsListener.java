package scenarios;

import io.appium.java_client.android.AndroidDriver;
import org.json.JSONArray;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import pages.BasePage;
import ru.yandex.qatools.allure.annotations.Title;
import ru.yandex.qatools.allure.utils.AnnotationManager;
import sun.nio.ch.Net;
import tracking.NetClient;

import java.lang.reflect.Field;
import java.util.Iterator;

/**
 * Created by buddyarifin on 6/14/16.
 */
public class ScreenshootsListener extends TestListenerAdapter  {
    private BasePage base;
    WebDriver driver;
    Object obj;
    AndroidSetup androidSetup;

    @Override
    public void onTestFailure(ITestResult testResult){
        obj = testResult.getInstance();
        driver = ((AndroidSetup)obj).driver;
        base = new BasePage(driver);
        try {
            System.out.println("***** Error "+testResult.getName()+" test has failed *****");
            base.getAttachment("FailedOn_"+testResult.getTestClass().getName()+testResult.getMethod().getMethodName()+".png");
//            request.goToTracker(testResult, this.array);
            System.out.println("FailedOn_"+testResult.getTestClass().getName()+testResult.getMethod().getMethodName()+".png");
        } catch (Exception e){
            System.out.print("-->Unable to screen capture");
            e.printStackTrace();
        }
    }

    @Override
    public void onTestStart(ITestResult result){
        System.out.println("Running Test --> "+result.getMethod().getMethodName());
//        this.array = AndroidSetup.array;
    }

    @Override
    public void onTestSuccess(ITestResult testResult){
        obj = testResult.getInstance();
        driver = ((AndroidSetup)obj).driver;
        base = new BasePage(driver);
        try {
            System.out.println("***** Success Execution for "+testResult.getName()+" *****");
//            request.goToTracker(testResult, this.array);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onFinish(ITestContext testContext) {
        Iterator<ITestResult> listOfFailedTests = testContext.getFailedTests().getAllResults().iterator();
        while (listOfFailedTests.hasNext()){
            ITestResult failedTest = listOfFailedTests.next();
            ITestNGMethod method = failedTest.getMethod();
            if (testContext.getFailedTests().getResults(method).size() > 1){
                listOfFailedTests.remove();
            } else {
                if (testContext.getPassedTests().getResults(method).size() > 0) {
                    listOfFailedTests.remove();
                }
            }
        }
    }

}

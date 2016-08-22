package scenarios;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.json.JSONArray;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import pages.BasePage;
import ru.yandex.qatools.allure.annotations.Title;
import ru.yandex.qatools.allure.utils.AnnotationManager;
import scenarios.AndroidSetup;
import sun.nio.ch.Net;
import tracking.NetClient;
import utils.Log;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Iterator;

/**
 * Created by buddyarifin on 6/14/16.
 */
public class ScreenshootsListener extends TestListenerAdapter  {
    private BasePage base;
    private WebDriver driver;
    private Object obj;
    private Annotation[] annotations;

    @Override
    public void onTestFailure(ITestResult testResult){
        obj = testResult.getInstance();
        driver = ((AndroidSetup)obj).driver;
        base = new BasePage(driver);
        try {
            Log.info("***** Error "+getTestTitle(testResult)+" test has failed *****");
            base.getAttachment("FailedOn_"+testResult.getTestClass().getName()+testResult.getMethod().getMethodName()+".png");
//            request.goToTracker(testResult, this.array);
            Log.info("FailedOn_"+testResult.getTestClass().getName()+testResult.getMethod().getMethodName()+".png");
        } catch (Exception e){
            Log.info("-->Unable to screen capture, for test "+getTestTitle(testResult));
            e.printStackTrace();
        }
    }

    @Override
    public void onTestStart(ITestResult testResult){
        Log.info("Running Test --> "+getTestTitle(testResult));
        obj = testResult.getInstance();
        driver = ((AndroidSetup)obj).driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), obj);
//        this.array = AndroidSetup.array;
    }

    @Override
    public void onTestSuccess(ITestResult testResult){
        obj = testResult.getInstance();
        driver = ((AndroidSetup)obj).driver;
        base = new BasePage(driver);
        try {
            Log.info("***** Success Execution for "+getTestTitle(testResult)+" *****");
//            request.goToTracker(testResult, this.array);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onFinish(ITestContext testContext) {
        Iterator<ITestResult> listOfFailedTests = testContext.getFailedTests().getAllResults().iterator();
        Iterator<ITestResult> listOfSkippedTests = testContext.getSkippedTests().getAllResults().iterator();
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

        while (listOfSkippedTests.hasNext()){
            ITestResult failedTest = listOfSkippedTests.next();
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

    public String getTestTitle(ITestResult result) {
        annotations = result.getMethod().getConstructorOrMethod().getMethod().getAnnotations();
        AnnotationManager annotationManager = new AnnotationManager(annotations);
        return annotationManager.getTitle();
    }

}

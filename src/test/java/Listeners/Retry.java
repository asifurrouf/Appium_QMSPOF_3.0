package Listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.allure.utils.AnnotationManager;
import utils.Log;

/**
 * Created by buddyarifin on 7/22/16.
 */
public class Retry implements IRetryAnalyzer {

    private int retryCount=1;
    private int maxRetryCount=2;

    @Step("Retry Mode : re-run failed testcases")
    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            AnnotationManager testAnnotationAllure = new AnnotationManager(result.getMethod().getConstructorOrMethod()
                    .getMethod().getAnnotations());
            Log.info("######  Retry failed tc-scenarios : " + testAnnotationAllure.getTitle() + " ######");
            retryCount++;
            return true;
        }
        return false;
    }
}

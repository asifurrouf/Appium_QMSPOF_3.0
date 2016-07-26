package Listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.allure.utils.AnnotationManager;

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
            System.out.println("######  Retry for tc-scenarios : "+testAnnotationAllure.getTitle()+" ######");
            retryCount++;
            return true;
        }
        return false;
    }
}

package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;
import utilites.logsutils;

public class itestresultmethodclass implements ITestListener {
    public void onTestStart(ITestResult result) {
        logsutils.info("Testcase " + result.getName() + "started");

    }

    public void onTestFailure(ITestResult result) {

        logsutils.info("Testcase " + result.getName() + "started");
    }

    public void onTestSkipped(ITestResult result) {
        logsutils.info("Testcase " + result.getName() + "  started ");
    }
}

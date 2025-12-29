package listeners;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestContext;
import org.testng.ITestResult;
import utilites.utility;

import java.io.IOException;

import static drivefactorys.drivefactory.getdriver;

public class iinvokeedmethodslistenersclass implements IInvokedMethodListener {
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {
    }

    public void afterInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {

           if (testResult.getStatus()==ITestResult.FAILURE){
               try {
                   utility.takeingscreenshots(getdriver(),testResult.getName());
               } catch (IOException e) {
                   throw new RuntimeException(e);
               }
           }
    }
}

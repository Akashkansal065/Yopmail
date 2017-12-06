package com.selenium.ReportAnalyzer;

import java.util.Set;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

public class TestCountReset implements ITestListener {
    @Override
	public void  onFinish(ITestContext context) {
		Set<ITestResult> failedTests = context.getFailedTests().getAllResults();
		for (ITestResult temp : failedTests) {
			ITestNGMethod method = temp.getMethod();
			if (context.getFailedTests().getResults(method).size() > 1) {
				failedTests.remove(temp);
			} else {
				if (context.getPassedTests().getResults(method).size() > 0) {
					failedTests.remove(temp);
				}
			}
		}
	}
  
    public void onTestStart(ITestResult result) {   }
  
    public void onTestSuccess(ITestResult result) {   }
  
    public synchronized void onTestFailure(ITestResult result) {/*
		Set<ITestResult> failedTests = result.getTestContext().getFailedTests().getAllResults();
		for (ITestResult temp : failedTests) {
			ITestNGMethod method = temp.getMethod();
			if (result.getTestContext().getFailedTests().getResults(method).size() > 1) {
				failedTests.remove(temp);
			} else {
				if (result.getTestContext().getFailedTests().getResults(method).size() > 0) {
					failedTests.remove(temp);
				}
			}
		}
	   */}

    public void onTestSkipped(ITestResult result) {
		Set<ITestResult> failedTests = result.getTestContext().getSkippedTests().getAllResults();
		for (ITestResult temp : failedTests) {
			ITestNGMethod method = temp.getMethod();
			if (result.getTestContext().getSkippedTests().getResults(method).size() > 0) {
				failedTests.remove(temp);
			} /*else {
				if (result.getTestContext().getSkippedTests().getResults(method).size() > 0) {
					failedTests.remove(temp);
				}*/
			//}
		}
	}

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {   }

    public void onStart(ITestContext context) {   }
} 
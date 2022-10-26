package com.uisuite.listeners;

import com.uisuite.enums.ExtentLogType;
import com.uisuite.reporter.ExtentLogger;
import com.uisuite.reporter.ExtentReporter;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGExtentReportListener implements ITestListener, ISuiteListener {
    private static final String TEST = "Test: ";

    public void onStart(ITestContext context){
        ExtentReporter.setUpExtentReport();
    }

    public void onFinish(ITestContext context){
        ExtentReporter.flushExtentReport();
    }

    public void onTestStart(ITestResult result){
        ExtentReporter.startTest(result.getMethod().getMethodName());
    }

    public void onTestSuccess(ITestResult result){
        ExtentLogger.log(ExtentLogType.PASS, TEST+result.getMethod().getMethodName()+" is passed.");
    }

    public void onTestFailure(ITestResult result){
        ExtentLogger.log(ExtentLogType.FAIL, TEST+result.getMethod().getMethodName()+" is failed. Reason for failure: "+result.getThrowable().getMessage());
    }

    public void onTestSkipped(ITestResult result){
        ExtentLogger.log(ExtentLogType.SKIP, TEST+result.getMethod().getMethodName()+" is skipped. Reason for skip: "+result.getThrowable().getMessage());
    }
}

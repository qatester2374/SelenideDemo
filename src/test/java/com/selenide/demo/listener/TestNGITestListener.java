package com.selenide.demo.listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static com.codeborne.selenide.Selenide.screenshot;

public class TestNGITestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("*** Running test method " + result.getMethod().getMethodName() + "...");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("*** Executed " + result.getMethod().getMethodName() + " test successfully...");
    }

    @Override
    public void onTestFailure(ITestResult result) {
//        saveScreenshotPNG(AppiumManager.getGlobalDriver());
//        saveTextLog(getTestMethodName(result) + " Screenshot captured for the test case.");
//        Configuration.screenshots = true;
        screenshot("test_failed");
        System.out.println("*** Test execution " + result.getMethod().getMethodName() + " failed and screenshot taken.");
    }

    private void open(String s) {
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("*** Test " + result.getMethod().getMethodName() + " skipped...");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("*** Test failed but within percentage % " + result.getMethod().getMethodName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("*** Test Suite " + context.getName() + " ending ***");
    }

}


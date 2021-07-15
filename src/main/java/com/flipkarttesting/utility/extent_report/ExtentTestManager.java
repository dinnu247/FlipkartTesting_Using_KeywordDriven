/*
 *Purpose : Class is implemented for managing the test reports for each test
 *
 * @author Dinesh Kumar Peddakotla
 * @version 1.0
 * @since 10-07-2021
 */
package com.flipkarttesting.utility.extent_report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import java.util.HashMap;
import java.util.Map;

public class ExtentTestManager {
    static Map<Integer, ExtentTest> extentTestMap = new HashMap<>();
    static ExtentReports extent = ExtentManager.getInstance();

    //it is used to get the test
    public static synchronized ExtentTest getTest() {
        return extentTestMap.get((int) Thread.currentThread().getId());
    }

    //end the writing of results to extent report after test
    public static synchronized void endTest() {
        extent.flush();
    }

    /**
     * startTest method is used to write test results to reports
     * @param testName test method name
     * @return test
     */
    public static synchronized ExtentTest startTest(String testName) {
        ExtentTest test = extent.createTest(testName);
        extentTestMap.put((int) Thread.currentThread().getId(), test);
        return test;
    }
}

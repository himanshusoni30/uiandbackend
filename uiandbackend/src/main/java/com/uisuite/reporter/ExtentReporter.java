package com.uisuite.reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ExtentReporter {
    static Map<Integer, ExtentTest> extentTestMap = new HashMap();
    private static ExtentReports extentReports;
    private static String filePath = "";
    private final static String EXTENT_REPORT_CONFIG_FILE_PATH = "src/main/resources/extentreportconfig.json";
    private static String extentFilePath() {
        if (filePath.isBlank()) {
            filePath = System.getProperty("user.dir") + "/target/extent-test-output/" + System.currentTimeMillis() + "_index.html";
        }
        return filePath;
    }

    public static void setUpExtentReport(){
        extentReports = new ExtentReports();
        ExtentSparkReporter reporter = new ExtentSparkReporter(extentFilePath());
        try{
            reporter.loadJSONConfig(new File(EXTENT_REPORT_CONFIG_FILE_PATH));
            extentReports.attachReporter(reporter);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void flushExtentReport(){
        if(Objects.nonNull(extentReports)){
            extentReports.flush();
            ExtentReportManager.unloadExtentTest();
        }
    }

    public static void startTest(String testName){
        ExtentReportManager.setExtentTest(extentReports.createTest(testName));
    }


}

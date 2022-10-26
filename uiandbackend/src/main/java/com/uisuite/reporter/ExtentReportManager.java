package com.uisuite.reporter;

import com.aventstack.extentreports.ExtentTest;

import java.util.Objects;

public class ExtentReportManager {
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    static ExtentTest getExtentTest(){
        return extentTest.get();
    }

    static void setExtentTest(ExtentTest testReference){
        if(Objects.nonNull(testReference)){
            extentTest.set(testReference);
        }
    }

    static void unloadExtentTest(){
        extentTest.remove();
    }
}

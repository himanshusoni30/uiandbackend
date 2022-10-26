package com.uisuite.reporter;

import com.aventstack.extentreports.ExtentTest;
import com.uisuite.enums.ExtentLogType;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Consumer;

public class ExtentLogger {
    private static ExtentTest test;

    static{
        test = ExtentReportManager.getExtentTest();
    }

    private static Consumer<String> pass = message -> test.pass(message);
    private static Consumer<String> fail = message -> test.fail(message);
    private static Consumer<String> skip = message -> test.skip(message);

    private static Map<ExtentLogType, Consumer<String>> map = new EnumMap<>(ExtentLogType.class);

    static{
        map.put(ExtentLogType.PASS, pass);
        map.put(ExtentLogType.FAIL, fail);
        map.put(ExtentLogType.SKIP, skip);
    }

    public static void log(ExtentLogType status, String message){map.get(status).accept(message);}

}

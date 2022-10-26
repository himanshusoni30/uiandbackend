package com.uisuite.base;

import com.uisuite.driverandbrowsersetup.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    @BeforeMethod
    public static void setUp(){
        Driver.initDriver();
    }

    @AfterMethod
    public static void tearDown(){
        Driver.quitDriver();
    }
}

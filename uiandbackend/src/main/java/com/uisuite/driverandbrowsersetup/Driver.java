package com.uisuite.driverandbrowsersetup;

import com.uisuite.enums.BrowserType;


public class Driver {
    public static void initDriver(){
        DriverManager.setDriver(BrowserSetUp.launchBrowser(BrowserType.CHROME));
        DriverManager.getDriver().manage().deleteAllCookies();
        DriverManager.getDriver().get("https://jqueryui.com/button/");
    }

    public static void quitDriver(){
        DriverManager.getDriver().quit();
        DriverManager.unload();
    }
}

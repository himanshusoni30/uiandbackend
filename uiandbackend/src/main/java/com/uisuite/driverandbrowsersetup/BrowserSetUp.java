package com.uisuite.driverandbrowsersetup;

import com.uisuite.enums.BrowserType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public class BrowserSetUp {
    private BrowserSetUp(){}

    private static final Map<BrowserType, Supplier<WebDriver>> map = new EnumMap<>(BrowserType.class);

    private static final Supplier<WebDriver> chrome = ()->{
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    };

    static{
        map.put(BrowserType.CHROME, chrome);
    }

    public static WebDriver launchBrowser(BrowserType browser){return map.get(browser).get();}
}

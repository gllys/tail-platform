package com.zlt.gllys.tester;

import com.zlt.gllys.controller.DefaultApiController;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by zhangletian on 16/8/3.
 */
public class AppiumDriverSetter {
    private Logger logger = Logger.getLogger(DefaultApiController.class);
    private static AndroidDriver<AndroidElement> appiumDriver = null;

    @BeforeClass
    public static AndroidDriver init() {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("platformName", "Android");
        cap.setCapability("deviceName", "Android");
        cap.setCapability("appActivity", ".Launcher");
        cap.setCapability("appPackage", "me.ele");
        cap.setCapability("ignoreUnimportantViews", "true");
        try {
            appiumDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
            return appiumDriver;
        } catch (MalformedURLException mal) {
            mal.printStackTrace();
            return appiumDriver;
        }


    }

    @Test
    public void Open() throws Exception {
        Thread.sleep(30000);
    }

    @AfterClass
    public void Closed() {
        appiumDriver.close();
        appiumDriver.quit();

    }
}

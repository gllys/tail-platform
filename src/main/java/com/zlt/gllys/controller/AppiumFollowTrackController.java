package com.zlt.gllys.controller;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangletian on 16/8/2.
 */
@Controller
@RequestMapping("/appium")
public class AppiumFollowTrackController {
    private AppiumDriver<AndroidElement> appiumDriver;

    @RequestMapping("")
    public Map<String, Object> one_tow_three() {


        return new HashMap<>();


    }


}

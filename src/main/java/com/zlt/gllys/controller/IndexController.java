package com.zlt.gllys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zhangletian on 16/7/26.
 */

@Controller
@RequestMapping("/tail")
public class IndexController {

    @RequestMapping("/login")
    public String login() {
        return "login";
    }
    @RequestMapping("/index")
    public String index() {
        return "index";
    }
    @RequestMapping("/registration")
    public String registration() {
        return "registration";
    }
}

package com.zlt.gllys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zhangletian on 16/7/26.
 */

@Controller
@RequestMapping("/tail")
public class IndexController extends BaseController {

    @RequestMapping("/login")
    public String login() throws Exception {
        return "login";
    }

    @RequestMapping("/index")
    public String index() throws Exception {
        return "index";
    }

    @RequestMapping("/registration")
    public String registration() throws Exception {
        return "registration";
    }
}

package com.zlt.gllys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zhangletian on 16/7/20.
 */

@Controller
@RequestMapping("/")
public class DefaultController extends BaseController{
    @RequestMapping("")
    public String defaultController(Model model)throws Exception{
        model.addAttribute("name","tail-platform");
        return  "redirect:/tail/index";
    }

    @RequestMapping("/500")
    public String showServerError() {
        return "500";
    }
}

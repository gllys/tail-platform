package com.zlt.gllys.controller;


import com.zlt.gllys.impl.UserServiceImpl;
import com.zlt.gllys.model.Role;
import com.zlt.gllys.model.UserCreateForm;
import com.zlt.gllys.util.ResultUtil.*;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangletian on 16/7/20.
 */

@Controller
@RequestMapping("/restapi")
public class UserInfoController extends BaseController{

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("/index")
    public String greetingFirst() {
        return "index";
    }



    @RequestMapping("/login")
    public String login(Model model) {
        model.addAttribute("name", "platform-tail");
        return "login";
    }

    @RequestMapping(value = "/user",method = RequestMethod.POST)
    @ResponseBody
    public HttpEntity user(HttpServletRequest request,
                               Model model,@RequestBody Object params)throws Exception{
        Map<String, Object> map = new HashMap<>();
        if(params==null){
            map.put("code","403");
            map.put("message","参数不完整");
            return new ResponseEntity<Object>(map, HttpStatus.FORBIDDEN);

        }
        JSONObject jsonObject = JSONObject.fromObject(params);
        UserCreateForm userCreateForm = new UserCreateForm();
        userCreateForm.setEmail(jsonObject.getString("email"));
        userCreateForm.setPassword(jsonObject.getString("password"));
        userCreateForm.setRole(Role.USER);

        Result<Boolean> result = userService.create(userCreateForm);
        map.put("code",200);
        map.put("message",result.getMessage());
        return new ResponseEntity<Object>(map,HttpStatus.OK);
    }

}

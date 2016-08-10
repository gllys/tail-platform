package com.zlt.gllys.controller;


import com.zlt.gllys.impl.UserInfoServiceImpl;
import com.zlt.gllys.model.UserInfo;
import com.zlt.gllys.util.ResultUtil.*;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
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
 * Created by zhangletian on 16/7/22.
 */
@SuppressWarnings("SpringJavaAutowiringInspection") //加这个注解让IDE 不报: Could not autowire

@Controller
@RequestMapping("/api")
public class DefaultApiController extends BaseController {
    private Logger logger = Logger.getLogger(DefaultApiController.class);
    @Autowired
    private UserInfoServiceImpl userInfoService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> tryFirst(HttpServletRequest request,
                                        Model model,@RequestBody Object params) throws Exception{
        String username = "username";
        Map<String, Object> map = new HashMap<>();
        JSONObject jsonObject = JSONObject.fromObject(params);
        if(jsonObject.isEmpty()||jsonObject.getString(username)==null){
            map.put("code",503);
            map.put("message","却少参数:username");
            return map;
        }
        UserInfo userInfo = userInfoService.selectByUserName(jsonObject.getString(username));
        if(userInfo==null){
            map.put("code",503);
            map.put("result",userInfo);
            return map;
        }
        map.put("result", userInfo);
        logger.info(userInfo);
        logger.info("number:one");
        return map;
    }

    @RequestMapping(value = "/postValue", method = RequestMethod.POST)
    @ResponseBody
    public HttpEntity postValue(HttpServletRequest request,
                                Model model, @RequestBody Object params) throws Exception{

        Map<String, Object> map = new HashMap<>();

        if(params==null){
            map.put("code","403");
            map.put("message","参数不完整");
            return new ResponseEntity<Object>(map, HttpStatus.FORBIDDEN);

        }

        JSONObject jsonObject = JSONObject.fromObject(params);


        Result<Boolean> result = userInfoService.postValue(jsonObject);
        if(!result.isSuccess()){
            map.put("code", "500");
            map.put("message", result.getMessage());
            return new ResponseEntity<Object>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        else {
            map.put("code", "200");
            map.put("message", result.getMessage());
            return new ResponseEntity<Object>(map, HttpStatus.OK);
        }
    }


}

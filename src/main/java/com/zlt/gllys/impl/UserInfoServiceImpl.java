package com.zlt.gllys.impl;

import com.zlt.gllys.mapper.UserInfoMapper;
import com.zlt.gllys.model.UserInfo;
import com.zlt.gllys.service.UserInfoService;
import com.zlt.gllys.util.ResultSupportUtil;
import com.zlt.gllys.util.ResultUtil.Result;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by zhangletian on 16/7/20.
 */
@SuppressWarnings("SpringJavaAutowiringInspection") //加这个注解让IDE 不报: Could not autowire
@Service
public class UserInfoServiceImpl implements UserInfoService {
    private static Logger logger = Logger.getLogger(UserInfoServiceImpl.class);

    //@Autowired
    //private SqlSession sqlSession;
    @Autowired
    private UserInfoMapper userInfoMapper;


    @Override
    public Result<UserInfo> selectByUserName(String userName) {

        if (userName.isEmpty() || userName == null) {
            return null;
        }
        //return this.sqlSession.selectOne("selectByUserName", userName);
        return userInfoMapper.selectByUserName(userName);
    }

    @Override
    public Result<Boolean> postValue(JSONObject jsonObject) {
        ResultSupportUtil<Boolean> result = new ResultSupportUtil<Boolean>();
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(jsonObject.getString("username"));
        userInfo.setUserpwd(jsonObject.getString("userpwd"));
        userInfo.setAuth(jsonObject.getString("userauth"));
        userInfoMapper.postValue(userInfo);
        result.setResult(true,"200","success");
        return result;

    }


}

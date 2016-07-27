package com.zlt.gllys.service;

import com.zlt.gllys.model.UserInfo;
import com.zlt.gllys.util.ResultUtil.*;
import net.sf.json.JSONObject;

/**
 * Created by zhangletian on 16/7/20.
 */

public interface UserInfoService {

 UserInfo selectByUserName(String userName);
 Result<Boolean> postValue(JSONObject jsonObject);
}

package com.zlt.gllys.mapper;

import com.zlt.gllys.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;


/**
 * Created by zhangletian on 16/7/20.
 */


@Mapper
public interface UserInfoMapper {

 UserInfo selectByUserName(String userName);
 int postValue(UserInfo userInfo);

}

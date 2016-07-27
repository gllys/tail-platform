package com.zlt.gllys.mapper;

import com.zlt.gllys.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.Collection;

/**
 * Created by zhangletian on 16/7/27.
 */
@Mapper
public interface UserMapper {
    User findOneByEmail(String email);

    User findOneById(Long id);

    Collection<User> findAll();

    Boolean saveUser(User user);


}
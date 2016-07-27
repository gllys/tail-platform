package com.zlt.gllys.service;

import com.zlt.gllys.model.User;
import com.zlt.gllys.model.UserCreateForm;
import com.zlt.gllys.util.ResultUtil.Result;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by zhangletian on 16/7/27.
 */
public interface UserService {

    Optional<User> getUserById(long id);

    User getUserByEmail(String email);

    Collection<User> getAllUsers();

    Result<Boolean> create( UserCreateForm form);


}

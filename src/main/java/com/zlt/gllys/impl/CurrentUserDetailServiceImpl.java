package com.zlt.gllys.impl;

/**
 * Created by zhangletian on 16/7/27.
 */

import com.zlt.gllys.mapper.UserMapper;
import com.zlt.gllys.model.CurrentUser;
import com.zlt.gllys.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


/**
 * Created by zhangletian on 16/7/27.
 */
@Service
public class CurrentUserDetailServiceImpl implements UserDetailsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CurrentUserDetailServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

//    @Autowired
//    public CurrentUserDetailServiceImpl(UserMapper userMapper) {
//        this.userMapper = userMapper;
//    }

    @Override
    public CurrentUser loadUserByUsername(String email) {
        LOGGER.debug("Authenticating user with email={}", email.replaceFirst("@.*", "@***"));
        User user = userMapper.findOneByEmail(email);
        if(user==null)
        {throw new UsernameNotFoundException(String.format("User with email=%s was not found", email));}
        return new CurrentUser(user);
    }


}

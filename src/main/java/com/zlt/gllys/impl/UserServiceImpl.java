package com.zlt.gllys.impl;

import com.zlt.gllys.mapper.UserMapper;
import com.zlt.gllys.model.User;
import com.zlt.gllys.model.UserCreateForm;
import com.zlt.gllys.service.UserService;
import com.zlt.gllys.util.ResultSupportUtil;
import com.zlt.gllys.util.ResultUtil.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by zhangletian on 16/7/27.
 */
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Service
    public class UserServiceImpl implements UserService {

        private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);


        @Autowired
        private UserMapper userMapper;


        @Override
        public Optional<User> getUserById(long id) {
            LOGGER.debug("Getting user={}", id);
            return Optional.ofNullable(userMapper.findOneById(id));
        }

        @Override
        public User getUserByEmail(String email) {
            LOGGER.debug("Getting user by email={}", email.replaceFirst("@.*", "@***"));
            return userMapper.findOneByEmail(email);
        }

        @Override
        public Collection<User> getAllUsers() {
            LOGGER.debug("Getting all users");
            return userMapper.findAll();
        }

        @Override
        public Result<Boolean> create(UserCreateForm form) {
            ResultSupportUtil<Boolean> result = new ResultSupportUtil<>();
            User user = new User();
            user.setEmail(form.getEmail());
            user.setPasswordHash(new BCryptPasswordEncoder().encode(form.getPassword()));
            user.setRole(form.getRole());
            userMapper.saveUser(user);
            result.setResult(true,"200","success");
            return result;
        }

    }


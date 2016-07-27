package com.zlt.gllys.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;


/**
 * Created by zhangletian on 16/7/21.
 */
public class LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    protected static final Logger LOGGER = LoggerFactory.getLogger(LoginSuccessHandler.class);
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

        //TODO Harish
        LOGGER.info("LoginSuccessHandler <- onAuthenticationSuccess() -> for user: TODO Harish");
        setDefaultTargetUrl("/static/user.html");
        super.onAuthenticationSuccess(request, response, authentication);
    }
}


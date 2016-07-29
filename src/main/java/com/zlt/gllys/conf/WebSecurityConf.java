package com.zlt.gllys.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by zhangletian on 16/7/20.
 */
@SuppressWarnings("SpringJavaAutowiringInspection")
@Configuration
@EnableWebSecurity
public class WebSecurityConf extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        //auth.inMemoryAuthentication().withUser("admin").password("admin").roles("USER");
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(new BCryptPasswordEncoder());

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                //不验证拦截的匹配目录
                .antMatchers("/resources/**", "/api/**", "/tail/registration")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                //登陆的页面,锁死
                .loginPage("/tail/login")
                .permitAll()
                //默认的验证成功的地址
                .defaultSuccessUrl("/tail/index")
                .and()
                //登出操作
                .logout()
                .logoutUrl("/tail/logout")
                .permitAll()
                .invalidateHttpSession(true)
                .and()
                // 登录后记住用户，下次自动登录
                // 数据库中必须存在名为persistent_logins的表
                // 建表语句见code15
                .rememberMe()
                .tokenValiditySeconds(1209600)
                .and()
                //csrf验证关闭
                .csrf().disable();
    }


    /*

    http
        .authorizeRequests()
            .antMatchers("/admin/**").hasRole("ADMIN")
            .anyRequest().authenticated()
            .and()
        .formLogin()
            .loginPage("/signin")
            .loginProcessingUrl("/signin/authenticate")
            .failureUrl("/signin?login_error=t")
            .defaultSuccessUrl("/dashboard")
            .permitAll()
            .and()
        .logout()
            .logoutUrl("/signout")
            .logoutSuccessHandler(logoutSuccessHandler)
            .deleteCookies("JSESSIONID")
            .permitAll()
            .and()
        .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
            .sessionAuthenticationStrategy(new RegisterSessionAuthenticationStrategy(sessionRegistry))
            .and()
        .rememberMe()
            .key("myrememberkey")
            .rememberMeServices(rememberMeServices)
            .and()
        .requestCache()
            .requestCache(requestCache)
            .and()
        .httpBasic()
            .disable()
        ;
    */


}
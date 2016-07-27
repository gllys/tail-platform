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
                .antMatchers("/resources/**","/api/**","/tail/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/tail/login").permitAll()
                .defaultSuccessUrl("/tail/index")
                .and()
                .logout()
                .permitAll().and().csrf().disable();
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
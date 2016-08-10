package com.zlt.gllys.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by zhangletian on 16/7/20.
 */


@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {"classpath:/resources/", "classpath:/static/"};

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//            registry.addViewController("/index").setViewName("index");
//            registry.addViewController("/").setViewName("index");
//              registry.addViewController("/index").setViewName("login");
    }
//    @Bean
//    public ServletRegistrationBean dispatcherRegistration(DispatcherServlet dispatcherServlet) {
//        ServletRegistrationBean registration = new ServletRegistrationBean(
//                dispatcherServlet);
//        dispatcherServlet.setThrowExceptionIfNoHandlerFound(true);
//        return registration;
//    }


}


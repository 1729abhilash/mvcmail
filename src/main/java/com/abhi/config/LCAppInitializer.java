package com.abhi.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


public class LCAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {

        Class  arr[]={LoveCalculatorConfig.class};
        return arr;
    }

    @Override
    protected String[] getServletMappings() {
        String arr[]={"/"};
        return arr;
    }
}

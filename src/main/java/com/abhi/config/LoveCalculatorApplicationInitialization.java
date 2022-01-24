package com.abhi.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
public class LoveCalculatorApplicationInitialization{

//public class LoveCalculatorApplicationInitialization implements WebApplicationInitializer {

    //webapplcitaiotninitializer telling tomcat it is automatically detected by tomcat
//this has only one method wherein we have to implemtns dispatcher servelt but tomcat contains servlet 3.0+
//    @Override
//    public void onStartup(ServletContext servletContext) throws ServletException {
////        System.out.println("my custom class method info");
//        //loading the xml
////        XmlWebApplicationContext webApplicationContext =new XmlWebApplicationContext();
////     webApplicationContext.setConfigLocation("classpath:dad-frontcontroller-servlet.xml");
// //loaidng the java class
//        AnnotationConfigWebApplicationContext  webApplicationContext=new AnnotationConfigWebApplicationContext();
//        webApplicationContext.register(LoveCalculatorConfig.class);
//
//        //create a dispatcher servelt object
//        DispatcherServlet  dispatcherServlet=new DispatcherServlet(webApplicationContext);
//
//        //servelet context creater only one per web aplliction
//        //regitster  the dispatcher servlet with the servlet context object
//        ServletRegistration.Dynamic myCustomDispatcherServlet=servletContext.addServlet("myDispatcherServlet",
//                dispatcherServlet);
//
//        myCustomDispatcherServlet.setLoadOnStartup(1);
//        myCustomDispatcherServlet.addMapping("/");
//        //confiture load on startup and url mapping
//
//
//
//    }

}

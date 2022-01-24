package com.abhi.config;


import com.abhi.converters.CreditCardConverter;
import com.abhi.converters.CreditConverterObjectToString;
import com.abhi.formatter.CreditCardFormatter;
import com.abhi.formatter.PhoneNumberFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.format.FormatterRegistry;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.JavaMailSenderImpl;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.JavaMailSenderImpl;
//import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.Properties;
import java.util.logging.Logger;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages= {"com.abhi"})
@PropertySource("classpath:email.properties")
//@PropertySource("classpath:adfds.properties")for other files to be loaded
// or
//@PropertySources(
//        {@PropertySource("classpath:adsf")
//        @PropertySource("classpath:adfad")}
//)
public class LoveCalculatorConfig implements WebMvcConfigurer {

     @Autowired
   private Environment env;
     Logger logger=Logger.getLogger(LoveCalculatorConfig.class.getName());




    //set up my view resolver
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
      viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Bean
    MessageSource messageSource(){
         ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
         messageSource.setBasename("messages");
         return messageSource;
    }

    @Bean
    public LocalValidatorFactoryBean validator(){

        LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
    localValidatorFactoryBean.setValidationMessageSource(messageSource());
    return localValidatorFactoryBean;
    }

    @Override
   public Validator getValidator(){
        return validator();
   }


    @Override
    public void addFormatters(FormatterRegistry registry) {

        registry.addFormatter(new PhoneNumberFormatter());
     //   registry.addFormatter(new CreditCardFormatter());
       // registry.addConverter(new CreditCardConverter());
    //  registry.addConverter(new CreditConverterObjectToString());
    }

    @Bean
    public JavaMailSender getJavaMailSender(){
    JavaMailSenderImpl jsm = new JavaMailSenderImpl();
      logger.info(">>>>>>>>>>fetching the host value "+env.getProperty("mail.host"));
      jsm.setHost(env.getProperty("mail.host"));
      jsm.setUsername(env.getProperty("mail.username"));
      jsm.setPassword(env.getProperty("mail.password"));
      jsm.setPort(getIntProperty("mail.port"));
      jsm.setJavaMailProperties(getMailProperties());
      return jsm;

    }

    private Properties getMailProperties() {
        Properties mailProperties=new Properties();
        mailProperties.put("mail.smtp.starttls.enable",true);
        mailProperties.put("mail.smtp.ssl.trust","smtp.gmail.com");
        mailProperties.put("mail.smtp.port", "587");
        mailProperties.put("mail.smtp.auth", true);
        mailProperties.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
        return mailProperties;
    }


    int getIntProperty(String key){//helper method

        String property=env.getProperty(key);
      return Integer.parseInt(property);

    }

}

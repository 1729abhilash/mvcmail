package com.abhi.controllers;

import com.abhi.dto.EmailDTO;
import com.abhi.dto.UserInfoDto;
import com.abhi.service.LCAppEmailService;
import com.abhi.service.LCAppEmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.logging.Logger;

@Controller
public class EmailController {

    @Autowired
    private LCAppEmailServiceImpl lcAppEmailService;
     Logger logger=Logger.getLogger(EmailController.class.getName());//java.util

    //@RequestMapping("/sendEmail/{userName}")//we do not want to send the data with the url
    @RequestMapping("/sendEmail")//@PathVariable("userName") it was below
//    public String sendEmail(@CookieValue("LCApp.userName") String userName
//                          ,  Model model){
    public String sendEmail(Model model){
        //  @RequestMapping("/sendEmail/{userName}/{hobby}")
        //
        // public String sendEmail(@PathVariable Map<String,String>pathVar,
        //                          ,  Model model){
        //    String userName=pathVar.get("userName");    //
        ////    String hobby=pathVar.get("hobby");    //
        //

        model.addAttribute("emailDTO", new EmailDTO());
      //  model.addAttribute("userInfo",dto);
//model.addAttribute("userName",userName.toUpperCase());//this was for when we were using httperequest.get cookies
       // model.addAttribute("userName",userName.toUpperCase());
        return "send-email-page";
    }


    @RequestMapping("/process-email")
//    public String processEmail(@CookieValue("LCApp.userName")String userName,
//                               @ModelAttribute("emailDTO") EmailDTO emailDTO,Model model){

    public String processEmail(@SessionAttribute("userInfo") UserInfoDto userInfoDto,
            @ModelAttribute("emailDTO") EmailDTO emailDTO, Model model, HttpSession session){
          String userName= (String) session.getAttribute("userName");
            String newUserName= "Mr"+userName;
          //  model.addAttribute("userName",userName.toUpperCase());    /if there are same name inmodel and session
        //first it will try to fetch from model if it is not there then it will to fetch from session
        model.addAttribute("newUserName",newUserName);

       //calling the sendEmail method
        try {
            lcAppEmailService.sendEmail(userInfoDto.getUserName(), emailDTO.getUserEmail(), userInfoDto.getResult());
        }
        catch (Exception e){
            logger.info("logging the exception "+e);
        }

        return "process-email-page";
    }


}

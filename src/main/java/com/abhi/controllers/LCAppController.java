package com.abhi.controllers;


import com.abhi.dto.UserInfoDto;
import com.abhi.service.LCAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@SessionAttributes("userInfo")//modelattribute name and Sessionattribure name should match
public class LCAppController {

//    @RequestMapping("/")
//    public String showHomePage(Model model){
//        //read the existing property by fetching it from the dto
//        UserInfoDto userInfo=new UserInfoDto();
//         model.addAttribute("userInfo",userInfo);
//
//        return "home-page";
//    }
//
    //other way of above

    @Autowired
    LCAppService lCAppService;

    @RequestMapping("/")
//    public String showHomePage(@ModelAttribute("userInfo") UserInfoDto userInfoDto, HttpServletRequest request,
//                               HttpSession session){
//
    public String showHomePage(Model model){
            //will use spring mvc tag in home-page.jsp
        //read the existing property by fetching it from the dto
       //UserInfoDto userInfo=new UserInfoDto();
        //model.addAttribute("userInfo",userInfo);
//      Cookie[] cookies=request.getCookies();
//      for(Cookie temp:cookies){
//          if("LCApp.userName".equals(temp.getName()))
//          {
//              String myUserName=temp.getValue();
//              userInfoDto.setUserName(myUserName);
//          }
//
//      }
      //  userInfoDto.setUserName((String) session.getAttribute("userName"));

       model.addAttribute("userInfo",new UserInfoDto());//in sessionattribute with @modelattribute it is not adding
        // we have create manually model then it will added to sessionattributes
        return "home-page";
    }


    //fetching query parameter with the help of using
    //requestpparam  before it wew were using
    //httpservletrequest object and with the help
    //of that object we were fetching the parameter requuest.getParameter()

//    @RequestMapping("/process-homepage")
//    public String showResultPage(@RequestParam("userName") String userName, @RequestParam("crushName") String crushName
//    , Model model){
//        model.addAttribute("userName",userName);
//        model.addAttribute("crushName",crushName);
//        return "result-page";
//    }


    //fetching query parameter using Dto object//this is data binding
//    @RequestMapping("/process-homepage")
//    public String showResultPage(UserInfoDto userInfoDto
//            , Model model){
//
//        //writing the value to the properties by fetching from the url
////        model.addAttribute("userName",userInfoDto.getUserName());
////        model.addAttribute("crushName",userInfoDto.getCrushName());
////        or we can do this
//       model.addAttribute("userInfo",userInfoDto);
//
//        return "result-page";
//    }

    //other way of above method of doing this


//    @RequestMapping("/process-homepage")
//    public String showResultPage(@Valid @ModelAttribute("userInfo")UserInfoDto userInfoDto, BindingResult result,
//                                 HttpServletResponse response,HttpServletRequest request){
////@valid annotation help to trigeer bean validation
//       //once alll query paramter goes to dto
//        //then it validated whether it is meating criteria
//if(result.hasErrors()){
//    List<ObjectError> allErrors=result.getAllErrors();
//     for(ObjectError temp:allErrors){
//         System.out.println(temp);
//     }
//
//    return "home-page";
//}
//
//
//  //creating a cookie for the user name
////        Cookie cookie = new Cookie("LCApp.userName", userInfoDt.getUserName());
////    cookie.setMaxAge(60*60*24);
////
////    //add the cookie to the response
////        response.addCookie(cookie);
//
//
//   //write a service which will calculate the love %
//        // between the useranem and crushanme
//
//
//        HttpSession session =request.getSession();
//        session.setAttribute("userName",userInfoDto.getUserName());
//            session.setMaxInactiveInterval(120);//if the user remain inactive for 120 minutes it will remove session
//        // attribute username formt he server
//
//        return "result-page";
//    }



    @RequestMapping("/process-homepage")
    public String showResultPage(@Valid @ModelAttribute("userInfo") UserInfoDto userInfoDto,BindingResult result,
                                 Model model)
    {

        if(result.hasErrors()){
    List<ObjectError> allErrors=result.getAllErrors();
     for(ObjectError temp:allErrors){
         System.out.println(temp);
     }

    return "home-page";
}
     String appResult=lCAppService.calculateLove(userInfoDto.getUserName(), userInfoDto.getCrushName());
        userInfoDto.setResult(appResult);
        model.addAttribute("result",appResult);
        return "result-page";
    }

}

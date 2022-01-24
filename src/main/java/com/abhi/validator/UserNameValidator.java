package com.abhi.validator;

import com.abhi.dto.UserRegistrationDto;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.validation.Valid;

public class UserNameValidator implements Validator {
    //check if the userNameValidator supports a given object
    @Override
    public boolean supports(Class<?> clazz) {
        System.out.println("supprot method");
        return UserRegistrationDto.class.equals(clazz);
    }


    //we need to write our custom validation check
    @Override
    public void validate(Object o, Errors errors) {
//to check if the field is null
        System.out.println("alidate method");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"userName","userName.empty","UserName cannot be " +
                "empty");

           //the String should contains '_'
        String userName=((UserRegistrationDto)o).getUserName();
  if(!userName.contains("_"))
  {
      errors.rejectValue("userName","userName:invlaid sTring","String must contain  '_");
  }
    }
}

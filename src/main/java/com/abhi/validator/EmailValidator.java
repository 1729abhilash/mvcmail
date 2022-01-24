package com.abhi.validator;

import com.abhi.dto.UserRegistrationDto;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class EmailValidator implements Validator {


    @Override
    public boolean supports(Class<?> aClass) {
        return UserRegistrationDto.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"communicationDto.email","email.empty");


        //whether the email is ending with seleniumexpress.com

        String email=((UserRegistrationDto)o).getCommunicationDto().getEmail();

        if(!email.endsWith("seleniumexpress.com")){

            errors.rejectValue("communicationDto.email","email.invalidDomain");
        }

    }
}

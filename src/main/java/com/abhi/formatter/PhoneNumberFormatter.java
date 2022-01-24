package com.abhi.formatter;

import com.abhi.dto.Phone;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class PhoneNumberFormatter implements Formatter<Phone> {
    @Override
    public Phone parse(String completePhoneNumber, Locale locale) throws ParseException {

        //split the string received from the user
        String phoneNumber[] = completePhoneNumber.split("-");

        //whether the number consist of--
        Phone phone = new Phone();
        int index=completePhoneNumber.indexOf("-");

        if(index==-1){
            //if the '-' is not found  then add 91 as the default coutry code
            phone.setCountryCode("91");
            phone.setUserNumber(phoneNumber[0]);

        }
        else {

            //extract the countryocode and set it to the phone class countrtyocdeporperty

            phone.setCountryCode(phoneNumber[0]);
            phone.setUserNumber(phoneNumber[1]);
        }
        return phone;
    }

    @Override
    public String print(Phone phone, Locale locale) {
        return phone.getCountryCode()+"-"+phone.getUserNumber();
    }
}

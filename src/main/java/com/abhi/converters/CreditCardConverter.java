package com.abhi.converters;

import com.abhi.credit.CreditCard;
import org.springframework.core.convert.converter.Converter;

public class CreditCardConverter implements Converter <String, CreditCard>{
//we can use converter instead using ediotr or formatter
//but we need to register converter we have to go to config classes
    @Override
    public CreditCard convert(String text) {
        String[] digitsArray=text.split("-");
        //settign credit card values

        CreditCard card = new CreditCard();
        card.setFirstFourDigits(Integer.valueOf(digitsArray[0]));
        card.setSecondFourDigits(Integer.valueOf(digitsArray[1]));
        card.setThirdFourDigits(Integer.valueOf(digitsArray[2]));
        card.setFourFourDigits(Integer.valueOf(digitsArray[3]));
        return card;

    }

    //unfortunaltey we dont't have to for viceversa we have to create another converter

}

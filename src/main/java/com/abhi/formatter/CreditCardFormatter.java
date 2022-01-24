package com.abhi.formatter;

import com.abhi.credit.CreditCard;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class CreditCardFormatter implements Formatter<CreditCard> {


    @Override
    public CreditCard parse(String text, Locale locale) throws ParseException {
       //splitting the credit card
        String[] digitsArray=text.split("-");
   //settign credit card values

        CreditCard card = new CreditCard();
        card.setFirstFourDigits(Integer.valueOf(digitsArray[0]));
        card.setSecondFourDigits(Integer.valueOf(digitsArray[1]));
        card.setThirdFourDigits(Integer.valueOf(digitsArray[2]));
        card.setFourFourDigits(Integer.valueOf(digitsArray[3]));
     return card;
    }

    @Override
    public String print(CreditCard creditCard, Locale locale) {
        return null;
    }
}

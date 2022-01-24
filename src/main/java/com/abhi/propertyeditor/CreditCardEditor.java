package com.abhi.propertyeditor;

import com.abhi.credit.CreditCard;

import java.beans.PropertyEditorSupport;

public class CreditCardEditor extends PropertyEditorSupport {
   //simulating a editor warking as a formatter\
    //we can do do formatter workes in editor also


    @Override
    public String getAsText() {
        CreditCard creditCard =(CreditCard)getValue();
      return "sample "+creditCard;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {

        String[] digitsArray=text.split("-");
        //settign credit card values

        CreditCard card = new CreditCard();
        card.setFirstFourDigits(Integer.valueOf(digitsArray[0]));
        card.setSecondFourDigits(Integer.valueOf(digitsArray[1]));
        card.setThirdFourDigits(Integer.valueOf(digitsArray[2]));
        card.setFourFourDigits(Integer.valueOf(digitsArray[3]));
       setValue(card);

    }
}

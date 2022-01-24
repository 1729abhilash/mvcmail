package com.abhi.converters;

import com.abhi.credit.CreditCard;
import org.springframework.core.convert.converter.Converter;

public class CreditConverterObjectToString implements Converter<CreditCard,String> {
    @Override
    public String convert(CreditCard creditCard) {
      return "sample: "+creditCard;
    }
}

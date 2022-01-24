package com.abhi.controllers;

import com.abhi.credit.CreditCard;
import com.abhi.dto.BillDTO;
import com.abhi.formatter.CreditCardFormatter;
import com.abhi.propertyeditor.CreditCardEditor;
import com.abhi.propertyeditor.MyCurrencyEditor;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Date;

@Controller
public class InitTestBinderTestController {

    @RequestMapping("/bill")
    public String showHomePage(@ModelAttribute("billDTO") BillDTO billDTO){
        return "bill-page";
    }

    @RequestMapping("/process-bill")
    public String showResultBillPage(@Valid @ModelAttribute("billDTO") BillDTO billDTO, BindingResult result){

        if(result.hasErrors())
        {
            return "bill-page";
        }
        return "bill-result-page";
    }

    @InitBinder
    public void initBinder2(WebDataBinder binder){

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        CustomDateEditor customDateEditor = new CustomDateEditor(dateFormat,true);
      binder.registerCustomEditor(Date.class,"date",customDateEditor);


      //register a custom editor for the amount field
        NumberFormat numberFormat=new DecimalFormat("##,###.00");
        CustomNumberEditor customNumberEditor = new CustomNumberEditor(BigDecimal.class,numberFormat,true);
     binder.registerCustomEditor(BigDecimal.class,"amount",customNumberEditor);

     //register a custom editor for currency
        MyCurrencyEditor myCurrencyEditor = new MyCurrencyEditor();
        binder.registerCustomEditor(Currency.class,"currency",myCurrencyEditor);

        //adding a custom formatter rather than in config class
        //binder.addCustomFormatter(new CreditCardFormatter());


       //CreditCardEditor myCreditCardEditor = new CreditCardEditor();//same formatter thing we can do using editor also
      // binder.registerCustomEditor(CreditCard.class,"creditCard",myCreditCardEditor);

    }

}

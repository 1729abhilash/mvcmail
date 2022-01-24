package com.abhi.service;

import org.springframework.stereotype.Service;

@Service
public class LCAppServiceImpl implements LCAppService{
   public final String LC_APP_FORMULA="FLAME";

    @Override
    public String calculateLove(String userName, String crushName) {
      int userAndCrushNameCount=  (userName+crushName).toCharArray().length;
      int formulacount=LC_APP_FORMULA.toCharArray().length;
      int rem=userAndCrushNameCount%formulacount;
      char resultChar=LC_APP_FORMULA.charAt(rem);
         String result=whatsBetweenUs(resultChar);
        return result;
    }

    @Override
    public String whatsBetweenUs(char calculationResult) {

        if(calculationResult=='F')
        {
           return LoveCalculatorConstants.F_CHAR_MEANING;
        }
        else if(calculationResult=='L')
        {
            return LoveCalculatorConstants.L_CHAR_MEANING;
        }
        else if(calculationResult=='A')
        {
            return LoveCalculatorConstants.A_CHAR_MEANING;
        }
        else if(calculationResult=='M')
        {
            return LoveCalculatorConstants.M_CHAR_MEANING;
        }
        else if(calculationResult=='E')
        {
            return LoveCalculatorConstants.E_CHAR_MEANING;
        }
        else if(calculationResult=='S')
        {
            return LoveCalculatorConstants.S_CHAR_MEANING;
        }

        return null;
    }
}

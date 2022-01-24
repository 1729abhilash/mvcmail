package com.abhi.validator;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class AgeValidator implements ConstraintValidator<Age,Integer> {


    private int lower;
    private int upper;
    @Override
    public void initialize(Age age) {
   ///i can write the post//shayad pre construct  work right here
//this method will execute when we initialize the value
        this.upper=age.upper();
        this.lower=age.lower();
    }

    @Override
    public boolean isValid(Integer age, ConstraintValidatorContext constraintValidatorContext) {
       //i need to write my logic here
         if(age==null) {
             return false;
         }
          else if(age<lower||age>upper){
               return false;//fail
          }

        return true;//pass
    }
}

package com.abhi.credit;

public class CreditCard {
    private Integer firstFourDigits;
    private Integer secondFourDigits;
    private Integer thirdFourDigits;
    private Integer fourFourDigits;

    public Integer getFirstFourDigits() {
        return firstFourDigits;
    }

    public void setFirstFourDigits(Integer firstFourDigits) {
        this.firstFourDigits = firstFourDigits;
    }

    public Integer getSecondFourDigits() {
        return secondFourDigits;
    }

    public void setSecondFourDigits(Integer secondFourDigits) {
        this.secondFourDigits = secondFourDigits;
    }

    public Integer getThirdFourDigits() {
        return thirdFourDigits;
    }

    public void setThirdFourDigits(Integer thirdFourDigits) {
        this.thirdFourDigits = thirdFourDigits;
    }

    public Integer getFourFourDigits() {
        return fourFourDigits;
    }

    public void setFourFourDigits(Integer fourFourDigits) {
        this.fourFourDigits = fourFourDigits;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "firstFourDigits=" + firstFourDigits +
                ", secondFourDigits=" + secondFourDigits +
                ", thirdFourDigits=" + thirdFourDigits +
                ", fourFourDigits=" + fourFourDigits +
                '}';
    }
}

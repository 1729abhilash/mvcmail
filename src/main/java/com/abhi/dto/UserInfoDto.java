package com.abhi.dto;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserInfoDto {

    @NotBlank(message="User name can't be blank ")
    //@Min(value=3,message="*your name should have 3 characters")
    @Size(min=3,max=15,message="{userName.size}")
    private String userName;

    @NotBlank(message="crush name can't be blank ")
   @Size(min=3,max=15,message="your crush min have 3 charcter and max have 15 character ")
    private String crushName;
    
    @AssertTrue(message="please  agree to our aconditions")
    private boolean termAndCondition;
    private String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public boolean isTermAndCondition() {
        return termAndCondition;
    }

    public void setTermAndCondition(boolean termAndCondition) {
        this.termAndCondition = termAndCondition;
    }

    

    public UserInfoDto(){

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCrushName() {
        return crushName;
    }

    public void setCrushName(String crushName) {
        this.crushName = crushName;
    }

    @Override
    public String toString() {
        return "UserInfoDto{" +
                "userName='" + userName + '\'' +
                ", crushName='" + crushName + '\'' +
                '}';
    }
}

package com.abhi.dto;

import com.abhi.validator.Age;

import javax.validation.constraints.NotEmpty;

public class UserRegistrationDto {

    @NotEmpty(message="{string.notEmpty}")
    private String name;
    private String userName;
    private char[] password;
    private String countryName;



    private String[] hobbies;
    private String gender;
    @Age(lower=45,upper=60)
    private Integer age;//developing custom annotation//behind the string is converted into string
    private CommunicationDto communicationDto;
    public CommunicationDto getCommunicationDto() {
        return communicationDto;
    }

    public void setCommunicationDto(CommunicationDto communicationDto) {
        this.communicationDto = communicationDto;
    }



    public String getGender() {
        return gender;
    }
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    public String[] getHobbies() {
        return hobbies;
    }

    public void setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }
}

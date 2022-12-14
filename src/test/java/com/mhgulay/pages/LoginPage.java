package com.mhgulay.pages;

import com.mhgulay.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "login")
    public WebElement userNameField;

    @FindBy(id = "password")
    public WebElement userPasswordField;

    @FindBy(xpath = "//button[@class=\"btn btn-primary\"]")
    public WebElement submitButton;

    @FindBy(xpath = "//p[@class=\"alert alert-danger\"]")
    public WebElement message;

}

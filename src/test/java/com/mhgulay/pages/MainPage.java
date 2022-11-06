package com.mhgulay.pages;

import com.mhgulay.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    public MainPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (className = "oe_topbar_name")
    public WebElement userName;

    @FindBy(xpath = "//ul[@class=\"dropdown-menu\"]/li[6]")
    public WebElement logoutButton;


}

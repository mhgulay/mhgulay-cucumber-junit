package com.mhgulay.step_definitions;

import com.mhgulay.pages.UpgenixLogin;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static com.mhgulay.utilities.ConfigurationReader.*;
import static com.mhgulay.utilities.Driver.*;

public class UpgenixLoginStepDefinitions {

    UpgenixLogin upgenixLogin = new UpgenixLogin();

    @When("user is on upgenix login page")
    public void user_is_on_upgenix_login_page() {
        getDriver().get(getProperty("url"));
    }
    @When("user try to login with valid credentials")
    public void user_try_to_login_with_valid_credentials() {
        upgenixLogin.userNameField.sendKeys(getProperty("userName"));
        upgenixLogin.userPasswordField.sendKeys(getProperty("password"));
        upgenixLogin.submitButton.submit();
    }
    @Then("user should see home page")
    public void user_should_see_home_page() {
        String title="Odoo";
        Assert.assertEquals(getDriver().getTitle(),title);
    }

}

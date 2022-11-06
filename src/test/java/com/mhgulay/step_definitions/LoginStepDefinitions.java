package com.mhgulay.step_definitions;

import com.mhgulay.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.mhgulay.utilities.ConfigurationReader.*;
import static com.mhgulay.utilities.Driver.*;
import static org.junit.Assert.*;

public class LoginStepDefinitions {

    LoginPage loginPage = new LoginPage();
    WebDriverWait wait = new WebDriverWait(getDriver(), 15);


    @When("user should be on the login page")
    public void user_should_be_on_the_login_page() {
        getDriver().get(getProperty("url"));
    }

    @When("user can try to valid {string} in email box")
    public void user_can_try_to_valid_in_email_box(String email) {
        loginPage.userNameField.sendKeys(email);
    }

    @When("user can try to valid {string} in password box")
    public void user_can_try_to_valid_in_password_box(String password) {
        loginPage.userPasswordField.sendKeys(password);
        loginPage.submitButton.click();
    }

    @Then("user should see the main page title like {string}")
    public void userShouldSeeTheMainPageTitleLike(String title) {
        wait.until(ExpectedConditions.titleIs("#Inbox - Odoo"));
        assertEquals(title, getDriver().getTitle());
    }

    @And("user can try to invalid {string} in email box")
    public void userCanTryToInvalidInEmailBox(String email) {
        loginPage.userNameField.sendKeys(email);

    }

    @When("user can try to invalid {string} in password box")
    public void user_can_try_to_invalid_in_password_box(String password) {
        loginPage.userPasswordField.sendKeys(password);
        loginPage.submitButton.click();
    }

    @Then("user should see {string} message")
    public void userShouldSeeMessage(String message) {
        //wait.until(ExpectedConditions.visibilityOf(loginPage.message));
        assertEquals(message, loginPage.message.getText());
    }

    @Then("user should see {string} password message")
    public void userShouldSeePasswordMessage(String message) {
        assertEquals(message, loginPage.userPasswordField.getAttribute("validationMessage"));
    }

    @Then("user should see {string} username message")
    public void userShouldSeeUsernameMessage(String message) {
        assertEquals(message, loginPage.userNameField.getAttribute("validationMessage"));
    }

    @And("user can try to valid {string} in password box wait")
    public void userCanTryToValidInPasswordBoxWait(String password) {
        loginPage.userPasswordField.sendKeys(password);
    }

    @Then("user check input type {string}")
    public void userCheckInputType(String password) {
        assertEquals(password, loginPage.userPasswordField.getAttribute("type"));
    }

    @And("user can try to valid {string} in password box with enter key")
    public void userCanTryToValidInPasswordBoxWithEnterKey(String password) {
        loginPage.userPasswordField.sendKeys(password + Keys.ENTER);
    }
}

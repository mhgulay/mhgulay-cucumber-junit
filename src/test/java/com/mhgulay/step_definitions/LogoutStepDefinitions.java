package com.mhgulay.step_definitions;

import com.mhgulay.pages.LoginPage;
import com.mhgulay.pages.MainPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

import static com.mhgulay.utilities.ConfigurationReader.getProperty;
import static com.mhgulay.utilities.Driver.*;
import static org.junit.Assert.*;

public class LogoutStepDefinitions {

    MainPage mainPage = new MainPage();
    WebDriverWait wait = new WebDriverWait(getDriver(), 15);


    @When("user should click username on the page")
    public void user_should_click_username_on_the_page() {
        mainPage.userName.click();
    }
    @When("user should click {string} on the page")
    public void user_should_click_on_the_page(String string) {
        mainPage.logoutButton.click();
    }
    @Then("user should see log in page title like {string}")
    public void user_should_see_log_in_page_title_like(String string) {
        wait.until(ExpectedConditions.titleIs(string));
        assertEquals(string,getDriver().getTitle());

    }


    @And("user should click to step back button")
    public void userShouldClickToStepBackButton() {
       getDriver().navigate().back();
    }

    @Then("user should not see the main page title like {string}")
    public void userShouldNotSeeTheMainPageTitleLike(String string) {
        assertNotEquals(string,getDriver().getTitle());
    }

    @And("user should close all taps which is on browser")
    public void userShouldCloseAllTapsWhichIsOnBrowser() {
        JavascriptExecutor jse = (JavascriptExecutor)getDriver();
        jse.executeScript("window.open('about:blank','_blank')");
        ArrayList<String> tabs = new ArrayList<String> (getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs.get(0));
        getDriver().close();
        getDriver().switchTo().window(tabs.get(1));

    }

    @Then("user should not see the {string} on login page")
    public void userShouldNotSeeTheOnLoginPage(String username) {
        String controlUserName = getDriver().findElement(By.xpath("//*[.=\"" + username + "\"]")).getText();
        assertNotEquals(username, controlUserName);
    }
}

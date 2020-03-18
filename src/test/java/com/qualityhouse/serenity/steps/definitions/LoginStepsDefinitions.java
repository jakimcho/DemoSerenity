package com.qualityhouse.serenity.steps.definitions;

import com.qualityhouse.serenity.entities.User;
import com.qualityhouse.serenity.page_objects.HomePage;
import com.qualityhouse.serenity.page_objects.LoginPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.List;

/**
 * @author yakimfb
 * @since 12.03.20
 **/
public class LoginStepsDefinitions
{

    LoginPage loginPage;
    HomePage homePage;

    @Given( "^(?:.*) is on the login page$" )
    public void loginPageIsOpen()
    {
        loginPage.open();
    }

    @When( "^I enter \"([^\"]*)\" in username field$" )
    public void iEnterInUsernameField( String username ) throws Throwable
    {
        loginPage.enterUserName( username );
    }

    @When( "^I enter \"([^\"]*)\" in password field$" )
    public void iEnterInPasswordField( String password ) throws Throwable
    {
        loginPage.enterPassword( password );
    }

    @When( "^I click on login submit button$" )
    public void iClickOnLoginSubmitButton()
    {
        loginPage.clickLoginButton();
    }

    @Then( "^I should lend on my home page$" )
    public void iShouldLendOnMyHomePage()
    {
    }

    @Then( "^I should see \"([^\"]*)\"$" )
    public void iShouldSee( String arg0 ) throws Throwable
    {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When( "^(?:.*) logs in with:$" )
    public void johnLogsInWith( List<User> data )
    {
        User u1 = data.get( 0 );
        loginPage.enterUserName( u1.getUsername() );
        loginPage.enterPassword( u1.getPassword() );
        loginPage.clickLoginButton();
    }

    @Then( "^(.*) logs in is successfully$" )
    public void userShouldLoginSuccessfully( String userName)
    {
        Assert.assertTrue( homePage.isSignOutMenuDisplayed() );
        Assert.assertTrue( homePage.getLoggedInUserName().contains(userName.toLowerCase()) );
    }
}

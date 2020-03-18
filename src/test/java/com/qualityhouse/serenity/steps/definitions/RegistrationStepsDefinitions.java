package com.qualityhouse.serenity.steps.definitions;

import com.qualityhouse.serenity.entities.User;
import com.qualityhouse.serenity.page_objects.LoginPage;
import com.qualityhouse.serenity.page_objects.RegistrationPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

import java.util.List;

/**
 * @author yakimfb
 * @since 18.03.20
 **/
public class RegistrationStepsDefinitions
{
    LoginPage loginPage;
    RegistrationPage registrationPage;

    @Given( "^(?:.*) has started an account registration with \"(.*)\" email$" )
    public void registrationProcessIsStarted( String email )
    {
        loginPage.startRegistrationWithEmail( email );
    }

    @When( "^(?:.*) enters his personal details:$" )
    public void userEntersPersonalDetailsInRegistrationForm( List<User> rawUserData )
    {
        User user = rawUserData.get( 0 );
        registrationPage.enterUserPersonalDetails( user );
    }
}

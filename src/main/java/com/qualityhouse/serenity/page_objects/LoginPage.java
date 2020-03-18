package com.qualityhouse.serenity.page_objects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

/**
 * @author yakimfb
 * @since 12.03.20
 **/

@DefaultUrl( "http://test.automationpractice.com/index.php?controller=authentication&back=my-account" )
public class LoginPage
        extends PageObject
{

    private static final By EMAIL_FIELD_LOCATOR = By.name( "email" );

    @FindBy( name = "email" )
    private WebElementFacade emailField;

    @FindBy( name = "passwd" )
    private WebElementFacade passwordField;

    @FindBy( name = "SubmitLogin" )
    private WebElementFacade loginButton;

    public void enterUserName( String email )
    {
        emailField.waitUntilEnabled()
                  .type( email );
    }

    public void enterPassword( String password )
    {
        passwordField.waitUntilEnabled()
                     .type( password );
    }

    public void clickLoginButton()
    {
        loginButton.waitUntilClickable()
                   .click();
    }
}

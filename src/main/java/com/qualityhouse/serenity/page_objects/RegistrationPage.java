package com.qualityhouse.serenity.page_objects;

import com.qualityhouse.serenity.entities.User;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.ui.Select;

/**
 * @author yakimfb
 * @since 18.03.20
 **/
public class RegistrationPage
        extends PageObject
{

    private WebElementFacade userTitleRadioButtons;

    @FindBy( id = "id_gender1" )
    private WebElementFacade mrRadioButton;

    @FindBy( id = "id_gender2" )
    private WebElementFacade mrsRadioButton;

    @FindBy( name = "customer_firstname" )
    private WebElementFacade firstNameField;

    @FindBy( name = "customer_lastname" )
    private WebElementFacade lastNameField;

    @FindBy( name = "email" )
    private WebElementFacade emailField;

    @FindBy( name = "passwd" )
    private WebElementFacade passwordField;

    @FindBy( name = "days" )
    private WebElementFacade dayOfBirthDropDown;

    @FindBy( name = "months" )
    private WebElementFacade monthOfBirthDropDown;

    @FindBy( name = "years" )
    private WebElementFacade yearOfBirthDropDown;


    public void enterUserPersonalDetails( User user )
    {
        if ( user.getTitle()
                 .equalsIgnoreCase( "mr" ) )
        {
            mrRadioButton.click();
        } else
        {
            mrsRadioButton.click();
        }

        firstNameField.type( user.getFirstName() );
        lastNameField.type( user.getLastName() );
        emailField.type( user.getEmail() );
        passwordField.type( user.getPassword() );

        dayOfBirthDropDown.selectByValue( user.getDataOfBirth()
                                              .split( "-" )[0] );
        monthOfBirthDropDown.selectByValue( user.getDataOfBirth()
                                                .split( "-" )[1] );
        yearOfBirthDropDown.selectByValue( user.getDataOfBirth()
                                               .split( "-" )[2] );
    }
}

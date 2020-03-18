package com.qualityhouse.serenity.page_objects;

import com.qualityhouse.serenity.entities.User;
import com.qualityhouse.serenity.utils.MonthsEnum;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.Map;

import static com.qualityhouse.serenity.utils.Months.getMonths;

/**
 * @author yakimfb
 * @since 18.03.20
 **/
public class RegistrationPage
        extends PageObject
{
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

    private static final By DAY_OF_BIRTH_DROP_DOWN_LOCATOR = By.name( "days" );

    private static final By MONTH_OF_BIRTH_DROP_DOWN_LOCATOR = By.name( "months" );

    private static final By YEAR_OF_BIRTH_DROP_DOWN_LOCATOR = By.name( "years" );

    public void enterUserPersonalDetails( User user )
    {
        selectGender( user.getTitle() );

        fillFiledWithData( firstNameField,
                           user.getFirstName() );
        fillFiledWithData( lastNameField,
                           user.getLastName() );
        fillFiledWithData( emailField,
                           user.getEmail() );
        fillFiledWithData( passwordField,
                           user.getPassword() );

        enterBirthDate( user.getDataOfBirth() );
    }

    private void selectGender( String gender )
    {
        if ( gender != null )
        {
            if ( gender.toLowerCase()
                       .contains( "mrs" ) )
            {
                mrsRadioButton.click();
            } else
            {
                mrRadioButton.click();
            }
        }
    }

    private void fillFiledWithData( WebElementFacade fieldElement,
                                    String data )
    {
        if ( data != null )
        {
            fieldElement.waitUntilEnabled()
                        .type( data );
        }
    }

    private void enterBirthDate( String dataOfBirth )
    {
        if ( dataOfBirth != null )
        {
            String[] tokenizedDateOfBirth = dataOfBirth
                    .split( "-" );
            String monthValue = MonthsEnum.valueOf( tokenizedDateOfBirth[1].toUpperCase() )
                                          .getValue();
            find( DAY_OF_BIRTH_DROP_DOWN_LOCATOR ).selectByValue( tokenizedDateOfBirth[0] );
            find( MONTH_OF_BIRTH_DROP_DOWN_LOCATOR ).selectByValue( monthValue );
            find( YEAR_OF_BIRTH_DROP_DOWN_LOCATOR ).selectByValue( tokenizedDateOfBirth[2] );
        }
    }

}

package com.qualityhouse.serenity.steps.libraries;

import com.qualityhouse.serenity.entities.AddressDetails;
import com.qualityhouse.serenity.entities.User;
import com.qualityhouse.serenity.page_objects.RegistrationPage;
import com.qualityhouse.serenity.utils.MonthsEnum;
import net.thucydides.core.annotations.Step;

import static com.qualityhouse.serenity.page_objects.RegistrationPage.*;

/**
 * @author yakimfb
 * @since 19.03.20
 **/
public class RegistrationActions
        extends BasesActions
{
    private RegistrationPage registrationPage;

    @Step( "Enters his/her personal details in the registration form {0}" )
    public void entersHisPersonalDetails( User user )
    {
        selectGender( user.getTitle() );

        fillFieldWithData( registrationPage.firstNameField,
                           user.getFirstName() );
        fillFieldWithData( registrationPage.lastNameField,
                           user.getLastName() );
        fillFieldWithData( registrationPage.emailField,
                           user.getEmail() );
        fillFieldWithData( registrationPage.passwordField,
                           user.getPassword() );

        enterBirthDate( user.getDataOfBirth() );
    }

    @Step( "Enters his/her address details in the registration form {0}" )
    public void entersHisAddressDetails( AddressDetails addressDetails )
    {
        fillFieldWithData( registrationPage.address1Field,
                           addressDetails.getAddress() );

        fillFieldWithData( registrationPage.addressCityField,
                           addressDetails.getCity() );

        selectFromDropDownAnItemByVisibleText( ADDRESS_STATE_DROP_DOWN_LOCATOR,
                                               addressDetails.getState() );

        fillFieldWithData( registrationPage.addressZipCodeField,
                           addressDetails.getZip() );

        selectFromDropDownAnItemByVisibleText( ADDRESS_COUNTRY_DROP_DOWN_LOCATOR,
                                               addressDetails.getCountry() );

        fillFieldWithData( registrationPage.addressMobilePhoneField,
                           addressDetails.getMobilePhone() );

        fillFieldWithData( registrationPage.addressAliasField,
                           addressDetails.getAddressAlias() );
    }

    private void selectGender( String gender )
    {
        if ( gender != null )
        {
            if ( gender.toLowerCase()
                       .contains( "mrs" ) )
            {
                registrationPage.mrsRadioButton.click();
            } else
            {
                registrationPage.mrRadioButton.click();
            }
        }
    }

    private void enterBirthDate( String dataOfBirth )
    {
        if ( dataOfBirth != null )
        {
            String[] tokenizedDateOfBirth = dataOfBirth
                    .split( "-" );
            String day = tokenizedDateOfBirth[0];
            String monthValue = MonthsEnum.valueOf( tokenizedDateOfBirth[1].toUpperCase() )
                                          .getValue();
            String year = tokenizedDateOfBirth[2];

            selectFromDropDownAnItemByValue( DAY_OF_BIRTH_DROP_DOWN_LOCATOR,
                                             day );
            selectFromDropDownAnItemByValue( MONTH_OF_BIRTH_DROP_DOWN_LOCATOR,
                                             monthValue );
            selectFromDropDownAnItemByValue( YEAR_OF_BIRTH_DROP_DOWN_LOCATOR,
                                             year );
        }
    }
}
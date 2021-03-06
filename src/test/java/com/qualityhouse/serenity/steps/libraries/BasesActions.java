package com.qualityhouse.serenity.steps.libraries;

import com.qualityhouse.serenity.page_objects.BasePage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yakimfb
 * @since 19.03.20
 **/
public class BasesActions
{
    private BasePage currentPage;

    @Step( "Enters '{1}' in field {0}" )
    protected void fillsFieldWithData( WebElementFacade fieldElement,
                                       String data )
    {
        if ( data != null )
        {
            fieldElement.waitUntilEnabled()
                        .type( data );
        }
    }

    @Step( "Selects '{1}' item from drop down {0}" )
    protected void selectsFromDropDownAnItemByValue( WebElementFacade dropDownElement,
                                                     String itemValue )
    {
        if ( itemValue != null )
        {
            dropDownElement.selectByValue( itemValue );
        }
    }

    protected void fillsFieldWithData( By fieldElement,
                                       String data )
    {
        fillsFieldWithData( (WebElementFacade) currentPage.find( fieldElement ),
                            data );
    }

    protected void selectsFromDropDownAnItemByValue( By dropDownLocator,
                                                     String itemValue )
    {
        this.selectsFromDropDownAnItemByValue( (WebElementFacade) currentPage.find( dropDownLocator ),
                                               itemValue );
    }

    protected void selectsFromDropDownAnItemByVisibleText( By dropDownLocator,
                                                           String itemValue )
    {
        this.selectsFromDropDownAnItemByVisibleText( (WebElementFacade) currentPage.find( dropDownLocator ),
                                                     itemValue );
    }

    @Step( "Selects '{1}' item from drop down {0}" )
    protected void selectsFromDropDownAnItemByVisibleText( WebElementFacade dropDownElement,
                                                           String itemValue )
    {
        if ( itemValue != null )
        {
            dropDownElement.selectByVisibleText( itemValue );
        }
    }

    @Step
    protected void clicksOn( WebElementFacade buttonOrLink )
    {
        buttonOrLink.waitUntilClickable()
                    .click();
    }

    @Step
    public boolean canSeeElement( WebElementFacade webElement )
    {
        return webElement.isVisible();
    }

    @Step
    public String readsTextFrom( WebElementFacade webElement )
    {
        return webElement.waitUntilVisible()
                         .getText()
                         .trim();
    }

    @Step
    public void clicksOn( final By locator )
    {
        currentPage.find( locator )
                   .waitUntilClickable()
                   .click();
    }

    public String readsTextFrom( By locator )
    {
        return readsTextFrom( (WebElementFacade) currentPage.find( locator ) );
    }

    @Step
    public List<String> readsTextFromList( By listItemsLocator )
    {
        List<WebElementFacade> errorsItemsElements = currentPage.findAll( listItemsLocator );
        List<String> errorMessages = new ArrayList<>( errorsItemsElements.size() );

        for ( WebElementFacade item : errorsItemsElements )
        {
            errorMessages.add( item.getText()
                                   .trim() );
        }
        return errorMessages;
    }
}

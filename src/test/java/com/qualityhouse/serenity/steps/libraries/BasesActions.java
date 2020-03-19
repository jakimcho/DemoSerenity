package com.qualityhouse.serenity.steps.libraries;

import com.qualityhouse.serenity.page_objects.BasePage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

/**
 * @author yakimfb
 * @since 19.03.20
 **/
public class BasesActions
{
    private BasePage currentPage;

    @Step("Enters '{1}' in field {0}")
    void fillFieldWithData( WebElementFacade fieldElement,
                            String data )
    {
        if ( data != null )
        {
            fieldElement.waitUntilEnabled()
                        .type( data );
        }
    }

    @Step("Selects '{1}' item from drop down {0}")
    void selectFromDropDownAnItemByValue( WebElementFacade dropDownElement,
                                          String itemValue )
    {
        if ( itemValue != null )
        {
            dropDownElement.selectByValue( itemValue );
        }
    }

    void selectFromDropDownAnItemByValue( By dropDownLocator,
                                          String itemValue )
    {
        this.selectFromDropDownAnItemByValue( (WebElementFacade) currentPage.find( dropDownLocator ),
                                              itemValue );
    }

    void selectFromDropDownAnItemByVisibleText( By dropDownLocator,
                                                String itemValue )
    {
        this.selectFromDropDownAnItemByVisibleText( (WebElementFacade) currentPage.find( dropDownLocator ),
                                                    itemValue );
    }

    @Step("Selects '{1}' item from drop down {0}")
    void selectFromDropDownAnItemByVisibleText( WebElementFacade dropDownElement,
                                                String itemValue )
    {
        if ( itemValue != null )
        {
            dropDownElement.selectByVisibleText( itemValue );
        }
    }
}

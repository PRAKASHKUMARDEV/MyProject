package com.myproject.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myproject.actiondriver.Action;
import com.myproject.base.BaseClass;

public class HomePage extends BaseClass {
    private static HomePage instance;
    private Action action = new Action();
    
    @FindBy(xpath = "//span[text()='My wishlists']")
    private WebElement myWishList;
    
    @FindBy(xpath = "//span[text()='Order history and details']")
    private WebElement orderHistory;

    private HomePage() {
        PageFactory.initElements(getDriver(), this);
    }

    public static HomePage getInstance() {
        if (instance == null) {
            instance = new HomePage();
        }
        return instance;
    }
    
    public boolean validateMyWishList() throws Throwable {
        return action.isDisplayed(getDriver(), myWishList);
    }
    
    public boolean validateOrderHistory() throws Throwable {
        return action.isDisplayed(getDriver(), orderHistory);
    }
    
    public String getCurrURL() throws Throwable {
        return action.getCurrentURL(getDriver());
    }
}

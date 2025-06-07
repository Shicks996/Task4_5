package com.stv.factorypages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.stv.framework.core.drivers.MyDriver;

public class LoginPageFactory {

    public LoginPageFactory() {
        PageFactory.initElements(MyDriver.getDriver(), this);
    }

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[contains(text(), 'Sign In Securely')]")
    private WebElement loginButton;

    @FindBy(className = "password-toggle")
    private WebElement showPasswordToggle;

    @FindBy(className = "form-error")
    private WebElement errorMessage;

    public void enterEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickLogin() {
        loginButton.click();
    }

    public void clickShowPassword() {
        showPasswordToggle.click();
    }

    public boolean isShowPasswordVisible() {
        return showPasswordToggle.isDisplayed();
    }

    public boolean isErrorDisplayed() {
        return errorMessage.isDisplayed();
    }
}

package com.stv.factorytests;



import com.stv.factorypages.LoginPageFactory;
import com.stv.framework.core.drivers.MyDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoginTests {

    private WebDriver driver;
    private LoginPageFactory loginPage;

    @BeforeMethod
    public void setUp() {
        driver = MyDriver.getDriver();
        driver.get("https://www.wiggle.com/login");
        loginPage = new LoginPageFactory();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testSqlInjectionInEmailField() {
        loginPage.enterEmail("' OR '1'='1");
        loginPage.enterPassword("somePassword123");
        loginPage.clickLogin();
        assertTrue(loginPage.isErrorDisplayed(), "Error message was not shown for SQL injection.");
    }

    //@Test
    //public void testShowPasswordButtonVisibilityAndClick() {
    //    assertTrue(loginPage.isShowPasswordVisible(), "'Show Password' button is not visible.");
    //    loginPage.enterPassword("test123");
    //    loginPage.clickShowPassword();
        // Проверка на то, что поле стало текстовым — WebDriver напрямую это не покажет, но действие выполнено
   // }
}
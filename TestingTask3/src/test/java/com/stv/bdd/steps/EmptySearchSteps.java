package com.stv.bdd.steps;

import com.stv.framework.core.drivers.MyDriver;
;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class EmptySearchSteps {
    WebDriver driver = MyDriver.getDriver();

    @When("the user submits an empty search")
    public void submitEmptySearch() {
        WebElement searchButton = driver.findElement(By.cssSelector("button[type='submit']"));
        searchButton.click();
    }

    @Then("an error message should be displayed")
    public void verifyErrorMessage() {
        WebElement error = driver.findElement(By.cssSelector(".search-suggestion__header")); //
        Assert.assertTrue(error.isDisplayed(), "Expected error message not displayed.");

    }
    @When("the user clicks the search icon without typing anything")
    public void the_user_clicks_the_search_icon_without_typing_anything() {
        WebDriver driver = MyDriver.getDriver();
        WebElement searchInput = driver.findElement(By.cssSelector("input[type='search']"));
        searchInput.sendKeys(Keys.ENTER);
    }

    @Then("the user should stay on the homepage or see a validation message")
    public void the_user_should_stay_on_the_homepage_or_see_a_validation_message() {
        WebDriver driver = MyDriver.getDriver();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.equals("https://www.wiggle.com/"), "User is not on the homepage");
    }
}
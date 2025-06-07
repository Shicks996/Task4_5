package com.stv.bdd.steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import com.stv.framework.core.drivers.MyDriver;
import static org.junit.Assert.*;

public class SearchOutlineSteps {

    WebDriver driver = MyDriver.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));



    @When("the user searches for {string}")
    public void searchFor(String keyword) {
        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("SearchTerm")));
        searchInput.clear();
        searchInput.sendKeys(keyword, Keys.ENTER);
    }

    @Then("search results for {string} are shown")
    public void checkSearchResults(String keyword) {
        WebElement productList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".product-list")));
        assertTrue(productList.isDisplayed());
    }
}
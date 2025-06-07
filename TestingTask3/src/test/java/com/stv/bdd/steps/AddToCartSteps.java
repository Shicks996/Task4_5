package com.stv.bdd.steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import com.stv.framework.core.drivers.MyDriver;

import static org.junit.Assert.*;

public class AddToCartSteps {

    WebDriver driver = MyDriver.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));

   // @Given("the user is on the Wiggle homepage")
    //public void openHomePage() {
    //    driver.get("https://www.wiggle.com/");
   //     driver.manage().window().maximize();
   // }

    //@When("the user searches for {string}")
    //public void searchProduct(String keyword) {
   //     WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("SearchTerm")));
    //    searchInput.clear();
    //    searchInput.sendKeys(keyword, Keys.ENTER);
    //}

    @And("the user clicks on the first product")
    public void clickFirstProduct() {
        WebElement firstProduct = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li.product-list__item a")));
        firstProduct.click();
    }

    @And("the user adds the product to the cart")
    public void addToCart() {
        WebElement addToCartBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[data-test='add-to-basket-button']")));
        addToCartBtn.click();
    }

    @Then("the product should appear in the shopping cart")
    public void verifyProductInCart() {
        WebElement basket = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[data-test='basket-link']")));
        basket.click();

        WebElement productInCart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".basket-line-product-title")));
        assertTrue(productInCart.isDisplayed());
    }
}
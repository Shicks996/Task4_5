package com.stv.bdd.steps;

import io.cucumber.java.en.Given;
import com.stv.framework.core.drivers.MyDriver;

public class CommonSteps {

    @Given("the user is on the Wiggle homepage")
    public void openHomePage() {
        MyDriver.getDriver().get("https://www.wiggle.com/");
    }
}
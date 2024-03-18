package org.brit.cucumber.step_defs;

import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import org.brit.webdriver.AppFactory;
import org.testng.annotations.BeforeSuite;

public class BaseStepDef {
    @BeforeAll
    public static void beforeSuite(){
        AppFactory.initApp();
    }
}

package org.brit.cucumber.step_defs;

import org.brit.webdriver.AppFactory;
import org.testng.annotations.BeforeSuite;

public class BaseStepDef {
    @BeforeSuite
    public void beforeSuite(){
        AppFactory.initApp();
    }
}

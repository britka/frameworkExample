package org.brit.tests;

import org.brit.application.IApplication;
import org.brit.webdriver.AppFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    public IApplication application;

    @BeforeClass
    public void beforeSuite(){
        application = AppFactory.initApp();
    }

}

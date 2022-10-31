package org.brit.tests;

import org.brit.application.IApplication;
import org.brit.webdriver.AppFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    public IApplication application;

    @BeforeClass
    public void beforeSuite(){
        application = AppFactory.initApp();
    }

    @BeforeMethod
    public void beforeMethod(){
        application
                .goToApp()
                .login("standard_user", "secret_sauce");
    }

    @AfterMethod
    public void afterMethod(){
        application.openMenu().logout();
    }

}

package org.brit.webdriver;

import com.codeborne.selenide.Configuration;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.brit.application.IApplication;
import org.brit.application.mobile.MobileApplication;
import org.brit.application.web.WebApplication;

@Log
public class AppFactory {

    public static IApplication initApp() {
        String property = System.getProperty("whereToRun", "web");
        switch (property) {
            case "web": {
                log.info("Init web instance");
                Configuration.timeout = 15000;
                Configuration.baseUrl = "https://www.saucedemo.com";
                Configuration.browserSize = "1920x1080";
                Configuration.browser = "chrome";
                return new WebApplication();
            }
            case "mobile": {
                log.info("Init mobile instance");
                Configuration.browser = AndroidDriverProvider.class.getName();
                return new MobileApplication();
            }
        }
        return null;
    }
}

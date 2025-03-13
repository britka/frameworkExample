package org.brit.webdriver;

import com.codeborne.selenide.Configuration;
import lombok.extern.java.Log;
import org.brit.application.IApplication;
import org.brit.application.mobile.MobileApplication;
import org.brit.application.pw.WebApplicationPW;
import org.brit.application.web.WebApplication;

@Log
public class AppFactory {

    public static IApplication initApp() {
        String property = System.getProperty("whereToRun", "web");
        switch (property) {
            case "web": {
                log.info("Init web instance");
                Configuration.browser = WebdriverDriverProvider.class.getName();
               // Configuration.browser = PlaywrightiumProvider.class.getName();
                return new WebApplication();
            }
            case "web_pw": {
                log.info("Init web instance");
                // Configuration.browser = WebdriverDriverProvider.class.getName();
                return new WebApplicationPW();
            }
            case "mobile": {
                log.info("Init mobile instance");
                Configuration.browser = AndroidDriverProvider.class.getName();
                return new MobileApplication();
            }
            case "remote_mobile": {
                log.info("Init remote mobile instance");
                Configuration.browser = AndroidRemotrDriverProvider.class.getName();
                return new MobileApplication();
            }
        }
        return null;
    }
}

package org.brit.webdriver;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.brit.application.IApplication;
import org.brit.application.mobile.MobileApplication;
import org.brit.application.web.WebApplication;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Map;

@Log
public class AppFactory {

    public static IApplication initApp() {
        String property = System.getProperty("whereToRun", "web");
        switch (property) {
            case "web": {
                log.info("Init web instance");
                Configuration.browser = WebdriverDriverProvider.class.getName();
                return new WebApplication();
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

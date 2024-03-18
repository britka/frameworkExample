package org.brit.webdriver;

import com.codeborne.selenide.WebDriverProvider;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.annotation.Nonnull;
import java.util.Map;

/**
 * Created by Serhii Bryt
 * 18.03.2024 19:16
 **/
public class WebdriverDriverProvider implements WebDriverProvider {
    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        ChromeOptions options = new ChromeOptions();
        //options.merge(capabilities);
      //  options.setBrowserVersion("121");
        // options.addArguments("--incognito");
        options.setExperimentalOption("prefs",
                Map.of("credentials_enable_service", false,
                        "profile.password_manager_enabled", false)
        );
        ChromeDriver chromeDriver = new ChromeDriver(options);
        chromeDriver.manage().window().maximize();
        return chromeDriver;
    }
}

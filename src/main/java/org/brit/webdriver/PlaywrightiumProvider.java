package org.brit.webdriver;

import com.codeborne.selenide.WebDriverProvider;
import org.brit.driver.PlaywrightiumDriver;
import org.brit.options.PlaywrightiumOptions;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

/**
 * Created by Serhii Bryt
 * 03.06.2024 18:48
 **/
public class PlaywrightiumProvider implements WebDriverProvider {
    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        PlaywrightiumOptions playwrightiumOptions = new PlaywrightiumOptions();
        playwrightiumOptions.setHeadless(false);
        playwrightiumOptions.setRecordVideo(true);
        playwrightiumOptions.merge(capabilities);
        return new PlaywrightiumDriver(playwrightiumOptions);
    }
}

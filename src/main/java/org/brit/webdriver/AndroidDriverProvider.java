package org.brit.webdriver;

import static com.codeborne.selenide.Selenide.closeWebDriver;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import java.io.File;
import java.net.URL;
import javax.annotation.Nonnull;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class AndroidDriverProvider implements WebDriverProvider {

    AndroidDriver androidDriver;

    @SneakyThrows
    @Nonnull
    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
        closeWebDriver();
        Configuration.startMaximized = false;
        Configuration.browserSize = null;
        DesiredCapabilities capability = new DesiredCapabilities();
        capability.setCapability("deviceName", "emulator-5554");
        capability.setCapability("platformVersion", "11");
        capability.setCapability("platformName", "Android");
        capability.setCapability("app", new File("app/app.apk").getAbsolutePath());
        capability.setCapability("appPackage", "com.swaglabsmobileapp");
        capability.setCapability("appActivity", ".MainActivity");
       // desiredCapabilities.merge(capability);
        androidDriver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capability);
        return androidDriver;
    }
}

package org.brit.webdriver;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import lombok.SneakyThrows;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.URL;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class AndroidRemotrDriverProvider implements WebDriverProvider {

    AndroidDriver androidDriver;

    @SneakyThrows
    public WebDriver createDriver(Capabilities desiredCapabilities) {
        closeWebDriver();
        // Configuration.startMaximized = false;
        // Configuration.startMaximized = false;
        Configuration.browserSize = null;
        DesiredCapabilities capability = new DesiredCapabilities();
        capability.setCapability("deviceName", "android");
        capability.setCapability("browserVersion", "8.1");
        //  capability.setCapability("platformVersion", "8.1");
        //  capability.setCapability("platformName", "Android");
        capability.setCapability("app", new File("app/app.apk").getAbsolutePath());
        capability.setCapability("appPackage", "com.swaglabsmobileapp");
        capability.setCapability("appActivity", ".MainActivity");
        capability.setCapability("enableVNC", true);
        // desiredCapabilities.merge(capability);
        androidDriver = (AndroidDriver) new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);

        return androidDriver;
    }
}

package org.brit.webdriver;

import static com.codeborne.selenide.Selenide.closeWebDriver;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import java.io.File;
import java.net.URL;
import javax.annotation.Nonnull;

import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.options.BaseOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import lombok.SneakyThrows;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class AndroidDriverProvider implements WebDriverProvider {

    AndroidDriver androidDriver;

    @SneakyThrows
    @Nonnull
    public WebDriver createDriver(Capabilities desiredCapabilities) {
        AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();
        service.start();

        closeWebDriver();
       // Configuration.startMaximized = false;
        Configuration.timeout = 30000;
        Configuration.browserSize = null;

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("emulator-5554")
                .setPlatformName("Android")
                .setApp(new File("app/app.apk").getAbsolutePath())
                .setAppPackage("com.swaglabsmobileapp")
                .setAppActivity(".MainActivity");

//        DesiredCapabilities capability = new DesiredCapabilities();
//        capability.setCapability("deviceName", "emulator-5554");
//      //  capability.setCapability("platformVersion", "10");
//        capability.setCapability("platformName", "Android");
//        capability.setCapability("app", new File("app/app.apk").getAbsolutePath());
//        capability.setCapability("appPackage", "com.swaglabsmobileapp");
//        capability.setCapability("appActivity", ".MainActivity");
//        capability.setCapability("automationName", "UiAutomator2");
       // desiredCapabilities.merge(capability);
        androidDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
        return androidDriver;
    }
}

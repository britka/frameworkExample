package org.brit.webdriver;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

/**
 * Created by Serhii Bryt
 * 03.06.2024 18:42
 **/
public class PlaywrightDriver {
    private static PlaywrightDriver instance = null;
    private ThreadLocal<Playwright> playwright = new ThreadLocal<>();
    private ThreadLocal<BrowserContext> browserContext = new ThreadLocal<>();
    private ThreadLocal<Page> page = new ThreadLocal<>();

    public static PlaywrightDriver getInstance() {
        if (instance == null){
            instance = new PlaywrightDriver();
        }
        return instance;
    }

    public Playwright getPlaywright() {
        if (playwright.get() == null){
            playwright.set(Playwright.create());
        }
        return playwright.get();
    }

    public BrowserContext getBrowserContext() {
        if (browserContext.get() == null){
           browserContext.set(getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)).newContext());
        }
        return browserContext.get();
    }

    public Page getPage() {
        if (page.get() == null){
            page.set(getBrowserContext().newPage());
        }
        return page.get();
    }
}

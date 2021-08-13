package com.selenide.demo.utils;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.Cookie;

import java.util.Set;

public class CookiesUtils {
    Set<Cookie> seleniumCookieSet = WebDriverRunner.getWebDriver().manage().getCookies();

    public int checkCookies() {
        if(seleniumCookieSet.isEmpty()) {
            return 0;
        } else {
            return seleniumCookieSet.size();
        }
    }

    public String cookieName() {
        for(Cookie cookie: seleniumCookieSet) {
            return cookie.getName();
        }
        return null;
    }

    public void setCookie() {
        System.out.println(seleniumCookieSet.isEmpty());
    }
}

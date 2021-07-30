package com.selenide.demo.base;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import static com.codeborne.selenide.Selenide.open;

public abstract class TestBase {

    @BeforeTest
    public void config() {
        Configuration.timeout = 30000;
//        Configuration.browser = "safari";
    }

    @BeforeMethod
    public void init() {
        open("https://galeria.stage.galeria.bestbytes.net/", "", "demo", "dfLr8dY7e7ZJJmtqwAJtVQZiGHNiUZ9gNssMjK4rHTFFaTeUd6");
        open("https://galeria.stage.galeria.bestbytes.net/");
    }

    @AfterMethod
    public void close() {

    }

    @AfterTest
    public void tearDown() {

    }
}

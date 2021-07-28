package com.selenide.demo.tests;

import com.selenide.demo.keyword.GaleriaKeywords;
import org.testng.annotations.*;

import static com.codeborne.selenide.Selenide.open;

public class GaleriaTest {

    GaleriaKeywords galeriaKeywords;

    @BeforeTest
    void openPage() {
        galeriaKeywords = new GaleriaKeywords();
    }

    @BeforeMethod
    void init() {
        open("https://galeria.stage.galeria.bestbytes.net/", "", "demo", "dfLr8dY7e7ZJJmtqwAJtVQZiGHNiUZ9gNssMjK4rHTFFaTeUd6");
        open("https://galeria.stage.galeria.bestbytes.net/");
    }

    @Test
    void cart() throws InterruptedException {
        galeriaKeywords.addToCart();
        Thread.sleep(5000);
    }

    @AfterMethod
    void close() {

    }

    @AfterTest
    void tearDown() {

    }
}

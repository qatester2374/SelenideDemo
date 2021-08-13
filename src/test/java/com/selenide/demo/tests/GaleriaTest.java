package com.selenide.demo.tests;

import com.selenide.demo.base.TestBase;
import com.selenide.demo.keyword.GaleriaKeywords;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GaleriaTest extends TestBase {

    protected GaleriaKeywords galeriaKeywords;

    @BeforeTest
    void before() {
        galeriaKeywords = new GaleriaKeywords();
    }

    @Test
    void cart() throws InterruptedException {
        galeriaKeywords.addToCart();
        Thread.sleep(5000);
    }

    @Test
    void store() throws InterruptedException {
//        Thread.sleep(15000);
        galeriaKeywords.favoriteStore();
        Thread.sleep(5000);
    }

    @Test
    void hover() throws InterruptedException {
        galeriaKeywords.hoverArticleImages();
    }

    @Test
    void articleHeader() throws InterruptedException {
        galeriaKeywords.validateArticleHeader();
    }

    @Test
    void quantity() throws InterruptedException {
        galeriaKeywords.changeQuantity();
        Thread.sleep(2000);
    }

    @Test
    void menus() throws InterruptedException {
        galeriaKeywords.openMenuInHeader();
    }

    @Test
    void filialFinder() throws InterruptedException {
        galeriaKeywords.filialFinderKey();
        Thread.sleep(4000);
    }

}

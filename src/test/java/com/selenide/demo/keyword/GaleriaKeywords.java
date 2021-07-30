package com.selenide.demo.keyword;

import com.selenide.demo.pages.GaleriaPage;
import com.selenide.demo.utils.CookiesUtils;
import com.selenide.demo.utils.LocalStorageUtils;

public class GaleriaKeywords {

    GaleriaPage galeriaPage = new GaleriaPage();

    public void addToCart() throws InterruptedException {
        CookiesUtils cookiesUtils = new CookiesUtils();

        System.out.println("COOKIES SIZE: " + cookiesUtils.checkCookies());
        System.out.println("COOKIES NAME: " + cookiesUtils.cookieName());

        galeriaPage.clickOnElement("button","All menu");
        galeriaPage.scrollOnElementAndClick("Shirts & Tops");
        galeriaPage.validateGridIsDisplayed();
        galeriaPage.scrollOnElementInGridAndClick(1);
        galeriaPage.clickOnElement("button","Add to cart");
//        galeriaPage.scrollOnElement("Unit Test - Content Links");
//        galeriaPage.closeMenu();

        galeriaPage.clickOnElement("button","All menu");
        galeriaPage.scrollOnElementAndClick("Golf");
        galeriaPage.validateGridIsDisplayed();
        galeriaPage.scrollOnElementInGridAndClick(14);
        galeriaPage.clickOnElement("button","Add to cart");

        galeriaPage.clickOnElement("button","All menu");
        galeriaPage.scrollOnElementAndClick("Handschuhe");
        galeriaPage.validateGridIsDisplayed();
        galeriaPage.scrollOnElementInGridAndClick(1);
        galeriaPage.clickOnElement("button","Add to cart");
        galeriaPage.clickOnXIcon(2);

        galeriaPage.clickOnElement("button","All menu");
        galeriaPage.scrollOnElementAndClick("Haushalt");
        galeriaPage.validateGridIsDisplayed();
        galeriaPage.scrollOnElementInGridAndClick(2);
        galeriaPage.clickOnElement("button","Add to cart");

        galeriaPage.clickOnElement("button","All menu");
        galeriaPage.scrollOnElementAndClick("Radsport");
        galeriaPage.validateGridIsDisplayed();
        galeriaPage.scrollOnElementInGridAndClick(7);
        galeriaPage.clickOnElement("button","Add to cart");

        System.out.println("COOKIES NAME BOTTOM: " + cookiesUtils.cookieName());
    }

    public void favoriteStore() {
        LocalStorageUtils localStorageUtils = new LocalStorageUtils();

        galeriaPage.clickOnElement("span", "Filiale");
        localStorageUtils.localStorageStores("Berlin", 3);
        galeriaPage.clickOnElement("button", "ndern");
        localStorageUtils.localStorageStores("Krefeld", 1);
        galeriaPage.clickOnElement("button", "ndern");
        localStorageUtils.localStorageStores("Duisburg", 9);
    }
}

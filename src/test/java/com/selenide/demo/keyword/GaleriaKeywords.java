package com.selenide.demo.keyword;

import com.selenide.demo.pages.GaleriaPage;

public class GaleriaKeywords {

    GaleriaPage galeriaPage = new GaleriaPage();

    public void addToCart() {
        galeriaPage.clickOnButton("All menu");
        galeriaPage.scrollOnElementAndClick("Handschuhe");
        galeriaPage.validateGridIsDisplayed();
        galeriaPage.scrollOnElementInGridAndClick(1);
        galeriaPage.clickOnButton("Add to cart");

        galeriaPage.clickOnButton("All menu");
        galeriaPage.scrollOnElementAndClick("Haushalt");
        galeriaPage.validateGridIsDisplayed();
        galeriaPage.scrollOnElementInGridAndClick(2);
        galeriaPage.clickOnButton("Add to cart");

        galeriaPage.clickOnButton("All menu");
        galeriaPage.scrollOnElementAndClick("Radsport");
        galeriaPage.validateGridIsDisplayed();
        galeriaPage.scrollOnElementInGridAndClick(7);
        galeriaPage.clickOnButton("Add to cart");
    }
}

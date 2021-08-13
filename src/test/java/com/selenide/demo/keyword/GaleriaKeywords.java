package com.selenide.demo.keyword;

import com.selenide.demo.locators.Locators;
import com.selenide.demo.pages.GaleriaPage;
import com.selenide.demo.utils.CookiesUtils;
import com.selenide.demo.utils.LocalStorageUtils;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class GaleriaKeywords {

    GaleriaPage galeriaPage = new GaleriaPage();
    int counter = 0;
    List<String> items = new ArrayList<String>();

    /**
     *
     * Click on the All menu button
     * Click on the specific article in the grid
     * Get name of the article
     * Click on the add to cart button
     * Open cart on the top right part of the page
     * Get name of the article in the cart
     * Assert that article name in the cart is equal as article name in the page
     *
     * @param group
     * @param index
     * @throws InterruptedException
     */
    private void cart(String group, int index) throws InterruptedException {
        galeriaPage.clickOnElement("button","All menu");
        galeriaPage.scrollOnElementAndClick(group);
        galeriaPage.validateGridIsDisplayed();
        galeriaPage.scrollOnElementInGridAndClick(index);
        String articleName = galeriaPage.getArticleName();
        items.add(articleName);
        System.out.println("articleName:" + articleName);
        System.out.println("items1: " + items);
        galeriaPage.clickOnElement("button","Add to cart");
        galeriaPage.openCart();
//        System.out.println(galeriaPage.cartSize());
        Thread.sleep(2000);
        boolean nameIsInTheCart = galeriaPage.getArticleNameInCard(articleName);
        System.out.println("nameIsInTheCart: " + nameIsInTheCart);
        Assert.assertTrue(nameIsInTheCart);
        counter = counter + 1;
//        System.out.println("counter: " + counter);
        Assert.assertEquals(counter, galeriaPage.cartSize());
        Thread.sleep(5000);
    }

    /**
     *
     * Open specific group of articles
     * Add articles in the cart
     * Check is valid articles added to the cart
     *
     * @throws InterruptedException
     */
    public void addToCart() throws InterruptedException {
        CookiesUtils cookiesUtils = new CookiesUtils();

        System.out.println("COOKIES SIZE: " + cookiesUtils.checkCookies());
        System.out.println("COOKIES NAME: " + cookiesUtils.cookieName());

        cart("Taschen", 7);

        cart("Golf", 14);

        cart("Premium", 1);

        cart("Badminton", 2);

//        galeriaPage.clickOnXIcon(2);

        cart("Radsport", 7);

        System.out.println("COOKIES NAME BOTTOM: " + cookiesUtils.cookieName());
    }

    /**
     * Select and change favorite store
     */
    public void favoriteStore() throws InterruptedException {
        LocalStorageUtils localStorageUtils = new LocalStorageUtils();
        CookiesUtils cookiesUtils = new CookiesUtils();

        galeriaPage.clickOnElementContainsText("button/p", "Filiale");
        localStorageUtils.localStorageStores("Berlin", 3);
        galeriaPage.clickOnElementContainsText("button", "ndern");
        localStorageUtils.localStorageStores("Krefeld", 1);
        galeriaPage.clickOnElementContainsText("button", "ndern");
        localStorageUtils.localStorageStores("Duisburg", 9);

        System.out.println("COOKIE NAME ;-): " + cookiesUtils.cookieName());
    }

    /**
     *
     * Hover over images in the left side of single article page
     *
     * @throws InterruptedException
     */
    public void hoverArticleImages() throws InterruptedException {
        galeriaPage.clickOnElement("button","All menu");
        galeriaPage.scrollOnElementAndClick("Badminton");
        galeriaPage.validateGridIsDisplayed();
        galeriaPage.scrollOnElementInGridAndClick(3);
//        galeriaPage.scrollOnImageOnGrid(2);
        galeriaPage.hoverOverImages();
    }

    /**
     *
     * Scroll grid of article until it reaches end of the grid
     *
     * @throws InterruptedException
     */
    public void validateArticleHeader() throws InterruptedException {
        galeriaPage.clickOnElement("button","All menu");
        galeriaPage.scrollOnElementAndClick("Radsport");
        galeriaPage.validateGridIsDisplayed();
//        galeriaPage.scrollToNextLineInGrid(3, 1000);
//        System.out.println(Locators.searchResultsGrid.size());
        for (int i=0; i < Locators.searchResultsGrid.size(); i++) {
//            System.out.println("i: " + i);
        }
        int j = 0;
        try {

            do {
                j = j + 1;
                galeriaPage.scrollToNextLineInGrid(j,  0);
                if (Locators.searchResultsGrid.get(j).getText().contains("TomTailor")) {
                    System.out.println("Tom Tailor!!!!!! " + Locators.searchResultsGrid.get(j).getText());
                }
                System.out.println(Locators.searchResultsGrid.size());
            } while (Locators.searchResultsGrid.size() < 39); // 399

        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: " + e);
        }
    }

    /**
     *
     * Change quantity by clicking + and - button, or enter it manually in input
     *
     * @throws InterruptedException
     */
    public void changeQuantity() throws InterruptedException {
        galeriaPage.clickOnElement("button","All menu");
        galeriaPage.scrollOnElementAndClick("Radsport");
        galeriaPage.validateGridIsDisplayed();
        galeriaPage.scrollOnElementInGridAndClick(7);
        galeriaPage.scrollToQuantity();

        galeriaPage.clickToIncreaseQuantity();
        Thread.sleep(1000);
        galeriaPage.clickToIncreaseQuantity();
        Thread.sleep(1000);
        galeriaPage.clickToDecreaseQuantity();
        Thread.sleep(1000);
        galeriaPage.clickToIncreaseQuantity();
        Thread.sleep(1000);
        galeriaPage.clearQuantityInput();
        Thread.sleep(1000);
        galeriaPage.enterQuantity("99");
        Thread.sleep(1000);
        galeriaPage.clearQuantityInput();
        Thread.sleep(1000);
    }

    public void openMenuInHeader() throws InterruptedException {
        galeriaPage.hoverMenu("Sport", "Radsport");
        galeriaPage.hoverMenu("Damen", "Blusen");
    }

    public void filialFinderKey() throws InterruptedException {
        galeriaPage.clickOnElementContainsText("button/p", "Filiale");
        galeriaPage.clickOnFilialFinder();
        galeriaPage.numberOfFilialen();
        galeriaPage.filialeItemContainsImage();
        galeriaPage.filialeSuggest("Hamburg");
    }
}

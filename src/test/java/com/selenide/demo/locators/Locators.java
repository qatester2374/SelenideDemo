package com.selenide.demo.locators;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Locators {
    public static SelenideElement damenTab = $(byXpath("//a[contains(text(), 'Damen')]"));
    SelenideElement searchInput = $(byXpath("//input[@placeholder='Search products']"));
    public static SelenideElement allMenu = $(byXpath("//button[contains(text(), 'All menu')]"));
    public static SelenideElement radSport = $(byXpath("//a[contains(text(), 'Radsport')]"));
    public static SelenideElement winterschuhe = $(byXpath("//a[contains(text(), 'Winterschuhe')]"));
    SelenideElement span = $(byXpath("//span[contains(text(), 'Radsport')]"));
    public static ElementsCollection searchResultsGrid = $$("div.heluOB div.EPiAM");
    ElementsCollection labelsArticle = $$("div label");
    SelenideElement quantityPlus = $(byXpath("//button[@data-testid='plusButton']"));
    SelenideElement quantityMinus = $(byXpath("//button[@data-testid='minusButton']"));
    SelenideElement counterInput = $(byName("counterInput"));
    ElementsCollection imagesGrid = $$(".ProductGallerystyled__ThumbsStyle-sc-1dr9xt-3 button");
    SelenideElement numberOfSearchElements = $(byClassName("gkk-pop-pagination__details"));
    ElementsCollection searchResultItems = $$("#search-result-items li.gkk-search-results__item");
    SelenideElement wishList = $(byId("IDTA_wishlist"));
    SelenideElement wishListIndicator = $(byId("wishlist-indicator"));
    //    SelenideElement pagination = $(byClassName("gkk-pop-pagination__nav-pages-item-link"));
    SelenideElement lastPage = $(byClassName("gkk-pop-pagination__nav-icon--relative-left"));
    SelenideElement lastPageNumbers = $(byClassName("gkk-pop-pagination__nav-pages"));
    ElementsCollection lastPageNumbersElements = $$("ul .gkk-pop-pagination__nav-pages-item");
    public static SelenideElement filiale = $(byXpath("//span[contains(text(), 'Filiale')]"));
    SelenideElement andern = $(byXpath("//button[contains(text(), 'ndern')]"));
    SelenideElement findStore = $(byXpath("//input[@placeholder='Find store']"));
    //    ElementsCollection stores = $$("div .kMuqUv");
    ElementsCollection stores = $$("div .kMuqUv .gFlvGi");
    SelenideElement closeFiliale = $(byXpath("//html/body/div[2]"));
    SelenideElement sport = $(byXpath("//a[contains(text(), 'Sport')]"));
    SelenideElement addToCart = $(byXpath("//button[contains(text(), 'Add to cart')]"));
    ElementsCollection numOfProductInCard = $$("table.CartSummaryTable__StyledTable-sc-1nljcub-0 tr:nth-child(1) td");
    ElementsCollection warenkorbIcon = $$("button.sc-dIsUp.kMuqUv");
    ElementsCollection warenkorbButton = $$("a.gfuSqG button.ilcNEp");
    public static ElementsCollection links = $$("div.kFpSeR ul li a");
    public static ElementsCollection body = $$("div.sc-kEqXSa.bAVzgZ");
    public static SelenideElement close = $(byXpath("/html/body/div[4]/button"));
    public static ElementsCollection deleteFromCard = $$("div.sc-hHEiqL.ccTnQh div div div button.sc-dIsUp.bpicMv.sc-dlMDgC.kpPvTx svg");
}

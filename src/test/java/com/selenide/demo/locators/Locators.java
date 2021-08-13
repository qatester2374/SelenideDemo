package com.selenide.demo.locators;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Locators {
    public static SelenideElement damenTab = $(byXpath("//a[contains(text(), 'Damen')]"));
    SelenideElement searchInput = $(byXpath("//input[@placeholder='Search products']"));
    public static SelenideElement allMenu = $(byXpath("//button[contains(text(), 'All menu')]"));
    public static SelenideElement radSport = $(byXpath("//a[contains(text(), 'Radsport')]"));
    public static SelenideElement winterschuhe = $(byXpath("//a[contains(text(), 'Winterschuhe')]"));
    SelenideElement span = $(byXpath("//span[contains(text(), 'Radsport')]"));
    public static ElementsCollection searchResultsGrid = $$("div.sc-fujyAs.kSdKLt div.sc-lbVvki.ghCdOs"); // div.sc-bdnxRM.bmDzTv div.sc-iNiQyp.jdiWPe
    ElementsCollection labelsArticle = $$("div label");
    public static SelenideElement quantityPlus = $(byXpath("//button[@data-testid='plusButton']"));
    public static SelenideElement quantityMinus = $(byXpath("//button[@data-testid='minusButton']"));
    public static SelenideElement counterDiv = $(byXpath("//div[@data-testid='counterInput']"));
    public static SelenideElement counterInput = $(byName("counterInput"));
    public static ElementsCollection imagesGrid = $$("div.sc-bdnxRM.ProductGallerystyled__ThumbsStyle-sc-1dr9xt-3.kEraaO.ecPPfR button");
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
    public static SelenideElement findStore = $(byXpath("//input[@placeholder='Find store']"));
    //    ElementsCollection stores = $$("div .kMuqUv");
    ElementsCollection stores = $$("div .kMuqUv .gFlvGi");
    SelenideElement closeFiliale = $(byXpath("//html/body/div[2]"));
    SelenideElement sport = $(byXpath("//a[contains(text(), 'Sport')]"));
    SelenideElement addToCart = $(byXpath("//button[contains(text(), 'Add to cart')]"));
    ElementsCollection numOfProductInCard = $$("table.CartSummaryTable__StyledTable-sc-1nljcub-0 tr:nth-child(1) td");
    public static SelenideElement warenkorbIcon = $(byXpath("//*[@id=\"__next\"]/div/div[1]/div[2]/div/div[1]/div/div[3]"));
    ElementsCollection warenkorbButton = $$("a.gfuSqG button.ilcNEp");
    public static ElementsCollection links = $$("div.kFpSeR ul li a");
    public static ElementsCollection body = $$("div.sc-kEqXSa.bAVzgZ");
    public static SelenideElement close = $(byXpath("/html/body/div[4]/button"));
    public static ElementsCollection deleteFromCard = $$("div.sc-hHEiqL.ccTnQh div div div button.sc-dIsUp.bpicMv.sc-dlMDgC.kpPvTx svg");
//    public static SelenideElement articleName = $(byCssSelector("h2.sc-eCApnc.eAtizK"));
    public static ElementsCollection articlesInCart = $$("div.sc-hHEiqL.ccTnQh.sc-iJCRrE.bojiJp div div div h4");
    public static ElementsCollection menuHeaderElements = $$(byXpath("//*[@id=\"__next\"]/div/div[1]/div[2]/div/div[1]/nav/div[1]/div"));
    public static  ElementsCollection subMenuElements = $$("div.sc-bdnxRM.hsMRbp p.sc-gtsrHT.jNHpaB"); // div.sc-bdnxRM.hsMRbp
    public static SelenideElement filialFinder = $(byXpath("//button[contains(@class, 'sc-dIsUp') and contains(@class, 'lkknZH') and contains(text(), 'Zum GALERIA Filialfinder')]"));
    public static ElementsCollection filialenList = $$("div.ubsf_locations-list-inner > div.ubsf_locations-list-item");
    public static SelenideElement filialeImg = $(byXpath("//img[contains(@class, 'lazy-load-image') and contains(@src, 'https://s3.eu-central-1.amazonaws.com/uberall-userpics-prod/2838595/thumb_V9NV3JJKQ3.png')]"));
    public static SelenideElement geoSuggestInput = $(byXpath("//input[@class='geosuggest__input']"));
    public static ElementsCollection geoSuggests = $$("ul.geosuggest__suggests li.geosuggest__item.ubsf_fixture-item");
}

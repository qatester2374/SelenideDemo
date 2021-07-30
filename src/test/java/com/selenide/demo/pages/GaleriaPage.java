package com.selenide.demo.pages;

import com.codeborne.selenide.SelenideElement;
import com.selenide.demo.base.PageBase;
import com.selenide.demo.locators.Locators;

import java.util.Random;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class GaleriaPage extends PageBase {

    Random rand = new Random();

    public void hover(String tag, String text) {
        SelenideElement el = $(byXpath("//" + tag + "[contains(text(), '" + text + "')]"));
        el.hover();
    }

    public void clickOnElement(String locator, String text) {
        SelenideElement button = $(byXpath("//" + locator + "[contains(text(), '" + text + "')]"));
        clickOn(button);

//        if(Locators.links.size() > 0) {
//            int rand_int1 = rand.nextInt(Locators.links.size());
//            System.out.println("********************************************");
//            System.out.println("LINKS: " + Locators.links.size() + " RANDOM: " + rand_int1 + " TEXT: " + text);
////        for(int i=0; i<Locators.links.size(); i++) {
////            System.out.println(Locators.links.get(i).getText());
////        }
//            System.out.println("DELETE: " + Locators.deleteFromCard.size());
//        }
    }

    public void scrollOnElementAndClick(String text) {
        SelenideElement el = $(byXpath("//a[contains(text(), '" + text + "')]"));
        System.out.println("TEXT: " + text);
        scrollTo(el);
        clickOn(el);
    }

    public void scrollOnElement(String text) {
        SelenideElement el = $(byXpath("//a[contains(text(), '" + text + "')]"));
        scrollTo(el);
    }

    public void closeMenu() {
        Locators.close.click();
    }

    public void validateGridIsDisplayed() {
        gridIsDisplayed(Locators.searchResultsGrid);
    }

    public void scrollOnElementInGridAndClick(int index) {
        scrollToElementInGrid(Locators.searchResultsGrid, index);
        clickOn(Locators.searchResultsGrid.get(index));
    }

    public void clickOnXIcon(int index) {
        Locators.deleteFromCard.get(index).click();
    }

    // Filiale

}

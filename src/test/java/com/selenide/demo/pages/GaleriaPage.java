package com.selenide.demo.pages;

import com.codeborne.selenide.SelenideElement;
import com.selenide.demo.base.PageBase;
import com.selenide.demo.locators.Locators;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class GaleriaPage extends PageBase {

    public void clickOnButton(String text) {
        SelenideElement button = $(byXpath("//button[contains(text(), '" + text + "')]"));
        clickOn(button);
    }

    public void scrollOnElementAndClick(String text) {
        SelenideElement el = $(byXpath("//a[contains(text(), '" + text + "')]"));
        scrollTo(el);
        clickOn(el);
    }

    public void validateGridIsDisplayed() {
        gridIsDisplayed(Locators.searchResultsGrid);
    }

    public void scrollOnElementInGridAndClick(int index) {
        scrollToElementInGrid(Locators.searchResultsGrid, index);
        clickOn(Locators.searchResultsGrid.get(index));
    }
}

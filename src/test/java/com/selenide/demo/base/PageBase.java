package com.selenide.demo.base;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;

public abstract class PageBase {

    protected void clickOn(SelenideElement el) {
        $(el).shouldBe(Condition.visible);
        el.click();
    }

    protected void scrollTo(SelenideElement el) {
        $(el).scrollIntoView(true).shouldBe(Condition.visible);
    }

    protected void gridIsDisplayed(ElementsCollection searchGrid) {
        $(searchGrid.get(0)).shouldBe(Condition.exist);
        System.out.println(searchGrid.size());
        Assert.assertTrue(searchGrid.size() > 0);
    }

    protected void scrollToElementInGrid(ElementsCollection searchGrid, int index) {
        $(searchGrid.get(index)).scrollIntoView(true);
    }

}

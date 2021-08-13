package com.selenide.demo.base;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.selenide.demo.locators.Locators;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;
import static org.assertj.core.api.Assertions.assertThat;

public abstract class PageBase {

    protected void clickOn(SelenideElement el) {
        $(el).shouldBe(Condition.visible);
        el.click();
    }

    protected void sendKeys(SelenideElement el, String text) {
        $(el).shouldBe(Condition.visible);
        el.sendKeys(text);
    }

    protected void isDisplayed(SelenideElement el) {
        $(el).shouldBe(Condition.visible);
    }

    protected void clear(SelenideElement el) {
        $(el).shouldBe(Condition.visible);
        el.clear();
    }

    protected void hover(SelenideElement el) {
        $(el).shouldBe(Condition.visible);
        el.hover();
    }

    protected void assertStringEquals(SelenideElement el, String text) {
        Assert.assertTrue(el.getValue().equals(text));
    }

    protected void assertStringContains(SelenideElement el, String text) {
        Assert.assertTrue(el.getText().contains(text));
    }

    protected void assertNumber(int number) {
        Assert.assertTrue(Integer.valueOf(Locators.counterInput.getValue()).equals(number));
    }

    protected void assertImage(SelenideElement el) {
        assertThat($(el).isImage()).isTrue();
    }

    protected void scrollTo(SelenideElement el) throws InterruptedException {
        // the top of the element will be aligned to the top.
        $(el).scrollIntoView(true).shouldBe(Condition.visible);
        // element will be aligned to the center.
        $(el).scrollIntoView("{behavior: \"instant\", block: \"center\", inline: \"center\"}");
    }

    protected void elementsCollectionIsDisplayed(ElementsCollection elements) {
        $(elements.get(0)).shouldBe(Condition.visible);
        System.out.println("SEARCH GRID SIZE: " + elements.size());
        Assert.assertTrue(elements.size() > 0);
    }

    protected void scrollToElementInElementsCollection(ElementsCollection elements, int index) {
        $(elements.get(index)).scrollIntoView(true).shouldBe(Condition.visible);
    }

    protected boolean isElementsCollectionLoaded(ElementsCollection elements) {
        if (elements.size() > 0) {
            return true;
        }
        return false;
    }

    protected void containsImage(SelenideElement el, String imageClass, String url) {
        el.find(By.cssSelector("img")).shouldBe(Condition.visible);
        el.find(By.className(imageClass)).shouldBe(Condition.visible);
        el.find(By.cssSelector("img")).getAttribute("src").equals(url);
        System.out.println("src: " + el.find(By.cssSelector("img")).getAttribute("src"));
    }

}

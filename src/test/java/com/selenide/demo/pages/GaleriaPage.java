package com.selenide.demo.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.selenide.demo.base.PageBase;
import com.selenide.demo.locators.Locators;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class GaleriaPage extends PageBase {

    /**
     *
     * Click on the element with locator and text
     *
     * @param locator
     * @param text
     */
    public void clickOnElement(String locator, String text) {
        SelenideElement el = $(byXpath("//" + locator + "[text()='" + text + "']"));
        clickOn(el);
    }

    public void clickOnElementContainsText(String locator, String text) {
        SelenideElement el = $(byXpath("//" + locator + "[contains(text(),'" + text + "')]"));
        clickOn(el);
    }

    /**
     *
     * Scroll to element in the list and click on it
     *
     * @param text
     * @throws InterruptedException
     */
    public void scrollOnElementAndClick(String text) throws InterruptedException {
        SelenideElement el = $(byXpath("//a[text()='" + text + "']"));
        scrollTo(el);
        clickOn(el);
    }

    /**
     *
     * Scroll on the element on the page
     *
     * @param text
     * @throws InterruptedException
     */
    public void scrollOnElement(String text) throws InterruptedException {
        SelenideElement el = $(byXpath("//a[contains(text(), '" + text + "')]"));
        scrollTo(el);
    }

    /**
     *
     */
    public void closeMenu() {
        Locators.close.click();
    }

    /**
     * Validate that grid with articles is displayed
     */
    public void validateGridIsDisplayed() {
        elementsCollectionIsDisplayed(Locators.searchResultsGrid);
    }

    /**
     *
     * Scroll om the element in the grid of articles
     *
     * @param index
     */
    public void scrollOnElementInGrid(int index) {
        scrollToElementInElementsCollection(Locators.searchResultsGrid, index);
    }

    /**
     *
     * Scroll om the element in the grid of articles and click io it
     *
     * @param index
     */
    public void scrollOnElementInGridAndClick(int index) {
        scrollToElementInElementsCollection(Locators.searchResultsGrid, index);
        clickOn(Locators.searchResultsGrid.get(index));
    }

    /**
     *
     * Scroll on grid of images in the single article page
     *
     * @param index
     */
    public void scrollOnImageOnGrid(int index) {
        scrollToElementInElementsCollection(Locators.imagesGrid, index);
        System.out.println("Images Grid: " + Locators.imagesGrid);
    }

    /**
     *
     * Scroll on item in the cart (on the top right)
     *
     * @param index
     */
    public void scrollOnItemInCard(int index) {
        scrollToElementInElementsCollection(Locators.articlesInCart, index);
    }

    /**
     *
     * Click on icon to delete the article from the cart
     *
     * @param index
     */
    public void clickOnXIcon(int index) {
        Locators.deleteFromCard.get(index).click();
    }

    /**
     * Hover over images in the left side of single article page
     */
    public void hoverOverImages() {
        Locators.imagesGrid.get(0).shouldBe(Condition.visible);
        System.out.println("images: " + Locators.imagesGrid.size());
        for (int i = 0; i < Locators.imagesGrid.size(); i++) {
            scrollToElementInElementsCollection(Locators.imagesGrid, i);
            hover(Locators.imagesGrid.get(i));
        }
    }

    /**
     *
     * Scroll to the next line on the grid with articles until it reaches the end
     *
     * @param index
     * @param duration
     * @throws InterruptedException
     */
    public void scrollToNextLineInGrid(int index, int duration) throws InterruptedException {
        scrollOnElementInGrid(index);
        Thread.sleep(duration);
    }

    /**
     * Click on the + button to increase the quantity of the order
     */
    public void clickToIncreaseQuantity() {
        int val = Integer.valueOf(Locators.counterInput.getValue());
        clickOn(Locators.quantityPlus);
        assertNumber(val+1);
    }

    /**
     * Click on the - button to decrease the quantity of the order
     */
    public void clickToDecreaseQuantity() {
        int val = Integer.valueOf(Locators.counterInput.getValue());
        clickOn(Locators.quantityMinus);
        assertNumber(val-1);
    }

    /**
     *
     * Enter quantity manually in the input
     *
     * @param text
     */
    public void enterQuantity(String text) {
        sendKeys(Locators.counterInput, text);
        assertStringEquals(Locators.counterInput, text);
    }

    /**
     *
     * Scroll to the area with quantity input and buttons
     *
     * @throws InterruptedException
     */
    public void scrollToQuantity() throws InterruptedException {
        scrollTo(Locators.counterInput);
    }

    /**
     * Clear quantity input
     */
    public void clearQuantityInput() {
        clear(Locators.counterInput);
        System.out.println("COUNTER CLEAR: " + Locators.counterInput.getValue());
        assertStringEquals(Locators.counterInput,"");
    }

    /**
     *
     * Get name of the article in the single article page
     *
     * @return
     */
    public String getArticleName() {
        SelenideElement el = $(byCssSelector("h2.sc-gtsrHT.bDjPuH"));
//        System.out.println(el.getText().substring(el.getText().lastIndexOf("Name: ") + 6));
        return el.getText().substring(el.getText().lastIndexOf("Name: ") + 6);
    }

    /**
     *
     * Get name of the article in the cart (on the top right)
     *
     * @param str
     * @return
     */
    public boolean getArticleNameInCard(String str) {
//        List<String> items = new ArrayList<String>();
//        SelenideElement el = $(byCssSelector("h4.sc-hKFxyN.epoLLl"));
        ElementsCollection elements = $$("div.sc-hHEiqL.ccTnQh.sc-iJCRrE.bojiJp div div div h4");
//        System.out.println(elements.get(elements.size()-1).getText());
        System.out.println("elements size: " + elements.size());
        for (int i=0; i<elements.size(); i++) {
            System.out.println("element: " + elements.get(i).getText());
//            items.add(elements.get(i).getText());
            if (elements.get(i).getText().contains(str)) {
                return true;
            }
        }
//        System.out.println("items: " + items);
//        scrollOnItemInCard(elements.size()-1);
//        elements.get(elements.size()-1).shouldBe(Condition.visible);
//        return elements.get(elements.size()-1).getText();
        return false;
    }

    /**
     *
     * Get number of the articles in the cart
     *
     * @return
     */
    public int cartSize() {
        return Locators.articlesInCart.size();
    }

    /**
     * Open cart in the top right part of the page
     */
    public void openCart() {
        clickOn(Locators.warenkorbIcon);
    }

    public void hoverMenu(String menu, String submenu) throws InterruptedException {
        System.out.println("Tab Header: " + Locators.menuHeaderElements.size());
        for (int i=0; i<Locators.menuHeaderElements.size(); i++) {
//            System.out.println("Name of the tab: " + Locators.menuHeaderElements.get(i).getText());
            if (Locators.menuHeaderElements.get(i).getText().equals(menu)) {
                hover(Locators.menuHeaderElements.get(i));
                isDisplayed(Locators.subMenuElements.get(0));
//                System.out.println("Sub menus: " + Locators.subMenuElements.size());
                for (int j=0; j<Locators.subMenuElements.size(); j++) {
//                    System.out.println("Sub menus names: " + Locators.subMenuElements.get(j).getText());
                    if (Locators.subMenuElements.get(j).getText().equals(submenu)) {
//                        clickOnSubMenu(submenu, Locators.subMenuElements.get(j));
                        clickOn(Locators.subMenuElements.get(j).find(By.cssSelector("a")));
                        Thread.sleep(5000);
                    }
                }
            }
        }
    }

    public void clickOnSubMenu(String groupName, SelenideElement el) {
        SelenideElement header = $(By.xpath("//p[contains(@class, 'sc-gtsrHT') and contains(@class, 'jNHpaB')]/a[contains(text(), '" + groupName + "')]"));
        clickOn(el);
        isDisplayed(header);
    }

    public void clickOnFilialFinder() {
        clickOn(Locators.filialFinder);
    }

    public void numberOfFilialen () {
        isDisplayed(Locators.filialenList.get(0));
        System.out.println("Number of filialen: " + Locators.filialenList.size());
    }

    public void filialeItemContainsImage() {
        containsImage(Locators.filialenList.get(0), "lazy-load-image", "https://s3.eu-central-1.amazonaws.com/uberall-userpics-prod/2838599/thumb_ad6bqf8p60.png");
        assertImage(Locators.filialenList.get(0).find(By.cssSelector("img")));
    }

    public void filialeSuggest(String searchtext) throws InterruptedException {
        sendKeys(Locators.geoSuggestInput, searchtext);
        System.out.println("Number of suggests start: " + Locators.geoSuggests.size());
        Thread.sleep(1000);
        System.out.println("Number of suggests after: " + Locators.geoSuggests.size());
        for (int i=0; i<Locators.geoSuggests.size(); i++) {
            System.out.println("Suggest text: " + Locators.geoSuggests.get(i).getText());
            assertStringContains(Locators.geoSuggests.get(i), searchtext);
        }
    }
}

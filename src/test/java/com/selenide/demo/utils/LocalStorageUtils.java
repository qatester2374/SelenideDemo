package com.selenide.demo.utils;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.json.JSONObject;
import org.testng.Assert;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class LocalStorageUtils {

    public void localStorageStores(String term, int index) {
        SelenideElement findStore = $(byXpath("//input[@placeholder='Find store']"));
        //    ElementsCollection stores = $$("div .kMuqUv");
        System.out.println(Configuration.browser);
        String cssSelector = "";
        if (Configuration.browser.equals("chrome")) {
            cssSelector = "div.sc-pNWdM.jJtBfs button.sc-ksluID.jeonAc";
        } else if (Configuration.browser.equals("safari")) {
            cssSelector = "div.sc-iCoGMd.ggWneT button.sc-dIsUp.kMuqUv";
        }
        ElementsCollection stores = $$(cssSelector);
        findStore.sendKeys(term); // Krefeld term
        findStore.pressEnter();
//        System.out.println("Stores size: " + stores.size());
        String item = stores.get(index).getText();
        System.out.println("Stores item: " + item);
        stores.get(index).click();
        System.out.println("LOCAL STORAGE: " + localStorage().getItem("site"));
        JSONObject jsonObject = new JSONObject(localStorage().getItem("site"));
        Assert.assertTrue(item.equals(jsonObject.getJSONObject("favoriteStore").get("name")));
    }
}

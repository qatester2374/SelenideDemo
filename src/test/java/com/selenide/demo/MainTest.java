package com.selenide.demo;

import com.codeborne.selenide.*;
import org.json.JSONObject;
import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.io.InputStream;
import java.net.CookieStore;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class MainTest {

    SelenideElement damenTab = $(byXpath("//a[contains(text(), 'Damen')]"));
    SelenideElement searchInput = $(byXpath("//input[@placeholder='Search products']"));
    SelenideElement allMenu = $(byXpath("//button[contains(text(), 'All menu')]"));
    SelenideElement radSport = $(byXpath("//a[contains(text(), 'Radsport')]"));
    SelenideElement span = $(byXpath("//span[contains(text(), 'Radsport')]"));
    ElementsCollection searchResultsGrid = $$("div.heluOB div.hngzF");
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
    SelenideElement filiale = $(byXpath("//span[contains(text(), 'Filiale')]"));
    SelenideElement andern = $(byXpath("//button[contains(text(), 'ndern')]"));
    SelenideElement findStore = $(byXpath("//input[@placeholder='Find store']"));
    //    ElementsCollection stores = $$("div .kMuqUv");
    ElementsCollection stores = $$("div .kMuqUv .gFlvGi");
    SelenideElement closeFiliale = $(byXpath("//html/body/div[2]"));
    SelenideElement sport = $(byXpath("//a[contains(text(), 'Sport')]"));
    SelenideElement addToCart = $(byXpath("//button[contains(text(), 'Add to cart')]"));
    ElementsCollection numOfProductInCard = $$("table.CartSummaryTable__StyledTable-sc-1nljcub-0 tr:nth-child(1) td");
    ElementsCollection deleteFromcard = $$("button.kpPvTx");
    ElementsCollection warenkorbIcon = $$("button.sc-dIsUp.kMuqUv");
    ElementsCollection warenkorbButton = $$("a.gfuSqG button.ilcNEp");

    // registration
    SelenideElement name = $(byId("jform_name"));
    SelenideElement username = $(byId("jform_username"));
    SelenideElement password = $(byId("jform_password1"));
    SelenideElement confirmPassword = $(byId("jform_password2"));
    SelenideElement email = $(byId("jform_email1"));
    SelenideElement confirmEmail = $(byId("jform_email2"));
    SelenideElement registerSubmit = $(byXpath("//button[contains(text(), 'Register')]"));

    // login
    SelenideElement usernameLogin = $(byId("username"));
    SelenideElement passwordLogin = $(byId("password"));
    SelenideElement loginSubmit = $(byXpath("//button[contains(text(), 'Log in')]"));

    // upload
    SelenideElement galleryViewForImage = $(byXpath("//h3[contains(text(), 'Gallery View for Images')]"));
    SelenideElement fineUploaderGalleryArea = $(byId("fine-uploader-gallery"));
    SelenideElement inputUpload = $(byXpath("//*[@id=\"fine-uploader-gallery\"]/div/div[3]/input"));

    SelenideElement manualTriggerUploads = $(byXpath("//h3[contains(text(), 'Manually Trigger Uploads')]"));
    SelenideElement selectFiles = $(byXpath("//*[@id=\"fine-uploader-manual-trigger\"]/div/div[3]/div/input"));
    SelenideElement triggerUpload = $(byId("trigger-upload"));

    // prompt
    SelenideElement prompt = $(byName("prompt"));

    // Flickr
    SelenideElement flickrLogin = $(byXpath("//*[@id=\"yui_3_16_0_1_1627041923177_152\"]/div/div[3]/div/ul[2]/li[2]/a"));
    SelenideElement flickrEmail = $(byXpath("/html/body/div/div/div[2]/div/div[1]/div[2]/span/div/div/p"));

    public SelenideElement searchElementContainsText(String str) {
        SelenideElement element = $(byXpath("//img[contains(@alt,'" + str + "')]"));
        return element;
    }

    public Integer countElements(String id) throws InterruptedException {
        Thread.sleep(2000);
        ElementsCollection myElementList = $$("#" + id);
        return myElementList.size();
//        if (myElementList.size() > 0) {
//            click(mobileElement);
//        }
    }

    @BeforeTest
    void beforeTest() {
//        Configuration.browser = "Safari";
//        open("https://www.galeria.de/");
//        Configuration.headless = true;
    }

    @Test
    void todoGaleria() throws InterruptedException {
        /************
         * Open page
         ************/
        open("https://galeria.stage.galeria.bestbytes.net/", "", "demo", "dfLr8dY7e7ZJJmtqwAJtVQZiGHNiUZ9gNssMjK4rHTFFaTeUd6");
        open("https://galeria.stage.galeria.bestbytes.net/");
//        Thread.sleep(2000);
        /************
         * Hover over Damen tab
         ************/
//        $(damenTab).shouldBe(Condition.visible);
        damenTab.hover();
//        Thread.sleep(1000);

        /************
         * Click on the Allmenu button
         ************/
        $(allMenu).shouldBe(Condition.visible);
        allMenu.click();
        /************
         * Scroll to radSport link
         ************/
        $(radSport).scrollIntoView(true).shouldBe(Condition.visible).click();
        Thread.sleep(15000);
        $(span).shouldBe(Condition.visible);
        /************
         * Confirm that number of search items is greater than 0
         ************/
        $(searchResultsGrid.get(0)).shouldBe(Condition.visible);
        System.out.println(searchResultsGrid.size());
        Assert.assertTrue(searchResultsGrid.size() > 0);

        /************
         * Scroll to the search results
         ************/
        $(searchResultsGrid.get(0)).scrollIntoView(true);
        /************
         * Hover over first item in search results
         ************/
        searchResultsGrid.get(0).hover();
        Thread.sleep(1000);
        $(withText("more items available")).shouldBe(Condition.visible);
        /************
         * Hover over second item in search results
         ************/
        searchResultsGrid.get(1).hover();
        $(withText("more items available")).shouldBe(Condition.visible);
        /************
         * Click on the first item in search results
         ************/
        searchResultsGrid.get(0).click();
        Thread.sleep(1000);
        /************
         * Click on the labels for selection
         ************/
        System.out.println("labels: " + labelsArticle.size());
        for (int i = 0; i < labelsArticle.size(); i++) {
            labelsArticle.get(i).click();
            Assert.assertTrue(labelsArticle.get(i).getText().contains("label for"));
        }
        /************
         * Quantity input
         ************/
        quantityPlus.click();
        quantityPlus.click();
        quantityMinus.click();
        quantityPlus.click();
        counterInput.sendKeys("-200");
        counterInput.clear();
        counterInput.sendKeys("23");

        Thread.sleep(1000);

        /************
         * Hover over images on the left side of the page
         ************/
        System.out.println("images: " + imagesGrid.size());

        for (int i = 0; i < imagesGrid.size(); i++) {
            imagesGrid.get(i).hover();
        }

        Thread.sleep(3000);

        System.out.println(searchResultItems.size());

        Set<Cookie> seleniumCookieSet = WebDriverRunner.getWebDriver().manage().getCookies();
        Assert.assertTrue(seleniumCookieSet.isEmpty());
        addToCart.click();
        $(withText("Warenkorb")).shouldBe(Condition.visible);
        $(withText("1")).shouldBe(Condition.visible);
        System.out.println("Number of delete buttons: " + deleteFromcard.size());
        Thread.sleep(5000);

        Assert.assertTrue(!seleniumCookieSet.equals(null));
        for(Cookie cookie: seleniumCookieSet) {
            System.out.println("Cookie: " + cookie);
        }
        System.out.println("Num of products: " + numOfProductInCard.size());
        System.out.println("Text cart 1: " + numOfProductInCard.get(0).getText());
        System.out.println("Text cart 2: " + numOfProductInCard.get(1).getText());
        Assert.assertTrue(Integer.valueOf(numOfProductInCard.get(1).getText()).equals(1));

        /************
         * Zoom in zoom out page
         ************/
        zoom(2.0);
        Thread.sleep(1000);
        zoom(0.1);
        Thread.sleep(1000);
        zoom(1.0);
        Thread.sleep(1000);

        /************
         * Click on the link Filiale top left
         ************/
        filiale.click();

        /************
         * Type term in thesearch input and validate that localStorage item is created
         ************/
        localStorageAssert("Berlin");

        /************
         * Validate that link for edit search is displayed, and click on it
         ************/
        andern.shouldBe(Condition.visible);
        andern.click();

        /************
         * Type new term in the search input and validate that localStorage item is created
         ************/
        localStorageAssert("Krefeld");

        /************
         * Clear localStorage
         ************/
        localStorage().clear();

        /************
         * Close Filiale left panel
         ************/
        closeFiliale.shouldBe(Condition.visible).click();
        /************
         * Refresh page
         ************/
        refresh();
        /************
         * Validate that localStorage item does not exists
         ************/
        Assert.assertEquals(localStorage().getItem("site"), null);

        /************
         * Click on Sport tab
         ************/
        sport.click();
        $(withText("Outdoor & Wandern")).shouldBe(Condition.visible);
        $(withText("Darts")).shouldBe(Condition.visible);

        for(Cookie cookie: seleniumCookieSet) {
            if (cookie.getName().equals("cart")) {
                WebDriverRunner.getWebDriver().manage().deleteCookie(cookie);
            }
        }
        refresh();
        warenkorbIcon.get(2).click();
        warenkorbButton.get(0).click();
        $(withText("Warenkorb")).shouldBe(Condition.visible);
        $(withText("0")).shouldBe(Condition.visible);

        Thread.sleep(4000);
    }

    void localStorageAssert(String term) {
        findStore.sendKeys(term); // Krefeld term
        findStore.pressEnter();
        String firstItem = stores.get(0).getText();
        System.out.println("Stores 1st item: " + firstItem);
        stores.get(0).click();
        System.out.println("LOCAL STORAGE1: " + localStorage().getItem("site"));
        JSONObject jsonObject1 = new JSONObject(localStorage().getItem("site"));
        Assert.assertTrue(firstItem.equals(jsonObject1.getJSONObject("favoriteStore").get("name")));
    }

    @Test
    void register() throws InterruptedException {
        open("http://demo.t3-framework.org/joomla30/index.php/en/joomla-pages/sample-page-2/registration-form");
        name.sendKeys("User");
        username.sendKeys("user");
        password.sendKeys("12345");
        confirmPassword.sendKeys("1234");
        email.sendKeys("hilimi6347@herrain.com");
        confirmEmail.sendKeys("hilimi6347@herrain.com");
        registerSubmit.click();
        Thread.sleep(3000);
    }

    @Test
    void login() throws InterruptedException {
        open("http://demo.t3-framework.org/joomla30/index.php/en/joomla-pages/sample-page-2/login-page");
        usernameLogin.sendKeys("user");
        passwordLogin.sendKeys("12345");
        loginSubmit.click();
        Thread.sleep(3000);
    }

    void downloadImageFromExternalURL(String imageName) throws IOException {
        InputStream inputStream = new URL("https://upload.wikimedia.org/wikipedia/commons/4/42/Shaqi_jrvej.jpg").openStream();
        Files.copy(inputStream, Paths.get(System.getProperty("user.dir") + imageName), StandardCopyOption.REPLACE_EXISTING);
    }

    void uploadImageFromStorage(String imageName) {
        inputUpload.sendKeys(System.getProperty("user.dir") + imageName);
    }

    void selectAndUploadImageFromStorage(String imageName) {
        selectFiles.sendKeys(System.getProperty("user.dir") + imageName);
    }

    @Test
    void uploadImage() throws InterruptedException, IOException {
        open("https://fineuploader.com/demos.html");
        galleryViewForImage.scrollTo();
        downloadImageFromExternalURL("/Shaqi_jrvej.jpg");
        uploadImageFromStorage("/Shaqi_jrvej.jpg");
        Thread.sleep(1000);
        manualTriggerUploads.scrollTo();
        selectAndUploadImageFromStorage("/Shaqi_jrvej.jpg");
        triggerUpload.click();
        Thread.sleep(1000);
    }

    @Test
    void sendEmail() {
        String to = "jovica.raicki@gmail.com";
        String from = "qatester2374@gmail.com";
        String host = "smtp.gmail.com";
        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("qatester2374@gmail.com", "qT123$a(");

            }

        });

        session.setDebug(true);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("This is the Subject Line!");

            // Now set the actual message
            message.setText("This is actual message");

            System.out.println("sending...");
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }

    @Test
    void testGallery() throws InterruptedException {
        open("https://www.flickr.com");
//        flickrLogin.click();
//        flickrEmail.sendKeys();
//        Thread.sleep(3000);
    }

}

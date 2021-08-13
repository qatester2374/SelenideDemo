package com.selenide.demo.base;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.*;

import java.text.ParseException;

import static com.codeborne.selenide.Selenide.*;

public abstract class TestBase {

    @BeforeTest
    @Parameters(value = {"Environment"})
    public void config(String environment){
        Configuration.timeout = 60000;
        Configuration.browser = environment;
        Configuration.fastSetValue = true;
    }

    @BeforeMethod
    public void init() throws ParseException {
//        open("https://galeria.stage.galeria.bestbytes.net/catalogue-frontend/details?id=4012436233156");
        open("https://galeria.stage.galeria.bestbytes.net/", "", "demo", "dfLr8dY7e7ZJJmtqwAJtVQZiGHNiUZ9gNssMjK4rHTFFaTeUd6");
        open("https://galeria.stage.galeria.bestbytes.net/");
//        Cookie ck = new Cookie("profile", "eyJhbGciOiJSUzI1NiIsImtpZCI6IjYwYTkwM2UzZTRmYzdhNmM1NzZlYWQwZGU0YmI1MGRiIiwidHlwIjoiSldUIn0.eyJpYXQiOjE2Mjc5ODE0MTEsIm5iZiI6MTYyNzk4MTQxMSwib2JqIjp7InNpZCI6IjcxNTg1ZWVjLTdkZjctNDg5Mi05NjAxLWE4OTJjOTY2MmFlYiIsInRpZCI6IiJ9fQ.OcyUpeDNtKxGPo8x-DW7QSrLZw-dRRU9549a-YaFuRGPvY5JU9v4R9O1I5HzbgbHyCd56rkdRAq59bSf_ridfV1EXk7nK_LwUOo--jmsbkahiSlcExWkrVvX4SR6FH9tc1s_2cpRzgE9ZbGuDzQ1C1iW1N0UQLTbYRyMVG4QgCkNLSEcM16OqdoSA1Q4oV8_7rK7DD8o3qOW0TaqTHZ9xS72E2UjlsQrgH-gReEh8AaluT4NJkWaLXqdMplHuXDC7GBJBtwCzdh0xQRyZ60dUBXx_RIjJKorOEryPVs5yMYwTT_805xkzarIxyy2cXqfXPAzcW7bCIiAUW_nSohzsQ");
//        Cookie cookie = new Cookie.Builder("profile", "eyJhbGciOiJSUzI1NiIsImtpZCI6IjYwYTkwM2UzZTRmYzdhNmM1NzZlYWQwZGU0YmI1MGRiIiwidHlwIjoiSldUIn0.eyJpYXQiOjE2Mjc5ODE0MTEsIm5iZiI6MTYyNzk4MTQxMSwib2JqIjp7InNpZCI6IjcxNTg1ZWVjLTdkZjctNDg5Mi05NjAxLWE4OTJjOTY2MmFlYiIsInRpZCI6IiJ9fQ.OcyUpeDNtKxGPo8x-DW7QSrLZw-dRRU9549a-YaFuRGPvY5JU9v4R9O1I5HzbgbHyCd56rkdRAq59bSf_ridfV1EXk7nK_LwUOo--jmsbkahiSlcExWkrVvX4SR6FH9tc1s_2cpRzgE9ZbGuDzQ1C1iW1N0UQLTbYRyMVG4QgCkNLSEcM16OqdoSA1Q4oV8_7rK7DD8o3qOW0TaqTHZ9xS72E2UjlsQrgH-gReEh8AaluT4NJkWaLXqdMplHuXDC7GBJBtwCzdh0xQRyZ60dUBXx_RIjJKorOEryPVs5yMYwTT_805xkzarIxyy2cXqfXPAzcW7bCIiAUW_nSohzsQ").domain("https://galeria.stage.galeria.bestbytes.net/").build();
//        Date dt = new Date();
//        Calendar c = Calendar.getInstance();
//        c.setTime(dt);
//        c.add(Calendar.DATE, 1);
//        dt = c.getTime();
//        System.out.println("DATE: " + dt);
//        Cookie cook = new Cookie("profile",
//                "eyJhbGciOiJSUzI1NiIsImtpZCI6IjYwYTkwM2UzZTRmYzdhNmM1NzZlYWQwZGU0YmI1MGRiIiwidHlwIjoiSldUIn0.eyJpYXQiOjE2Mjc5ODE0MTEsIm5iZiI6MTYyNzk4MTQxMSwib2JqIjp7InNpZCI6IjcxNTg1ZWVjLTdkZjctNDg5Mi05NjAxLWE4OTJjOTY2MmFlYiIsInRpZCI6IiJ9fQ.OcyUpeDNtKxGPo8x-DW7QSrLZw-dRRU9549a-YaFuRGPvY5JU9v4R9O1I5HzbgbHyCd56rkdRAq59bSf_ridfV1EXk7nK_LwUOo--jmsbkahiSlcExWkrVvX4SR6FH9tc1s_2cpRzgE9ZbGuDzQ1C1iW1N0UQLTbYRyMVG4QgCkNLSEcM16OqdoSA1Q4oV8_7rK7DD8o3qOW0TaqTHZ9xS72E2UjlsQrgH-gReEh8AaluT4NJkWaLXqdMplHuXDC7GBJBtwCzdh0xQRyZ60dUBXx_RIjJKorOEryPVs5yMYwTT_805xkzarIxyy2cXqfXPAzcW7bCIiAUW_nSohzsQ",
//                ".galeria.stage.galeria.bestbytes.net",
//                "/",
//                dt,
//                true,
//                true);
//        WebDriverRunner.getWebDriver().manage().addCookie(cook);
    }

    @AfterMethod
    public void close() {
        closeWindow();
    }

    @AfterTest
    public void tearDown() {
        closeWebDriver();
    }
}

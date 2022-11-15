package org.example;

import com.thoughtworks.gauge.Step;
import org.example.base.BaseMethods;
import org.example.base.BaseTest;
import org.example.pages.ProductPage;
import org.example.pages.StartPage;
import org.junit.Assert;
import org.openqa.selenium.By;

public class StepImplementation extends BaseTest {

    BaseMethods baseMethods = new BaseMethods();
    ProductPage productPage = new ProductPage();
    StartPage startPage= new StartPage();



    @Step("Uygulama acildiginda cookie'ler icin izin verilir")
    public void acceptCookie() throws InterruptedException {
        baseMethods.waitBySecond(15);
        startPage.cookiesAccept();
        logger.info("uygulama acildiginda cerezlere izin verildi");
    }

    @Step("Uygulamanın acildigi kontrol edilir.")
    public void appControl() throws InterruptedException {
        baseMethods.waitBySecond(2);
        ProductPage.isAppOpen("Check-in");
        baseMethods.waitBySecond(2);
        logger.info("uygulamanin acildigi kontrol edildi");
    }

    @Step("Bilet al butonu tiklanir")
    public void booking() throws InterruptedException {
        baseMethods.waitBySecond(2);
        startPage.clickBooking();
        logger.info("bilet al butonuna tiklandi");
    }

    @Step("Seyehat tipi olarak “one way” secilir.")
    public void oneWayTravel() throws InterruptedException {
        baseMethods.waitBySecond(2);
        baseMethods.clickElementById("com.turkishairlines.mobile:id/frDashboard_tvOneWay");
        baseMethods.waitBySecond(5);
        logger.info("seyahat tipi tek yon olarak secildi ");
    }

    @Step("Kalkis havaalanı olarak Berlin secilir.")
    public void departureAirport() throws InterruptedException {
        baseMethods.waitBySecond(1);
        baseMethods.clickElementById("com.turkishairlines.mobile:id/frDashboard_tvFromCode");
        baseMethods.waitBySecond(1);
        baseMethods.clickElementById("com.turkishairlines.mobile:id/frAirportSelection_etSearch");
        baseMethods.sendKeyElementById("com.turkishairlines.mobile:id/frAirportSelection_etSearch","berlin");
        baseMethods.waitBySecond(1);
        baseMethods.clickElementById("com.turkishairlines.mobile:id/itemAirport_tvBottom"); //berlin icin
        baseMethods.waitBySecond(1);
        logger.info("kalkis havaalani berlin olarak secildi");
    }

    @Step("Varis havaalani olarak istanbul secilir.")
    public void destinationAirport() throws InterruptedException {
        baseMethods.waitBySecond(1);
        baseMethods.clickElementById("com.turkishairlines.mobile:id/frDashboard_tvToCode");
        baseMethods.waitBySecond(1);
        baseMethods.clickElementById("com.turkishairlines.mobile:id/frAirportSelection_etSearch");
        baseMethods.sendKeyElementById("com.turkishairlines.mobile:id/frAirportSelection_etSearch","istanbul");
        baseMethods.waitBySecond(1);
        baseMethods.clickElementByXpath("(//*[@resource-id=\"com.turkishairlines.mobile:id/itemAirport_tvBottom\"])[2]"); //istanbul icin
        baseMethods.waitBySecond(1);
        logger.info("varis havaalani istanbul olarak secildi");
    }

    @Step("Bugunun tarihine +7 olacak sekilde bir gidis tarihi secilir")
    public void selectDate() throws InterruptedException {

        int nextDate;
        baseMethods.clickElementById("com.turkishairlines.mobile:id/dateWidget_tvDateDay");
        nextDate = Integer.parseInt(appiumDriver.findElement(By.id("com.turkishairlines.mobile:id/dateWidget_tvDateDay")).getText()) + 7;
        String date = "//*[@text = " + "'" + nextDate + "'" + "]";
        baseMethods.clickElementByXpath(date);
        baseMethods.clickElementById("com.turkishairlines.mobile:id/frDashboard_btnDone");
        logger.info("tarih icin bir hafta sonrasi secildi");
    }

    @Step("Arama butonuna tıklanir")
    public void clickSearchButton(){
        baseMethods.clickElementById("com.turkishairlines.mobile:id/frDashboard_btnSearch");
        logger.info("arama butonuna tiklandi");
    }

    @Step("Ucus ekraninin geldigi kontrol edilir")
    public void controlFlightScreen() throws InterruptedException {

        baseMethods.waitBySecond(3);
        //appiumDriver.findElement(By.id("com.turkishairlines.mobile:id/itemFlightSearchParent_rlRoot")).isDisplayed();
        Boolean check= appiumDriver.findElement(By.id("com.turkishairlines.mobile:id/itemFlightSearchParent_rlRoot")).isDisplayed();
        Assert.assertTrue(check);
        logger.info("ucus ekraninin geldigi kontrol edildi");
    }

    @Step("Rastgele bir ucus secilir.")
    public void chooseRandomFlight() throws InterruptedException {
        baseMethods.waitBySecond(3);
        productPage.chooseRandomElement(By.id("com.turkishairlines.mobile:id/itemFlightSearchParent_llFlightDirectionView"));
        logger.info("rastgele ucus secildi");
    }

    @Step("Economy class secilir")
    public void chooseEconomyClass() throws InterruptedException {
        baseMethods.waitBySecond(2);
        baseMethods.clickElementByXpath("(//*[@resource-id=\"com.turkishairlines.mobile:id/brandItem\"])[1]");
        logger.info("ekonomi sinifi secildi");
    }

    @Step("Devam butonuna tiklanir")
    public void continueButton() throws InterruptedException {
        baseMethods.waitBySecond(2);
        baseMethods.clickElementById("com.turkishairlines.mobile:id/frFlightSearch_btnContinue");
        logger.info("devam butonu tiklandi");
    }

    @Step("EcoFly'da kal butonuna tiklanir")
    public void stayEcoFly() throws InterruptedException {
        baseMethods.waitBySecond(2);
        baseMethods.clickElementById("com.turkishairlines.mobile:id/bsEcoExtra_btnNegative");
        logger.info("ekonomi sinifinda kal butonu tiklandi");
    }




}

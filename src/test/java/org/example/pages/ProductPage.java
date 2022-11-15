package org.example.pages;

import io.appium.java_client.MobileElement;
import org.apache.logging.log4j.Logger;
import org.example.base.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Random;

public class ProductPage extends BaseTest {

    public static void isAppOpen(String text){
        String element = appiumDriver.findElement(By.id("com.turkishairlines.mobile:id/acMain_btnCheckin")).getText();
        Assert.assertTrue("Check-in yazisi gorundu",element.equals(text));

    }


    public void chooseRandomElement(By by){
        List<MobileElement> elements = appiumDriver.findElements(by);
        System.out.println("Total elements : " + elements.size());
        Random rand = new Random();
        int index = rand.nextInt(elements.size()-1);
        System.out.println("index= " + index);
        elements.get(index).click();
    }


}

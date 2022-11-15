package org.example.pages;

import org.example.base.BaseMethods;
import org.example.base.BaseTest;

public class StartPage extends BaseTest {

    BaseMethods baseMethods = new BaseMethods();

    public void cookiesAccept() throws InterruptedException {
        baseMethods.waitBySecond(4);
        baseMethods.clickElementById("com.turkishairlines.mobile:id/frPrivacy_btnAccept");
        baseMethods.waitBySecond(2);
    }

    public void clickBooking() throws InterruptedException {
        baseMethods.clickElementById("com.turkishairlines.mobile:id/acMain_btnBooking");
        baseMethods.waitBySecond(2);
    }


}

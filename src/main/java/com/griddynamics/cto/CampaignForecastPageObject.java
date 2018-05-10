package com.griddynamics.cto;

import com.codeborne.selenide.SelenideElement;

public class CampaignForecastPageObject extends PageObject {

    final static String SELECTOR_SLIDE = ".mat-slide-toggle";

    SelenideElement toggleBar = root.$(SELECTOR_SLIDE);

    public CampaignForecastPageObject(SelenideElement root) {
        super(root);
    }

    public void toggleCampaign() {
        toggleBar.click();
    }

}

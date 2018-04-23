package com.griddynamics.cto;

import com.codeborne.selenide.SelenideElement;

public class PredictionPageObject extends PageObject{
    public PredictionPageObject(SelenideElement root) {
        super(root);
    }

    final static String SELECTOR_CAMPAIGN_NAME = ".at-campaign-name";
    final static String SELECTOR_START_DATE = ".at-campaign-start-date";
    final static String SELECTOR_END_DATE = ".at-campaign-end-date";

    public String getCampaignName(){
        return root.$(SELECTOR_CAMPAIGN_NAME).getText();
    }

    public String getCampaignStartDate(){
        return root.$(SELECTOR_CAMPAIGN_NAME).getText();
    }

    public String getCampaignEndDate(){
        return root.$(SELECTOR_CAMPAIGN_NAME).getText();
    }

}

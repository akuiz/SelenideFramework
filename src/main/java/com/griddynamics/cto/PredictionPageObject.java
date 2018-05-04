package com.griddynamics.cto;

import com.codeborne.selenide.SelenideElement;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class PredictionPageObject extends PageObject{
    public PredictionPageObject(SelenideElement root) {
        super(root);
    }

    final static String SELECTOR_CAMPAIGN_NAME = ".at-campaign-name";
    final static String SELECTOR_START_DATE = ".at-campaign-start-date";
    final static String SELECTOR_END_DATE = ".at-campaign-end-date";

    final static String SELECTOR_PROFITS = ".mat-column-profit";
    final static String SELECTOR_QUANTITIES = ".mat-column-quantity";

    SelenideElement profitBaseLine = root.$$(SELECTOR_PROFITS).get(0);
    SelenideElement profitPrediction = root.$$(SELECTOR_PROFITS).get(1);
    SelenideElement quantityBaseLine = root.$$(SELECTOR_QUANTITIES).get(0);
    SelenideElement quantityPrediction = root.$$(SELECTOR_QUANTITIES).get(1);

    public String getCampaignName(){
        return root.$(SELECTOR_CAMPAIGN_NAME).getText();
    }

    public String getCampaignStartDate(){
        return root.$(SELECTOR_CAMPAIGN_NAME).getText();
    }

    public String getCampaignEndDate(){
        return root.$(SELECTOR_CAMPAIGN_NAME).getText();
    }

    public void checkBaseLine(int profit, int quantity) {
        assertThat(profitBaseLine.getText()).isEqualTo(profit);
        assertThat(quantityBaseLine.getText()).isEqualTo(quantity);
    }

    public void checkCampaignPrediction(int profit, int quantity) {
        assertThat(profitPrediction.getText()).isEqualTo(profit);
        assertThat(quantityPrediction.getText()).isEqualTo(quantity);
    }
}

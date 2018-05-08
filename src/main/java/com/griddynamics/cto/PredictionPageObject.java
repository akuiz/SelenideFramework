package com.griddynamics.cto;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.not;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static org.assertj.core.api.Java6Assertions.assertThat;

public class PredictionPageObject extends PageObject {
    public PredictionPageObject(SelenideElement root) {
        super(root);
    }

    final static String SELECTOR_CAMPAIGN_NAME = ".name__input";
    final static String SELECTOR_START_DATE = ".start-date__input";
    final static String SELECTOR_END_DATE = ".end-date__input";

    final static String SELECTOR_PROFITS = ".mat-column-profit";
    final static String SELECTOR_QUANTITIES = ".mat-column-quantity";

    final static String SELECTOR_REVENUE = ".revenue";
    final static String SELECTOR_PROFIT = ".profit";
    final static String SELECTOR_QUANTITY = ".quantity";

    SelenideElement revenueBaseline = root.$$(SELECTOR_REVENUE).first();
    SelenideElement revenuePrediction = root.$$(SELECTOR_REVENUE).last();
    SelenideElement profitBaseline = root.$$(SELECTOR_PROFIT).first();
    SelenideElement profitPrediction = root.$$(SELECTOR_PROFIT).last();
    SelenideElement quantityBaseline = root.$$(SELECTOR_QUANTITY).first();
    SelenideElement quantityPrediction = root.$$(SELECTOR_QUANTITY).last();

    public String getCampaignName() {
        return root.$(SELECTOR_CAMPAIGN_NAME).getValue();
    }

    public String getCampaignStartDate() {
        return root.$(SELECTOR_START_DATE).getValue();
    }

    public String getCampaignEndDate() {
        return root.$(SELECTOR_END_DATE).getValue();
    }

    public void checkCampaignPrediction(int profit, int quantity) {
        assertThat(profitPrediction.getText()).isEqualTo(profit);
        assertThat(quantityPrediction.getText()).isEqualTo(quantity);
    }

    public void checkRevenue(String expectedBaseLine, String expectedPrediction) {
        revenueBaseline.waitUntil(visible, timeout);
        assertThat(revenueBaseline.getText()).isEqualTo(expectedBaseLine);
        assertThat(revenuePrediction.getText()).isEqualTo(expectedPrediction);
    }

    public void checkProfit(String expectedBaseLine, String expectedPrediction) {
        assertThat(profitBaseline.getText()).isEqualTo(expectedBaseLine);
        assertThat(profitPrediction.getText()).isEqualTo(expectedPrediction);
    }

    public void checkQuantity(String expectedBaseLine, String expectedPrediction) {
        assertThat(quantityBaseline.getText()).isEqualTo(expectedBaseLine);
        assertThat(quantityPrediction.getText()).isEqualTo(expectedPrediction);
    }
}

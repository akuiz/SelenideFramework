package com.griddynamics.cto;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static org.assertj.core.api.Java6Assertions.assertThat;

public class CampaignsForecastPageObject extends PageObject {

    final static String SELECTOR_REVENUE = ".revenue";
    final static String SELECTOR_PROFIT = ".profit";
    final static String SELECTOR_QUANTITY = ".quantity";

    SelenideElement revenueBaseline = root.$$(SELECTOR_REVENUE).first();
    SelenideElement revenuePrediction = root.$$(SELECTOR_REVENUE).last();
    SelenideElement profitBaseline = root.$$(SELECTOR_PROFIT).first();
    SelenideElement profitPrediction = root.$$(SELECTOR_PROFIT).last();
    SelenideElement quantityBaseline = root.$$(SELECTOR_QUANTITY).first();
    SelenideElement quantityPrediction = root.$$(SELECTOR_QUANTITY).last();

    public CampaignsForecastPageObject(SelenideElement root) {
        super(root);
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

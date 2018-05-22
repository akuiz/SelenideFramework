package com.griddynamics.cto;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

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

    @Step("Make sure that revenue is equal to expected value")
    public void checkRevenue(String expectedBaseLine, String expectedPrediction) {
        revenueBaseline.waitUntil(visible, timeout);
        assertThat(revenueBaseline.getText()).as("Revenue baseline equals to %s", expectedBaseLine).isEqualTo(expectedBaseLine);
        assertThat(revenuePrediction.getText()).as("Revenue prediction equals %s", expectedPrediction).isEqualTo(expectedPrediction);
    }

    @Step("Make sure that profit is equal to expected value")
    public void checkProfit(String expectedBaseLine, String expectedPrediction) {
        assertThat(profitBaseline.getText()).as("Profit baseline equals to %s", expectedBaseLine).isEqualTo(expectedBaseLine);
        assertThat(profitPrediction.getText()).as("Profit prediction equals to %s", expectedPrediction).isEqualTo(expectedPrediction);
    }

    @Step("Make sure that quantity is equal to expected value")
    public void checkQuantity(String expectedBaseLine, String expectedPrediction) {
        assertThat(quantityBaseline.getText()).as("Quantity baseline equals to %s", expectedBaseLine).isEqualTo(expectedBaseLine);
        assertThat(quantityPrediction.getText()).as("Quantity prediction equals to %s", expectedPrediction).isEqualTo(expectedPrediction);
    }

}

package com.griddynamics.cto;

import com.codeborne.selenide.SelenideElement;
import com.griddynamics.cto.model.CampaignModel;
import com.griddynamics.cto.model.PredictionModel;

import static com.codeborne.selenide.Condition.not;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ForecastPageObject extends PageObject {

    public ForecastPageObject(SelenideElement root) {
        super(root);
    }

    final static String SELECTOR_BUILD_FORECAST = ".btn__title";
    final static String SELECTOR_FORDECAST_CHARTS = ".content__parts__right";
    final static String SELECTOR_LOADER_SPINNER = ".mat-progress-spinner";

    SelenideElement buildForecastButton = root.$(SELECTOR_BUILD_FORECAST);

    public void setCampaigns(CampaignModel... campaigns) {
        for (CampaignModel campaign : campaigns) {
            SelenideElement campaignElement = root.$(byText(campaign.getName())).scrollTo();
            campaignElement.scrollIntoView("{behavior: \"smooth\", block: \"center\", inline: \"center\"}");
            CampaignForecastPageObject campaignForecast = new CampaignForecastPageObject($(byText(campaign.getName())).parent().parent());
            campaignForecast.toggleCampaign();
        }
    }

    public void buildForeCast() {
        buildForecastButton.scrollIntoView(false).click();
        waitForLoader();
    }

    private void waitForLoader() {
        $(SELECTOR_LOADER_SPINNER).shouldBe(visible);
        $(SELECTOR_LOADER_SPINNER).waitUntil(not(visible), timeout);
    }

    public void checkPrediction(PredictionModel predictionModel) {
        PredictionPageObject predictionPart = new PredictionPageObject($(SELECTOR_FORDECAST_CHARTS));
        predictionPart.checkRevenue(predictionModel.getRevenue().getKey(), predictionModel.getRevenue().getValue());
        predictionPart.checkProfit(predictionModel.getProfit().getKey(), predictionModel.getProfit().getValue());
        predictionPart.checkQuantity(predictionModel.getQuantity().getKey(), predictionModel.getQuantity().getValue());
    }
}

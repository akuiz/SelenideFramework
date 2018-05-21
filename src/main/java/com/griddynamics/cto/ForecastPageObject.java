package com.griddynamics.cto;

import com.codeborne.selenide.SelenideElement;
import com.griddynamics.cto.model.CampaignModel;
import com.griddynamics.cto.model.PredictionModel;
import org.joda.time.DateTime;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.not;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ForecastPageObject extends PageObject {

    public ForecastPageObject(SelenideElement root) {
        super(root);
    }

    static final String SELECTOR_START_DATE = ".start-date__input";
    static final String SELECTOR_END_DATE = ".end-date__input";
    final static String SELECTOR_BUILD_FORECAST = ".btn__title";
    final static String SELECTOR_FORDECAST_CHARTS = ".content__parts__right";
    final static String SELECTOR_LOADER_SPINNER = ".mat-progress-spinner";

    static final String SELECTOR_DATE_PICKER = ".mat-datepicker-popup";

    SelenideElement startDateInput = root.$(SELECTOR_START_DATE);
    SelenideElement endDateInput = root.$(SELECTOR_END_DATE);

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
        buildForecastButton.shouldBe(enabled).scrollIntoView(false).click();
        waitForLoader();
    }

    public void checkForecast(PredictionModel predictionModel) {
        PredictionPageObject predictionPart = new PredictionPageObject($(SELECTOR_FORDECAST_CHARTS));
        predictionPart.checkRevenue(predictionModel.getRevenue().getKey(), predictionModel.getRevenue().getValue());
        predictionPart.checkProfit(predictionModel.getProfit().getKey(), predictionModel.getProfit().getValue());
        predictionPart.checkQuantity(predictionModel.getQuantity().getKey(), predictionModel.getQuantity().getValue());
    }

    public void setDates(DateTime startDate, DateTime endDate) {
        if(startDate.isBefore(formatter.parseDateTime("5/1/2018"))){
            setStartDate(startDate);
            setEndDate(endDate);
        }
        else{
            setEndDate(endDate);
            setStartDate(startDate);
        }
    }

    private void setStartDate(DateTime startDate) {
        startDateInput.scrollIntoView(false).click();
        DatePickerPageObject datePickerPageObject = new DatePickerPageObject($(SELECTOR_DATE_PICKER));
        datePickerPageObject.pickDate(startDate);
    }

    private void setEndDate(DateTime startDate) {
        endDateInput.scrollIntoView(false).click();
        DatePickerPageObject datePickerPageObject = new DatePickerPageObject($(SELECTOR_DATE_PICKER));
        datePickerPageObject.pickDate(startDate);
    }
}

package com.griddynamics.cto;

import com.codeborne.selenide.SelenideElement;
import com.griddynamics.cto.model.CampaignModel;
import com.griddynamics.cto.model.ForecastModel;
import com.griddynamics.cto.model.PredictionModel;
import io.qameta.allure.Step;
import org.joda.time.DateTime;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.disabled;
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
    final static String SELECTOR_START_DATE_INPUT = ".mat-progress-spinner";
    final static String SELECTOR_END_DATE_INPUT = ".mat-progress-spinner";

    static final String SELECTOR_DATE_PICKER = ".mat-datepicker-popup";

    SelenideElement startDateInput = root.$(SELECTOR_START_DATE);
    SelenideElement endDateInput = root.$(SELECTOR_END_DATE);

    SelenideElement buildForecastButton = root.$(SELECTOR_BUILD_FORECAST);

    @Step("Pick campaigns for the forecast")
    public void setCampaigns(CampaignModel... campaigns) {
        for (CampaignModel campaign : campaigns) {
            SelenideElement campaignElement = root.$(byText(campaign.getName())).scrollTo();
            campaignElement.scrollIntoView("{ block: \"center\", inline: \"center\"}");
            CampaignForecastPageObject campaignForecast = new CampaignForecastPageObject($(byText(campaign.getName())).parent().parent());
            campaignForecast.toggleCampaign();
        }
    }

    @Step("Press forecast button and wait for the result")
    public void buildForeCast() {
        buildForecastButton.shouldBe(enabled).scrollIntoView(false).click();
        waitForLoader();
    }

    @Step("Check values of the forecast")
    public void checkForecast(ForecastModel predictionModel) {
        PredictionPageObject predictionPart = new PredictionPageObject($(SELECTOR_FORDECAST_CHARTS));
        predictionPart.checkRevenue(predictionModel.getRevenue().getKey(), predictionModel.getRevenue().getValue());
        predictionPart.checkProfit(predictionModel.getProfit().getKey(), predictionModel.getProfit().getValue());
        predictionPart.checkQuantity(predictionModel.getQuantity().getKey(), predictionModel.getQuantity().getValue());
    }

    @Step("Set forecast dates")
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
        int defaultMonth =  Integer.valueOf($(SELECTOR_START_DATE_INPUT).getValue().split("/")[0]);
        startDateInput.scrollIntoView(false).click();
        DatePickerPageObject datePickerPageObject = new DatePickerPageObject($(SELECTOR_DATE_PICKER));
        datePickerPageObject.pickDate(startDate, defaultMonth);
    }

    private void setEndDate(DateTime endDate) {
        int defaultMonth =  Integer.valueOf($("SELECTOR_START_DATE_INPUT").getValue().split("/")[0]);
        endDateInput.scrollIntoView(false).click();
        DatePickerPageObject datePickerPageObject = new DatePickerPageObject($(SELECTOR_DATE_PICKER));
        datePickerPageObject.pickDate(endDate, defaultMonth);
    }

        @Step("Can't pick start date after end date and vice versa")
        public void checkForecastDatePicker() {
            startDateInput.click();
            DatePickerPageObject startDatePickerPageObject = new DatePickerPageObject($(SELECTOR_DATE_PICKER));
            startDatePickerPageObject.nextMonthButton.shouldBe(disabled);
            startDatePickerPageObject.pickCurrentMonthDay(2);
            endDateInput.click();
            DatePickerPageObject endDatePickerPageObject = new DatePickerPageObject($(SELECTOR_DATE_PICKER));
            endDatePickerPageObject.previousMonthButton.shouldBe(disabled);
            endDatePickerPageObject.impossibleToPickCurrentMonthDay(1);
            endDatePickerPageObject.pickCurrentMonthDay(29);
            startDateInput.click();
            startDatePickerPageObject = new DatePickerPageObject($(SELECTOR_DATE_PICKER));
            startDatePickerPageObject.impossibleToPickCurrentMonthDay(30);
        }
}

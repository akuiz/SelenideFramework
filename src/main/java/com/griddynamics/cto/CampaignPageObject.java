package com.griddynamics.cto;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.griddynamics.cto.model.DiscountModel;
import com.griddynamics.cto.model.CampaignModel;
import com.griddynamics.cto.model.PromotionModel;
import com.griddynamics.cto.model.PredictionModel;
import io.qameta.allure.Step;
import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static org.assertj.core.api.Java6Assertions.assertThat;

public class CampaignPageObject extends PageObject {

    static final String SELECTOR_CAMPAIGN_NAME = ".name-column__title";
    static final String SELECTOR_CAMPAIGN_START_DATE = ".start-column";
    static final String SELECTOR_CAMPAIGN_END_DATE = ".end-column";
    static final String SELECTOR_CAMPAIGN_ACTIONS = ".actions-column";
    static final String SELECTOR_CAMPAIGNS_DISCOUNTS = ".name-column__promos";
    static final String SELECTOR_SHOW_PREDITION = ".show-prediction-btn";

    static final String XPATH_CAMPAIGN_START_DATE = ".//input[@placeholder='Start Date']";
    static final String XPATH_CAMPAIGN_END_DATE = ".//input[@placeholder='End Date']";
    static final String XPATH_CAMPAIGN_NAME = ".//input[@placeholder='Campaign name']";

    final static String XPATH_LAST_OFFER = ".//mat-list/mat-list-item[last()]";
    final static String XPATH_OFFERS = ".//mat-list/mat-list-item";

    String SELECTOR_POP_UP = ".mat-dialog-container";

    static final String SELECTOR_OVERLAY_DATE_PICKER = ".cdk-overlay-backdrop";

    static final String SELECTOR_ADD_OFFER_BUTTON = ".add-offer-icon";

    ElementsCollection actions = root.$$(".mat-icon-button");

    SelenideElement predictionButton = root.$(SELECTOR_SHOW_PREDITION);

    ElementsCollection offerElements = root.$$(byXpath(XPATH_OFFERS));

    SelenideElement startDateField = root.$(SELECTOR_CAMPAIGN_START_DATE);
    SelenideElement endDateField = root.$(SELECTOR_CAMPAIGN_END_DATE);
    SelenideElement campaignNameField = root.$(SELECTOR_CAMPAIGN_NAME);

    public CampaignPageObject(SelenideElement root) {
        super(root);
    }

    public String getOfferName(int n) {
        return getOffer(n).getName();
    }

    public OfferPageObject getOffer(int n) {
        return new OfferPageObject(offerElements.get(n));
    }

    public String getOfferValue(int n) {
        return getOffer(n).getValue();
    }

    public String getOfferRule(int n) {
        return getOffer(n).getRule();
    }

    public CampaignModel getCampaignModel() {
        ArrayList<PromotionModel> campaingOffers = getOffersFromCampaign();
        CampaignModel campaign = new CampaignModel().toBuilder()
                .name(getName())
                .endDate(getEndDate())
                .startDate(getStartDate())
                .discounts(getDiscounts())
                .build();
        return campaign;
    }

    public ArrayList<PromotionModel> getOffersFromCampaign() {
        ArrayList<PromotionModel> offers = new ArrayList<PromotionModel>();
        for (int offerNumber = 0; offerNumber < offerElements.size(); offerNumber++) {
            offers.add(new PromotionModel().toBuilder()
                    .name(getOfferName(offerNumber))
                    .value(getOfferValue(offerNumber))
                    .build());
        }
        return offers;
    }

    public String getName() {
        return campaignNameField.getText();
    }

    public DateTime getStartDate() {
        return formatter.parseDateTime((startDateField.getText()));
    }

    public DateTime getEndDate() {
        return formatter.parseDateTime((endDateField.getText()));
    }

    public void expand() {
        root.$(SELECTOR_CAMPAIGN_NAME).click();
    }

    public ArrayList<DiscountModel> getDiscounts() {
        List<String> discountNames = root.$(SELECTOR_CAMPAIGNS_DISCOUNTS).$$("div").texts();
        ArrayList<DiscountModel> discounts = new ArrayList<>();
        for (int i = 0; i < discountNames.size() - 1; i++) {
            discounts.add(DiscountModel.builder().
                    name(discountNames.get(i)).
                    build());
        }
        return discounts;
    }

    public void delete() {
        actions.last().click();
        $(byXpath("//span[contains(text(),'REMOVE')]")).click();
    }

    public void duplicateCampaign() {
        actions.get(1).click();
        DuplicatePromotionPageObject duplicatePromotionWindow = new DuplicatePromotionPageObject($(SELECTOR_POP_UP));
        duplicatePromotionWindow.duplicatePromotion();
    }

    public void editCampaign(CampaignModel campaignModel) {
        actions.first().click();
        EditCampaignPageObject editCampaignWindow = new EditCampaignPageObject($(SELECTOR_POP_UP));
        editCampaignWindow.setValues(campaignModel);
    }

    public void changeCampaignName(String name) {
        actions.first().click();
        EditCampaignPageObject editCampaignWindow = new EditCampaignPageObject($(SELECTOR_POP_UP));
        editCampaignWindow.changeName(name);
    }

    @Step("Check prediction of the campaign")
    public void checkPrediction(PredictionModel predictionModel) {
        this.expand();
        predictionButton.shouldBe(Condition.enabled).click();
        PredictionPageObject predictionWindow = new PredictionPageObject($(SELECTOR_POP_UP));
        assertThat(predictionWindow.getCampaignName()).isEqualTo(getName());
        assertThat(predictionWindow.getCampaignStartDate()).isEqualTo(getStartDate());
        assertThat(predictionWindow.getCampaignEndDate()).isEqualTo(getEndDate());
        predictionWindow.checkRevenue(predictionModel.getRevenue().getKey(), predictionModel.getRevenue().getValue());
        predictionWindow.checkProfit(predictionModel.getProfit().getKey(), predictionModel.getProfit().getValue());
        predictionWindow.checkQuantity(predictionModel.getQuantity().getKey(), predictionModel.getQuantity().getValue());
    }

    public void changeCampaignDates(DateTime startDate, DateTime endDate) {
        actions.first().click();
        EditCampaignPageObject editCampaignWindow = new EditCampaignPageObject($(SELECTOR_POP_UP));
        editCampaignWindow.changeDates(startDate, endDate);
    }

    public void changeCampaignDiscounts(ArrayList<DiscountModel> discounts) {
        actions.first().click();
        EditCampaignPageObject editCampaignWindow = new EditCampaignPageObject($(SELECTOR_POP_UP));
        editCampaignWindow.changeDiscounts(discounts);
    }
}

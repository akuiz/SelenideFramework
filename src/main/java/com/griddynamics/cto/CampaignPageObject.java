package com.griddynamics.cto;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.griddynamics.cto.models.DiscountModel;
import io.qameta.allure.Step;
import com.griddynamics.cto.models.CampaignModel;
import com.griddynamics.cto.models.OfferModel;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class CampaignPageObject extends PageObject {

    static final String SELECTOR_CAMPAIGN_NAME = ".name-column__title";
    static final String SELECTOR_CAMPAIGN_START_DATE = ".start-column";
    static final String SELECTOR_CAMPAIGN_END_DATE = ".end-column";
    static final String SELECTOR_CAMPAIGN_ACTIONS = ".actions-column";
    static final String SELECTOR_CAMPAIGNS_DISCOUNTS = ".name-column__promos";

    static final String XPATH_CAMPAIGN_START_DATE = ".//input[@placeholder='Start Date']";
    static final String XPATH_CAMPAIGN_END_DATE = ".//input[@placeholder='End Date']";
    static final String XPATH_CAMPAIGN_NAME = ".//input[@placeholder='Campaign name']";

    final static String XPATH_LAST_OFFER = ".//mat-list/mat-list-item[last()]";
    final static String XPATH_OFFERS = ".//mat-list/mat-list-item";

    String SELECTOR_DUPLICATE_CAMPAIGN = ".mat-dialog-container";

    static final String SELECTOR_OVERLAY_DATE_PICKER = ".cdk-overlay-backdrop";

    static final String SELECTOR_ADD_OFFER_BUTTON = ".add-offer-icon";

    ElementsCollection actions = root.$$(".mat-icon-button");

    SelenideElement lastOfferElement = root.$(byXpath(XPATH_LAST_OFFER));
    SelenideElement addOfferButton = root.$(SELECTOR_ADD_OFFER_BUTTON);

    ElementsCollection offerElements = root.$$(byXpath(XPATH_OFFERS));

    SelenideElement startDateField = root.$(SELECTOR_CAMPAIGN_NAME);
    SelenideElement endDateField = root.$(SELECTOR_CAMPAIGN_START_DATE);
    SelenideElement campaignNameField = root.$(SELECTOR_CAMPAIGN_END_DATE);

    public CampaignPageObject(SelenideElement root) {
        super(root);
    }

    public void setOffers(ArrayList<OfferModel> offerList) {
        for (int offerNumber = 0; offerNumber < offerList.size(); offerNumber++) {
            this.addOffer(offerList.get(offerNumber));
        }
    }

    @Step("Add offer to campaign")
    public void addOffer(OfferModel offer) {
        addOfferButton.scrollTo().click();
        OfferPageObject offerPageObject = new OfferPageObject(lastOfferElement);
        offerPageObject.setValues(offer);
    }

    public int getAmountOfOffers(){
        return offerElements.size();
    }

    public String getOfferName(int n){
        return getOffer(n).getName();
    }

    public OfferPageObject getOffer(int n){
        return  new OfferPageObject(offerElements.get(n));
    }

    public String getOfferValue(int n){
        return getOffer(n).getValue();

    }

    public String getOfferRule(int n){
        return getOffer(n).getRule();
    }


    public CampaignModel getCampaignModel() {
        ArrayList<OfferModel> campaingOffers = getOffersFromCampaign();
        CampaignModel campaign = new CampaignModel().toBuilder()
                .name(getName())
                .endDate(getEndDate())
                .startDate(getStartDate())
                .discounts(getDiscounts())
                .build();
        return campaign;
    }

    public ArrayList<OfferModel> getOffersFromCampaign() {
        ArrayList<OfferModel> offers = new ArrayList<OfferModel>();
        for (int offerNumber = 0; offerNumber <offerElements.size(); offerNumber++) {
            offers.add(new OfferModel().toBuilder()
                    .name(getOfferName(offerNumber))
                    .value(getOfferValue(offerNumber))
                    .build());
        }
        return offers;
    }

    public String getName() {
        return campaignNameField.getText();
    }

    public String getStartDate() {
        return startDateField.getText().replace('-','/');
    }

    public String getEndDate() {
        return endDateField.getText().replace('-','/');
    }

    public void expand() {
        root.$(SELECTOR_CAMPAIGN_NAME).click();
    }

    public ArrayList<DiscountModel> getDiscounts() {
        List<String> discountNames = $(SELECTOR_CAMPAIGNS_DISCOUNTS).$$("div").texts();
        ArrayList<DiscountModel> discounts = new ArrayList<>();
        for (String discountName : discountNames){
            discounts.add(DiscountModel.builder().
                    name(discountName).
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
        DuplicatePromotionPageObject duplicatePromotionWindow = new DuplicatePromotionPageObject($(SELECTOR_DUPLICATE_CAMPAIGN));
        duplicatePromotionWindow.duplicatePromotion();
    }

    public void editCampaign(CampaignModel campaignModel) {

    }

    public void changeCampaignName(String name) {
        actions.first().click();
        EditCampaignPageObject editCampaignWindow = new EditCampaignPageObject($(SELECTOR_DUPLICATE_CAMPAIGN));
        editCampaignWindow.changeName(name);
    }
}

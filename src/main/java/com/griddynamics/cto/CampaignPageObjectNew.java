package com.griddynamics.cto;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CampaignPageObjectNew extends PageObject{

    static final String SELECTOR_CAMPAIGN_NAME = ".at-campaign-name";
    static final String SELECTOR_CAMPAIGN_START_DATE = ".at-campaign-start-date";
    static final String SELECTOR_CAMPAIGN_END_DATE = ".at-campaign-end-date";

    static final String SELECTOR_CAMPAIGN_EDIT = ".at-campaign-edit";
    static final String SELECTOR_CAMPAIGN_COPY = ".at-campaign-copy";
    static final String SELECTOR_CAMPAIGN_DELETE = ".at-campaign-delete";
    static final String SELECTOR_CAMPAIGN_PREDICTION = ".at-campaign-predict";

    static final String SELECTOR_CAMPAIGN_OFFERS = ".at-campaign-offer";

    SelenideElement editButton = root.$(SELECTOR_CAMPAIGN_EDIT);
    SelenideElement copyButton = root.$(SELECTOR_CAMPAIGN_COPY);
    SelenideElement deleteButton = root.$(SELECTOR_CAMPAIGN_DELETE);
    SelenideElement predictionButton = root.$(SELECTOR_CAMPAIGN_PREDICTION);

    ElementsCollection campaignOffers = root.$$(SELECTOR_CAMPAIGN_OFFERS);

    public CampaignPageObjectNew(SelenideElement root) {
        super(root);
    }

    public String getCampaignName(){
        return $(SELECTOR_CAMPAIGN_NAME).getText();
    }

    public String getCampaignStartDate(){
        return $(SELECTOR_CAMPAIGN_START_DATE).getText();
    }

    public String getCampaignEndDate(){
        return $(SELECTOR_CAMPAIGN_END_DATE).getText();
    }


}

package com.griddynamics.cto;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class NewCampaignPageObject extends PageObject{

    static final String SELECTOR_CAMPAIGN_NAME = ".at-campaign-name";
    static final String SELECTOR_START_DATE = ".at-start-date";
    static final String SELECTOR_END_DATE = ".at-end-date";

    static final String SELECTOR_PROMOTION = ".at-promotion";

    ElementsCollection promotions = root.$$(SELECTOR_PROMOTION);

    public NewCampaignPageObject(SelenideElement root) {
        super(root);
    }

}

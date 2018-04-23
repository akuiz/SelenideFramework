package com.griddynamics.cto;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

public class ManageCampaignsPageObject extends PageObject{

    static final String SELECTOR_ADD_CAMPAIGN = ".at-add-campaign-button";

    static final String SELECTOR_CAMPAIGNS = ".at-promotion";

    SelenideElement addPromotionFirst = root.$$(SELECTOR_ADD_CAMPAIGN).first();
    SelenideElement addPromotionSecond = root.$$(SELECTOR_ADD_CAMPAIGN).last();

    ElementsCollection promotions = root.$$(SELECTOR_CAMPAIGNS);

    public ManageCampaignsPageObject(SelenideElement root) {
        super(root);
    }
}

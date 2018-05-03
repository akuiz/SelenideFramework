package com.griddynamics.cto;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.griddynamics.cto.models.CampaignModel;
import com.griddynamics.cto.models.DiscountModel;
import com.griddynamics.cto.models.OfferModel;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class NewCampaignPageObject extends PageObject{

    static final String SELECTOR_CAMPAIGN_NAME = ".name__input";
    static final String SELECTOR_START_DATE = ".start-date__input";
    static final String SELECTOR_END_DATE = ".end-date__input";
    static final String SELECTOR_PROMOTIONS = ".promotions__input";
    static final String SELECETOR_ADD_CAMPAIGN_BUTTON = ".btn__title";

    static final String SELECTOR_PROMOTION_OPTIONS = ".mat-option-text";

    static final String SELECTOR_BACKGROUND = ".cdk-overlay-container";

    SelenideElement nameInput = root.$(SELECTOR_CAMPAIGN_NAME);
    SelenideElement startDateInput = root.$(SELECTOR_START_DATE);
    SelenideElement endDateInput = root.$(SELECTOR_END_DATE);
    SelenideElement promotionsInput = root.$(SELECTOR_PROMOTIONS);

    SelenideElement addCampaignButton = root.$(SELECETOR_ADD_CAMPAIGN_BUTTON);

    public NewCampaignPageObject(SelenideElement root) {
        super(root);
    }

    public void addCampaign(CampaignModel campaign) {
        nameInput.setValue(campaign.getName());
        startDateInput.setValue(campaign.getStartDate());
        $(SELECTOR_BACKGROUND).click();
        endDateInput.setValue(campaign.getEndDate());
        $(SELECTOR_BACKGROUND).click();
        setDiscounts(campaign.getDiscounts());
        addCampaignButton.click();
    }

    void setDiscounts(ArrayList<DiscountModel> discounts){
        promotionsInput.click();
        ElementsCollection discountSelection = $$(SELECTOR_PROMOTION_OPTIONS);
        for(DiscountModel discount : discounts){
            int indexOfBrand = discountSelection.texts().indexOf(discount.getName());
            discountSelection.get(indexOfBrand).scrollTo().click();
        }
        $(SELECTOR_BACKGROUND).click();
    }

}

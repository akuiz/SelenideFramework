package com.griddynamics.cto;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.griddynamics.cto.models.CampaignModel;
import com.griddynamics.cto.models.DiscountModel;
import sun.jvm.hotspot.debugger.Page;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class EditCampaignPageObject extends PageObject{

    public EditCampaignPageObject(SelenideElement root) {
        super(root);
    }

    static final String SELECTOR_CAMPAIGN_NAME = ".name__input";
    static final String SELECTOR_START_DATE = ".start-date__input";
    static final String SELECTOR_END_DATE = ".end-date__input";
    static final String SELECTOR_PROMOTIONS = ".promotions__input";
    static final String SELECETOR_UPDATECAMPAIGN_BUTTON = ".btn__title";

    static final String SELECTOR_PROMOTION_OPTIONS = ".mat-option-text";

    static final String SELECTOR_BACKGROUND = ".cdk-overlay-container";

    SelenideElement nameInput = root.$(SELECTOR_CAMPAIGN_NAME);
    SelenideElement startDateInput = root.$(SELECTOR_START_DATE);
    SelenideElement endDateInput = root.$(SELECTOR_END_DATE);
    SelenideElement promotionsInput = root.$(SELECTOR_PROMOTIONS);



    SelenideElement updateCampaignButton = root.$(SELECETOR_UPDATECAMPAIGN_BUTTON);


    void setDiscounts(ArrayList<DiscountModel> discounts){
        promotionsInput.click();
        ElementsCollection discountSelection = $$(SELECTOR_PROMOTION_OPTIONS);
        for(DiscountModel discount : discounts){
            int indexOfBrand = discountSelection.texts().indexOf(discount.getName());
            discountSelection.get(indexOfBrand).scrollTo().click();
        }
        $(SELECTOR_BACKGROUND).click();
    }

    public void changeName(String name) {
        nameInput.setValue(name);
        updateCampaignButton.click();
    }
}

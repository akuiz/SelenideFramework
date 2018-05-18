package com.griddynamics.cto;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.griddynamics.cto.model.CampaignModel;
import com.griddynamics.cto.model.DiscountModel;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.ArrayList;

import static com.codeborne.selenide.Condition.disabled;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class NewCampaignPageObject extends PageObject {

    static final String SELECTOR_CAMPAIGN_NAME = ".name__input";
    static final String SELECTOR_START_DATE = ".start-date__input";
    static final String SELECTOR_END_DATE = ".end-date__input";
    static final String SELECTOR_PROMOTIONS = ".promotions";
    static final String SELECTOR_ADD_CAMPAIGN_BUTTON = ".btn";

    static final String SELECTOR_DATE_PICKER = ".mat-datepicker-popup";

    static final String SELECTOR_PROMOTION_OPTIONS = ".mat-option-text";

    static final String SELECTOR_BACKGROUND = ".cdk-overlay-container";

    SelenideElement nameInput = root.$(SELECTOR_CAMPAIGN_NAME);
    SelenideElement startDateInput = root.$(SELECTOR_START_DATE);
    SelenideElement endDateInput = root.$(SELECTOR_END_DATE);
    SelenideElement promotionsInput = root.$(SELECTOR_PROMOTIONS);

    SelenideElement addCampaignButton = root.$(SELECTOR_ADD_CAMPAIGN_BUTTON);

    public NewCampaignPageObject(SelenideElement root) {
        super(root);
    }

    public void addCampaign(CampaignModel campaign) {
        nameInput.setValue(campaign.getName());
        setDates(campaign.getStartDate(), campaign.getEndDate());
        setDiscounts(campaign.getDiscounts());
        addCampaignButton.click();
    }

    public void checkAddCampaignValidation(CampaignModel campaign) {
        nameInput.setValue(campaign.getName());
        addCampaignButton.shouldBe(disabled);
        setDiscounts(campaign.getDiscounts());
        addCampaignButton.shouldBe(disabled);
    }


    private void setDates(DateTime startDate, DateTime endDate) {
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
        startDateInput.click();
        DatePickerPageObject datePickerPageObject = new DatePickerPageObject($(SELECTOR_DATE_PICKER));
        datePickerPageObject.pickDate(startDate);
    }

    private void setEndDate(DateTime startDate) {
        endDateInput.click();
        DatePickerPageObject datePickerPageObject = new DatePickerPageObject($(SELECTOR_DATE_PICKER));
        datePickerPageObject.pickDate(startDate);
    }


    void setDiscounts(ArrayList<DiscountModel> discounts) {
        promotionsInput.click();
        ElementsCollection discountSelection = $$(SELECTOR_PROMOTION_OPTIONS);
        for (DiscountModel discount : discounts) {
            int indexOfBrand = discountSelection.texts().indexOf(discount.getName());
            discountSelection.get(indexOfBrand).scrollTo().click();
        }
        $(SELECTOR_BACKGROUND).click();
    }
}

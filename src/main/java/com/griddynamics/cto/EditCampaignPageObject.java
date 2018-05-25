package com.griddynamics.cto;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.griddynamics.cto.model.CampaignModel;
import com.griddynamics.cto.model.DiscountModel;
import org.joda.time.DateTime;

import java.util.ArrayList;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class EditCampaignPageObject extends PageObject {

    public EditCampaignPageObject(SelenideElement root) {
        super(root);
    }

    static final String SELECTOR_CAMPAIGN_NAME = ".name__input";
    static final String SELECTOR_START_DATE = ".start-date__input";
    static final String SELECTOR_END_DATE = ".end-date__input";
    static final String SELECTOR_PROMOTIONS = ".promotions__input";
    static final String SELECETOR_UPDATECAMPAIGN_BUTTON = ".btn__title";

    static final String SELECTOR_DATE_PICKER = ".mat-datepicker-popup";

    static final String SELECTOR_PROMOTION_OPTIONS = ".mat-option-text";

    static final String SELECTOR_BACKGROUND = ".cdk-overlay-container";

    SelenideElement nameInput = root.$(SELECTOR_CAMPAIGN_NAME);
    SelenideElement startDateInput = root.$(SELECTOR_START_DATE);
    SelenideElement endDateInput = root.$(SELECTOR_END_DATE);
    SelenideElement promotionsInput = root.$(SELECTOR_PROMOTIONS);

    SelenideElement updateCampaignButton = root.$(SELECETOR_UPDATECAMPAIGN_BUTTON);

    void changeDiscounts(ArrayList<DiscountModel> discounts) {
        setDiscounts(discounts);
        updateCampaignButton.click();
    }

    void setDiscounts(ArrayList<DiscountModel> discounts){
        promotionsInput.click();
        ArrayList<String> requiredDiscountNames = getDiscountNames(discounts);
        ElementsCollection discountSelection = $$(SELECTOR_PROMOTION_OPTIONS);
        for (SelenideElement selectedDiscount : discountSelection){
            if (selectedDiscount.parent().getAttribute("aria-selected").equals("true")) {
                if (!requiredDiscountNames.contains(selectedDiscount.getText())) {
                    int indexOfDiscountToUnhceck = discountSelection.texts().indexOf(selectedDiscount.getText());
                    discountSelection.get(indexOfDiscountToUnhceck).scrollTo().click();
                }
            }
        }
        for (DiscountModel discount : discounts) {
            int indexOfDiscount = discountSelection.texts().indexOf(discount.getName());
            if (!discountSelection.get(indexOfDiscount).parent().getAttribute("aria-selected").equals("true"))
                discountSelection.get(indexOfDiscount).scrollTo().click();
        }
        $(SELECTOR_BACKGROUND).click();
    }

    public ArrayList<String> getDiscountNames(ArrayList<DiscountModel> discounts){
        ArrayList<String> discountNames = new ArrayList<>();
        for (DiscountModel discount : discounts){
            discountNames.add(discount.getName());
        }
        return discountNames;
    }

    public void changeName(String name) {
        nameInput.setValue(name);
        updateCampaignButton.click();
    }

    public void changeDates(DateTime startDate, DateTime endDate) {
        setDates(startDate, endDate);
        updateCampaignButton.click();
    }

    private void setDates(DateTime startDate, DateTime endDate) {
        if (startDate.isBefore(formatter.parseDateTime("5/1/2018"))) {
            setStartDate(startDate);
            setEndDate(endDate);
        } else {
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

    public void setValues(CampaignModel campaignModel) {
        nameInput.setValue(campaignModel.getName());
        setDates(campaignModel.getStartDate(), campaignModel.getEndDate());
        setDiscounts(campaignModel.getDiscounts());
        updateCampaignButton.click();
    }
}


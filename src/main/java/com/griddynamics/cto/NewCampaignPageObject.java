package com.griddynamics.cto;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.griddynamics.cto.model.CampaignModel;
import com.griddynamics.cto.model.DiscountModel;
import io.qameta.allure.Step;
import org.joda.time.DateTime;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.ArrayList;

import static com.codeborne.selenide.Condition.disabled;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

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
        if(startDate.isBefore(DateTime.now())){
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

    private void setEndDate(DateTime endDate) {
        endDateInput.click();
        DatePickerPageObject datePickerPageObject = new DatePickerPageObject($(SELECTOR_DATE_PICKER));
        datePickerPageObject.pickDate(endDate);
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

    @Step("Make sure that 'Add Campaign' button is disabled after filling values")
    public void addBadCampaign(CampaignModel campaignModel) {
        setCampaignValues(campaignModel);
        addCampaignButton.shouldBe(disabled);
    }

    private void setCampaignValues(CampaignModel campaign) {
        setName(campaign.getName());
        setDiscounts(campaign.getDiscounts());
        setDates(campaign.getStartDate(), campaign.getEndDate());
    }

    private void setName(String name) {
        if("".equals(name)){
            clearNameInputValue();
        }
        else {
            nameInput.setValue(name);
        }
    }

    private void clearNameInputValue() {
        WebDriverRunner.getWebDriver().findElement(By.cssSelector(SELECTOR_CAMPAIGN_NAME)).sendKeys(Keys.chord(Keys.COMMAND,"a"));
        WebDriverRunner.getWebDriver().findElement(By.cssSelector(SELECTOR_CAMPAIGN_NAME)).sendKeys(Keys.BACK_SPACE);
    }

    @Step("Can't pick start date after end date and vice versa")
    public void validateDatePicker() {
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

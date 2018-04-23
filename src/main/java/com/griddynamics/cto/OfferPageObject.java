package com.griddynamics.cto;

import com.codeborne.selenide.SelenideElement;
import com.griddynamics.cto.models.OfferModel;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class OfferPageObject extends PageObject {

    static final String SELECTOR_OFFER_NAME = ".at-offer-name";
    static final String SELECTOR_OFFER_RULE = ".at-offer-rule";
    static final String SELECTOR_OFFER_TYPE = ".at-offer-type";
    static final String SELECTOR_OFFER_VALUE = ".at-offer-value";

    static final String SELECTOR_OFFER_EDIT = ".at-edit-offer";
    static final String SELECTOR_OFFER_COPY = ".at-copy-offer";
    static final String SELECTOR_OFFER_DELETE = ".at-delete-offer";

    static final String XPATH_OFFER_NAME = ".//input[@placeholder='Offer']";
    static final String XPATH_OFFER_VALUE = ".//input[@placeholder='']";
    static final String XPATH_OFFER_RULE = ".//input[@placeholder='Rule']";

    static final String XPATH_OFFER_TYPE_SELECT_BUTTON = ".//mat-select[contains(@class, 'mat-select')]";
    static final String XPATH_OFFER_TYPE = ".//mat-option[@ng-reflect-value='";

    SelenideElement selectOfferTypeButton = root.$(byXpath(XPATH_OFFER_TYPE_SELECT_BUTTON));
    SelenideElement offerNameInput = root.$(byXpath(XPATH_OFFER_NAME));
    SelenideElement offerValueInput = root.$(byXpath(XPATH_OFFER_VALUE));
    SelenideElement offerRuleInput = root.$(byXpath(XPATH_OFFER_RULE));


    public OfferPageObject(SelenideElement root) {
        super(root);
    }

    public String getName() {
        return offerNameInput.getValue();
    }

    public void setName(String name) {
        root.$(SELECTOR_OFFER_NAME).setValue(name);
    }

    public String getRule() {
        return offerRuleInput.getValue();
    }

    public void setRule(String rule) {
        offerRuleInput.setValue("TEEEEST");
    }

    public String getType() {
        return selectOfferTypeButton.getAttribute("ng-reflect-value");
    }

    public void setType(String type) {
        selectOfferTypeButton.click();
        $(byXpath(XPATH_OFFER_TYPE + type + "']")).click();
    }

    public String getValue() {
        return offerValueInput.getValue();
    }

    public void setValue(String value) {
        offerValueInput.setValue(value);
    }

    public void setValues(OfferModel offer) {
        offerNameInput.setValue(offer.getName());
        offerValueInput.setValue(offer.getValue());
        offerRuleInput.setValue(offer.getRule());
        this.setType(offer.getType());
    }
}

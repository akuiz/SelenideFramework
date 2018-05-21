package com.griddynamics.cto;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.griddynamics.cto.model.OfferModel;
import io.qameta.allure.Step;

import java.util.ArrayList;
import java.util.Arrays;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class OfferPageObject extends PageObject {

    static final String SELECTOR_OFFER_NAME = ".name-column";
    static final String SELECTOR_OFFER_RULE = ".rule-column";
    static final String SELECTOR_OFFER_TYPE = ".type-column";
    static final String SELECTOR_OFFER_VALUE = ".value-column";

    static final String SELECTOR_ACTIONS = ".actions-column";

    SelenideElement actions1 = root.$(SELECTOR_ACTIONS);

    ElementsCollection actions = root.$$(".mat-icon-button");

    static final String SELECTOR_OFFER_EDIT = ".at-edit-offer";
    static final String SELECTOR_OFFER_COPY = ".at-copy-offer";
    static final String SELECTOR_OFFER_DELETE = ".at-delete-offer";

    static final String XPATH_DELETE_PROMOTION = "//span[contains(text(),'REMOVE')]";

    String ELEMENT_UPDATE_PROMOTION_WINDOW = ".mat-dialog-container";


    static final String XPATH_OFFER_TYPE_SELECT_BUTTON = ".//mat-select[contains(@class, 'mat-select')]";
    static final String XPATH_OFFER_TYPE = ".//mat-option[@ng-reflect-value='";

    SelenideElement offerTypeField = root.$((SELECTOR_OFFER_TYPE));
    SelenideElement promotionNameField = root.$((SELECTOR_OFFER_NAME));
    SelenideElement offerRuleField = root.$((SELECTOR_OFFER_RULE));
    SelenideElement offerValueField = root.$(SELECTOR_OFFER_VALUE);

    public SelenideElement getActions() {
        return actions1.$(".mat-icon-button");
    }

    public OfferPageObject(SelenideElement root) {
        super(root);
    }

    public String getName() {
        return promotionNameField.getText();
    }

    public void setName(String name) {
        root.$(SELECTOR_OFFER_NAME).setValue(name);
    }

    public String getRule() {
        return offerRuleField.getText();
    }

    public void setRule(String rule) {
        offerRuleField.setValue("TEEEEST");
    }

    public OfferType getType() {
        String type = offerTypeField.getText();
        return OfferType.fromString(type);
    }

    public void setType(String type) {
        offerTypeField.click();
        $(byXpath(XPATH_OFFER_TYPE + type + "']")).click();
    }

    public String getValue() {
        return offerValueField.getText();
    }

    public void setValue(String value) {
        offerValueField.setValue(value);
    }

    public void setValues(OfferModel offer) {
        promotionNameField.setValue(offer.getName());
        offerValueField.setValue(offer.getValue());
        offerRuleField.setValue(offer.getBrands().get(0));
    }

    public void deletePromotion() {
        actions.last().click();
        $(byXpath(XPATH_DELETE_PROMOTION)).click();
    }

    public ArrayList<String> getBrands() {
        ArrayList<String> brandsArrayList = new ArrayList<String>(Arrays.asList(offerRuleField.getText().split(", ")));
        return brandsArrayList;
    }

    public void updatePromotionName(String newPromotionName) {
        actions.first().click();
        EditPromotionPageObject editPromotionWindow = new EditPromotionPageObject($(ELEMENT_UPDATE_PROMOTION_WINDOW));
        editPromotionWindow.updatePromotionName(newPromotionName);
    }

    public void updatePromotion(OfferModel newPromotion) {
        actions.first().click();
        EditPromotionPageObject editPromotionWindow = new EditPromotionPageObject($(ELEMENT_UPDATE_PROMOTION_WINDOW));
        editPromotionWindow.updatePromotion(newPromotion);
    }

    public void duplicatePromotion() {
        actions.get(1).click();
        DuplicatePromotionPageObject duplicatePromotionWindow = new DuplicatePromotionPageObject($(ELEMENT_UPDATE_PROMOTION_WINDOW));
        duplicatePromotionWindow.duplicatePromotion();
    }

    public OfferModel getOfferModel() {
        return new OfferModel().toBuilder()
                .name(this.getName())
                .value(this.getValue())
                .type(this.getType())
                .brands(this.getBrands())
                .build();
    }
}

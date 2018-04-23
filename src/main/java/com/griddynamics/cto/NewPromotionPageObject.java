package com.griddynamics.cto;

import com.codeborne.selenide.SelenideElement;
import com.griddynamics.cto.models.OfferModel;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class NewPromotionPageObject extends PageObject{

    static final String SELECTOR_ADD_PROMOTION = ".at-add-promotion";

    static final String SELECTOR_OFFER_NAME = ".at-offer-name";
    static final String SELECTOR_OFFER_RULE = ".at-offer-rule";
    static final String SELECTOR_OFFER_TYPE = ".at-offer-type";
    static final String SELECTOR_OFFER_VALUE = ".at-offer-value";

    static final String SELECTOR_CLOSE_WINDOW = ".close-dialog";

    static final String SELECTOR_OFFER_CANCEL_CREATION = ".at-offer-cancel-creation";

    SelenideElement addPromotionButton = root.$(SELECTOR_ADD_PROMOTION);

    SelenideElement offerNameInput = root.$(SELECTOR_OFFER_NAME);
    SelenideElement offerRuleInput = root.$(SELECTOR_OFFER_RULE);
    SelenideElement offerTypeInput = root.$(SELECTOR_OFFER_TYPE);
    SelenideElement offerValueInput = root.$(SELECTOR_OFFER_VALUE);

    SelenideElement closeWindowButton = root.$(SELECTOR_CLOSE_WINDOW);

    public NewPromotionPageObject(SelenideElement root) {
        super(root);
    }

    public void setOfferName(String name){
        offerNameInput.setValue(name);
    }

    public String getOfferName(){
        return offerNameInput.getValue();
    }

    public void setOfferRule(String rule){
        offerRuleInput.setValue(rule);
    }

    public String getOfferRule(){
        return offerRuleInput.getValue();
    }

    public void setOfferType(String type){
        offerTypeInput.setValue(type);
    }

    public String getOfferType(){
        return offerTypeInput.getValue();
    }

    public void setOfferValue(String value){
        offerValueInput.setValue(value);
    }

    public String getOfferValue(){
        return offerValueInput.getValue();
    }

    public void setOfferValues(OfferModel offer){
        this.setOfferName(offer.getName());
        this.setOfferValue(offer.getValue());
        this.setOfferType(offer.getType());
        this.setOfferRule(offer.getRule());
    }

    @Step("Close add promotion dialog")
    public void closeAddPromotionDialog(){
        closeWindowButton.click();
    }
}

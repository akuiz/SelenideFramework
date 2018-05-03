package com.griddynamics.cto;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.griddynamics.cto.models.CampaignModel;
import com.griddynamics.cto.models.OfferModel;
import io.qameta.allure.Step;

import java.util.ArrayList;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DuplicatePromotionPageObject extends PageObject {

    static final String SELECTOR_ADD_PROMOTION = ".btn__title";

    static final String SELECTOR_OFFER_NAME = ".name__input";
    static final String SELECTOR_OFFER_RULE = ".rule__input";
    static final String SELECTOR_OFFER_TYPE = ".type__input";
    static final String SELECTOR_OFFER_VALUE = ".value__input";

    static final String SELECTOR_BACKGROUND = ".cdk-overlay-container";

    static final String SELECTOR_OPTIONS = ".mat-option-text";

    static final String SELECTOR_CLOSE_WINDOW = ".close-dialog";

    static final String SELECTOR_OFFER_CANCEL_DUPLICATION = ".close-dialog";

    SelenideElement addPromotionButton = root.$(SELECTOR_ADD_PROMOTION);

    SelenideElement offerNameInput = root.$(SELECTOR_OFFER_NAME);
    SelenideElement offerRuleInput = root.$(SELECTOR_OFFER_RULE);
    SelenideElement offerTypeInput = root.$(SELECTOR_OFFER_TYPE);
    SelenideElement offerValueInput = root.$(SELECTOR_OFFER_VALUE);

    SelenideElement closeWindowButton = root.$(SELECTOR_CLOSE_WINDOW);

    public void setOfferName(String name){
        offerNameInput.setValue(name);
    }

    public String getOfferName(){
        return offerNameInput.getValue();
    }

    public void setOfferType(OfferType type){
        offerTypeInput.click();
        switch (type){
            case PERCENT_OFF:
                $$(SELECTOR_OPTIONS).get(0).click();
                break;
            case PERCENT_OF_AMOUNT:
                $$(SELECTOR_OPTIONS).get(1).click();
                break;
            case BOGO:
                $$(SELECTOR_OPTIONS).get(2).click();
                break;
            case FIX_DISCOUNT:
                $$(SELECTOR_OPTIONS).get(3).click();
                break;
        }
    }

    public String getOfferType(){
        return offerTypeInput.getValue();
    }

    public void setOfferValue(String value){
        if (value != null) offerValueInput.setValue(value);
        else return;
    }

    public String getOfferValue(){
        return offerValueInput.getValue();
    }

    @Step("Close add promotion dialog")
    public void closeAddPromotionDialog(){
        closeWindowButton.click();
    }

    public void setPromotionValues(OfferModel promotion) {
        offerNameInput.setValue(promotion.getName());
        setOfferBrands(promotion.getBrands());
        setOfferType(promotion.getType());
        if(!promotion.isBOGO()) setOfferValue(promotion.getValue());
    }

    public void setOfferBrands(ArrayList<String> promotionBrands){
        offerRuleInput.click();
        ElementsCollection brandsSelection = $$(SELECTOR_OPTIONS);
        for(String brand : promotionBrands){
            int indexOfBrand = brandsSelection.texts().indexOf(brand);
            brandsSelection.get(indexOfBrand).scrollTo().click();
        }
        $(SELECTOR_BACKGROUND).click();
    }

    @Step("Add promotion template")
    public void addPromotion(OfferModel promotion) {
        setPromotionValues(promotion);
        addPromotionButton.click();
    }

    public void isVisible() {
        root.shouldBe(visible);
    }

    public DuplicatePromotionPageObject(SelenideElement root) {
        super(root);
    }

    public void duplicatePromotion() {
        addPromotionButton.click();
    }
}
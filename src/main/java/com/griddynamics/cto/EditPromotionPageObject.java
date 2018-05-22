package com.griddynamics.cto;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.griddynamics.cto.model.OfferModel;
import io.qameta.allure.Step;

import java.util.ArrayList;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class EditPromotionPageObject extends PageObject {
    public EditPromotionPageObject(SelenideElement root) {
        super(root);
    }

    static final String SELECTOR_UPDATE_PROMOTION = ".btn__title";

    static final String SELECTOR_PROMOTION_NAME = ".name__input";
    static final String SELECTOR_OFFER_RULE = ".rule__input";
    static final String SELECTOR_OFFER_TYPE = ".type__input";
    static final String SELECTOR_OFFER_VALUE = ".value__input";

    static final String SELECTOR_BACKGROUND = ".cdk-overlay-container";

    static final String SELECTOR_OPTIONS = ".mat-option-text";

    static final String SELECTOR_CLOSE_WINDOW = ".close-dialog";

    static final String SELECTOR_OFFER_CANCEL_CREATION = ".at-offer-cancel-creation";

    SelenideElement updatePromotionButton = root.$(SELECTOR_UPDATE_PROMOTION);

    SelenideElement promotionNameInput = root.$(SELECTOR_PROMOTION_NAME);
    SelenideElement promotionRuleInput = root.$(SELECTOR_OFFER_RULE);
    SelenideElement promotionTypeInput = root.$(SELECTOR_OFFER_TYPE);
    SelenideElement promotionValueInput = root.$(SELECTOR_OFFER_VALUE);

    SelenideElement closeWindowButton = root.$(SELECTOR_CLOSE_WINDOW);

    public void setOfferName(String name) {
        promotionNameInput.setValue(name);
    }

    public String getOfferName() {
        return promotionNameInput.getValue();
    }

    public void setOfferType(OfferType type) {
        promotionTypeInput.click();
        switch (type) {
            case PERCENT_OFF:
                $$(SELECTOR_OPTIONS).get(0).click();
                break;
            case PERCENT_OF_AMOUNT:
                $$(SELECTOR_OPTIONS).get(1).click();
                break;
            case BOGO:
                $$(SELECTOR_OPTIONS).get(1).click();
                break;
            case FIX_DISCOUNT:
                $$(SELECTOR_OPTIONS).get(3).click();
                break;
        }
    }

    public String getOfferType() {
        return promotionTypeInput.getValue();
    }

    public void setOfferValue(String value) {
        if (value != null) promotionValueInput.setValue(value);
        else return;
    }

    public String getOfferValue() {
        return promotionValueInput.getValue();
    }

    @Step("Close add promotion dialog")
    public void closeAddPromotionDialog() {
        closeWindowButton.click();
    }

    public void setPromotionValues(OfferModel promotion) {
        promotionNameInput.setValue(promotion.getName());
        setOfferBrands(promotion.getBrands());
        setOfferType(promotion.getType());
        if (!promotion.isBOGO()) setOfferValue(promotion.getValue());
    }

    public void setOfferBrands(ArrayList<String> promotionBrands) {
        promotionRuleInput.click();
        ElementsCollection brandsSelection = $$(SELECTOR_OPTIONS);
        for (String brand : promotionBrands) {
            int indexOfBrand = brandsSelection.texts().indexOf(brand);
            if (!brandsSelection.get(indexOfBrand).parent().getAttribute("aria-selected").equals("true"))
                brandsSelection.get(indexOfBrand).scrollTo().click();
        }
        $(SELECTOR_BACKGROUND).click();
    }

    @Step("Update promotion name")
    public void updatePromotionName(String name) {
        promotionNameInput.setValue(name);
        updatePromotionButton.click();
    }

    @Step("Update promotion to a new one")
    public void updatePromotion(OfferModel newPromotion) {
        setPromotionValues(newPromotion);
        updatePromotionButton.click();
    }

    public void isVisible() {
        root.shouldBe(visible);
    }

    public void updatePromotionValue(String value) {
        promotionValueInput.setValue(value);
        updatePromotionButton.click();
    }
}

package com.griddynamics.cto;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.griddynamics.cto.model.PromotionModel;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.ArrayList;

import static com.codeborne.selenide.Condition.disabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class NewPromotionPageObject extends PageObject {

    static final String SELECTOR_ADD_PROMOTION = ".btn";
    static final String SELECTOR_PROMOTION_NAME = ".name__input";
    static final String SELECTOR_PROMOTION_RULE = ".rule__input";
    static final String SELECTOR_RPOMOTION_TYPE = ".type__input";
    static final String SELECTOR_PROMOTION_VALUE = ".value__input";

    static final String SELECTOR_BACKGROUND = ".cdk-overlay-container";

    static final String SELECTOR_OPTIONS = ".mat-option-text";

    static final String SELECTOR_CLOSE_WINDOW = ".close-dialog";

    static final String SELECTOR_OFFER_CANCEL_CREATION = ".at-offer-cancel-creation";

    SelenideElement addPromotionButton = root.$(SELECTOR_ADD_PROMOTION);

    SelenideElement promotionNameInput = root.$(SELECTOR_PROMOTION_NAME);
    SelenideElement promotionRuleInput = root.$(SELECTOR_PROMOTION_RULE);
    SelenideElement promotionTypeInput = root.$(SELECTOR_RPOMOTION_TYPE);
    SelenideElement promotionValueInput = root.$(SELECTOR_PROMOTION_VALUE);

    SelenideElement closeWindowButton = root.$(SELECTOR_CLOSE_WINDOW);

    public NewPromotionPageObject(SelenideElement root) {
        super(root);
    }

    public void setOfferName(String name) {
        if ("".equals(name)) {
            clearNameInputValue();
        } else {
            promotionNameInput.setValue(name);
        }
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
                $$(SELECTOR_OPTIONS).get(2).click();
                break;
            case BOGO:
                $$(SELECTOR_OPTIONS).get(1).click();
                break;
            case FIX_DISCOUNT:
                $$(SELECTOR_OPTIONS).get(3).click();
                break;
        }
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

    public void setPromotionValues(PromotionModel promotion) {
        setOfferName(promotion.getName());
        setOfferBrands(promotion.getBrands());
        setOfferType(promotion.getType());
        if (!promotion.isBOGO()) setOfferValue(promotion.getValue());
    }

    public void setOfferBrands(ArrayList<String> promotionBrands) {
        promotionRuleInput.click();
        ElementsCollection brandsSelection = $$(SELECTOR_OPTIONS);
        for (String brand : promotionBrands) {
            int indexOfBrand = brandsSelection.texts().indexOf(brand);
            brandsSelection.get(indexOfBrand).scrollTo().click();
        }
        $(SELECTOR_BACKGROUND).click();
    }

    @Step("Set promotion values and click add promotion button")
    public void addPromotion(PromotionModel promotion) {
        setPromotionValues(promotion);
        addPromotionButton.click();
    }

    public void isVisible() {
        root.shouldBe(visible);
    }

    @Step("Make sure that button is disabled after filling values")
    public void addBadPromotion(PromotionModel promotion) {
        setPromotionValues(promotion);
        addPromotionButton.shouldBe(disabled);
    }

    private void clearNameInputValue() {
        WebDriverRunner.getWebDriver().findElement(By.cssSelector(SELECTOR_PROMOTION_NAME)).sendKeys(Keys.chord(Keys.COMMAND, "a"));
        WebDriverRunner.getWebDriver().findElement(By.cssSelector(SELECTOR_PROMOTION_NAME)).sendKeys(Keys.BACK_SPACE);
    }
}

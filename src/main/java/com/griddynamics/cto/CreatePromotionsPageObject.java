package com.griddynamics.cto;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.griddynamics.cto.model.OfferModel;
import io.qameta.allure.Step;

import java.util.ArrayList;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byPartialLinkText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static com.griddynamics.cto.assertion.OfferModelAssert.assertThat;

public class CreatePromotionsPageObject extends PageObject {

    String SELECTOR_ADD_PROMOTION = ".btn-add-promo";

    String SELECTOR_PROMOTIONS = ".at-promotion";

    String SELECTOR_ADD_NEW_PROMOTION_WINDOW = ".mat-dialog-container";

    String SELECTOR_MANAGE_CAMPAIGNS_BUTTON = ".manage-campaigns-button";

    SelenideElement manageCampaignsButtong = root.$(SELECTOR_MANAGE_CAMPAIGNS_BUTTON);
    SelenideElement addPromotionFirstButton = root.$$(SELECTOR_ADD_PROMOTION).first();
    SelenideElement addPromotionSecondButton = root.$$(SELECTOR_ADD_PROMOTION).last();

    ElementsCollection promotions = $$(SELECTOR_PROMOTIONS);

    public CreatePromotionsPageObject(SelenideElement root) {
        super(root);
    }

    @Step("Add promotion template")
    public OfferPageObject addPromotion(OfferModel promotion) {
        waitForLoader();
        addPromotionFirstButton.click();
        NewPromotionPageObject createNewPromotionWindow = new NewPromotionPageObject($(SELECTOR_ADD_NEW_PROMOTION_WINDOW));
        createNewPromotionWindow.addPromotion(promotion);
        return new OfferPageObject(root.$(byText(promotion.getName())).parent());
    }

    @Step("Add promotion template")
    public OfferPageObject addPromotionSecondButton(OfferModel promotion) {
        waitForLoader();
        addPromotionFirstButton.click();
        NewPromotionPageObject createNewPromotionWindow = new NewPromotionPageObject($(SELECTOR_ADD_NEW_PROMOTION_WINDOW));
        createNewPromotionWindow.addPromotion(promotion);
        return new OfferPageObject(root.$(byText(promotion.getName())).parent());
    }

    @Step("Add promotion without brands")
    public void addPromotionWithoutBrands(OfferModel promotion) {
        waitForLoader();
        addPromotionFirstButton.click();
        NewPromotionPageObject createNewPromotionWindow = new NewPromotionPageObject($(SELECTOR_ADD_NEW_PROMOTION_WINDOW));
        createNewPromotionWindow.addBadPromotion(promotion);
    }

    @Step("Add promotion without name")
    public void addPromotionWithoutName(OfferModel promotion) {
        waitForLoader();
        addPromotionFirstButton.click();
        NewPromotionPageObject createNewPromotionWindow = new NewPromotionPageObject($(SELECTOR_ADD_NEW_PROMOTION_WINDOW));
        createNewPromotionWindow.addBadPromotion(promotion);
    }

    @Step("Make sure that promotion was successully created/updated")
    public void checkPromotionExists(OfferModel offerModel) {
        OfferModel promotion = findOfferByName(offerModel.getName());
        assertThat(promotion).isSameDiscountAs(offerModel);
    }

    @Step("Find promotion with name: {name}")
    private OfferModel findOfferByName(String name) {
        OfferPageObject promotionPageObject = new OfferPageObject(root.$(byText(name)).parent());
        OfferModel promotion = new OfferModel().toBuilder()
                .name(promotionPageObject.getName())
                .value(promotionPageObject.getValue())
                .type(promotionPageObject.getType())
                .brands(promotionPageObject.getBrands())
                .build();
        return promotion;
    }

    @Step("Delete promotion with name: {name}")
    public void deletePromotion(String name) {
        OfferPageObject promotionPageObject = findOfferPageObjectByName(name);
        promotionPageObject.deletePromotion();
    }

    private OfferPageObject findOfferPageObjectByName(String name) {
        return new OfferPageObject(root.$(byText(name)).parent());
    }

    @Step("Make sure there is no promotion with name: {name}")
    public void checkPromotionNotExists(String name) {
        $(byText(name)).shouldNot(exist);
    }

    public void addPromotionWithEmptyName(OfferModel promotion) {
        addPromotionFirstButton.scrollTo();
        addPromotionFirstButton.click();
        NewPromotionPageObject createNewPromotionWindow = new NewPromotionPageObject($(SELECTOR_ADD_NEW_PROMOTION_WINDOW));
        createNewPromotionWindow.addPromotion(promotion);
        createNewPromotionWindow.isVisible();
    }

    public void updatePromotionByName(String actualPromotionName, String newPromotionName) {
        OfferPageObject promotionPageObject = findOfferPageObjectByName(actualPromotionName);
        promotionPageObject.updatePromotionName(newPromotionName);
    }

    @Step("Update promotion")
    public void updatePromotion(OfferModel actualPromotion, OfferModel newPromotion) {
        OfferPageObject promotionPageObject = findOfferPageObjectByName(actualPromotion.getName());
        promotionPageObject.updatePromotion(newPromotion);
    }

    @Step("Duplicate promotion")
    public void duplicatePromotion(OfferModel actualPromotion) {
        OfferPageObject promotionPageObject = findOfferPageObjectByName(actualPromotion.getName());
        promotionPageObject.duplicatePromotion();
    }

    @Step("Make sure that promotion exist twice")
    public void checkPromotionExistsTwice(OfferModel originPromotion) {
        ArrayList<OfferPageObject> promotionsList = findAllPromotionsByName(originPromotion.getName());
        for (int i = 0; i < promotionsList.size(); i++) {
            OfferModel promotion = promotionsList.get(i).getOfferModel();
            assertThat(promotion).isSameDiscountAs(originPromotion);
        }
    }

    private ArrayList<OfferPageObject> findAllPromotionsByName(String name) {
        $$(byText(name)).shouldHaveSize(2);
        ArrayList promotions = new ArrayList();
        promotions.add(new OfferPageObject(root.$$(byText(name)).get(0).parent()));
        promotions.add(new OfferPageObject(root.$$(byText(name)).get(1).parent()));
        return promotions;
    }

    @Step("Update promotion name to {name}")
    public void updatePromotionName(OfferModel actualPromotion, String name) {
        OfferPageObject promotionPageObject = findOfferPageObjectByName(actualPromotion.getName());
        promotionPageObject.updatePromotionName(name);
    }

    @Step("Update promotion value to {value}")
    public void updatedPromotionValue(OfferModel promotion, String value) {
        OfferPageObject promotionPageObject = findOfferPageObjectByName(promotion.getName());
        promotionPageObject.updatePromotionValue(value);
    }

    @Step("Delete all test promotions")
    public void deleteTestPromotions() {
        OfferPageObject testPromotion = findTestPromotion();
        while(!(testPromotion==null)){
            testPromotion.deletePromotion();
            testPromotion = findTestPromotion();
        }
    }

    private OfferPageObject findTestPromotion() {
        if(root.$(byXpath("//*[contains(text(), 'at_')]")).exists()){
            return new OfferPageObject(root.$(byXpath("//*[contains(text(), 'at_')]")).parent());
        }
        return null;
    }
}

package com.griddynamics.cto;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.griddynamics.cto.model.OfferModel;
import io.qameta.allure.Step;

import java.util.ArrayList;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
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
        Selenide.sleep(2000);
        addPromotionFirstButton.click();
        NewPromotionPageObject createNewPromotionWindow = new NewPromotionPageObject($(SELECTOR_ADD_NEW_PROMOTION_WINDOW));
        createNewPromotionWindow.addPromotion(promotion);
        checkPromotionExists(promotion);
        return new OfferPageObject(root.$(byText(promotion.getName())).parent());
    }

    @Step("Add promotion without required parameters")
    public void addBadPromotion(OfferModel promotion) {
        Selenide.sleep(2000);
        addPromotionFirstButton.click();
        NewPromotionPageObject createNewPromotionWindow = new NewPromotionPageObject($(SELECTOR_ADD_NEW_PROMOTION_WINDOW));
        createNewPromotionWindow.tryToAddBadPromotion(promotion);
    }

    @Step("Check that promotion was successully created")
    public void checkPromotionExists(OfferModel offerModel) {
        OfferModel promotion = findOfferByName(offerModel.getName());
        assertThat(promotion).isSameDiscountAs(offerModel);
    }

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

    public void deletePromotionByName(OfferModel promotion) {
        OfferPageObject promotionPageObject = findOfferPageObjectByName(promotion.getName());
        promotionPageObject.deletePromotion();
        checkPromotionNotExistsByName(promotion);
    }

    private OfferPageObject findOfferPageObjectByName(String name) {
        return new OfferPageObject(root.$(byText(name)).parent());
    }

    public void checkPromotionNotExistsByName(OfferModel offerModel) {
        $(byText(offerModel.getName())).shouldNot(exist);
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

    public void updatePromotion(OfferModel actualPromotion, OfferModel newPromotion) {
        OfferPageObject promotionPageObject = findOfferPageObjectByName(actualPromotion.getName());
        promotionPageObject.updatePromotion(newPromotion);
    }

    public void duplicatePromotion(OfferModel actualPromotion) {
        OfferPageObject promotionPageObject = findOfferPageObjectByName(actualPromotion.getName());
        promotionPageObject.duplicatePromotion();
    }

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

}

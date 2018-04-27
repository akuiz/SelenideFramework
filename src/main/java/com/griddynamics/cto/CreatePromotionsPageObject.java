package com.griddynamics.cto;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.commands.Exists;
import com.griddynamics.cto.models.OfferModel;
import net.bytebuddy.utility.JavaModule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byValue;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static com.griddynamics.cto.assertions.OfferModelAssert.assertThat;

public class CreatePromotionsPageObject extends PageObject {

    String SELECTOR_ADD_PROMOTION = ".btn-add-promo";

    String SELECTOR_PROMOTIONS = ".at-promotion";

    String ELEMENT_ADD_NEW_PROMOTION_WINDOW = ".mat-dialog-container";

    SelenideElement addPromotionFirstButton = root.$$(SELECTOR_ADD_PROMOTION).first();
    SelenideElement addPromotionSecondButton = root.$$(SELECTOR_ADD_PROMOTION).last();

    ElementsCollection promotions = $$(SELECTOR_PROMOTIONS);

    public CreatePromotionsPageObject(SelenideElement root) {
       super(root);
   }

    public void addPromotion(OfferModel promotion) {
        Selenide.sleep(2000);
        addPromotionFirstButton.click();
        NewPromotionPageObject createNewPromotionWindow = new NewPromotionPageObject($(ELEMENT_ADD_NEW_PROMOTION_WINDOW));
        createNewPromotionWindow.addPromotion(promotion);
    }

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

    public void deletePromotionByName(OfferModel offerModel) {
        OfferPageObject promotionPageObject = findOfferPageObjectByName(offerModel.getName());
        promotionPageObject.deletePromotion();
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
        NewPromotionPageObject createNewPromotionWindow = new NewPromotionPageObject($(ELEMENT_ADD_NEW_PROMOTION_WINDOW));
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
}

package com.griddynamics.cto;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

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

    public void addPromotion() {
        System.out.println("+++"+addPromotionFirstButton.exists());
        addPromotionFirstButton.scrollTo();
        addPromotionFirstButton.click();
     //   Selenide.switchTo().window(1);
        NewPromotionPageObject createNewPromotionWindow = new NewPromotionPageObject($(ELEMENT_ADD_NEW_PROMOTION_WINDOW));
        createNewPromotionWindow.closeAddPromotionDialog();
    }
}

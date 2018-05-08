package com.griddynamics.cto;

import com.codeborne.selenide.SelenideElement;

public class RemovePromotionPageObject extends PageObject {

    static final String SELECTOR_REMOVE_OFFER_CONFIRMATION = ".at-remove-offer";

    SelenideElement removeConfirmationButton = root.$(SELECTOR_REMOVE_OFFER_CONFIRMATION);

    public RemovePromotionPageObject(SelenideElement root) {
        super(root);
    }
}

package com.griddynamics.cto.assertions;

import com.griddynamics.cto.models.DiscountModel;
import com.griddynamics.cto.models.OfferModel;
import org.assertj.core.api.AbstractAssert;

public class DiscountModelAssert extends AbstractAssert<DiscountModelAssert, DiscountModel> {
    public DiscountModelAssert(DiscountModel actualDiscount) {
        super(actualDiscount, DiscountModelAssert.class);
    }

    public static DiscountModelAssert assertThat(DiscountModel actualDiscount) {
        return new DiscountModelAssert(actualDiscount);
    }

    public AbstractAssert isSameDiscountAs(DiscountModel expectedDiscount) {
        isNotNull();
        if (!actual.getName().equals(expectedDiscount.getName())) {
            failWithMessage("Expected offer's name to be <%s> but was <%s>", expectedDiscount.getName(), actual.getName());
        }
        return this;
    }
}
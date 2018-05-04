package com.griddynamics.cto.assertion;

import com.griddynamics.cto.model.OfferModel;
import org.assertj.core.api.AbstractAssert;

public class OfferModelAssert extends AbstractAssert<OfferModelAssert, OfferModel>{

    public OfferModelAssert(OfferModel actualOffer) {
        super(actualOffer, OfferModelAssert.class);
    }

    public static OfferModelAssert assertThat(OfferModel actualOffer) {
        return new OfferModelAssert(actualOffer);
    }

    public AbstractAssert hasSameNameAs(OfferModel expectedOffer) {
        isNotNull();
        if (!actual.getName().equals(expectedOffer.getName())) {
            failWithMessage("Expected offer's name to be <%s> but was <%s>", expectedOffer.getName(), actual.getName());
        }
        return this;
    }

    public AbstractAssert isSameDiscountAs(OfferModel expectedOffer) {
        isNotNull();
        assertThat(actual).hasSameNameAs(expectedOffer);
        assertThat(actual).hasSameTypeAs(expectedOffer);
        assertThat(actual).hasSameBrandsAs(expectedOffer);
        assertThat(actual).hasSameValueAs(expectedOffer);
        return this;
    }

    public AbstractAssert hasSameTypeAs(OfferModel expectedOffer) {
        isNotNull();
        if (!actual.getType().equals(expectedOffer.getType())) {
            failWithMessage("Expected offer's type to be <%s> but was <%s>", expectedOffer.getType(), actual.getType());
        }
        return this;
    }

    public AbstractAssert hasSameBrandsAs(OfferModel expectedOffer) {
        isNotNull();
        for (int i = 0; i <actual.getBrands().size() ; i++) {
            if (!actual.getBrands().get(i).equals(expectedOffer.getBrands().get(i))) {
                failWithMessage("Expected offer's brand to be <%s> but was <%s>", expectedOffer.getBrands().get(i), actual.getBrands().get(i));
            }
        }
        return this;
    }

    public AbstractAssert hasSameValueAs(OfferModel expectedOffer) {
        isNotNull();
        if (!actual.getValue().equals(expectedOffer.getValue())) {
            failWithMessage("Expected offer's value to be <%s> but was <%s>", expectedOffer.getValue(), actual.getValue());
        }
        return this;
    }

}

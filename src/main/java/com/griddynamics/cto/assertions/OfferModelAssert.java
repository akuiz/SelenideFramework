package com.griddynamics.cto.assertions;

import com.griddynamics.cto.models.CampaignModel;
import com.griddynamics.cto.models.OfferModel;
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
        assertThat(actual).hasSameRuleAs(expectedOffer);
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

    public AbstractAssert hasSameRuleAs(OfferModel expectedOffer) {
        isNotNull();
        if (!actual.getRule().equals(expectedOffer.getRule())) {
            failWithMessage("Expected offer's rule to be <%s> but was <%s>", expectedOffer.getRule(), actual.getRule());
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

package com.griddynamics.cto.assertions;

import io.qameta.allure.Step;
import org.assertj.core.api.AbstractAssert;

import com.griddynamics.cto.models.*;

import java.util.ArrayList;

public class CampaignModelAssert extends AbstractAssert<CampaignModelAssert, CampaignModel> {

    public CampaignModelAssert(CampaignModel actualCampaign) {
        super(actualCampaign, CampaignModelAssert.class);
    }

    public static CampaignModelAssert assertThat(CampaignModel actualCampaign) {
        return new CampaignModelAssert(actualCampaign);
    }

    public AbstractAssert hasSameNameAs(CampaignModel expectedCampaign) {
        isNotNull();
        if (!actual.getName().equals(expectedCampaign.getName())) {
            failWithMessage("Expected campaigns's name to be <%s> but was <%s>", expectedCampaign.getName(), actual.getName());
        }
        return this;
    }

    public AbstractAssert hasSameStartDateAs(CampaignModel expectedCampaign) {
        isNotNull();
        if (!actual.getStartDate().equals(expectedCampaign.getStartDate())) {
            failWithMessage("Expected campaigns's start date to be <%s> but was <%s>", expectedCampaign.getStartDate(), actual.getStartDate());
        }
        return this;
    }

    public AbstractAssert hasSameStartEndAs(CampaignModel expectedCampaign) {
        isNotNull();
        if (!actual.getEndDate().equals(expectedCampaign.getEndDate())) {
            failWithMessage("Expected campaigns's start date to be <%s> but was <%s>", expectedCampaign.getEndDate(), actual.getEndDate());
        }
        return this;
    }

    public AbstractAssert isSameCampaignAs(CampaignModel expectedCampaign) {
        isNotNull();
        assertThat(actual).hasSameNameAs(expectedCampaign);
        assertThat(actual).hasSameStartDateAs(expectedCampaign);
        assertThat(actual).hasSameStartDateAs(expectedCampaign);
        assertThat(actual).hasSameDiscountsAs(expectedCampaign);
        return this;
    }

    public AbstractAssert hasSameDiscountsAs(CampaignModel expectedCampaign) {
        isNotNull();
        ArrayList<DiscountModel> actualDiscounts = actual.getDiscounts();
        ArrayList<DiscountModel> expectedDiscounts = expectedCampaign.getDiscounts();
        for (int discountNumber = 0; discountNumber < actualDiscounts.size(); discountNumber++) {
            DiscountModelAssert.assertThat(actualDiscounts.get(discountNumber)).isSameDiscountAs(expectedDiscounts.get(discountNumber));
        }
        return this;
    }

}

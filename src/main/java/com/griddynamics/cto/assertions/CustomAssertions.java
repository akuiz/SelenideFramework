package com.griddynamics.cto.assertions;

import com.griddynamics.cto.models.CampaignModel;
import com.griddynamics.cto.models.OfferModel;
import org.assertj.core.api.Assertions;


public class CustomAssertions extends Assertions {

    public static CampaignModelAssert assertThat(CampaignModel actual) {
        return new CampaignModelAssert(actual);
    }

    public static OfferModelAssert assertThat(OfferModel actual) {
        return new OfferModelAssert(actual);
    }

}

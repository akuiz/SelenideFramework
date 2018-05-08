package com.griddynamics.cto.assertion;

import com.griddynamics.cto.model.CampaignModel;
import com.griddynamics.cto.model.OfferModel;
import org.assertj.core.api.Assertions;

public class CustomAssertions extends Assertions {

    public static CampaignModelAssert assertThat(CampaignModel actual) {
        return new CampaignModelAssert(actual);
    }

    public static OfferModelAssert assertThat(OfferModel actual) {
        return new OfferModelAssert(actual);
    }

}

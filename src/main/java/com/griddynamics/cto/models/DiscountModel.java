package com.griddynamics.cto.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

import static com.griddynamics.cto.OfferType.PERCENT_OFF;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class DiscountModel {
    private String name;

    public static DiscountModel TestCampaignBOGODiscount() {
        return new DiscountModel().toBuilder()
                .name("CreateCampaignTestPromotionBOGO")
                .build();
    }

    public static DiscountModel TestCampaignOFFPromotion(){
        return new DiscountModel().toBuilder()
                .name("CreateCampaignTestPromotionOFF")
                .build();
    }

}

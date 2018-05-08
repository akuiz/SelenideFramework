package com.griddynamics.cto.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    public static DiscountModel TestCampaignOFFPromotion() {
        return new DiscountModel().toBuilder()
                .name("CreateCampaignTestPromotionOFF")
                .build();
    }

    public static DiscountModel Spring2018Discount() {
        return new DiscountModel().toBuilder()
                .name("Spring 5% off on $400")
                .build();
    }

}

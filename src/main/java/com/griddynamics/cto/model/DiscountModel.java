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

    public static DiscountModel DiscountBOGOOnlyCampaign() {
        return new DiscountModel().toBuilder()
                .name("CreateCampaignTestWithBOGOPromotion")
                .build();
    }

    public static DiscountModel ForecastOFFDiscount() {
        return new DiscountModel().toBuilder()
                .name("ForecastTestPromotionOFF")
                .build();
    }

    public static DiscountModel ForecastBOGODiscount() {
        return new DiscountModel().toBuilder()
                .name("ForecastTestPromotionBOGO")
                .build();
    }

    public static DiscountModel AdriannaPappell5PercentOFF() {
        return new DiscountModel().toBuilder()
                .name("Adrianna Papell 5% OFF")
                .build();
    }

    public static DiscountModel DiscountBOGOSmoke() {
        return new DiscountModel().toBuilder()
                .name("Smoke promotion BOGO")
                .build();
    }

    public static DiscountModel DiscountOFFSmoke() {
        return new DiscountModel().toBuilder()
                .name("Smoke promotion %OFF")
                .build();
    }
}

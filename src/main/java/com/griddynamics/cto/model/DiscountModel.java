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
                .name("at_CreateCampaignTestPromotionBOGO")
                .build();
    }

    public static DiscountModel TestCampaignOFFPromotion() {
        return new DiscountModel().toBuilder()
                .name("at_CreateCampaignTestPromotionOFF")
                .build();
    }

    public static DiscountModel DiscountBOGOOnlyCampaign() {
        return new DiscountModel().toBuilder()
                .name("at_CreateCampaignTestWithBOGOPromotion")
                .build();
    }

    public static DiscountModel ForecastOFFDiscount() {
        return new DiscountModel().toBuilder()
                .name("at_ForecastTestPromotionOFF")
                .build();
    }

    public static DiscountModel ForecastBOGODiscount() {
        return new DiscountModel().toBuilder()
                .name("at_ForecastTestPromotionBOGO")
                .build();
    }

    public static DiscountModel AdriannaPappell5PercentOFF() {
        return new DiscountModel().toBuilder()
                .name("Adrianna Papell 5% OFF")
                .build();
    }

    public static DiscountModel DiscountBOGOSmoke() {
        return new DiscountModel().toBuilder()
                .name("at_Promotion for Campaign BOGO")
                .build();
    }

    public static DiscountModel DiscountOFFSmoke() {
        return new DiscountModel().toBuilder()
                .name("at_Promotion for Campaign OFF")
                .build();
    }

    public static DiscountModel CalvinKleinOFF5() {
        return new DiscountModel().toBuilder()
                .name("Calvin Klein Special Offer 5%")
                .build();
    }

    public static DiscountModel CalvinKleinOFF7() {
        return new DiscountModel().toBuilder()
                .name("Calvin Klein Special Offer 7%")
                .build();
    }

    public static DiscountModel CalvinKleinOFF10() {
        return new DiscountModel().toBuilder()
                .name("Calvin Klein Special Offer 10%")
                .build();
    }

    public static DiscountModel AdriannaPapellOFF5() {
        return new DiscountModel().toBuilder()
                .name("Adrianna Papell 5% OFF")
                .build();
    }

    public static DiscountModel FreePeopleOFF10() {
        return new DiscountModel().toBuilder()
                .name("Free People 10% OFF")
                .build();
    }

    public static DiscountModel FreePeopleBOGO() {
        return new DiscountModel().toBuilder()
                .name("Free People BOGO")
                .build();
    }

    public static DiscountModel DiscountCampaignOFF(){
        return new DiscountModel().toBuilder()
        .name("at_Promotion for Campaign OFF")
                .build();
    }

    public static DiscountModel DiscountCampaignBOGO(){
        return new DiscountModel().toBuilder()
        .name("at_Promotion for Campaign BOGO")
                .build();
    }
}

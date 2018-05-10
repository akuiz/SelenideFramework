package com.griddynamics.cto.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class CampaignModel {
    private String startDate;
    private String endDate;
    private String name;
    private ArrayList<DiscountModel> discounts;

    public static CampaignModel TestCampaign() {
        return new CampaignModel().toBuilder()
                .name("TestCampaign")
                .startDate("5/1/2018")
                .endDate("5/31/2018")
                .discounts(new ArrayList<DiscountModel>() {{
                    add(DiscountModel.TestCampaignBOGODiscount());
                    add(DiscountModel.TestCampaignOFFPromotion());

                }})
                .build();
    }

    public static CampaignModel Promo1() {
        return new CampaignModel().toBuilder()
                .name("1Promo")
                .startDate("2018/05/01")
                .endDate("2018/05/31")
                .discounts(new ArrayList<DiscountModel>() {{
                    add(DiscountModel.TestCampaignBOGODiscount());
                    add(DiscountModel.TestCampaignOFFPromotion());

                }})
                .build();
    }

    public static CampaignModel Promo3() {
        return new CampaignModel().toBuilder()
                .name("3Promos")
                .startDate("2018/05/01")
                .endDate("2018/05/31")
                .discounts(new ArrayList<DiscountModel>() {{
                    add(DiscountModel.TestCampaignBOGODiscount());
                    add(DiscountModel.TestCampaignOFFPromotion());

                }})
                .build();
    }

    public static CampaignModel Calvin28() {
        return new CampaignModel().toBuilder()
                .name("Calvin Klein with brand 28")
                .startDate("2018/05/01")
                .endDate("2018/05/31")
                .discounts(new ArrayList<DiscountModel>() {{
                    add(DiscountModel.TestCampaignBOGODiscount());
                    add(DiscountModel.TestCampaignOFFPromotion());

                }})
                .build();
    }

    public static CampaignModel CalvinSpring() {
        return new CampaignModel().toBuilder()
                .name("Calvin Klein Spring 2018")
                .startDate("2018/05/01")
                .endDate("2018/05/31")
                .discounts(new ArrayList<DiscountModel>() {{
                    add(DiscountModel.TestCampaignBOGODiscount());
                    add(DiscountModel.TestCampaignOFFPromotion());

                }})
                .build();
    }

    public static CampaignModel Adrianna() {
        return new CampaignModel().toBuilder()
                .name("Adrianna Papell Spring 2018")
                .startDate("2018/05/01")
                .endDate("2018/05/31")
                .discounts(new ArrayList<DiscountModel>() {{
                    add(DiscountModel.TestCampaignBOGODiscount());
                    add(DiscountModel.TestCampaignOFFPromotion());

                }})
                .build();
    }

    public static CampaignModel IssueCampaign() {
        return new CampaignModel().toBuilder()
                .name("IssueCampaign")
                .startDate("05/01/2018")
                .endDate("05/31/2018")
                .discounts(new ArrayList<DiscountModel>() {{
                    add(DiscountModel.TestCampaignBOGODiscount());
                    add(DiscountModel.TestCampaignOFFPromotion());

                }})
                .build();
    }

    public static CampaignModel Test2Promo() {
        return new CampaignModel().toBuilder()
                .name("Test2Promo")
                .startDate("2018/05/01")
                .endDate("2018/05/31")
                .discounts(new ArrayList<DiscountModel>() {{
                    add(DiscountModel.TestCampaignBOGODiscount());
                    add(DiscountModel.TestCampaignOFFPromotion());

                }})
                .build();
    }

    public static CampaignModel TestEditedCampaign() {
        return new CampaignModel().toBuilder()
                .name("TestEditedCampaign")
                .startDate("1/1/2018")
                .endDate("1/1/2019")
                .discounts(new ArrayList<DiscountModel>() {{
                    add(DiscountModel.TestCampaignBOGODiscount());
                    add(DiscountModel.TestCampaignOFFPromotion());

                }})
                .build();
    }

    public static CampaignModel Spring2018() {
        return new CampaignModel().toBuilder()
                .name("Spring 2018")
                .startDate("2018/03/01")
                .endDate("2018/05/30")
                .discounts(new ArrayList<DiscountModel>() {{
                    add(DiscountModel.Spring2018Discount());
                }})
                .build();
    }

}



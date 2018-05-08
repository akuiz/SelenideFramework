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
                .startDate("2018/05/01")
                .endDate("2018/05/31")
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



package com.griddynamics.cto.models;

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
                .startDate("1/1/2018")
                .endDate("1/1/2019")
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

}



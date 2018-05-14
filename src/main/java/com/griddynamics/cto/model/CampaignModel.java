package com.griddynamics.cto.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;

import java.util.ArrayList;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class CampaignModel {
    private DateTime startDate;
    private DateTime endDate;
    private String name;
    private ArrayList<DiscountModel> discounts;

    public static CampaignModel TestCampaign() {
        return new CampaignModel().toBuilder()
                .name("TestCreateCampaign")
                .startDate(new DateTime(2018, 5, 11, 0, 0, 0, 0))
                .endDate(new DateTime(2018, 5, 16, 0, 0, 0, 0))
                .discounts(new ArrayList<DiscountModel>() {{
                    add(DiscountModel.TestCampaignBOGODiscount());
                    add(DiscountModel.TestCampaignOFFPromotion());
                }})
                .build();
    }

    public static CampaignModel Promo1() {
        return new CampaignModel().toBuilder()
                .name("1Promo")
                .startDate(new DateTime(2018, 5, 1, 0, 0, 0, 0))
                .endDate(new DateTime(2018, 5, 29, 0, 0, 0, 0))
                .discounts(new ArrayList<DiscountModel>() {{
                    add(DiscountModel.TestCampaignBOGODiscount());
                    add(DiscountModel.TestCampaignOFFPromotion());

                }})
                .build();
    }

    public static CampaignModel Promo3() {
        return new CampaignModel().toBuilder()
                .name("3Promos")
                .startDate(new DateTime(2018, 5, 1, 0, 0, 0, 0))
                .endDate(new DateTime(2018, 5, 29, 0, 0, 0, 0))
                .discounts(new ArrayList<DiscountModel>() {{
                    add(DiscountModel.TestCampaignBOGODiscount());
                    add(DiscountModel.TestCampaignOFFPromotion());

                }})
                .build();
    }

    public static CampaignModel Calvin28() {
        return new CampaignModel().toBuilder()
                .name("Calvin Klein with brand 28")
                .startDate(new DateTime(2018, 5, 1, 0, 0, 0, 0))
                .endDate(new DateTime(2018, 5, 29, 0, 0, 0, 0))
                .discounts(new ArrayList<DiscountModel>() {{
                    add(DiscountModel.TestCampaignBOGODiscount());
                    add(DiscountModel.TestCampaignOFFPromotion());

                }})
                .build();
    }

    public static CampaignModel CalvinSpring() {
        return new CampaignModel().toBuilder()
                .name("Calvin Klein Spring 2018")
                .startDate(new DateTime(2018, 5, 1, 0, 0, 0, 0))
                .endDate(new DateTime(2018, 5, 29, 0, 0, 0, 0))
                .discounts(new ArrayList<DiscountModel>() {{
                    add(DiscountModel.TestCampaignBOGODiscount());
                    add(DiscountModel.TestCampaignOFFPromotion());

                }})
                .build();
    }

    public static CampaignModel Adrianna() {
        return new CampaignModel().toBuilder()
                .name("Adrianna Papell Spring 2018")
                .startDate(new DateTime(2018, 5, 1, 0, 0, 0, 0))
                .endDate(new DateTime(2018, 5, 29, 0, 0, 0, 0))
                .discounts(new ArrayList<DiscountModel>() {{
                    add(DiscountModel.TestCampaignBOGODiscount());
                    add(DiscountModel.TestCampaignOFFPromotion());

                }})
                .build();
    }

    public static CampaignModel IssueCampaign() {
        return new CampaignModel().toBuilder()
                .name("IssueCampaign")
                .startDate(new DateTime(2018, 5, 1, 0, 0, 0, 0))
                .endDate(new DateTime(2018, 5, 29, 0, 0, 0, 0))
                .discounts(new ArrayList<DiscountModel>() {{
                    add(DiscountModel.TestCampaignBOGODiscount());
                    add(DiscountModel.TestCampaignOFFPromotion());

                }})
                .build();
    }

    public static CampaignModel Test2Promo() {
        return new CampaignModel().toBuilder()
                .name("Test2Promo")
                .startDate(new DateTime(2018, 5, 1, 0, 0, 0, 0))
                .endDate(new DateTime(2018, 5, 29, 0, 0, 0, 0))
                .discounts(new ArrayList<DiscountModel>() {{
                    add(DiscountModel.TestCampaignBOGODiscount());
                    add(DiscountModel.TestCampaignOFFPromotion());

                }})
                .build();
    }

    public static CampaignModel TestEditedCampaign() {
        return new CampaignModel().toBuilder()
                .name("TestEditedCampaign")
                .startDate(new DateTime(2018, 5, 1, 0, 0, 0, 0))
                .endDate(new DateTime(2018, 5, 29, 0, 0, 0, 0))
                .discounts(new ArrayList<DiscountModel>() {{
                    add(DiscountModel.TestCampaignBOGODiscount());
                    add(DiscountModel.TestCampaignOFFPromotion());

                }})
                .build();
    }

    public static CampaignModel Spring2018() {
        return new CampaignModel().toBuilder()
                .name("Spring 2018")
                .startDate(new DateTime(2018, 5, 1, 0, 0, 0, 0))
                .endDate(new DateTime(2018, 5, 29, 0, 0, 0, 0))
                .discounts(new ArrayList<DiscountModel>() {{
                    add(DiscountModel.Spring2018Discount());
                }})
                .build();
    }

}



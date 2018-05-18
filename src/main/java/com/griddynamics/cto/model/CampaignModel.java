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

    public static CampaignModel EditCampaignOrigin() {
        return new CampaignModel().toBuilder()
                .name("Origin campaign, dates,discounts,name should be changed")
                .startDate(new DateTime(2018, 5, 2, 0, 0, 0, 0))
                .endDate(new DateTime(2018, 5, 29, 0, 0, 0, 0))
                .discounts(new ArrayList<DiscountModel>() {{
                    add(DiscountModel.DiscountBOGOSmoke());
                }})
                .build();
    }
    public static CampaignModel EditCampaignEdited() {
        return new CampaignModel().toBuilder()
                .name("Origin campaign, dates,discounts,name have been changed")
                .startDate(new DateTime(2018, 5, 4, 0, 0, 0, 0))
                .endDate(new DateTime(2018, 5, 25, 0, 0, 0, 0))
                .discounts(new ArrayList<DiscountModel>() {{
                    add(DiscountModel.DiscountOFFSmoke());
                }})
                .build();
    }

    public static CampaignModel CampaignBOGOSmoke() {
        return new CampaignModel().toBuilder()
                .name("Smoke campaign with BOGO promotion")
                .startDate(new DateTime(2018, 5, 2, 0, 0, 0, 0))
                .endDate(new DateTime(2018, 5, 29, 0, 0, 0, 0))
                .discounts(new ArrayList<DiscountModel>() {{
                    add(DiscountModel.DiscountBOGOSmoke());
                }})
                .build();
    }

    public static CampaignModel EditDiscountsCampaignOrigin() {
        return new CampaignModel().toBuilder()
                .name("Discounts should be changed")
                .startDate(new DateTime(2018, 5, 11, 0, 0, 0, 0))
                .endDate(new DateTime(2018, 5, 16, 0, 0, 0, 0))
                .discounts(new ArrayList<DiscountModel>() {{
                    add(DiscountModel.DiscountOFFSmoke());
                }})
                .build();
    }

    public static CampaignModel EditDiscountsCampaignEdited() {
        return new CampaignModel().toBuilder()
                .name("Discounts should be changed")
                .startDate(new DateTime(2018, 5, 11, 0, 0, 0, 0))
                .endDate(new DateTime(2018, 5, 16, 0, 0, 0, 0))
                .discounts(new ArrayList<DiscountModel>() {{
                    add(DiscountModel.DiscountBOGOSmoke());
                }})
                .build();
    }

    public static CampaignModel CampaignOFFSmoke() {
        return new CampaignModel().toBuilder()
                .name("Smoke campaign with Percent OFF promotion")
                .startDate(new DateTime(2018, 5, 3, 0, 0, 0, 0))
                .endDate(new DateTime(2018, 5, 27, 0, 0, 0, 0))
                .discounts(new ArrayList<DiscountModel>() {{
                    add(DiscountModel.DiscountOFFSmoke());
                }})
                .build();
    }

    public static CampaignModel CampaignOFFBOGOSmoke() {
        return new CampaignModel().toBuilder()
                .name("Smoke campaign with %OFF and BOGO promotions")
                .startDate(new DateTime(2018, 5, 4, 0, 0, 0, 0))
                .endDate(new DateTime(2018, 5, 17, 0, 0, 0, 0))
                .discounts(new ArrayList<DiscountModel>() {{
                    add(DiscountModel.DiscountOFFSmoke());
                    add(DiscountModel.DiscountBOGOSmoke());
                }})
                .build();
    }

    public static CampaignModel CampaignDateTimeTest() {
        return new CampaignModel().toBuilder()
                .name("Campaign with time")
                .startDate(new DateTime(2018, 4, 4, 0, 0, 0, 0))
                .endDate(new DateTime(2019, 6, 17, 0, 0, 0, 0))
                .discounts(new ArrayList<DiscountModel>() {{
                    add(DiscountModel.DiscountOFFSmoke());
                    add(DiscountModel.DiscountBOGOSmoke());
                }})
                .build();
    }

    public static CampaignModel CampaignDeleteSmoke() {
        return new CampaignModel().toBuilder()
                .name("This campaign should be deleted")
                .startDate(new DateTime(2018, 5, 11, 0, 0, 0, 0))
                .endDate(new DateTime(2018, 5, 16, 0, 0, 0, 0))
                .discounts(new ArrayList<DiscountModel>() {{
                    add(DiscountModel.DiscountOFFSmoke());
                    add(DiscountModel.DiscountBOGOSmoke());
                }})
                .build();
    }

    public static CampaignModel EditNameCampaignOrigin() {
        return new CampaignModel().toBuilder()
                .name("This campaign should be renamed")
                .startDate(new DateTime(2018, 5, 11, 0, 0, 0, 0))
                .endDate(new DateTime(2018, 5, 16, 0, 0, 0, 0))
                .discounts(new ArrayList<DiscountModel>() {{
                    add(DiscountModel.DiscountOFFSmoke());
                    add(DiscountModel.DiscountBOGOSmoke());
                }})
                .build();
    }

    public static CampaignModel EditNameCampaignRenamed() {
        return new CampaignModel().toBuilder()
                .name("This campaign has been renamed")
                .startDate(new DateTime(2018, 5, 11, 0, 0, 0, 0))
                .endDate(new DateTime(2018, 5, 16, 0, 0, 0, 0))
                .discounts(new ArrayList<DiscountModel>() {{
                    add(DiscountModel.DiscountOFFSmoke());
                    add(DiscountModel.DiscountBOGOSmoke());
                }})
                .build();
    }

    public static CampaignModel EditDatesCampaignOrigin() {
        return new CampaignModel().toBuilder()
                .name("Campaign's dates should be changed")
                .startDate(new DateTime(2018, 5, 11, 0, 0, 0, 0))
                .endDate(new DateTime(2018, 5, 16, 0, 0, 0, 0))
                .discounts(new ArrayList<DiscountModel>() {{
                    add(DiscountModel.DiscountOFFSmoke());
                    add(DiscountModel.DiscountBOGOSmoke());
                }})
                .build();
    }

    public static CampaignModel EditDatesCampaignChanged() {
        return new CampaignModel().toBuilder()
                .name("Campaign's dates should be changed")
                .startDate(new DateTime(2018, 5, 2, 0, 0, 0, 0))
                .endDate(new DateTime(2018, 5, 18, 0, 0, 0, 0))
                .discounts(new ArrayList<DiscountModel>() {{
                    add(DiscountModel.DiscountOFFSmoke());
                    add(DiscountModel.DiscountBOGOSmoke());
                }})
                .build();
    }

    public static CampaignModel CampaignWithBOGOPromotion() {
        return new CampaignModel().toBuilder()
                .name("CampaignWithBOGOPromotion")
                .startDate(new DateTime(2018, 5, 11, 0, 0, 0, 0))
                .endDate(new DateTime(2018, 5, 16, 0, 0, 0, 0))
                .discounts(new ArrayList<DiscountModel>() {{
                    add(DiscountModel.DiscountBOGOOnlyCampaign());
                }})
                .build();
    }

    public static CampaignModel ValidationCheckCampaign() {
        return new CampaignModel().toBuilder()
                .name("")
                .startDate(new DateTime(2018, 5, 11, 0, 0, 0, 0))
                .endDate(new DateTime(2018, 5, 16, 0, 0, 0, 0))
                .discounts(new ArrayList<DiscountModel>() {{
                }})
                .build();
    }

    public static CampaignModel TestForecastCampaign() {
        return new CampaignModel().toBuilder()
                .name("ForecastTestCampaign")
                .startDate(new DateTime(2018, 5, 11, 0, 0, 0, 0))
                .endDate(new DateTime(2018, 5, 16, 0, 0, 0, 0))
                .discounts(new ArrayList<DiscountModel>() {{
                    add(DiscountModel.ForecastBOGODiscount());
                    add(DiscountModel.ForecastOFFDiscount());
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

    public static CampaignModel ProductionAdrianna() {
        return new CampaignModel().toBuilder()
                .name("Adrianna Papell Spring 2018")
                .startDate(new DateTime(2018, 5, 11, 0, 0, 0, 0))
                .endDate(new DateTime(2018, 5, 16, 0, 0, 0, 0))
                .discounts(new ArrayList<DiscountModel>() {{
                    add(DiscountModel.AdriannaPappell5PercentOFF());

                }})
                .build();
    }
    public static CampaignModel ProductionAdriannaExtended() {
        return new CampaignModel().toBuilder()
                .name("Adrianna Papell Spring 2018 Extended")
                .startDate(new DateTime(2018, 5, 11, 0, 0, 0, 0))
                .endDate(new DateTime(2018, 5, 16, 0, 0, 0, 0))
                .discounts(new ArrayList<DiscountModel>() {{
                    add(DiscountModel.AdriannaPappell5PercentOFF());
                }})
                .build();
    }

}



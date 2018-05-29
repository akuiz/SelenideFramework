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
                .name("at_Origin campaign, dates,discounts,name should be changed")
                .startDate(new DateTime(2018, 5, 2, 0, 0, 0, 0))
                .endDate(new DateTime(2018, 5, 29, 0, 0, 0, 0))
                .discounts(new ArrayList<DiscountModel>() {{
                    add(DiscountModel.DiscountBOGOSmoke());
                }})
                .build();
    }
    public static CampaignModel EditCampaignEdited() {
        return new CampaignModel().toBuilder()
                .name("at_Origin campaign, dates,discounts,name have been changed")
                .startDate(new DateTime(2018, 5, 4, 0, 0, 0, 0))
                .endDate(new DateTime(2018, 5, 25, 0, 0, 0, 0))
                .discounts(new ArrayList<DiscountModel>() {{
                    add(DiscountModel.DiscountOFFSmoke());
                }})
                .build();
    }

    public static CampaignModel CampaignBOGOSmoke() {
        return new CampaignModel().toBuilder()
                .name("at_Smoke campaign with BOGO discount")
                .startDate(new DateTime(2018, 5, 2, 0, 0, 0, 0))
                .endDate(new DateTime(2018, 5, 29, 0, 0, 0, 0))
                .discounts(new ArrayList<DiscountModel>() {{
                    add(DiscountModel.DiscountBOGOSmoke());
                }})
                .build();
    }

    public static CampaignModel EditDiscountsCampaignOrigin() {
        return new CampaignModel().toBuilder()
                .name("at_Discounts should be changed")
                .startDate(new DateTime(2018, 5, 11, 0, 0, 0, 0))
                .endDate(new DateTime(2018, 5, 16, 0, 0, 0, 0))
                .discounts(new ArrayList<DiscountModel>() {{
                    add(DiscountModel.DiscountOFFSmoke());
                }})
                .build();
    }

    public static CampaignModel EditDiscountsCampaignEdited() {
        return new CampaignModel().toBuilder()
                .name("at_Discounts should be changed")
                .startDate(new DateTime(2018, 5, 11, 0, 0, 0, 0))
                .endDate(new DateTime(2018, 5, 16, 0, 0, 0, 0))
                .discounts(new ArrayList<DiscountModel>() {{
                    add(DiscountModel.DiscountBOGOSmoke());
                }})
                .build();
    }

    public static CampaignModel CampaignOFFSmoke() {
        return new CampaignModel().toBuilder()
                .name("at_Smoke campaign with Percent OFF discount")
                .startDate(new DateTime(2018, 5, 3, 0, 0, 0, 0))
                .endDate(new DateTime(2018, 5, 27, 0, 0, 0, 0))
                .discounts(new ArrayList<DiscountModel>() {{
                    add(DiscountModel.DiscountOFFSmoke());
                }})
                .build();
    }

    public static CampaignModel CampaignOFFBOGOSmoke() {
        return new CampaignModel().toBuilder()
                .name("at_Smoke campaign with %OFF and BOGO discounts")
                .startDate(new DateTime(2018, 5, 4, 0, 0, 0, 0))
                .endDate(new DateTime(2018, 5, 17, 0, 0, 0, 0))
                .discounts(new ArrayList<DiscountModel>() {{
                    add(DiscountModel.DiscountOFFSmoke());
                    add(DiscountModel.DiscountBOGOSmoke());
                }})
                .build();
    }

    public static CampaignModel CampaignFuture() {
        return new CampaignModel().toBuilder()
                .name("at_Campaign with future dates")
                .startDate(new DateTime(2018, 10, 23, 0, 0, 0, 0))
                .endDate(new DateTime(2018, 11, 26, 0, 0, 0, 0))
                .discounts(new ArrayList<DiscountModel>() {{
                    add(DiscountModel.DiscountOFFSmoke());
                    add(DiscountModel.DiscountBOGOSmoke());
                }})
                .build();
    }

    public static CampaignModel CampaignPast() {
        return new CampaignModel().toBuilder()
                .name("at_Campaign with past dates")
                .startDate(new DateTime(2018, 2, 23, 0, 0, 0, 0))
                .endDate(new DateTime(2018, 3, 26, 0, 0, 0, 0))
                .discounts(new ArrayList<DiscountModel>() {{
                    add(DiscountModel.DiscountOFFSmoke());
                    add(DiscountModel.DiscountBOGOSmoke());
                }})
                .build();
    }

    public static CampaignModel CampaignOneDay() {
        return new CampaignModel().toBuilder()
                .name("at_Campaign one day duration")
                .startDate(new DateTime(2018, 6, 23, 0, 0, 0, 0))
                .endDate(new DateTime(2018, 6, 23, 0, 0, 0, 0))
                .discounts(new ArrayList<DiscountModel>() {{
                    add(DiscountModel.DiscountOFFSmoke());
                    add(DiscountModel.DiscountBOGOSmoke());
                }})
                .build();
    }

    public static CampaignModel CampaignDateTimeTest() {
        return new CampaignModel().toBuilder()
                .name("at_Campaign with time")
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
                .name("at_This campaign should be deleted")
                .startDate(new DateTime(2018, 5, 11, 0, 0, 0, 0))
                .endDate(new DateTime(2018, 5, 16, 0, 0, 0, 0))
                .discounts(new ArrayList<DiscountModel>() {{
                    add(DiscountModel.DiscountOFFSmoke());
                    add(DiscountModel.DiscountBOGOSmoke());
                }})
                .build();
    }

    public static CampaignModel CampaignSimplePrediction() {
        return new CampaignModel().toBuilder()
                .name("at_This campaign is for checkign campaign prediction")
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
                .name("at_This campaign should be renamed")
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
                .name("at_This campaign has been renamed")
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
                .name("at_Campaign's dates should be changed")
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
                .name("at_Campaign's dates should be changed")
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
                .name("at_CampaignWithBOGOPromotion")
                .startDate(new DateTime(2018, 5, 11, 0, 0, 0, 0))
                .endDate(new DateTime(2018, 5, 16, 0, 0, 0, 0))
                .discounts(new ArrayList<DiscountModel>() {{
                    add(DiscountModel.DiscountBOGOOnlyCampaign());
                }})
                .build();
    }

    public static CampaignModel CampaignWithNoDiscounts() {
        return new CampaignModel().toBuilder()
                .name("at_Campaign with no discounts")
                .startDate(new DateTime(2018, 5, 11, 0, 0, 0, 0))
                .endDate(new DateTime(2018, 5, 16, 0, 0, 0, 0))
                .discounts(new ArrayList<DiscountModel>() {{
                }})
                .build();
    }

    public static CampaignModel CampaignWithEmptyName() {
        return new CampaignModel().toBuilder()
                .name("")
                .startDate(new DateTime(2018, 5, 11, 0, 0, 0, 0))
                .endDate(new DateTime(2018, 5, 16, 0, 0, 0, 0))
                .discounts(new ArrayList<DiscountModel>() {{
                    add(DiscountModel.DiscountOFFSmoke());
                }})
                .build();
    }

    public static CampaignModel TestForecastCampaign() {
        return new CampaignModel().toBuilder()
                .name("at_ForecastTestCampaign")
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
                .name("at_Adrianna Papell Spring 2018")
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
                .name("at_IssueCampaign")
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
                .name("at_Test2Promo")
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
                .name("at_Adrianna Papell Spring 2018")
                .startDate(new DateTime(2018, 5, 11, 0, 0, 0, 0))
                .endDate(new DateTime(2018, 5, 16, 0, 0, 0, 0))
                .discounts(new ArrayList<DiscountModel>() {{
                    add(DiscountModel.AdriannaPappell5PercentOFF());

                }})
                .build();
    }

    public static CampaignModel ProductionAdriannaExtended() {
        return new CampaignModel().toBuilder()
                .name("at_Adrianna Papell Spring 2018 Extended")
                .startDate(new DateTime(2018, 5, 11, 0, 0, 0, 0))
                .endDate(new DateTime(2018, 5, 16, 0, 0, 0, 0))
                .discounts(new ArrayList<DiscountModel>() {{
                    add(DiscountModel.AdriannaPappell5PercentOFF());
                }})
                .build();
    }

    public static CampaignModel CalvinKleinJune2018Dresses5() {
        return new CampaignModel().toBuilder()
                .name("Calvin Klein June 2018 Special Offer 5% All Dresses")
                .startDate(new DateTime(2018, 6, 1, 0, 0, 0, 0))
                .endDate(new DateTime(2018, 6, 30, 0, 0, 0, 0))
                .discounts(new ArrayList<DiscountModel>() {{
                    add(DiscountModel.CalvinKleinOFF5());
                }})
                .build();
    }

    public static CampaignModel CalvinKleinJune2018Dresses7() {
        return new CampaignModel().toBuilder()
                .name("Calvin Klein June 2018 Special Offer 7% All Dresses")
                .startDate(new DateTime(2018, 6, 1, 0, 0, 0, 0))
                .endDate(new DateTime(2018, 6, 30, 0, 0, 0, 0))
                .discounts(new ArrayList<DiscountModel>() {{
                    add(DiscountModel.CalvinKleinOFF7());
                }})
                .build();
    }

    public static CampaignModel CalvinKleinJune2018Dresses10() {
        return new CampaignModel().toBuilder()
                .name("Calvin Klein June 2018 Special Offer 10% All Dresses")
                .startDate(new DateTime(2018, 6, 1, 0, 0, 0, 0))
                .endDate(new DateTime(2018, 6, 30, 0, 0, 0, 0))
                .discounts(new ArrayList<DiscountModel>() {{
                    add(DiscountModel.CalvinKleinOFF10());
                }})
                .build();
    }

    public static CampaignModel AdriannaPapellSpring2018() {
        return new CampaignModel().toBuilder()
                .name("Adrianna Papell Spring 2018")
                .startDate(new DateTime(2018, 5, 11, 0, 0, 0, 0))
                .endDate(new DateTime(2018, 5, 31, 0, 0, 0, 0))
                .discounts(new ArrayList<DiscountModel>() {{
                    add(DiscountModel.AdriannaPapellOFF5());
                }})
                .build();
    }

    public static CampaignModel AdriannaPapellSpringExtended2018() {
        return new CampaignModel().toBuilder()
                .name("Adrianna Papell Spring 2018 Extended")
                .startDate(new DateTime(2018, 5, 11, 0, 0, 0, 0))
                .endDate(new DateTime(2018, 6, 9, 0, 0, 0, 0))
                .discounts(new ArrayList<DiscountModel>() {{
                    add(DiscountModel.AdriannaPapellOFF5());
                }})
                .build();
    }

    public static CampaignModel FreePeopleJuly2018() {
        return new CampaignModel().toBuilder()
                .name("Free People 4th July 2018")
                .startDate(new DateTime(2018, 6, 30, 0, 0, 0, 0))
                .endDate(new DateTime(2018, 7, 4, 0, 0, 0, 0))
                .discounts(new ArrayList<DiscountModel>() {{
                    add(DiscountModel.FreePeopleOFF10());
                }})
                .build();
    }

    public static CampaignModel FreePeopleJuly2018BOGO() {
        return new CampaignModel().toBuilder()
                .name("Free People 4th July 2018 BOGO")
                .startDate(new DateTime(2018, 7, 2, 0, 0, 0, 0))
                .endDate(new DateTime(2018, 7, 3, 0, 0, 0, 0))
                .discounts(new ArrayList<DiscountModel>() {{
                    add(DiscountModel.FreePeopleBOGO());
                }})
                .build();
    }

    public static CampaignModel CampaignOFFForecast() {
        return new CampaignModel().toBuilder()
                .name("at_Campaign for forecast with OFF discount")
                .startDate(new DateTime(2018, 5, 2, 0, 0, 0, 0))
                .endDate(new DateTime(2018, 5, 29, 0, 0, 0, 0))
                .discounts(new ArrayList<DiscountModel>() {{
                    add(DiscountModel.DiscountCampaignOFF());
                }})
                .build();
    }

    public static CampaignModel CampaignBOGOForecast() {
        return new CampaignModel().toBuilder()
                .name("at_Campaign for forecast with BOGO discount")
                .startDate(new DateTime(2018, 5, 2, 0, 0, 0, 0))
                .endDate(new DateTime(2018, 5, 29, 0, 0, 0, 0))
                .discounts(new ArrayList<DiscountModel>() {{
                    add(DiscountModel.DiscountCampaignBOGO());
                }})
                .build();
    }

    public static CampaignModel CampaignOFFBOGOForecast() {
        return new CampaignModel().toBuilder()
                .name("at_Campaign for forecast with BOGO and OFF discount")
                .startDate(new DateTime(2018, 5, 2, 0, 0, 0, 0))
                .endDate(new DateTime(2018, 5, 29, 0, 0, 0, 0))
                .discounts(new ArrayList<DiscountModel>() {{
                    add(DiscountModel.DiscountCampaignBOGO());
                    add(DiscountModel.DiscountCampaignOFF());
                }})
                .build();
    }
}



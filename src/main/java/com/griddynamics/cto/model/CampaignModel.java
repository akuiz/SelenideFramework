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
                .startDate(DateTime.now().plusDays(3))
                .endDate(DateTime.now().plusDays(7))
                .discounts(new ArrayList<DiscountModel>() {{
                    add(DiscountModel.DiscountBOGOSmoke());
                }})
                .build();
    }
    public static CampaignModel EditCampaignEdited() {
        return new CampaignModel().toBuilder()
                .name("at_Origin campaign, dates,discounts,name have been changed")
                .startDate(DateTime.now().minusDays(3))
                .endDate(DateTime.now().plusDays(9))
                .discounts(new ArrayList<DiscountModel>() {{
                    add(DiscountModel.DiscountOFFSmoke());
                }})
                .build();
    }

    public static CampaignModel CampaignBOGOSmoke() {
        return new CampaignModel().toBuilder()
                .name("at_Smoke campaign with BOGO discount")
                .startDate(DateTime.now().minusDays(2))
                .endDate(DateTime.now().plus(4))
                .discounts(new ArrayList<DiscountModel>() {{
                    add(DiscountModel.DiscountBOGOSmoke());
                }})
                .build();
    }

    public static CampaignModel EditDiscountsCampaignOrigin() {
        return new CampaignModel().toBuilder()
                .name("at_Discounts should be changed")
                .startDate(DateTime.now().plusDays(3))
                .endDate(DateTime.now().plusDays(7))
                .discounts(new ArrayList<DiscountModel>() {{
                    add(DiscountModel.DiscountOFFSmoke());
                }})
                .build();
    }

    public static CampaignModel EditDiscountsCampaignEdited() {
        return new CampaignModel().toBuilder()
                .name("at_Discounts should be changed")
                .startDate(DateTime.now().plusDays(3))
                .endDate(DateTime.now().plusDays(7))
                .discounts(new ArrayList<DiscountModel>() {{
                    add(DiscountModel.DiscountBOGOSmoke());
                }})
                .build();
    }

    public static CampaignModel CampaignOFFSmoke() {
        return new CampaignModel().toBuilder()
                .name("at_Smoke campaign with Percent OFF discount")
                .startDate(DateTime.now().minusDays(2))
                .endDate(DateTime.now().plus(4))
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
                .startDate(DateTime.now().plusMonths(3).plusDays(4))
                .endDate(DateTime.now().plusMonths(4).plusDays(6))
                .discounts(new ArrayList<DiscountModel>() {{
                    add(DiscountModel.DiscountOFFSmoke());
                    add(DiscountModel.DiscountBOGOSmoke());
                }})
                .build();
    }

    public static CampaignModel CampaignPast() {
        return new CampaignModel().toBuilder()
                .name("at_Campaign with past dates")
                .startDate(DateTime.now().minusMonths(4).minusDays(2))
                .endDate(DateTime.now().minusMonths(2).minusDays(1))
                .discounts(new ArrayList<DiscountModel>() {{
                    add(DiscountModel.DiscountOFFSmoke());
                    add(DiscountModel.DiscountBOGOSmoke());
                }})
                .build();
    }

    public static CampaignModel CampaignOneDay() {
        return new CampaignModel().toBuilder()
                .name("at_Campaign one day duration")
                .startDate(DateTime.now())
                .endDate(DateTime.now())
                .discounts(new ArrayList<DiscountModel>() {{
                    add(DiscountModel.DiscountOFFSmoke());
                    add(DiscountModel.DiscountBOGOSmoke());
                }})
                .build();
    }

    public static CampaignModel CampaignDeleteSmoke() {
        return new CampaignModel().toBuilder()
                .name("at_This campaign should be deleted")
                .startDate(DateTime.now().plusDays(2))
                .endDate(DateTime.now().plusDays(3))
                .discounts(new ArrayList<DiscountModel>() {{
                    add(DiscountModel.DiscountOFFSmoke());
                    add(DiscountModel.DiscountBOGOSmoke());
                }})
                .build();
    }

    public static CampaignModel EditNameCampaignOrigin() {
        return new CampaignModel().toBuilder()
                .name("at_This campaign should be renamed")
                .startDate(DateTime.now().minusDays(2))
                .endDate(DateTime.now().plus(4))
                .discounts(new ArrayList<DiscountModel>() {{
                    add(DiscountModel.DiscountOFFSmoke());
                    add(DiscountModel.DiscountBOGOSmoke());
                }})
                .build();
    }

    public static CampaignModel EditNameCampaignRenamed() {
        return new CampaignModel().toBuilder()
                .name("at_This campaign has been renamed")
                .startDate(DateTime.now().minusDays(2))
                .endDate(DateTime.now().plus(4))
                .discounts(new ArrayList<DiscountModel>() {{
                    add(DiscountModel.DiscountOFFSmoke());
                    add(DiscountModel.DiscountBOGOSmoke());
                }})
                .build();
    }

    public static CampaignModel EditDatesCampaignOrigin() {
        return new CampaignModel().toBuilder()
                .name("at_Campaign's dates should be changed")
                .startDate(DateTime.now().plusDays(4))
                .endDate(DateTime.now().plusDays(7))
                .discounts(new ArrayList<DiscountModel>() {{
                    add(DiscountModel.DiscountOFFSmoke());
                    add(DiscountModel.DiscountBOGOSmoke());
                }})
                .build();
    }

    public static CampaignModel EditDatesCampaignChanged() {
        return new CampaignModel().toBuilder()
                .name("at_Campaign's dates have been changed")
                .startDate(DateTime.now().plusMonths(2))
                .endDate(DateTime.now().plusMonths(2).plusDays(4))
                .discounts(new ArrayList<DiscountModel>() {{
                    add(DiscountModel.DiscountOFFSmoke());
                    add(DiscountModel.DiscountBOGOSmoke());
                }})
                .build();
    }

    public static CampaignModel CampaignWithNoDiscounts() {
        return new CampaignModel().toBuilder()
                .name("at_Campaign with no discounts")
                .startDate(DateTime.now().minusDays(2))
                .endDate(DateTime.now().plus(4))
                .discounts(new ArrayList<DiscountModel>() {{
                }})
                .build();
    }

    public static CampaignModel CampaignWithEmptyName() {
        return new CampaignModel().toBuilder()
                .name("")
                .startDate(DateTime.now().minusDays(2))
                .endDate(DateTime.now().plus(4))
                .discounts(new ArrayList<DiscountModel>() {{
                    add(DiscountModel.DiscountOFFSmoke());
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

    public static CampaignModel ForecastPredictionCampaign() {
        return new CampaignModel().toBuilder()
                .name("at_Campaign should have same prediction and forecast for some date")
                .startDate(new DateTime(2018, 6, 4, 0, 0, 0, 0))
                .endDate(new DateTime(2018, 6, 15, 0, 0, 0, 0))
                .discounts(new ArrayList<DiscountModel>() {{
                    add(DiscountModel.DiscountCampaignBOGO());
                    add(DiscountModel.DiscountCampaignOFF());
                }})
                .build();
    }
}



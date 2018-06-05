import com.griddynamics.cto.CampaignPageObject;
import com.griddynamics.cto.MainPage;
import com.griddynamics.cto.ManageCampaignsPageObject;
import com.griddynamics.cto.configuration.Configuration;
import com.griddynamics.cto.configuration.EnvironmentConfig;
import com.griddynamics.cto.data.PromotionDataManager;
import com.griddynamics.cto.model.CampaignModel;
import com.griddynamics.cto.model.PredictionModel;
import com.griddynamics.cto.model.PromotionModel;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class CampaignTest {

    private static final EnvironmentConfig environmentConfig = Configuration.INSTANCE.getEnvironmentConfig();

    @BeforeGroups(groups = "campaign_smoke")
    public void setUpPromotions(){
        PromotionDataManager.PreparePromotions(environmentConfig.url(), PromotionModel.PromotionOFFCampaign(), PromotionModel.PromotionBOGOCampaign());
    }

    @Test(description = "Add campaign with BOGO promotion", groups = {"campaign_smoke", "add_campaign"})
    public void addCamapaignWithBOGOPromotion() {
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        ManageCampaignsPageObject campaignsPage = mainPage.navigateToManageCampaignsPage();
        campaignsPage.addCampaign(CampaignModel.CampaignBOGOSmoke());
        campaignsPage.checkCampaignExists(CampaignModel.CampaignBOGOSmoke());
    }

    @Test(description = "Add campaign with OFF promotion", groups = {"campaign_smoke", "add_campaign"})
    public void addCamapaignWithOFFPromotion() {
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        ManageCampaignsPageObject campaignsPage = mainPage.navigateToManageCampaignsPage();
        campaignsPage.addCampaignSecondButton(CampaignModel.CampaignOFFSmoke());
        campaignsPage.checkCampaignExists(CampaignModel.CampaignOFFSmoke());
    }

    @Test(description = "Add campaign with BOGO and %OFF promotions", groups = {"campaign_smoke", "add_campaign"})
    public void addCampaign() {
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        ManageCampaignsPageObject campaignsPage = mainPage.navigateToManageCampaignsPage();
        campaignsPage.addCampaign(CampaignModel.CampaignOFFBOGOSmoke());
        campaignsPage.checkCampaignExists(CampaignModel.CampaignOFFBOGOSmoke());
    }

    @Test(description = "Add campaign with future dates", groups = {"campaign_smoke"})
    public void addFutureCampaign() {
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        ManageCampaignsPageObject campaignsPage = mainPage.navigateToManageCampaignsPage();
        campaignsPage.addCampaign(CampaignModel.CampaignFuture());
        campaignsPage.checkCampaignExists(CampaignModel.CampaignFuture());
    }

    @Test(description = "Add campaign with past dates", groups = {"campaign_smoke"})
    public void addPastCampaignTest() {
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        ManageCampaignsPageObject campaignsPage = mainPage.navigateToManageCampaignsPage();
        campaignsPage.addCampaign(CampaignModel.CampaignPast());
        campaignsPage.checkCampaignExists(CampaignModel.CampaignPast());
    }

    @Test(description = "Add campaign with past dates", groups = {"campaign_smoke"})
    public void addOneDayCampaign() {
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        ManageCampaignsPageObject campaignsPage = mainPage.navigateToManageCampaignsPage();
        campaignsPage.addCampaign(CampaignModel.CampaignOneDay());
        campaignsPage.checkCampaignExists(CampaignModel.CampaignOneDay());
    }

    @Test(description = "Remove campaign test", groups = {"campaign_smoke"}, dependsOnMethods = {"addCampaign"})
    public void deleteCampaignTest() {
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        ManageCampaignsPageObject campaignsPage = mainPage.navigateToManageCampaignsPage();
        campaignsPage.addCampaign(CampaignModel.CampaignDeleteSmoke());
        campaignsPage.deleteCampaignByName(CampaignModel.CampaignDeleteSmoke().getName());
        campaignsPage.checkCampaingNotExists(CampaignModel.CampaignDeleteSmoke().getName());
    }

    @Test(description = "Add campaign with empty name", groups = {"campaign_smoke"})
    public void addCampaignWithEmptyName() {
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        ManageCampaignsPageObject campaignsPage = mainPage.navigateToManageCampaignsPage();
        campaignsPage.addCampaignWithEmptyName(CampaignModel.CampaignWithEmptyName());
    }

    @Test(description = "Campaign with no discounts should not be added", groups = {"campaign_smoke"})
    public void addCampaignValidationTest() {
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        ManageCampaignsPageObject campaignsPage = mainPage.navigateToManageCampaignsPage();
        campaignsPage.addCampaignWithNoDiscounts(CampaignModel.CampaignWithNoDiscounts());
    }

    @Test(description = "Check Campaign Prediction", dependsOnMethods = {"addCampaign"}, groups = {"campaign_smoke"})
    public void checkPrediction() {
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        ManageCampaignsPageObject campaignsPage = mainPage.navigateToManageCampaignsPage();
        campaignsPage.addCampaign(CampaignModel.CampaignOFFBOGOSmoke());
        CampaignPageObject campaign = campaignsPage.getCampaign(CampaignModel.CampaignOFFBOGOSmoke().getName());
        campaign.checkPrediction(PredictionModel.CampaignOFFBOGOSmoke());
    }

    @Test(description = "Edit campaign name test", dependsOnMethods = {"addCampaign"}, groups = {"campaign_smoke"})
    public void editCampaignNameTest() {
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        ManageCampaignsPageObject campaignsPage = mainPage.navigateToManageCampaignsPage();
        campaignsPage.addCampaign(CampaignModel.EditNameCampaignOrigin());
        campaignsPage.changeCampaignName(CampaignModel.EditNameCampaignOrigin(), CampaignModel.EditNameCampaignRenamed().getName());
        campaignsPage.checkCampaignExists(CampaignModel.EditNameCampaignRenamed());
        campaignsPage.deleteCampaignByName(CampaignModel.EditNameCampaignRenamed().getName());
    }

    @Test(description = "Edit campaign dates test", groups = {"campaign_smoke"})
    public void editCampaignDatesTest() {
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        ManageCampaignsPageObject campaignsPage = mainPage.navigateToManageCampaignsPage();
        campaignsPage.addCampaign(CampaignModel.EditDatesCampaignOrigin());
        campaignsPage.changeCampaignDates(CampaignModel.EditDatesCampaignOrigin(), CampaignModel.EditDatesCampaignChanged().getStartDate(), CampaignModel.EditDatesCampaignChanged().getEndDate());
        campaignsPage.checkCampaignExists(CampaignModel.EditDatesCampaignChanged());
        campaignsPage.deleteCampaignByName(CampaignModel.EditDatesCampaignChanged().getName());
    }

    @Test(description = "Edit campaign discounts test", groups = {"campaign_smoke"})
    public void editCampaignDiscountsTest() {
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        ManageCampaignsPageObject campaignsPage = mainPage.navigateToManageCampaignsPage();
        campaignsPage.addCampaign(CampaignModel.EditDiscountsCampaignOrigin());
        campaignsPage.changeCampaignDiscounts(CampaignModel.EditDiscountsCampaignOrigin(), CampaignModel.EditDiscountsCampaignEdited().getDiscounts());
        campaignsPage.checkCampaignExists(CampaignModel.EditDiscountsCampaignEdited());
        campaignsPage.deleteCampaignByName(CampaignModel.EditDiscountsCampaignEdited().getName());
    }

    @Test(description = "Edit campaign's name,dates,discounts", groups = {"campaign_smoke"})
    public void editCampaignTest() {
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        ManageCampaignsPageObject campaignsPage = mainPage.navigateToManageCampaignsPage();
        campaignsPage.addCampaign(CampaignModel.EditCampaignOrigin());
        campaignsPage.editCampaign(CampaignModel.EditCampaignOrigin(), CampaignModel.EditCampaignEdited());
        campaignsPage.checkCampaignExists(CampaignModel.EditCampaignEdited());
        campaignsPage.deleteCampaignByName(CampaignModel.EditCampaignEdited().getName());
    }

    @Test(description = "Check startDate/endDate datePicker validation", groups={"campaign_smoke"})
    public void campaignDatePickerTest() {
        MainPage mainPage = open("http://35.196.70.251:4200", MainPage.class);
        ManageCampaignsPageObject campaignsPage = mainPage.navigateToManageCampaignsPage();
        campaignsPage.checkCampaignDatePicker();
    }

    @Test(description = "Check pre-created campaigns", groups = {"production", "production_read_only"}, priority = 1)
    public void precreatedCampaignsCheck() {
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        ManageCampaignsPageObject campaignsPage = mainPage.navigateToManageCampaignsPage();
        campaignsPage.checkNumberOfCampaigns(7);
        campaignsPage.checkCampaignExists(CampaignModel.CalvinKleinJune2018Dresses5());
        campaignsPage.checkCampaignExists(CampaignModel.CalvinKleinJune2018Dresses7());
        campaignsPage.checkCampaignExists(CampaignModel.CalvinKleinJune2018Dresses10());
        campaignsPage.checkCampaignExists(CampaignModel.AdriannaPapellSpring2018());
        campaignsPage.checkCampaignExists(CampaignModel.AdriannaPapellSpringExtended2018());
        campaignsPage.checkCampaignExists(CampaignModel.FreePeopleJuly2018());
        campaignsPage.checkCampaignExists(CampaignModel.FreePeopleJuly2018BOGO());
    }

    @Test(description = "Check prediction of Calvin Klein 5% campaign", groups = {"production", "production_read_only"}, priority = 2)
    public void checkPredictionKlein5() {
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        ManageCampaignsPageObject campaignsPage = mainPage.navigateToManageCampaignsPage();
        CampaignPageObject campaign = campaignsPage.getCampaign(CampaignModel.CalvinKleinJune2018Dresses5().getName());
        campaign.checkPrediction(PredictionModel.CalvinKleinJune2018Dresses5());
    }

    @Test(description = "Check prediction of Calvin Klein 7% campaign", groups = {"production", "production_read_only"}, priority = 2)
    public void checkCampaignPredictionKlein7() {
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        ManageCampaignsPageObject campaignsPage = mainPage.navigateToManageCampaignsPage();
        CampaignPageObject campaign = campaignsPage.getCampaign(CampaignModel.CalvinKleinJune2018Dresses7().getName());
        campaign.checkPrediction(PredictionModel.CalvinKleinJune2018Dresses7());
    }

    @Test(description = "Check prediction of Calvin Klein 10% campaign", groups = {"production", "production_read_only"}, priority = 2)
    public void checkCampaignPredictionKlein10() {
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        ManageCampaignsPageObject campaignsPage = mainPage.navigateToManageCampaignsPage();
        CampaignPageObject campaign = campaignsPage.getCampaign(CampaignModel.CalvinKleinJune2018Dresses10().getName());
        campaign.checkPrediction(PredictionModel.CalvinKleinJune2018Dresses10());
    }

    @Test(description = "Check prediction of AdriannaPapellSpring2018 campaign", groups = {"production", "production_read_only"}, priority = 2)
    public void checkCampaignPredictionAdrianna() {
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        ManageCampaignsPageObject campaignsPage = mainPage.navigateToManageCampaignsPage();
        CampaignPageObject campaign = campaignsPage.getCampaign(CampaignModel.AdriannaPapellSpring2018().getName());
        campaign.checkPrediction(PredictionModel.AdriannaPapellSpring2018());
    }

    @Test(description = "Check prediction of AdriannaPapellSpring2018 Extended campaign", groups = {"production", "production_read_only"}, priority = 2)
    public void checkCampaignPredictionAdriannaExtended() {
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        ManageCampaignsPageObject campaignsPage = mainPage.navigateToManageCampaignsPage();
        CampaignPageObject campaign = campaignsPage.getCampaign(CampaignModel.AdriannaPapellSpringExtended2018().getName());
        campaign.checkPrediction(PredictionModel.AdriannaPapellSpringExtended2018());
    }

    @Test(description = "Check prediction of Free People July 2018 campaign", groups = {"production", "production_read_only"}, priority = 2)
    public void checkCampaignPredictionFreePeople() {
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        ManageCampaignsPageObject campaignsPage = mainPage.navigateToManageCampaignsPage();
        CampaignPageObject campaign = campaignsPage.getCampaign(CampaignModel.FreePeopleJuly2018().getName());
        campaign.checkPrediction(PredictionModel.FreePeopleJuly2018());
    }

    @Test(description = "Check prediction of Free People July 2018 BOGO campaign", groups = {"production", "production_read_only"}, priority = 2)
    public void checkCampaignPredictionFreePeopleBOGO() {
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        ManageCampaignsPageObject campaignsPage = mainPage.navigateToManageCampaignsPage();
        CampaignPageObject campaign = campaignsPage.getCampaign(CampaignModel.FreePeopleJuly2018BOGO().getName());
        campaign.checkPrediction(PredictionModel.FreePeopleJuly2018BOGO());
    }
}

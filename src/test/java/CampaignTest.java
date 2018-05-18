import com.griddynamics.cto.*;
import com.griddynamics.cto.configuration.Configuration;
import com.griddynamics.cto.configuration.EnvironmentConfig;
import com.griddynamics.cto.model.CampaignModel;
import com.griddynamics.cto.model.OfferModel;
import com.griddynamics.cto.model.PredictionModel;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class CampaignTest {

    private static final EnvironmentConfig environmentConfig = Configuration.INSTANCE.getEnvironmentConfig();

    @Test(description = "Add campaign with BOGO promotion", dependsOnGroups = {"promotion_smoke"}, groups = {"campaign_smoke"})
    public void addCamapaignWithBOGOPromotion() {
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        ManageCampaignsPageObject campaignsPage = mainPage.navigateToManageCampaignsPage();
        campaignsPage.addCampaign(CampaignModel.CampaignBOGOSmoke());
    }

    @Test(description = "Add campaign BOGO promotion", dependsOnGroups = {"promotion_smoke"}, groups = {"campaign_smoke"})
    public void addCamapaignWithOFFPromotion() {
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        ManageCampaignsPageObject campaignsPage = mainPage.navigateToManageCampaignsPage();
        campaignsPage.addCampaign(CampaignModel.CampaignOFFSmoke());
    }

    @Test(description = "Add campaign with BOGO and %OFF promotions", dependsOnGroups = {"promotion_smoke"}, groups = {"campaign_smoke"})
    public void addCampaign() {
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        ManageCampaignsPageObject campaignsPage = mainPage.navigateToManageCampaignsPage();
        campaignsPage.addCampaign(CampaignModel.CampaignOFFBOGOSmoke());
    }

    @Test(description = "Remove campaign test", dependsOnGroups = {"promotion_smoke"}, groups = {"campaign_smoke"}, dependsOnMethods = {"addCampaign"})
    public void deleteCampaignTest() {
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        ManageCampaignsPageObject campaignsPage = mainPage.navigateToManageCampaignsPage();
        campaignsPage.addCampaign(CampaignModel.CampaignDeleteSmoke());
        campaignsPage.deleteCampaignByName(CampaignModel.CampaignDeleteSmoke().getName());
    }

    @Test(description = "Campaign with empty name and no promotions should not be added", groups = {"campaign_smoke"})
    public void addCampaignValidationTest() {
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        ManageCampaignsPageObject campaignsPage = mainPage.navigateToManageCampaignsPage();
        campaignsPage.addCampaignValidationCheck(CampaignModel.ValidationCheckCampaign());
    }

    @Test(description = "Check Campaign Prediction", dependsOnMethods = {"addCampaign"}, groups = {"campaign_smoke"})
    public void checkPrediction() {
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        ManageCampaignsPageObject campaignsPage = mainPage.navigateToManageCampaignsPage();
        CampaignPageObject campaign = campaignsPage.getCampaignByName(CampaignModel.CampaignOFFBOGOSmoke().getName());
        campaign.checkPrediction(PredictionModel.Test2PromotPrediction());
    }

    @Test(description = "Edit campaign name test", dependsOnGroups = {"promotion_smoke"}, dependsOnMethods = {"addCampaign"}, groups = {"campaign_smoke"})
    public void editCampaignNameTest() {
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        ManageCampaignsPageObject campaignsPage = mainPage.navigateToManageCampaignsPage();
        campaignsPage.addCampaign(CampaignModel.EditNameCampaignOrigin());
        campaignsPage.changeCampaignName(CampaignModel.EditNameCampaignOrigin(), CampaignModel.EditNameCampaignRenamed().getName());
        campaignsPage.checkCampaignExists(CampaignModel.EditNameCampaignRenamed());
        campaignsPage.deleteCampaignByName(CampaignModel.EditNameCampaignRenamed().getName());
    }

    @Test(description = "Edit campaign dates test", dependsOnGroups = {"promotion_smoke"}, dependsOnMethods = {"addCampaign"}, groups = {"campaign_smoke"})
    public void editCampaignDatesTest() {
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        ManageCampaignsPageObject campaignsPage = mainPage.navigateToManageCampaignsPage();
        campaignsPage.addCampaign(CampaignModel.EditDatesCampaignOrigin());
        campaignsPage.changeCampaignDates(CampaignModel.EditDatesCampaignOrigin(), CampaignModel.EditDatesCampaignChanged().getStartDate(), CampaignModel.EditDatesCampaignChanged().getEndDate());
        campaignsPage.checkCampaignExists(CampaignModel.EditDatesCampaignChanged());
        campaignsPage.deleteCampaignByName(CampaignModel.EditDatesCampaignChanged().getName());
    }

    @Test(description = "Edit campaign discounts test", dependsOnGroups = {"promotion_smoke"}, dependsOnMethods = {"addCampaign"}, groups = {"campaign_smoke"})
    public void editCampaignDiscountsTest() {
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        ManageCampaignsPageObject campaignsPage = mainPage.navigateToManageCampaignsPage();
        campaignsPage.addCampaign(CampaignModel.EditDiscountsCampaignOrigin());
        campaignsPage.changeCampaignDiscounts(CampaignModel.EditDiscountsCampaignOrigin(), CampaignModel.EditDiscountsCampaignEdited().getDiscounts());
        campaignsPage.checkCampaignExists(CampaignModel.EditDiscountsCampaignEdited());
        campaignsPage.deleteCampaignByName(CampaignModel.EditDiscountsCampaignEdited().getName());
    }

    @Test(description = "Edit campaign's name,dates,discounts", dependsOnGroups = {"promotion_smoke"}, dependsOnMethods = {"addCampaign"}, groups = {"campaign_smoke"})
    public void editCampaignTest() {
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        ManageCampaignsPageObject campaignsPage = mainPage.navigateToManageCampaignsPage();
        campaignsPage.addCampaign(CampaignModel.EditDiscountsCampaignOrigin());
        campaignsPage.editCampaign(CampaignModel.EditCampaignOrigin(), CampaignModel.EditCampaignEdited());
        campaignsPage.checkCampaignExists(CampaignModel.EditCampaignEdited());
        campaignsPage.deleteCampaignByName(CampaignModel.EditCampaignEdited().getName());
    }
}

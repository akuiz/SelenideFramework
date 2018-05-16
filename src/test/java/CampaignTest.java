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
        campaignsPage.addCampaign(CampaignModel.CampaignOFFSmoke());
    }

    @Test(description = "Add campaign with OFF promotion")
    public void addCampaignWithOFFPromotion() {
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        CreatePromotionsPageObject createPromotionPage = mainPage.navigateToCreatePromotionsPage();
        createPromotionPage.addPromotion(OfferModel.TestCreateCampaignWithOFFPromotion());
        ManageCampaignsPageObject campaignsPage = mainPage.navigateToManageCampaignsPage();
        campaignsPage.addCampaign(CampaignModel.CampaignWithOFFPromotion());
    }

    @Test(description = "Remove campaign test")
    public void deleteCampaignTest() {
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        CreatePromotionsPageObject createPromotionPage = mainPage.navigateToCreatePromotionsPage();
        createPromotionPage.addPromotion(OfferModel.TestDeleteCampaignBOGOPromotion());
        createPromotionPage.addPromotion(OfferModel.TestDeleteCampaignOFFPromotion());
        ManageCampaignsPageObject campaignsPage = mainPage.navigateToManageCampaignsPage();
        campaignsPage.addCampaign(CampaignModel.TestDeleteCampaign());
        campaignsPage.deleteCampaignByName(CampaignModel.TestDeleteCampaign().getName());
    }

    @Test(description = "Campaign with empty name and no promotions should not be added")
    public void addCampaignValidationTest() {
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        ManageCampaignsPageObject campaignsPage = mainPage.navigateToManageCampaignsPage();
        campaignsPage.addCampaignValidationCheck(CampaignModel.ValidationCheckCampaign());
    }

        @Test(description = "Duplicate campaign test", enabled = false)
    public void duplicateCampaignTest() {
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        CreatePromotionsPageObject createPromotionPage = mainPage.navigateToCreatePromotionsPage();
        createPromotionPage.addPromotion(OfferModel.TestCampaignBOGOPromotion());
        createPromotionPage.addPromotion(OfferModel.TestCampaignOFFPromotion());
        ManageCampaignsPageObject campaignsPage = mainPage.navigateToManageCampaignsPage();
        campaignsPage.addCampaign(CampaignModel.TestCreateCampaign());
        campaignsPage.duplicateCampaign(CampaignModel.TestCreateCampaign());
        campaignsPage.checkCampaignExistsTwice(CampaignModel.TestCreateCampaign());
    }

    @Test(description = "Edit campaign name test", enabled = false)
    public void editCampaignNameTest() {
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        CreatePromotionsPageObject createPromotionPage = mainPage.getPromotionsPageObject();
        createPromotionPage.addPromotion(OfferModel.TestEditCampaignPromotionBOGO());
        createPromotionPage.addPromotion(OfferModel.TestEditCampaignPromotionOFF());
        ManageCampaignsPageObject campaignsPage = mainPage.navigateToManageCampaignsPage();
        campaignsPage.addCampaign(CampaignModel.TestEditCampaign());
        campaignsPage.changeCampaignName(CampaignModel.TestEditCampaign(), CampaignModel.TestEditedCampaign().getName());
        campaignsPage.checkCampaingNotExists(CampaignModel.TestEditCampaign().getName());
        campaignsPage.checkCampaignExists(CampaignModel.TestEditedCampaign());
    }

    @Test(description = "Edit campaign discounts test", enabled = false)
    public void editCampaignDiscountsTest() {
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        ManageCampaignsPageObject campaignsPage = mainPage.navigateToManageCampaignsPage();
        campaignsPage.addCampaign(CampaignModel.TestEditCampaign());
        campaignsPage.changeCampaignName(CampaignModel.TestEditCampaign(), CampaignModel.TestEditedCampaign().getName());
        campaignsPage.checkCampaingNotExists(CampaignModel.TestEditCampaign().getName());
        campaignsPage.checkCampaignExists(CampaignModel.TestEditedCampaign());
    }

    @Test(description = "Edit campaign dates test", enabled = false)
    public void editCampaignDatesTest() {
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        CreatePromotionsPageObject createPromotionPage = mainPage.getPromotionsPageObject();
        createPromotionPage.addPromotion(OfferModel.TestEditCampaignPromotionBOGO());
        createPromotionPage.addPromotion(OfferModel.TestEditCampaignPromotionOFF());
        ManageCampaignsPageObject campaignsPage = mainPage.navigateToManageCampaignsPage();
        campaignsPage.addCampaign(CampaignModel.TestEditCampaign());
        campaignsPage.changeCampaignName(CampaignModel.TestEditCampaign(), CampaignModel.TestEditedCampaign().getName());
        campaignsPage.checkCampaingNotExists(CampaignModel.TestEditCampaign().getName());
        campaignsPage.checkCampaignExists(CampaignModel.TestEditedCampaign());
    }

    @Test(description = "Edit campaign dates test", enabled = false)
    public void editCampaignTest() {
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        CreatePromotionsPageObject createPromotionPage = mainPage.getPromotionsPageObject();
        createPromotionPage.addPromotion(OfferModel.TestEditCampaignPromotionBOGO());
        createPromotionPage.addPromotion(OfferModel.TestEditCampaignPromotionOFF());
        ManageCampaignsPageObject campaignsPage = mainPage.navigateToManageCampaignsPage();
        campaignsPage.addCampaign(CampaignModel.TestEditCampaign());
        campaignsPage.changeCampaignName(CampaignModel.TestEditCampaign(), CampaignModel.TestEditedCampaign().getName());
        campaignsPage.checkCampaingNotExists(CampaignModel.TestEditCampaign().getName());
        campaignsPage.checkCampaignExists(CampaignModel.TestEditedCampaign());
    }

    @Test(description = "Campaign check test", enabled = false)
    public void campaignExistsCheck() {
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        ManageCampaignsPageObject campaignsPage = mainPage.navigateToManageCampaignsPage();
        campaignsPage.checkCampaignExists(CampaignModel.Spring2018());
    }

    @Test(description = "Check Campaign Prediction")
    public void checkPrediction() {
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        ManageCampaignsPageObject campaignsPage = mainPage.navigateToManageCampaignsPage();
        CampaignPageObject campaign = campaignsPage.getCampaignByName(CampaignModel.IssueCampaign().getName());
        campaign.checkPrediction(PredictionModel.Test2PromotPrediction());
    }
}

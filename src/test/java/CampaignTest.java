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

    @Test(description = "Add campaign test")
    public void addCampaignTest() {
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        CreatePromotionsPageObject createPromotionPage = mainPage.navigateToCreatePromotionsPage();
        createPromotionPage.addPromotion(OfferModel.TestCampaignBOGOPromotion());
        createPromotionPage.addPromotion(OfferModel.TestCampaignOFFPromotion());
        ManageCampaignsPageObject campaignsPage = mainPage.navigateToManageCampaignsPage();
        campaignsPage.addCampaign(CampaignModel.TestCampaign());
    }

    @Test(description = "Remove campaign test")
    public void deleteCampaignTest() {
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        CreatePromotionsPageObject createPromotionPage = mainPage.navigateToCreatePromotionsPage();
        createPromotionPage.addPromotion(OfferModel.TestCampaignBOGOPromotion());
        createPromotionPage.addPromotion(OfferModel.TestCampaignOFFPromotion());
        ManageCampaignsPageObject campaignsPage = mainPage.navigateToManageCampaignsPage();
        campaignsPage.addCampaign(CampaignModel.TestCampaign());
        campaignsPage.deleteCampaignByName(CampaignModel.TestCampaign().getName());
    }

    @Test(description = "Remove campaign test")
    public void duplicateCampaignTest() {
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        CreatePromotionsPageObject createPromotionPage = mainPage.navigateToCreatePromotionsPage();
        createPromotionPage.addPromotion(OfferModel.TestCampaignBOGOPromotion());
        createPromotionPage.addPromotion(OfferModel.TestCampaignOFFPromotion());
        ManageCampaignsPageObject campaignsPage = mainPage.navigateToManageCampaignsPage();
        campaignsPage.addCampaign(CampaignModel.TestCampaign());
        campaignsPage.duplicateCampaign(CampaignModel.TestCampaign());
        campaignsPage.checkCampaignExistsTwice(CampaignModel.TestCampaign());
    }

    @Test(description = "Edit campaign test")
    public void editCampaignTest() {
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        CreatePromotionsPageObject createPromotionPage = mainPage.navigateToCreatePromotionsPage();
        createPromotionPage.addPromotion(OfferModel.TestCampaignBOGOPromotion());
        createPromotionPage.addPromotion(OfferModel.TestCampaignOFFPromotion());
        ManageCampaignsPageObject campaignsPage = mainPage.navigateToManageCampaignsPage();
        campaignsPage.addCampaign(CampaignModel.TestCampaign());
        campaignsPage.changeCampaignName(CampaignModel.TestEditedCampaign(), CampaignModel.TestEditedCampaign().getName());
        campaignsPage.checkCampaingNotExists(CampaignModel.TestCampaign().getName());
        campaignsPage.checkCampaignExistsTwice(CampaignModel.TestEditedCampaign());
    }

    @Test(description = "Campaign check test")
    public void campaignExistsCheck() {
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        ManageCampaignsPageObject campaignsPage = mainPage.navigateToManageCampaignsPage();
        campaignsPage.checkCampaignExists(CampaignModel.Spring2018());
    }

    @Test(description = "Create campaign with 2 Promos")
    public void createCampaignWith2ExistingPromos() {
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        ManageCampaignsPageObject campaignsPage = mainPage.navigateToManageCampaignsPage();
        campaignsPage.addCampaign(CampaignModel.IssueCampaign());
    }

    @Test(description = "Check Prediction Test2Promo")
    public void checkPrediction() {
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        ManageCampaignsPageObject campaignsPage = mainPage.navigateToManageCampaignsPage();
        CampaignPageObject campaign = campaignsPage.getCampaignByName(CampaignModel.Test2Promo().getName());
        campaign.checkPrediction(PredictionModel.Test2PromotPrediction());
    }
}

import com.griddynamics.cto.*;
import com.griddynamics.cto.configuration.Configuration;
import com.griddynamics.cto.configuration.EnvironmentConfig;
import com.griddynamics.cto.model.CampaignModel;
import com.griddynamics.cto.model.OfferModel;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class CampaignTest {

    private static final EnvironmentConfig environmentConfig = Configuration.INSTANCE.getEnvironmentConfig();

    @Test(description = "Add campaign test")
    public void addCampaignTest(){
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        CreatePromotionsPageObject createPromotionPage = mainPage.navigateToCreatePromotionsPage();
        createPromotionPage.addPromotion(OfferModel.TestCampaignBOGOPromotion());
        createPromotionPage.addPromotion(OfferModel.TestCampaignOFFPromotion());
        ManageCampaignsPageObject campaignsPageObject = mainPage.navigateToManageCampaignsPage();
        campaignsPageObject.addCampaign(CampaignModel.TestCampaign());
    }

    @Test(description = "Remove campaign test")
    public void deleteCampaignTest(){
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        CreatePromotionsPageObject createPromotionPage = mainPage.navigateToCreatePromotionsPage();
        createPromotionPage.addPromotion(OfferModel.TestCampaignBOGOPromotion());
        createPromotionPage.addPromotion(OfferModel.TestCampaignOFFPromotion());
        ManageCampaignsPageObject campaignsPageObject = mainPage.navigateToManageCampaignsPage();
        campaignsPageObject.addCampaign(CampaignModel.TestCampaign());
        campaignsPageObject.deleteCampaignByName(CampaignModel.TestCampaign().getName());
    }

    @Test(description = "Remove campaign test")
    public void duplicateCampaignTest(){
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        CreatePromotionsPageObject createPromotionPage = mainPage.navigateToCreatePromotionsPage();
        createPromotionPage.addPromotion(OfferModel.TestCampaignBOGOPromotion());
        createPromotionPage.addPromotion(OfferModel.TestCampaignOFFPromotion());
        ManageCampaignsPageObject campaignsPageObject = mainPage.navigateToManageCampaignsPage();
        campaignsPageObject.addCampaign(CampaignModel.TestCampaign());
        campaignsPageObject.duplicateCampaign(CampaignModel.TestCampaign());
        campaignsPageObject.checkCampaignExistsTwice(CampaignModel.TestCampaign());
    }

    @Test(description = "Edit campaign test")
    public void editCampaignTest(){
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        CreatePromotionsPageObject createPromotionPage = mainPage.navigateToCreatePromotionsPage();
        createPromotionPage.addPromotion(OfferModel.TestCampaignBOGOPromotion());
        createPromotionPage.addPromotion(OfferModel.TestCampaignOFFPromotion());
        ManageCampaignsPageObject campaignsPageObject = mainPage.navigateToManageCampaignsPage();
        campaignsPageObject.addCampaign(CampaignModel.TestCampaign());
        campaignsPageObject.changeCampaignName(CampaignModel.TestEditedCampaign(), CampaignModel.TestEditedCampaign().getName());
        campaignsPageObject.checkCampaingNotExists(CampaignModel.TestCampaign().getName());
        campaignsPageObject.checkCampaignExistsTwice(CampaignModel.TestEditedCampaign());
    }


    @Test(description = "Campaign prediction test")
    public void predictionCampaignTest(){
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        CreatePromotionsPageObject createPromotionPage = mainPage.navigateToCreatePromotionsPage();
        createPromotionPage.addPromotion(OfferModel.TestCampaignBOGOPromotion());
        createPromotionPage.addPromotion(OfferModel.TestCampaignOFFPromotion());
        ManageCampaignsPageObject campaignsPageObject = mainPage.navigateToManageCampaignsPage();
        CampaignPageObject campaign = campaignsPageObject.addCampaign(CampaignModel.TestCampaign());
        campaign.checkPredition(100,200,100,200);
    }

    @Test(description = "Campaign check test")
    public void campaignExistsCheck() {
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        ManageCampaignsPageObject campaignsPageObject = mainPage.navigateToManageCampaignsPage();
        campaignsPageObject.checkCampaignExists(CampaignModel.Spring2018());

    }
}

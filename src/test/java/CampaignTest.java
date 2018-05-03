import com.codeborne.selenide.Selenide;
import com.griddynamics.cto.CreatePromotionsPageObject;
import com.griddynamics.cto.MainPage;
import com.griddynamics.cto.ManageCampaignsPageObject;
import com.griddynamics.cto.models.CampaignModel;
import com.griddynamics.cto.models.OfferModel;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class CampaignTest {
    final static String PRODUCTION_URL = "http://35.196.70.251:4200/";
    final static String LOCALHOST_URL = "http://localhost:4200/promo";

    @Test(description = "Add campaign test")
    public void addCampaignTest(){
        MainPage mainPage = open(PRODUCTION_URL, MainPage.class);
        CreatePromotionsPageObject createPromotionPage = mainPage.navigateToCreatePromotionsPage();
        createPromotionPage.addPromotion(OfferModel.TestCampaignBOGOPromotion());
        createPromotionPage.checkPromotionExists(OfferModel.TestCampaignBOGOPromotion());
        createPromotionPage.addPromotion(OfferModel.TestCampaignOFFPromotion());
        createPromotionPage.checkPromotionExists(OfferModel.TestCampaignOFFPromotion());
        ManageCampaignsPageObject campaignsPageObject = mainPage.navigateToManageCampaignsPage();
        campaignsPageObject.addCampaign(CampaignModel.TestCampaign());
        campaignsPageObject.checkCampaignExists(CampaignModel.TestCampaign());
    }

    @Test(description = "Remove campaign test")
    public void deleteCampaignTest(){
        MainPage mainPage = open(PRODUCTION_URL, MainPage.class);
        CreatePromotionsPageObject createPromotionPage = mainPage.navigateToCreatePromotionsPage();
        createPromotionPage.addPromotion(OfferModel.TestCampaignBOGOPromotion());
        createPromotionPage.checkPromotionExists(OfferModel.TestCampaignBOGOPromotion());
        createPromotionPage.addPromotion(OfferModel.TestCampaignOFFPromotion());
        createPromotionPage.checkPromotionExists(OfferModel.TestCampaignOFFPromotion());
        ManageCampaignsPageObject campaignsPageObject = mainPage.navigateToManageCampaignsPage();
        campaignsPageObject.addCampaign(CampaignModel.TestCampaign());
        campaignsPageObject.checkCampaignExists(CampaignModel.TestCampaign());
        campaignsPageObject.deleteCampaignByName(CampaignModel.TestCampaign().getName());
        campaignsPageObject.checkCampaingNotExists(CampaignModel.TestCampaign());
    }

    public void duplicateCampaignTest(){
        MainPage mainPage = open(PRODUCTION_URL, MainPage.class);
        CreatePromotionsPageObject createPromotionPage = mainPage.navigateToCreatePromotionsPage();
        createPromotionPage.addPromotion(OfferModel.TestCampaignBOGOPromotion());
        createPromotionPage.checkPromotionExists(OfferModel.TestCampaignBOGOPromotion());
        createPromotionPage.addPromotion(OfferModel.TestCampaignOFFPromotion());
        createPromotionPage.checkPromotionExists(OfferModel.TestCampaignOFFPromotion());
        ManageCampaignsPageObject campaignsPageObject = mainPage.navigateToManageCampaignsPage();
        campaignsPageObject.addCampaign(CampaignModel.TestCampaign());
        campaignsPageObject.checkCampaignExists(CampaignModel.TestCampaign());
        campaignsPageObject.duplicateCampaign(CampaignModel.TestCampaign());
        campaignsPageObject.checkCampaignExistsTwice(CampaignModel.TestCampaign());
    }

    public void editCampaignTest(){
        MainPage mainPage = open(PRODUCTION_URL, MainPage.class);
        CreatePromotionsPageObject createPromotionPage = mainPage.navigateToCreatePromotionsPage();
        createPromotionPage.addPromotion(OfferModel.TestCampaignBOGOPromotion());
        createPromotionPage.checkPromotionExists(OfferModel.TestCampaignBOGOPromotion());
        createPromotionPage.addPromotion(OfferModel.TestCampaignOFFPromotion());
        createPromotionPage.checkPromotionExists(OfferModel.TestCampaignOFFPromotion());
        ManageCampaignsPageObject campaignsPageObject = mainPage.navigateToManageCampaignsPage();
        campaignsPageObject.addCampaign(CampaignModel.TestCampaign());
        campaignsPageObject.checkCampaignExists(CampaignModel.TestCampaign());
        campaignsPageObject.changeCampaignName(CampaignModel.TestEditedCampaign(), CampaignModel.TestEditedCampaign().getName());
        campaignsPageObject.checkCampaingNotExists(CampaignModel.TestCampaign());
        campaignsPageObject.checkCampaignExistsTwice(CampaignModel.TestEditedCampaign());
    }

}

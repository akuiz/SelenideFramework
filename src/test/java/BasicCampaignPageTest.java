import com.griddynamics.cto.CreatePromotionsPageObject;
import com.griddynamics.cto.MainPage;
import com.griddynamics.cto.configuration.Configuration;
import com.griddynamics.cto.configuration.EnvironmentConfig;
import com.griddynamics.cto.model.OfferModel;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class BasicCampaignPageTest {

    private static final EnvironmentConfig environmentConfig = Configuration.INSTANCE.getEnvironmentConfig();

    @Test(description = "Add  %_off promotion test")
    public void addPercentOffPromotion() {
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        CreatePromotionsPageObject createPromotionPage = mainPage.navigateToCreatePromotionsPage();
        createPromotionPage.addPromotion(OfferModel.CalvinKlein7OFF());
    }

    @Test(description = "Add  %_off_amount promotion test")
    public void addPercentOfAmountPromotion() {
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        CreatePromotionsPageObject createPromotionPage = mainPage.navigateToCreatePromotionsPage();
        createPromotionPage.addPromotion(OfferModel.CalvinKleinPercentOfAmoutDiscount());
    }

    @Test(description = "Add fix discount promotion test")
    public void addPercentFixDiscountPromotion() {
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        CreatePromotionsPageObject createPromotionPage = mainPage.navigateToCreatePromotionsPage();
        createPromotionPage.addPromotion(OfferModel.CalvinKleinFixDiscount());
    }

    @Test(description = "Add BOGO promotion test")
    public void addBOGOPromotion() {
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        CreatePromotionsPageObject createPromotionPage = mainPage.navigateToCreatePromotionsPage();
        createPromotionPage.addPromotion(OfferModel.CalvinKlein5OFF());
    }

    @Test(description = "Delete recentrly created promotion test")
    public void deletePromotionTest() {
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        CreatePromotionsPageObject createPromotionPage = mainPage.navigateToCreatePromotionsPage();
        createPromotionPage.addPromotion(OfferModel.CalvinKlein8OFF());
        createPromotionPage.checkPromotionExists(OfferModel.CalvinKlein8OFF());
        createPromotionPage.deletePromotionByName(OfferModel.CalvinKlein8OFF());
        createPromotionPage.checkPromotionNotExistsByName(OfferModel.CalvinKlein8OFF());
    }

    @Test(description = "Update promotion name test")
    public void updatePromotionNameTest(){
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        CreatePromotionsPageObject createPromotionPage = mainPage.navigateToCreatePromotionsPage();
        createPromotionPage.addPromotion(OfferModel.EditTestOriginPromotion());
        createPromotionPage.checkPromotionExists(OfferModel.EditTestOriginPromotion());
        createPromotionPage.updatePromotionByName(OfferModel.EditTestOriginPromotion().getName(), OfferModel.EditTestModifiedNamePromotion().getName());
        createPromotionPage.checkPromotionExists(OfferModel.EditTestModifiedNamePromotion());
    }

    @Test(description = "Update promotion test")
    public void updatePromotionTest(){
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        CreatePromotionsPageObject createPromotionPage = mainPage.navigateToCreatePromotionsPage();
        createPromotionPage.addPromotion(OfferModel.EditTestOriginPromotion());
        createPromotionPage.checkPromotionExists(OfferModel.EditTestOriginPromotion());
        createPromotionPage.updatePromotion(OfferModel.EditTestOriginPromotion(), OfferModel.EditTestModifiedPromotion());
        createPromotionPage.checkPromotionExists(OfferModel.EditTestModifiedPromotion());
    }

    @Test(description = "Clone promotion test")
    public void duplicatePromotionTest(){
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        CreatePromotionsPageObject createPromotionPage = mainPage.navigateToCreatePromotionsPage();
        createPromotionPage.addPromotion(OfferModel.DuplicatePromotion());
        createPromotionPage.checkPromotionExists(OfferModel.DuplicatePromotion());
        createPromotionPage.duplicatePromotion(OfferModel.DuplicatePromotion());
        createPromotionPage.checkPromotionExistsTwice(OfferModel.DuplicatePromotion());
    }
}

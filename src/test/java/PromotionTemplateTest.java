import com.griddynamics.cto.CreatePromotionsPageObject;
import com.griddynamics.cto.MainPage;
import com.griddynamics.cto.configuration.Configuration;
import com.griddynamics.cto.configuration.EnvironmentConfig;
import com.griddynamics.cto.model.OfferModel;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class PromotionTemplateTest {

    private static final EnvironmentConfig environmentConfig = Configuration.INSTANCE.getEnvironmentConfig();

    @Test(description = "Promotion with no brands should not be added", groups = {"promotion_smoke"})
    public void addPromotionWithNoBrands() {
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        CreatePromotionsPageObject createPromotionPage = mainPage.getPromotionsPageObject();
        createPromotionPage.addPromotionWithoutBrands(OfferModel.PromotionWithNoBrands());
    }

    @Test(description = "Promotion with empty name should not be added", groups = {"promotion_smoke"})
    public void addPromotionWithEmptyName() {
        MainPage mainPage = open("http://35.196.70.251:4200/promo", MainPage.class);
        CreatePromotionsPageObject createPromotionPage = mainPage.getPromotionsPageObject();
        createPromotionPage.addPromotionWithoutName(OfferModel.PromotionWithEmptyName());
    }

    @Test(description = "Promotion with %OFF type should be successfully aded", groups = {"promotion_smoke", "create_promotion"})
    public void addPercentOFFPromotion() {
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        CreatePromotionsPageObject createPromotionPage = mainPage.getPromotionsPageObject();
        createPromotionPage.addPromotion(OfferModel.PromotionOFFSmoke());
    }

    @Test(description = "Add BOGO promotion test", groups = {"promotion_smoke", "create_promotion"})
    public void addBOGOPromotion() {
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        CreatePromotionsPageObject createPromotionPage = mainPage.getPromotionsPageObject();
        createPromotionPage.addPromotion(OfferModel.SmokePromotionBOGO());
    }

    @Test(description = "Delete recentrly created promotion test", groups = {"promotion_smoke"})
    public void deletePromotionTest() {
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        CreatePromotionsPageObject createPromotionPage = mainPage.getPromotionsPageObject();
        createPromotionPage.addPromotion(OfferModel.SmokeDeletePromotionOFF());
        createPromotionPage.addPromotion(OfferModel.SmokeDeletePromotionBOGO());
        createPromotionPage.deletePromotion(OfferModel.SmokeDeletePromotionBOGO().getName());
        createPromotionPage.deletePromotion(OfferModel.SmokeDeletePromotionOFF().getName());
    }

    @Test(description = "Update promotion name test", groups = {"promotion_smoke"})
    public void updatePromotionNameTest() {
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        CreatePromotionsPageObject createPromotionPage = mainPage.getPromotionsPageObject();
        createPromotionPage.addPromotion(OfferModel.EditNameOriginPromotion());
        createPromotionPage.updatePromotionName(OfferModel.EditNameOriginPromotion(), OfferModel.EditNameRenamedPromotion().getName());
        createPromotionPage.checkPromotionExists(OfferModel.EditNameRenamedPromotion());
        createPromotionPage.deletePromotion(OfferModel.EditNameRenamedPromotion().getName());
    }

    @Test(description = "Update promotion type test", groups = {"promotion_smoke"})
    public void updatePromotionTypeTest() {
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        CreatePromotionsPageObject createPromotionPage = mainPage.getPromotionsPageObject();
        createPromotionPage.addPromotion(OfferModel.EditTypeOriginPromotionOFF());
        createPromotionPage.updatePromotion(OfferModel.EditTypeOriginPromotionOFF(), OfferModel.EditTypeChangedPromotionBOGO());
        createPromotionPage.checkPromotionExists(OfferModel.EditTypeChangedPromotionBOGO());
        createPromotionPage.deletePromotion(OfferModel.EditTypeChangedPromotionBOGO().getName());
    }

    @Test(description = "Duplicate promotion test", groups = {"promotion_smoke"})
    public void duplicatePromotionTest() {
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        CreatePromotionsPageObject createPromotionPage = mainPage.getPromotionsPageObject();
        createPromotionPage.addPromotion(OfferModel.DuplicatePromotion());
        createPromotionPage.checkPromotionExists(OfferModel.DuplicatePromotion());
        createPromotionPage.duplicatePromotion(OfferModel.DuplicatePromotion());
        createPromotionPage.checkPromotionExistsTwice(OfferModel.DuplicatePromotion());
    }

    @Test(description = "Add  %_off_amount promotion test", enabled = false, groups = {"promotion_smoke"})
    public void addPercentOfAmountPromotion() {
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        CreatePromotionsPageObject createPromotionPage = mainPage.getPromotionsPageObject();
        createPromotionPage.addPromotion(OfferModel.CalvinKleinPercentOfAmoutDiscount());
    }

    @Test(description = "Add fix discount promotion test", enabled = false, groups = {"promotion_smoke"})
    public void addPercentFixDiscountPromotion() {
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        CreatePromotionsPageObject createPromotionPage = mainPage.getPromotionsPageObject();
        createPromotionPage.addPromotion(OfferModel.CalvinKleinFixDiscount());
    }
}

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
    public void addEmptyPromotion() {
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        CreatePromotionsPageObject createPromotionPage = mainPage.getPromotionsPageObject();
        createPromotionPage.addBadPromotion(OfferModel.PromotionWithNoBrands());
    }

    @Test(description = "Add  %_off promotion test", groups = {"promotion_smoke"})
    public void addPercentOffPromotion() {
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        CreatePromotionsPageObject createPromotionPage = mainPage.getPromotionsPageObject();
        createPromotionPage.addPromotion(OfferModel.PromotionOFFSmoke());
    }

    @Test(description = "Add BOGO promotion test", groups = {"promotion_smoke"})
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
        createPromotionPage.deletePromotionByName(OfferModel.SmokeDeletePromotionBOGO());
        createPromotionPage.deletePromotionByName(OfferModel.SmokeDeletePromotionOFF());
    }

    @Test(description = "Update promotion name test", groups = {"promotion_smoke"}, dependsOnMethods = {"addPercentOffPromotion"})
    public void updatePromotionNameTest() {
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        CreatePromotionsPageObject createPromotionPage = mainPage.getPromotionsPageObject();
        createPromotionPage.addPromotion(OfferModel.EditNameOriginPromotion());
        createPromotionPage.updatePromotionByName(OfferModel.EditNameOriginPromotion().getName(), OfferModel.EditNameRenamedPromotion().getName());
        createPromotionPage.checkPromotionExists(OfferModel.EditNameRenamedPromotion());
        createPromotionPage.deletePromotionByName(OfferModel.EditNameRenamedPromotion());
    }

    @Test(description = "Update promotion type test", groups = {"promotion_smoke"})
    public void updatePromotionTypeTest() {
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        CreatePromotionsPageObject createPromotionPage = mainPage.getPromotionsPageObject();
        createPromotionPage.addPromotion(OfferModel.EditTypeOriginPromotionOFF());
        createPromotionPage.updatePromotion(OfferModel.EditTypeOriginPromotionOFF(), OfferModel.EditTypeChangedPromotionBOGO());
        createPromotionPage.checkPromotionExists(OfferModel.EditTypeChangedPromotionBOGO());
        createPromotionPage.deletePromotionByName(OfferModel.EditTypeChangedPromotionBOGO());
    }

    @Test(description = "Duplicate promotion test", groups = {"promotion_smoke"})
    public void duplicatePromotionTest() {
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        CreatePromotionsPageObject createPromotionPage = mainPage.getPromotionsPageObject();
        createPromotionPage.addPromotion(OfferModel.DuplicatePromotion());
        createPromotionPage.checkPromotionExists(OfferModel.DuplicatePromotion());
        createPromotionPage.duplicatePromotion(OfferModel.DuplicatePromotion());
        createPromotionPage.checkPromotionExistsTwice(OfferModel.DuplicatePromotion());
        createPromotionPage.deletePromotionByName(OfferModel.DuplicatePromotion());
        createPromotionPage.deletePromotionByName(OfferModel.DuplicatePromotion());
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

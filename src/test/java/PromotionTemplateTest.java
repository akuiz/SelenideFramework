import com.griddynamics.cto.CreatePromotionsPageObject;
import com.griddynamics.cto.MainPage;
import com.griddynamics.cto.configuration.Configuration;
import com.griddynamics.cto.configuration.EnvironmentConfig;
import com.griddynamics.cto.model.PromotionModel;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class PromotionTemplateTest {

    private static final EnvironmentConfig environmentConfig = Configuration.INSTANCE.getEnvironmentConfig();

    @Test(description = "Add promotion with no brands", groups = {"promotion_smoke"})
    public void addPromotionWithNoBrands() {
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        CreatePromotionsPageObject createPromotionPage = mainPage.getPromotionsPageObject();
        createPromotionPage.addPromotionWithoutBrands(PromotionModel.PromotionWithNoBrands());
    }

    @Test(description = "Add promotion with empty name", groups = {"promotion_smoke"})
    public void addPromotionWithEmptyName() {
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        CreatePromotionsPageObject createPromotionPage = mainPage.getPromotionsPageObject();
        createPromotionPage.addPromotionWithoutName(PromotionModel.PromotionWithEmptyName());
    }

    @Test(description = "Add %OFF promotion test", groups = {"promotion_smoke", "create_promotion"})
    public void addPercentOFFPromotion() {
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        CreatePromotionsPageObject createPromotionPage = mainPage.getPromotionsPageObject();
        createPromotionPage.addPromotion(PromotionModel.PromotionOFFSmoke());
        createPromotionPage.checkPromotionExists(PromotionModel.PromotionOFFSmoke());
    }

    @Test(description = "Add BOGO promotion test", groups = {"promotion_smoke", "create_promotion"})
    public void addBOGOPromotion() {
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        CreatePromotionsPageObject createPromotionPage = mainPage.getPromotionsPageObject();
        createPromotionPage.addPromotionSecondButton(PromotionModel.SmokePromotionBOGO());
        createPromotionPage.checkPromotionExists(PromotionModel.SmokePromotionBOGO());
    }

    @Test(description = "Delete recentrly created promotion test", groups = {"promotion_smoke"})
    public void deletePromotionTest() {
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        CreatePromotionsPageObject createPromotionPage = mainPage.getPromotionsPageObject();
        createPromotionPage.addPromotion(PromotionModel.SmokeDeletePromotionOFF());
        createPromotionPage.addPromotionSecondButton(PromotionModel.SmokeDeletePromotionBOGO());
        createPromotionPage.deletePromotion(PromotionModel.SmokeDeletePromotionBOGO().getName());
        createPromotionPage.checkPromotionNotExists(PromotionModel.SmokeDeletePromotionBOGO().getName());
        createPromotionPage.deletePromotion(PromotionModel.SmokeDeletePromotionOFF().getName());
        createPromotionPage.checkPromotionNotExists(PromotionModel.SmokeDeletePromotionOFF().getName());
    }

    @Test(description = "Update promotion name test", groups = {"promotion_smoke"})
    public void updatePromotionNameTest() {
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        CreatePromotionsPageObject createPromotionPage = mainPage.getPromotionsPageObject();
        createPromotionPage.addPromotion(PromotionModel.EditNameOriginPromotion());
        createPromotionPage.updatePromotionName(PromotionModel.EditNameOriginPromotion(), PromotionModel.EditNameRenamedPromotion().getName());
        createPromotionPage.checkPromotionExists(PromotionModel.EditNameRenamedPromotion());
        createPromotionPage.deletePromotion(PromotionModel.EditNameRenamedPromotion().getName());
        createPromotionPage.checkPromotionNotExists(PromotionModel.EditNameRenamedPromotion().getName());
    }

    @Test(description = "Update promotion value test", groups = {"promotion_smoke"})
    public void updatePromotionValueTest() {
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        CreatePromotionsPageObject createPromotionPage = mainPage.getPromotionsPageObject();
        createPromotionPage.addPromotion(PromotionModel.EditValueOriginPromotion());
        createPromotionPage.updatePromotionValue(PromotionModel.EditValueOriginPromotion(), PromotionModel.EditValueChangedPromotion().getValue());
        createPromotionPage.checkPromotionExists(PromotionModel.EditValueChangedPromotion());
        createPromotionPage.deletePromotion(PromotionModel.EditValueChangedPromotion().getName());
    }

    @Test(description = "Update promotion type test", groups = {"promotion_smoke"})
    public void updatePromotionTypeTest() {
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        CreatePromotionsPageObject createPromotionPage = mainPage.getPromotionsPageObject();
        createPromotionPage.addPromotion(PromotionModel.EditTypeOriginPromotionOFF());
        createPromotionPage.updatePromotion(PromotionModel.EditTypeOriginPromotionOFF(), PromotionModel.EditTypeChangedPromotionBOGO());
        createPromotionPage.checkPromotionExists(PromotionModel.EditTypeChangedPromotionBOGO());
        createPromotionPage.deletePromotion(PromotionModel.EditTypeChangedPromotionBOGO().getName());
        createPromotionPage.checkPromotionNotExists(PromotionModel.EditTypeChangedPromotionBOGO().getName());
    }

    @Test(description = "Duplicate promotion test", groups = {"promotion_smoke"})
    public void duplicatePromotionTest() {
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        CreatePromotionsPageObject createPromotionPage = mainPage.getPromotionsPageObject();
        createPromotionPage.addPromotion(PromotionModel.DuplicatePromotion());
        createPromotionPage.checkPromotionExists(PromotionModel.DuplicatePromotion());
        createPromotionPage.duplicatePromotion(PromotionModel.DuplicatePromotion());
        createPromotionPage.checkPromotionExistsTwice(PromotionModel.DuplicatePromotion());
    }

    @Test(description = "Add  %_off_amount promotion test", enabled = false, groups = {"promotion_smoke"})
    public void addPercentOfAmountPromotion() {
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        CreatePromotionsPageObject createPromotionPage = mainPage.getPromotionsPageObject();
        createPromotionPage.addPromotion(PromotionModel.CalvinKleinPercentOfAmoutDiscount());
    }

    @Test(description = "Add fix discount promotion test", enabled = false, groups = {"promotion_smoke"})
    public void addPercentFixDiscountPromotion() {
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        CreatePromotionsPageObject createPromotionPage = mainPage.getPromotionsPageObject();
        createPromotionPage.addPromotion(PromotionModel.CalvinKleinFixDiscount());
    }

    @Test(description = "Check pre-created promotions", groups = {"production_read_only", "production"})
    public void precreatedPromotionsTest(){
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        CreatePromotionsPageObject createPromotionPage = mainPage.getPromotionsPageObject();
        createPromotionPage.checkNUmberOfPromotions(6);
        createPromotionPage.checkPromotionExists(PromotionModel.CalvinKleinOFF5());
        createPromotionPage.checkPromotionExists(PromotionModel.CalvinKleinOFF7());
        createPromotionPage.checkPromotionExists(PromotionModel.CalvinKleinOFF10());
        createPromotionPage.checkPromotionExists(PromotionModel.AdriannaPapellOFF5());
        createPromotionPage.checkPromotionExists(PromotionModel.FreePeopleOFF10());
        createPromotionPage.checkPromotionExists(PromotionModel.FreePeopleBOGO());
    }
}

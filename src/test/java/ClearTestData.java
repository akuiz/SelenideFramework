import com.griddynamics.cto.CreatePromotionsPageObject;
import com.griddynamics.cto.MainPage;
import com.griddynamics.cto.ManageCampaignsPageObject;
import com.griddynamics.cto.configuration.Configuration;
import com.griddynamics.cto.configuration.EnvironmentConfig;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class ClearTestData {
    private static final EnvironmentConfig environmentConfig = Configuration.INSTANCE.getEnvironmentConfig();

   @Test(description = "Delete all test promotions")
    public void deleteAllPromotions(){
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        CreatePromotionsPageObject createPromotionPage = mainPage.getPromotionsPageObject();
        createPromotionPage.deleteTestPromotions();
    }

    @Test(description = "Delete all test campaigns")
    public void deleteAllDiscounts(){
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        ManageCampaignsPageObject campaignsPage = mainPage.navigateToManageCampaignsPage();
        campaignsPage.deleteTestCampaigns();
    }

}

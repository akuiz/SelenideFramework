import com.griddynamics.cto.CreatePromotionsPageObject;
import com.griddynamics.cto.ForecastPageObject;
import com.griddynamics.cto.MainPage;
import com.griddynamics.cto.ManageCampaignsPageObject;
import com.griddynamics.cto.configuration.Configuration;
import com.griddynamics.cto.configuration.EnvironmentConfig;
import com.griddynamics.cto.model.CampaignModel;
import com.griddynamics.cto.model.PredictionModel;
import org.joda.time.DateTime;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class ClearTestData {
    private static final EnvironmentConfig environmentConfig = Configuration.INSTANCE.getEnvironmentConfig();

   @Test(description = "Delete all test promotions")
    public void deleteAllPromotions(){
        MainPage mainPage = open("http://35.196.70.251:4200/", MainPage.class);
        CreatePromotionsPageObject createPromotionPage = mainPage.getPromotionsPageObject();
        createPromotionPage.deleteTestPromotions();
    }

    @Test(description = "Delete all test campaigns")
    public void deleteAllDiscounts(){
        MainPage mainPage = open("http://35.196.70.251:4200/", MainPage.class);
        ManageCampaignsPageObject campaignsPage = mainPage.navigateToManageCampaignsPage();
        campaignsPage.deleteTestCampaigns();
    }

}

import com.codeborne.selenide.Selenide;
import com.griddynamics.cto.CreatePromotionsPageObject;
import com.griddynamics.cto.ForecastPageObject;
import com.griddynamics.cto.MainPage;
import com.griddynamics.cto.ManageCampaignsPageObject;
import com.griddynamics.cto.configuration.Configuration;
import com.griddynamics.cto.configuration.EnvironmentConfig;
import com.griddynamics.cto.model.CampaignModel;
import com.griddynamics.cto.model.OfferModel;
import com.griddynamics.cto.model.PredictionModel;
import org.joda.time.DateTime;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class ForecastTest {
    private static final EnvironmentConfig environmentConfig = Configuration.INSTANCE.getEnvironmentConfig();

    @Test(description = "Check forecast")
    public void simpleForecastTest(){
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        CreatePromotionsPageObject createPromotionPage = mainPage.navigateToCreatePromotionsPage();
        createPromotionPage.addPromotion(OfferModel.TestForecastBOGOPromotion());
        createPromotionPage.addPromotion(OfferModel.TestForecastOFFPromotion());
        ManageCampaignsPageObject campaignsPage = mainPage.navigateToManageCampaignsPage();
        campaignsPage.addCampaign(CampaignModel.TestForecastCampaign());
        ForecastPageObject forecastPage = mainPage.navigateToForecastPage();
        forecastPage.setCampaigns(CampaignModel.TestForecastCampaign());
        forecastPage.setDates(new DateTime(2018, 5, 11, 0, 0, 0, 0), new DateTime(2018, 5, 13, 0, 0, 0, 0));
        forecastPage.buildForeCast();
        forecastPage.checkPrediction(PredictionModel.SimpleForecast());
    }

    @Test(description = "Production forecast test")
    public void productionFoTest(){
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        ForecastPageObject forecastPage = mainPage.navigateToForecastPage();
        forecastPage.setCampaigns(CampaignModel.ProductionAdrianna(), CampaignModel.ProductionAdriannaExtended());
        forecastPage.buildForeCast();
        forecastPage.checkPrediction(PredictionModel.ProductionAdriannaForecast());
    }
}

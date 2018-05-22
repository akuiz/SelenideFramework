import com.griddynamics.cto.ForecastPageObject;
import com.griddynamics.cto.MainPage;
import com.griddynamics.cto.configuration.Configuration;
import com.griddynamics.cto.configuration.EnvironmentConfig;
import com.griddynamics.cto.model.CampaignModel;
import com.griddynamics.cto.model.PredictionModel;
import org.joda.time.DateTime;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class ForecastTest {
    private static final EnvironmentConfig environmentConfig = Configuration.INSTANCE.getEnvironmentConfig();

    @Test(description = "Check forecast with one campaign", dependsOnGroups ={"add_campaign"}, groups = "{forecast_smoke}")
    public void forecastSmokeTest(){
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        ForecastPageObject forecastPage = mainPage.navigateToForecastPage();
        forecastPage.setCampaigns(CampaignModel.CampaignOFFBOGOSmoke());
        forecastPage.setDates(new DateTime(2018, 5, 11, 0, 0, 0, 0), new DateTime(2018, 5, 13, 0, 0, 0, 0));
        forecastPage.buildForeCast();
        forecastPage.checkForecast(PredictionModel.SmokeForecast());
    }

    @Test(description = "Check forecast with 3 campaigns", dependsOnGroups ={"add_campaign"}, groups = "{forecast_smoke}")
    public void forecastManyCampaignsTest(){
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        ForecastPageObject forecastPage = mainPage.navigateToForecastPage();
        forecastPage.setCampaigns(CampaignModel.CampaignOFFBOGOSmoke());
        forecastPage.setCampaigns(CampaignModel.CampaignBOGOSmoke());
        forecastPage.setCampaigns(CampaignModel.CampaignOFFSmoke());
        forecastPage.setDates(new DateTime(2018, 5, 11, 0, 0, 0, 0), new DateTime(2018, 5, 13, 0, 0, 0, 0));
        forecastPage.buildForeCast();
        forecastPage.checkForecast(PredictionModel.SmokeForecast());
    }

    @Test(description = "Check forecast for the same campaign but with different dates", dependsOnGroups ={"add_campaign"}, groups = "{forecast_smoke}")
    public void forecastDatesTest(){
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        ForecastPageObject forecastPage = mainPage.navigateToForecastPage();
        forecastPage.setCampaigns(CampaignModel.CampaignOFFBOGOSmoke());
        forecastPage.setDates(new DateTime(2018, 5, 11, 0, 0, 0, 0), new DateTime(2018, 5, 13, 0, 0, 0, 0));
        forecastPage.buildForeCast();
        forecastPage.checkForecast(PredictionModel.SmokeForecast());
        forecastPage.setDates(new DateTime(2018, 6, 14, 0, 0, 0, 0), new DateTime(2018, 6, 15, 0, 0, 0, 0));
        forecastPage.buildForeCast();
        forecastPage.checkForecast(PredictionModel.SmokeForecast());
    }
}

import com.griddynamics.cto.CampaignPageObject;
import com.griddynamics.cto.ForecastPageObject;
import com.griddynamics.cto.MainPage;
import com.griddynamics.cto.configuration.Configuration;
import com.griddynamics.cto.configuration.EnvironmentConfig;
import com.griddynamics.cto.model.CampaignModel;
import com.griddynamics.cto.model.ForecastModel;
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
        forecastPage.checkForecast(ForecastModel.SmokeForecast());
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
        forecastPage.checkForecast(ForecastModel.SmokeForecast());
    }

   @Test(description = "Check forecast for the same campaign but with different dates", dependsOnGroups ={"add_campaign"}, groups = "{forecast_smoke}")
    public void forecastDatesTest(){
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        ForecastPageObject forecastPage = mainPage.navigateToForecastPage();
        forecastPage.setCampaigns(CampaignModel.CampaignOFFBOGOSmoke());
        forecastPage.setDates(new DateTime(2018, 5, 11, 0, 0, 0, 0), new DateTime(2018, 7, 11, 0, 0, 0, 0));
        forecastPage.buildForeCast();
        forecastPage.checkForecast(ForecastModel.SmokeForecast());
        forecastPage.setDates(new DateTime(2018, 6, 14, 0, 0, 0, 0), new DateTime(2018, 6, 15, 0, 0, 0, 0));
        forecastPage.buildForeCast();
        forecastPage.checkForecast(ForecastModel.SmokeForecast());
    }

    @Test(description = "Check Calvin Klein 7%, Adrianna Papell and Free People forecast", groups = {"production", "production_read_only"})
    public void forecastCalvin7Test(){
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        ForecastPageObject forecastPage = mainPage.navigateToForecastPage();
        forecastPage.setDates(new DateTime(2018, 5, 11, 0, 0, 0, 0), new DateTime(2018, 7, 11, 0, 0, 0, 0));
        forecastPage.setCampaigns(CampaignModel.CalvinKleinJune2018Dresses7(), CampaignModel.AdriannaPapellSpring2018(), CampaignModel.FreePeopleJuly2018());
        forecastPage.buildForeCast();
        forecastPage.checkForecast(ForecastModel.CampaignsForecastDemo());
    }

    @Test(description = "Check Free People July 2018 BOGO forecast", groups = {"production", "production_read_only"})
    public void forecastFreePeopleBOGO(){
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        ForecastPageObject forecastPage = mainPage.navigateToForecastPage();
        forecastPage.setDates(new DateTime(2018, 6, 30, 0, 0, 0, 0), new DateTime(2018, 7, 4, 0, 0, 0, 0));
        forecastPage.setCampaigns(CampaignModel.FreePeopleJuly2018BOGO());
        forecastPage.buildForeCast();
        forecastPage.checkForecast(ForecastModel.FreePeopleJuly2018BOGO());
    }

    @Test(description = "Check Calvin Klein 5% forecast", groups = {"production", "production_read_only"})
    public void forecastCalvinKlein5Test(){
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        ForecastPageObject forecastPage = mainPage.navigateToForecastPage();
        forecastPage.setDates(new DateTime(2018, 6, 1, 0, 0, 0, 0), new DateTime(2018, 6, 30, 0, 0, 0, 0));
        forecastPage.setCampaigns(CampaignModel.CalvinKleinJune2018Dresses5());
        forecastPage.buildForeCast();
        forecastPage.checkForecast(ForecastModel.CalvinKleinJune2018Dresses5());
    }

    @Test(description = "Check Calvin Klein 7% forecast", groups = {"production", "production_read_only"})
    public void forecastCalvinKlein7Test(){
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        ForecastPageObject forecastPage = mainPage.navigateToForecastPage();
        forecastPage.setDates(new DateTime(2018, 6, 1, 0, 0, 0, 0), new DateTime(2018, 6, 30, 0, 0, 0, 0));
        forecastPage.setCampaigns(CampaignModel.CalvinKleinJune2018Dresses7());
        forecastPage.buildForeCast();
        forecastPage.checkForecast(ForecastModel.CalvinKleinJune2018Dresses7());
    }

    @Test(description = "Check Calvin Klein 10% forecast", groups = {"production", "production_read_only"})
    public void forecastCalvinKlein10Test(){
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        ForecastPageObject forecastPage = mainPage.navigateToForecastPage();
        forecastPage.setDates(new DateTime(2018, 6, 1, 0, 0, 0, 0), new DateTime(2018, 6, 30, 0, 0, 0, 0));
        forecastPage.setCampaigns(CampaignModel.CalvinKleinJune2018Dresses10());
        forecastPage.buildForeCast();
        forecastPage.checkForecast(ForecastModel.CalvinKleinJune2018Dresses10());
    }

    @Test(description = "Check Adrianna Papell Spring 2018 forecast", groups = {"production", "production_read_only"})
    public void forecastAdriannaPapellTest(){
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        ForecastPageObject forecastPage = mainPage.navigateToForecastPage();
        forecastPage.setDates(new DateTime(2018, 5, 11, 0, 0, 0, 0), new DateTime(2018, 5, 31, 0, 0, 0, 0));
        forecastPage.setCampaigns(CampaignModel.AdriannaPapellSpring2018());
        forecastPage.buildForeCast();
        forecastPage.checkForecast(ForecastModel.AdriannaPapellSpring2018());
    }

    @Test(description = "Check Adrianna Papell Spring 2018 extended forecast", groups = {"production, production_read_only"})
    public void forecastAdriannaPapellExtendedTest(){
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        ForecastPageObject forecastPage = mainPage.navigateToForecastPage();
        forecastPage.setDates(new DateTime(2018, 5, 11, 0, 0, 0, 0), new DateTime(2018, 6, 9, 0, 0, 0, 0));
        forecastPage.setCampaigns(CampaignModel.AdriannaPapellSpringExtended2018());
        forecastPage.buildForeCast();
        forecastPage.checkForecast(ForecastModel.AdriannaPapellSpringExtended2018());
    }

    @Test(description = "Check Free People July Spring 2018  forecast", groups = {"production", "production_read_only"})
    public void forecastFreePeopleTest(){
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        ForecastPageObject forecastPage = mainPage.navigateToForecastPage();
        forecastPage.setDates(new DateTime(2018, 6, 30, 0, 0, 0, 0), new DateTime(2018, 7, 4, 0, 0, 0, 0));
        forecastPage.setCampaigns(CampaignModel.FreePeopleJuly2018());
        forecastPage.buildForeCast();
        forecastPage.checkForecast(ForecastModel.FreePeopleJuly2018());
    }

}

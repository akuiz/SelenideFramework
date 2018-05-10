import com.griddynamics.cto.ForecastPageObject;
import com.griddynamics.cto.MainPage;
import com.griddynamics.cto.configuration.Configuration;
import com.griddynamics.cto.configuration.EnvironmentConfig;
import com.griddynamics.cto.model.CampaignModel;
import com.griddynamics.cto.model.PredictionModel;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class ForecastTest {
    private static final EnvironmentConfig environmentConfig = Configuration.INSTANCE.getEnvironmentConfig();

    @Test(description = "Check forecast")
    public void simpleForecastTest(){
        MainPage mainPage = open(environmentConfig.url(), MainPage.class);
        ForecastPageObject forecastPage = mainPage.navigateToForecastPage();
        forecastPage.setCampaigns(CampaignModel.CalvinSpring(), CampaignModel.Calvin28());
        forecastPage.buildForeCast();
        forecastPage.checkPrediction(PredictionModel.SimpleForecast());
    }
}

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class CampaignsPage {

    String addCampaingButton = ".add-campaign-icon";
    String mainPanelWithCampaigns = ".main-card";
    String foreCastButton = ".create-forecast-button";
    String cancelButton = ".cancel-forecast-button";

    @Step("Add Campaign")
    public void addCampaign(){
        $(addCampaingButton).scrollTo().click();
    }

    @Step("Add offer")
    public void addOffer(String campaignName){
    }

    @Step("Create Forecast")
    public ForecastPage createForecast(){
        $(foreCastButton).scrollTo().click();
        return page(ForecastPage.class);
    }

    @Step("Cancel Forecast")
    public PageObject cancelForecast(){
        $(cancelButton).scrollTo().click();
        return page(PageObject.class);
    }

    public ElementsCollection getCampaigns(){
        return $(mainPanelWithCampaigns).$$(byXpath("./div"));
    }

}

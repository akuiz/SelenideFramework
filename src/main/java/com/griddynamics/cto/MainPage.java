package com.griddynamics.cto;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import com.griddynamics.cto.model.CampaignModel;

import java.util.ArrayList;

import static com.griddynamics.cto.assertion.CustomAssertions.assertThat;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {

    final static String SELECTOR_PROMOTION_PAGE = ".app-promotions-page";

    final static String SELECTOR_CREATE_FORECASTBUTTON = ".create-forecast-button";
    final static String SELECTOR_CANCEL_FORECAST_BUTTON = ".cancel-forecast-button";
    final static String SELECTOR__ADD_CAMPAIGN_BUTTON = ".add-campaign-icon";

    final static String SELECTOR_PROMOTIONS_TAB = ".at-promotions-tab";
    final static String SELECTOR_CAMPAIGNS_TAB = ".at-campaigns-tab";
    final static String SELECTOR_FORECAST_TAB = ".at-forecast-tab";

    final static String XPATH_LAST_CAMPAIGN = "//mat-card[contains(@class, 'main-card')]/div[last()]";
    final static String XPATH_FIRST_CAMPAIGN = "//mat-card[contains(@class, 'main-card')]/div[1]";
    final static String XPATH_ALL_CAMPAIGNS = "//mat-card[contains(@class, 'main-card')]/div";

    final static String SELECTOR_CAMPAIGNS_PAGE_OBJECT = "app-campaigns-page";
    final static String SELECTOR_PROMOTIONS_PAGE_OBJECT = "app-promotions-page";
    final static String SELECTOR_FORECAST_PAGE_OBJECT = "app-forecast";


    final static String SELECTOR_TAB_LINKS = ".navigation__tab";

    ElementsCollection navigationLinks = $$(SELECTOR_TAB_LINKS);

    SelenideElement promotionsNavigationTab = navigationLinks.get(0);
    SelenideElement campaignsNavigationTab = navigationLinks.get(1);
    SelenideElement forecastNavigationTab = navigationLinks.last();

    SelenideElement promotionsTabButton = $(byXpath(SELECTOR_PROMOTIONS_TAB));
    SelenideElement campaignsTabButton = $(byXpath(SELECTOR_CAMPAIGNS_TAB));
    SelenideElement forecastTabButton = $(byXpath(SELECTOR_FORECAST_TAB));

    SelenideElement firstCampaignElement = $(byXpath(XPATH_FIRST_CAMPAIGN));
    SelenideElement lastCampaignElement = $(byXpath(XPATH_LAST_CAMPAIGN));

    SelenideElement cancelButton = $(SELECTOR_CANCEL_FORECAST_BUTTON);
    SelenideElement addCampaignButton = $(SELECTOR__ADD_CAMPAIGN_BUTTON);

    ElementsCollection campaignElements = $$(byXpath(XPATH_ALL_CAMPAIGNS));

    SelenideElement createPromotionsPageObject = $(SELECTOR_PROMOTION_PAGE);

    @Step("Navigate to createPromotions Tab")
    public CreatePromotionsPageObject navigateToCreatePromotionsPage() {
        promotionsNavigationTab.click();
        return new CreatePromotionsPageObject($(SELECTOR_PROMOTIONS_PAGE_OBJECT));
    }

    public CreatePromotionsPageObject getPromotionsPageObject(){
        return new CreatePromotionsPageObject($(SELECTOR_PROMOTIONS_PAGE_OBJECT));
    }

    static final String SELECTOR_ADD_PROMOTION = ".btn-add-promo";

    static final String SELECTOR_PROMOTIONS = ".at-promotion";

    SelenideElement addPromotionFirstButton = $$(SELECTOR_ADD_PROMOTION).first();
    SelenideElement addPromotionSecondButton = $$(SELECTOR_ADD_PROMOTION).last();

    public void addPromotion() {
        addPromotionFirstButton.click();
    }

    @Step("Navigate to ManageCampaigns Tab")
    public ManageCampaignsPageObject navigateToManageCampaignsPage() {
        campaignsNavigationTab.click();
        return new ManageCampaignsPageObject($(SELECTOR_CAMPAIGNS_PAGE_OBJECT));
    }

    public ForecastPageObject navigateToForecastPage() {
        forecastNavigationTab.scrollIntoView(false).click();
        return new ForecastPageObject($(SELECTOR_FORECAST_PAGE_OBJECT));
    }
}

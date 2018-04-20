package com.griddynamics.cto;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import com.griddynamics.cto.models.CampaignModel;

import java.util.ArrayList;
import static com.griddynamics.cto.assertions.CustomAssertions.assertThat;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {

    final static String SELECTOR_CREATE_FORECASTBUTTON = ".create-forecast-button";
    final static String SELECTOR_CANCEL_FORECAST_BUTTON = ".cancel-forecast-button";
    final static String SELECTOR__ADD_CAMPAIGN_BUTTON = ".add-campaign-icon";

    final static String XPATH_LAST_CAMPAIGN = "//mat-card[contains(@class, 'main-card')]/div[last()]";
    final static String XPATH_FIRST_CAMPAIGN = "//mat-card[contains(@class, 'main-card')]/div[1]";
    final static String XPATH_ALL_CAMPAIGNS = "//mat-card[contains(@class, 'main-card')]/div";

    SelenideElement firstCampaignElement = $(byXpath(XPATH_FIRST_CAMPAIGN));
    SelenideElement lastCampaignElement = $(byXpath(XPATH_LAST_CAMPAIGN));

    SelenideElement cancelButton = $(SELECTOR_CANCEL_FORECAST_BUTTON);
    SelenideElement addCampaignButton = $(SELECTOR__ADD_CAMPAIGN_BUTTON);

    ElementsCollection campaignElements = $$(byXpath(XPATH_ALL_CAMPAIGNS));

    @Step("Add Campaign")
    public CampaignPageObject addCampaign(CampaignModel campaign) {
        addCampaignButton.scrollTo().click();
        CampaignPageObject campaignPageObject = new CampaignPageObject(lastCampaignElement);
        campaignPageObject.setCampaignValues(campaign);
        return campaignPageObject;
    }

    @Step("Check that all expected campaigns are on the page")
    public void checkCampaignsConfiguration(CampaignListModel expectedCampaigns) {
        CampaignListModel actualCampaigns = getActualCampaigns();
        compareCampaignLists(actualCampaigns, expectedCampaigns);
    }

    @Step("Get campaigns from the page")
    private CampaignListModel getActualCampaigns() {
        ArrayList<CampaignModel> campaigns = new ArrayList<CampaignModel>();
        CampaignListModel actualCampaignList = new CampaignListModel(campaigns);
        for (int campaignNumber = 0; campaignNumber < campaignElements.size() ; campaignNumber++) {
            CampaignPageObject campaignPageObject = new CampaignPageObject(campaignElements.get(campaignNumber));
            campaigns.add(campaignPageObject.getCampaignModel());
        }
        return actualCampaignList;
    }

    @Step("Compare campaigns' values")
    private void compareCampaignLists(CampaignListModel actualCampaigns, CampaignListModel expectedCampaigns) {
        assertThat(actualCampaigns.getCampaigns()).hasSameSizeAs(expectedCampaigns.getCampaigns());
        for (int campaignNumber = 0; campaignNumber < actualCampaigns.getAmountOfCampaigns(); campaignNumber++) {
            CampaignModel actualCampaign = actualCampaigns.getCampaigns().get(campaignNumber);
            CampaignModel expectedCampaign = expectedCampaigns.getCampaigns().get(campaignNumber);
            assertThat(actualCampaign).isSameCampaignAs(expectedCampaign);
        }
    }
}

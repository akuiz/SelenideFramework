package com.griddynamics.cto.data;

import com.griddynamics.cto.CreatePromotionsPageObject;
import com.griddynamics.cto.MainPage;
import com.griddynamics.cto.ManageCampaignsPageObject;
import com.griddynamics.cto.model.CampaignModel;
import com.griddynamics.cto.model.PromotionModel;
import com.sun.javafx.scene.CameraHelper;

import static com.codeborne.selenide.Selenide.open;

public class CampaignDataManager extends DataManager{

    public static void CreateCampaigns(String url, CampaignModel... campaigns) {
        MainPage mainPage = open(url, MainPage.class);
        ManageCampaignsPageObject campaignsPage = mainPage.navigateToManageCampaignsPage();
        for (CampaignModel campaign : campaigns) {
            campaignsPage.addCampaign(campaign);
        }
    }

    public void DeleteAllTestCampaigns(String url, CampaignModel... campaigns){
        MainPage mainPage = open(url, MainPage.class);
        ManageCampaignsPageObject campaignsPage = mainPage.navigateToManageCampaignsPage();
        campaignsPage.deleteTestCampaigns();
    }
}

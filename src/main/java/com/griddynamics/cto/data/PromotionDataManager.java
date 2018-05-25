package com.griddynamics.cto.data;

import com.griddynamics.cto.CreatePromotionsPageObject;
import com.griddynamics.cto.MainPage;
import com.griddynamics.cto.configuration.Configuration;
import com.griddynamics.cto.configuration.EnvironmentConfig;
import com.griddynamics.cto.model.PromotionModel;

import static com.codeborne.selenide.Selenide.open;

public class PromotionDataManager extends DataManager{

    public static void CreatePromotions(String url, PromotionModel... promotions) {
        MainPage mainPage = open(url, MainPage.class);
        CreatePromotionsPageObject promotionsPage = mainPage.getPromotionsPageObject();
        for (PromotionModel promotion : promotions) {
            promotionsPage.addPromotion(promotion);
        }
    }

    public void DeleteAllTestPromotions(String url, PromotionModel... promotions){
        MainPage mainPage = open(url, MainPage.class);
        CreatePromotionsPageObject createPromotionPage = mainPage.getPromotionsPageObject();
        createPromotionPage.deleteTestPromotions();
    }
}

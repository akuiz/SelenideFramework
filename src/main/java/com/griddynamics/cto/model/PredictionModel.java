package com.griddynamics.cto.model;


import javafx.util.Pair;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

import static com.griddynamics.cto.OfferType.PERCENT_OFF;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class PredictionModel {

    private Pair<String, String> revenue;
    private Pair<String, String> profit;
    private Pair<String, String> quantity;

    public static PredictionModel Test2PromotPrediction() {
        return new PredictionModel().toBuilder()
                .revenue(new Pair("$205,038.99", "$64,209,132.03"))
                .profit(new Pair("$85,143.77", "$6,644,541.1"))
                .quantity(new Pair("1184", "427424"))
                .build();
    }

    public static PredictionModel ProductionAdriannaForecast() {
        return new PredictionModel().toBuilder()
                .revenue(new Pair("$739,372.45", "$920,667.55"))
                .profit(new Pair("$301,282.04", "$352,228"))
                .quantity(new Pair("3741", "4873"))
                .build();
    }

    public static PredictionModel CalvinKleinJune2018Dresses5() {
        return new PredictionModel().toBuilder()
                .revenue(new Pair("$167,694.59", "$293,966.63"))
                .profit(new Pair("$76,582.15", "$112,655.74"))
                .quantity(new Pair("942", "1631"))
                .build();
    }

    public static PredictionModel CalvinKleinJune2018Dresses7() {
        return new PredictionModel().toBuilder()
                .revenue(new Pair("$167,694.59", "$329,833.04"))
                .profit(new Pair("$76,582.15", "$112,991.41"))
                .quantity(new Pair("942", "1964"))
                .build();
    }

    public static PredictionModel CalvinKleinJune2018Dresses10() {
        return new PredictionModel().toBuilder()
                .revenue(new Pair("$167,694.59", "$331,384.13"))
                .profit(new Pair("$76,582.15", "$112,320.9"))
                .quantity(new Pair("942", "1980"))
                .build();
    }

    public static PredictionModel AdriannaPapellSpring2018() {
        return new PredictionModel().toBuilder()
                .revenue(new Pair("$493,843.1", "$673,988.79"))
                .profit(new Pair("$201,607.05", "$251,956.66"))
                .quantity(new Pair("2496", "3624"))
                .build();
    }

    public static PredictionModel AdriannaPapellSpringExtended2018() {
        return new PredictionModel().toBuilder()
                .revenue(new Pair("$710,125.67", "$966,991.88"))
                .profit(new Pair("$293,543.86", "$361,958.42"))
                .quantity(new Pair("3556", "5196"))
                .build();
    }

    public static PredictionModel FreePeopleJuly2018() {
        return new PredictionModel().toBuilder()
                .revenue(new Pair("$2,833.45", "$9,234.18"))
                .profit(new Pair("$909.41", "$3,650.66"))
                .quantity(new Pair("15", "44"))
                .build();
    }

    public static PredictionModel FreePeopleJuly2018BOGO() {
        return new PredictionModel().toBuilder()
                .revenue(new Pair("$1,206.7", "$291,407.38"))
                .profit(new Pair("$308.96", "$40,575.24"))
                .quantity(new Pair("7", "1924"))
                .build();
    }

    public static PredictionModel CampaignOFFBOGOSmoke() {
        return new PredictionModel().toBuilder()
                .revenue(new Pair("$94,668.55", "$199,273"))
                .profit(new Pair("$39,990.46", "$68,156.33"))
                .quantity(new Pair("543", "1142"))
                .build();
    }
}

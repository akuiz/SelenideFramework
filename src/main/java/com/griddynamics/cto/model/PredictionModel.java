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

}

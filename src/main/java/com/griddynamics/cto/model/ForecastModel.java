package com.griddynamics.cto.model;

import javafx.util.Pair;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class ForecastModel {

    private Pair<String, String> revenue;
    private Pair<String, String> profit;
    private Pair<String, String> quantity;

    public static ForecastModel CampaignsForecastDemo() {
        return new ForecastModel().toBuilder()
                .revenue(new Pair("$344,755.34", "$343,961.61"))
                .profit(new Pair("$112,967.34", "$112,849.91"))
                .quantity(new Pair("2065", "2057"))
                .build();
    }

    public static ForecastModel FreePeopleJuly2018BOGO() {
        return new ForecastModel().toBuilder()
                .revenue(new Pair("$344,755.34", "$343,961.61"))
                .profit(new Pair("$112,967.34", "$112,849.91"))
                .quantity(new Pair("2065", "2057"))
                .build();
    }

    public static ForecastModel SmokeForecast() {
        return new ForecastModel().toBuilder()
                .revenue(new Pair("$344,755.34", "$343,961.61"))
                .profit(new Pair("$112,967.34", "$112,849.91"))
                .quantity(new Pair("2065", "2057"))
                .build();
    }

    public static ForecastModel CalvinKleinJune2018Dresses5() {
        return new ForecastModel().toBuilder()
                .revenue(new Pair("$344,755.34", "$343,961.61"))
                .profit(new Pair("$112,967.34", "$112,849.91"))
                .quantity(new Pair("2065", "2057"))
                .build();
    }

    public static ForecastModel CalvinKleinJune2018Dresses7() {
        return new ForecastModel().toBuilder()
                .revenue(new Pair("$344,755.34", "$343,961.61"))
                .profit(new Pair("$112,967.34", "$112,849.91"))
                .quantity(new Pair("2065", "2057"))
                .build();
    }

    public static ForecastModel CalvinKleinJune2018Dresses10() {
        return new ForecastModel().toBuilder()
                .revenue(new Pair("$344,755.34", "$343,961.61"))
                .profit(new Pair("$112,967.34", "$112,849.91"))
                .quantity(new Pair("2065", "2057"))
                .build();
    }

    public static ForecastModel AdriannaPapellSpring2018() {
        return new ForecastModel().toBuilder()
                .revenue(new Pair("$344,755.34", "$343,961.61"))
                .profit(new Pair("$112,967.34", "$112,849.91"))
                .quantity(new Pair("2065", "2057"))
                .build();
    }

    public static ForecastModel AdriannaPapellSpringExtended2018() {
        return new ForecastModel().toBuilder()
                .revenue(new Pair("$344,755.34", "$343,961.61"))
                .profit(new Pair("$112,967.34", "$112,849.91"))
                .quantity(new Pair("2065", "2057"))
                .build();
    }

    public static ForecastModel FreePeopleJuly2018() {
        return new ForecastModel().toBuilder()
                .revenue(new Pair("$344,755.34", "$343,961.61"))
                .profit(new Pair("$112,967.34", "$112,849.91"))
                .quantity(new Pair("2065", "2057"))
                .build();
    }
}

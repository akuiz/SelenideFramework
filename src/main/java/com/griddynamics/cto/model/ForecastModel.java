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
                .revenue(new Pair("$1,873,563.55", "$2,207,292.76"))
                .profit(new Pair("$778,860.52", "$860,299.32"))
                .quantity(new Pair("9679", "11795"))
                .build();
    }

    public static ForecastModel FreePeopleJuly2018BOGO() {
        return new ForecastModel().toBuilder()
                .revenue(new Pair("$2,833.45", "$293,034.13"))
                .profit(new Pair("$909.41", "$41,175.69"))
                .quantity(new Pair("15", "1932"))
                .build();
    }

    public static ForecastModel SmokeForecast() {
        return new ForecastModel().toBuilder()
                .revenue(new Pair("$344,755.34", "$343,961.61"))
                .profit(new Pair("$112,967.34", "$112,849.91"))
                .quantity(new Pair("2065", "2057"))
                .build();
    }

    public static ForecastModel CampaignOFFBOGOSmoke() {
        return new ForecastModel().toBuilder()
                .revenue(new Pair("$28,307.98", "$31,717.26"))
                .profit(new Pair("$9,517.98", "$10,670.66"))
                .quantity(new Pair("165", "183"))
                .build();
    }

    public static ForecastModel CalvinKleinJune2018Dresses5() {
        return new ForecastModel().toBuilder()
                .revenue(new Pair("$167,694.59", "$293,966.63"))
                .profit(new Pair("$76,582.15", "$112,655.74"))
                .quantity(new Pair("942", "1631"))
                .build();
    }

    public static ForecastModel CalvinKleinJune2018Dresses7() {
        return new ForecastModel().toBuilder()
                .revenue(new Pair("$167,694.59", "$329,833.04"))
                .profit(new Pair("$76,582.15", "$112,991.41"))
                .quantity(new Pair("942", "1964"))
                .build();
    }

    public static ForecastModel CalvinKleinJune2018Dresses10() {
        return new ForecastModel().toBuilder()
                .revenue(new Pair("$167,694.59", "$331,384.13"))
                .profit(new Pair("$76,582.15", "$112,320.9"))
                .quantity(new Pair("942", "1980"))
                .build();
    }

    public static ForecastModel AdriannaPapellSpring2018() {
        return new ForecastModel().toBuilder()
                .revenue(new Pair("$493,843.1", "$673,988.79"))
                .profit(new Pair("$201,607.05", "$251,956.66"))
                .quantity(new Pair("2496", "3624"))
                .build();
    }

    public static ForecastModel AdriannaPapellSpringExtended2018() {
        return new ForecastModel().toBuilder()
                .revenue(new Pair("$710,125.67", "$966,991.88"))
                .profit(new Pair("$293,543.86", "$361,958.42"))
                .quantity(new Pair("3556", "5196"))
                .build();
    }

    public static ForecastModel FreePeopleJuly2018() {
        return new ForecastModel().toBuilder()
                .revenue(new Pair("$2,833.45", "$9,234.18"))
                .profit(new Pair("$909.41", "$3,650.66"))
                .quantity(new Pair("15", "44"))
                .build();
    }

    public static ForecastModel ThreeCampaignsForecast() {
        return new ForecastModel().toBuilder()
                .revenue(new Pair("$365,247.28", "$306,155.91"))
                .profit(new Pair("$122,445.53", "$107,328.17"))
                .quantity(new Pair("2151", "1748"))
                .build();
    }

    public static ForecastModel CampaignOFFBOGOSmokeFirstDate() {
        return new ForecastModel().toBuilder()
                .revenue(new Pair("$289,602.79", "$256,097.83"))
                .profit(new Pair("$94,205.55", "$92,748.69"))
                .quantity(new Pair("1725", "1469"))
                .build();
    }

    public static ForecastModel CampaignOFFBOGOForecastSecondDate() {
        return new ForecastModel().toBuilder()
                .revenue(new Pair("$68,839.83", "$81,536.64"))
                .profit(new Pair("$22,328.74", "$27,523.37"))
                .quantity(new Pair("410", "471"))
                .build();
    }
}


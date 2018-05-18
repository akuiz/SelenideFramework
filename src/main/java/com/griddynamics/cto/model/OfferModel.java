package com.griddynamics.cto.model;

import com.griddynamics.cto.OfferType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

import static com.griddynamics.cto.OfferType.*;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class OfferModel {

    private String name;
    private ArrayList<String> brands;
    private OfferType type;
    private String value;

    public static OfferModel PromotionOFFSmoke() {
        return new OfferModel().toBuilder()
                .name("Smoke promotion %OFF")
                .brands(new ArrayList<String>() {{
                    add("Calvin Klein");
                    add("Free People");
                }})
                .type(PERCENT_OFF)
                .value("8%")
                .build();
    }

    public static OfferModel SmokePromotionBOGO() {
        return new OfferModel().toBuilder()
                .name("Smoke promotion BOGO")
                .brands(new ArrayList<String>() {{
                    add("adidas");
                    add("Diesel");
                }})
                .type(BOGO)
                .value("")
                .build();
    }

    public static OfferModel SmokeDeletePromotionBOGO() {
        return new OfferModel().toBuilder()
                .name("This BOGO promotion should be deleted")
                .brands(new ArrayList<String>() {{
                    add("Free People");
                }})
                .type(BOGO)
                .value("")
                .build();
    }

    public static OfferModel SmokeDeletePromotionOFF() {
        return new OfferModel().toBuilder()
                .name("This %OFF promotion should be deleted")
                .brands(new ArrayList<String>() {{
                    add("Diesel");
                }})
                .type(PERCENT_OFF)
                .value("8%")
                .build();
    }

    public static OfferModel CalvinKleinFixDiscount() {
        return new OfferModel().toBuilder()
                .name("AT-promo-fix")
                .brands(new ArrayList<String>() {{
                    add("Calvin Klein");
                }})
                .type(FIX_DISCOUNT)
                .value("8$")
                .build();
    }

    public static OfferModel CalvinKleinPercentOfAmoutDiscount() {
        return new OfferModel().toBuilder()
                .name("Calvin Klein Jeans 7 % of amount discount")
                .brands(new ArrayList<String>() {{
                    add("Calvin Klein");
                }})
                .type(PERCENT_OF_AMOUNT)
                .value("8%")
                .build();
    }

    public static OfferModel PromotionWithNoBrands() {
        return new OfferModel().toBuilder()
                .name("Promotion with no brands")
                .brands(new ArrayList<String>() {{
                }})
                .type(PERCENT_OFF)
                .value("8%")
                .build();
    }

    public static OfferModel EditTestOriginPromotion() {
        return new OfferModel().toBuilder()
                .name("This is initial edit promotion test name")
                .brands(new ArrayList<String>() {{
                    add("Calvin Klein");
                    add("Free People");

                }})
                .type(PERCENT_OFF)
                .value("8%")
                .build();
    }

    public static OfferModel EditNameOriginPromotion() {
        return new OfferModel().toBuilder()
                .name("This promotion should be renamed after test completion")
                .brands(new ArrayList<String>() {{
                    add("Calvin Klein");
                    add("Free People");

                }})
                .type(PERCENT_OFF)
                .value("8%")
                .build();
    }

    public static OfferModel EditNameRenamedPromotion() {
        return new OfferModel().toBuilder()
                .name("This promotion was renamed during the test")
                .brands(new ArrayList<String>() {{
                    add("Calvin Klein");
                    add("Free People");

                }})
                .type(PERCENT_OFF)
                .value("8%")
                .build();
    }

    public static OfferModel EditTypeOriginPromotionOFF() {
        return new OfferModel().toBuilder()
                .name("Type of this promotion should be changed to BOGO")
                .brands(new ArrayList<String>() {{
                    add("Calvin Klein");
                    add("Free People");

                }})
                .type(PERCENT_OFF)
                .value("8%")
                .build();
    }

    public static OfferModel EditTypeChangedPromotionBOGO() {
        return new OfferModel().toBuilder()
                .name("The type of this promotion has been changed to BOGO")
                .brands(new ArrayList<String>() {{
                    add("Calvin Klein");
                    add("Free People");
                }})
                .type(BOGO)
                .value("")
                .build();
    }

    public static OfferModel DuplicatePromotion() {
        return new OfferModel().toBuilder()
                .name("This promotion should exists twice")
                .brands(new ArrayList<String>() {{
                    add("Calvin Klein");
                    add("Free People");
                }})
                .type(PERCENT_OFF)
                .value("8%")
                .build();
    }

    public static OfferModel TestForecastOFFPromotion() {
        return new OfferModel().toBuilder()
                .name("ForecastTestPromotionOFF")
                .brands(new ArrayList<String>() {{
                    add("Calvin Klein");
                }})
                .type(PERCENT_OFF)
                .value("8%")
                .build();
    }

    public static OfferModel TestForecastBOGOPromotion() {
        return new OfferModel().toBuilder()
                .name("ForecastTestPromotionBOGO")
                .brands(new ArrayList<String>() {{
                    add("Free People");
                }})
                .type(BOGO)
                .value("")
                .build();
    }


    public boolean isBOGO() {
        return this.getType().equals(BOGO);
    }

}

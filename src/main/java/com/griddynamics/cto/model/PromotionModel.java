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
public class PromotionModel {

    private String name;
    private ArrayList<String> brands;
    private OfferType type;
    private String value;

    public static PromotionModel PromotionOFFSmoke() {
        return new PromotionModel().toBuilder()
                .name("at_Smoke promotion %OFF")
                .brands(new ArrayList<String>() {{
                    add("Calvin Klein");
                    add("Free People");
                }})
                .type(PERCENT_OFF)
                .value("8%")
                .build();
    }

    public static PromotionModel SmokePromotionBOGO() {
        return new PromotionModel().toBuilder()
                .name("at_Smoke promotion BOGO")
                .brands(new ArrayList<String>() {{
                    add("adidas");
                    add("Diesel");
                }})
                .type(BOGO)
                .value("")
                .build();
    }

    public static PromotionModel SmokeDeletePromotionBOGO() {
        return new PromotionModel().toBuilder()
                .name("at_This BOGO promotion should be deleted")
                .brands(new ArrayList<String>() {{
                    add("Free People");
                }})
                .type(BOGO)
                .value("")
                .build();
    }

    public static PromotionModel SmokeDeletePromotionOFF() {
        return new PromotionModel().toBuilder()
                .name("at_This %OFF promotion should be deleted")
                .brands(new ArrayList<String>() {{
                    add("Diesel");
                }})
                .type(PERCENT_OFF)
                .value("8%")
                .build();
    }

    public static PromotionModel CalvinKleinFixDiscount() {
        return new PromotionModel().toBuilder()
                .name("at_AT-promo-fix")
                .brands(new ArrayList<String>() {{
                    add("Calvin Klein");
                }})
                .type(FIX_DISCOUNT)
                .value("8$")
                .build();
    }

    public static PromotionModel CalvinKleinPercentOfAmoutDiscount() {
        return new PromotionModel().toBuilder()
                .name("at_Calvin Klein Jeans 7 % of amount discount")
                .brands(new ArrayList<String>() {{
                    add("Calvin Klein");
                }})
                .type(PERCENT_OF_AMOUNT)
                .value("8%")
                .build();
    }

    public static PromotionModel PromotionWithNoBrands() {
        return new PromotionModel().toBuilder()
                .name("at_Promotion with no brands")
                .brands(new ArrayList<String>() {{
                }})
                .type(PERCENT_OFF)
                .value("8%")
                .build();
    }

    public static PromotionModel PromotionWithEmptyName() {
        return new PromotionModel().toBuilder()
                .name("")
                .brands(new ArrayList<String>() {{
                    add("Calvin Klein");
                }})
                .type(PERCENT_OFF)
                .value("8%")
                .build();
    }

    public static PromotionModel EditTestOriginPromotion() {
        return new PromotionModel().toBuilder()
                .name("at_This is initial edit promotion test name")
                .brands(new ArrayList<String>() {{
                    add("Calvin Klein");
                    add("Free People");

                }})
                .type(PERCENT_OFF)
                .value("8%")
                .build();
    }

    public static PromotionModel EditNameOriginPromotion() {
        return new PromotionModel().toBuilder()
                .name("at_This promotion should be renamed after test completion")
                .brands(new ArrayList<String>() {{
                    add("Calvin Klein");
                    add("Free People");

                }})
                .type(PERCENT_OFF)
                .value("8%")
                .build();
    }

    public static PromotionModel EditNameRenamedPromotion() {
        return new PromotionModel().toBuilder()
                .name("at_This promotion was renamed during the test")
                .brands(new ArrayList<String>() {{
                    add("Calvin Klein");
                    add("Free People");

                }})
                .type(PERCENT_OFF)
                .value("8%")
                .build();
    }

    public static PromotionModel EditValueOriginPromotion() {
        return new PromotionModel().toBuilder()
                .name("at_Value should be changed after test completion")
                .brands(new ArrayList<String>() {{
                    add("Calvin Klein");
                    add("Free People");

                }})
                .type(PERCENT_OFF)
                .value("8%")
                .build();
    }

    public static PromotionModel EditValueChangedPromotion() {
        return new PromotionModel().toBuilder()
                .name("at_Value should be changed after test completion")
                .brands(new ArrayList<String>() {{
                    add("Calvin Klein");
                    add("Free People");

                }})
                .type(PERCENT_OFF)
                .value("10%")
                .build();
    }

    public static PromotionModel EditTypeOriginPromotionOFF() {
        return new PromotionModel().toBuilder()
                .name("at_Type of this promotion should be changed to BOGO")
                .brands(new ArrayList<String>() {{
                    add("Calvin Klein");
                    add("Free People");

                }})
                .type(PERCENT_OFF)
                .value("8%")
                .build();
    }

    public static PromotionModel EditTypeChangedPromotionBOGO() {
        return new PromotionModel().toBuilder()
                .name("at_The type of this promotion has been changed to BOGO")
                .brands(new ArrayList<String>() {{
                    add("Calvin Klein");
                    add("Free People");
                }})
                .type(BOGO)
                .value("")
                .build();
    }

    public static PromotionModel DuplicatePromotion() {
        return new PromotionModel().toBuilder()
                .name("at_This promotion should exists twice")
                .brands(new ArrayList<String>() {{
                    add("Calvin Klein");
                    add("Free People");
                }})
                .type(PERCENT_OFF)
                .value("8%")
                .build();
    }

    public static PromotionModel TestForecastOFFPromotion() {
        return new PromotionModel().toBuilder()
                .name("at_ForecastTestPromotionOFF")
                .brands(new ArrayList<String>() {{
                    add("Calvin Klein");
                }})
                .type(PERCENT_OFF)
                .value("8%")
                .build();
    }

    public static PromotionModel TestForecastBOGOPromotion() {
        return new PromotionModel().toBuilder()
                .name("at_ForecastTestPromotionBOGO")
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

    public static PromotionModel CalvinKleinOFF5() {
        return new PromotionModel().toBuilder()
                .name("Calvin Klein Special Offer 5%")
                .brands(new ArrayList<String>() {{
                    add("Calvin Klein");
                }})
                .type(PERCENT_OFF)
                .value("5%")
                .build();
    }

    public static PromotionModel CalvinKleinOFF7() {
        return new PromotionModel().toBuilder()
                .name("Calvin Klein Special Offer 7%")
                .brands(new ArrayList<String>() {{
                    add("Calvin Klein");
                }})
                .type(PERCENT_OFF)
                .value("7%")
                .build();
    }

    public static PromotionModel CalvinKleinOFF10() {
        return new PromotionModel().toBuilder()
                .name("Calvin Klein Special Offer 10%")
                .brands(new ArrayList<String>() {{
                    add("Calvin Klein");
                }})
                .type(PERCENT_OFF)
                .value("10%")
                .build();
    }

    public static PromotionModel AdriannaPapellOFF5() {
        return new PromotionModel().toBuilder()
                .name("Adrianna Papell 5% OFF")
                .brands(new ArrayList<String>() {{
                    add("Adrianna Papell");
                }})
                .type(PERCENT_OFF)
                .value("5%")
                .build();
    }

    public static PromotionModel FreePeopleOFF10() {
        return new PromotionModel().toBuilder()
                .name("Free People 10% OFF")
                .brands(new ArrayList<String>() {{
                    add("Free People");
                }})
                .type(PERCENT_OFF)
                .value("10%")
                .build();
    }

    public static PromotionModel FreePeopleBOGO() {
        return new PromotionModel().toBuilder()
                .name("Free People BOGO")
                .brands(new ArrayList<String>() {{
                    add("Free People");
                }})
                .type(BOGO)
                .value("")
                .build();
    }
}

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

    public static OfferModel CalvinKlein7OFF() {
        return new OfferModel().toBuilder()
                .name("Calvin Klein 8% off")
                .brands(new ArrayList<String>() {{
                    add("Calvin Klein");
                    add("Free People");
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

    public static OfferModel CalvinKlein5OFF() {
        return new OfferModel().toBuilder()
                .name("Calvin Klein Spring 5% off")
                .brands(new ArrayList<String>() {{
                    add("Free People");
                }})
                .type(BOGO)
                .value("")
                .build();
    }

    public static OfferModel SimpleBOGOPromotion() {
        return new OfferModel().toBuilder()
                .name("sort_test1")
                .brands(new ArrayList<String>() {{
                    add("Free People");
                }})
                .type(BOGO)
                .value("")
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

    public static OfferModel EditTestModifiedNamePromotion() {
        return new OfferModel().toBuilder()
                .name("This is modified edit promotion test name")
                .brands(new ArrayList<String>() {{
                    add("Calvin Klein");
                    add("Free People");
                }})
                .type(PERCENT_OFF)
                .value("8%")
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

    public static OfferModel TestCampaignBOGOPromotion() {
        return new OfferModel().toBuilder()
                .name("CreateCampaignTestPromotionBOGO")
                .brands(new ArrayList<String>() {{
                    add("Calvin Klein");
                    add("Free People");
                }})
                .type(BOGO)
                .value("")
                .build();
    }

    public static OfferModel TestEditCampaignPromotionBOGO() {
        return new OfferModel().toBuilder()
                .name("TestEditCampaignPromotionBOGO")
                .brands(new ArrayList<String>() {{
                    add("Diesel");
                    add("DL1961");
                }})
                .type(BOGO)
                .value("")
                .build();
    }

    public static OfferModel TestEditCampaignPromotionOFF() {
        return new OfferModel().toBuilder()
                .name("TestEditCampaignPromotionOFF")
                .brands(new ArrayList<String>() {{
                    add("Calvin Klein");
                    add("Free People");
                }})
                .type(PERCENT_OFF)
                .value("13%")
                .build();
    }

    public static OfferModel TestCreateCampaignWithBOGOPromotion() {
        return new OfferModel().toBuilder()
                .name("CreateCampaignTestWithBOGOPromotion")
                .brands(new ArrayList<String>() {{
                    add("Diesel");
                    add("DL1961");
                    add("Dolce Vita");
                }})
                .type(BOGO)
                .value("")
                .build();
    }

    public static OfferModel TestCreateCampaignWithOFFPromotion() {
        return new OfferModel().toBuilder()
                .name("CreateCampaignTestWithOFFPromotion")
                .brands(new ArrayList<String>() {{
                    add("Blue Life");
                    add("Life is Good");
                    add("NAU");
                }})
                .type(PERCENT_OFF)
                .value("12%")
                .build();
    }

    public static OfferModel TestCampaignOFFPromotion() {
        return new OfferModel().toBuilder()
                .name("CreateCampaignTestPromotionOFF")
                .brands(new ArrayList<String>() {{
                    add("Calvin Klein");
                    add("Free People");
                }})
                .type(PERCENT_OFF)
                .value("10%")
                .build();
    }

    public static OfferModel TestDeleteCampaignBOGOPromotion() {
        return new OfferModel().toBuilder()
                .name("DeleteCampaignTestPromotionBOGO")
                .brands(new ArrayList<String>() {{
                    add("Calvin Klein");
                    add("Free People");
                }})
                .type(BOGO)
                .value("")
                .build();
    }

    public static OfferModel TestDeleteCampaignOFFPromotion() {
        return new OfferModel().toBuilder()
                .name("DeleteCampaignTestPromotionOFF")
                .brands(new ArrayList<String>() {{
                    add("Calvin Klein");
                    add("Free People");
                }})
                .type(PERCENT_OFF)
                .value("10%")
                .build();
    }

    public boolean isBOGO() {
        return this.getType().equals(BOGO);
    }

}

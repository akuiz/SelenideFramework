package com.griddynamics.cto.models;

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

    public static OfferModel CalvinKlein7OFF() {
        return new OfferModel().toBuilder()
                .name("Calvin Klein Jeans Spring 7% off")
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

    public static OfferModel CalvinKlein8OFF() {
        return new OfferModel().toBuilder()
                .name("sort_test1")
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

    public static OfferModel EmptyNamePromotion() {
        return new OfferModel().toBuilder()
                .name("")
                .brands(new ArrayList<String>() {{
                    add("Free People");
                }})
                .type(PERCENT_OFF)
                .value("8%")
                .build();
    }

    public static OfferModel EditTestOriginPromotion(){
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

    public static OfferModel EditTestModifiedPromotion(){
        return new OfferModel().toBuilder()
                .name("Completely different promotion")
                .brands(new ArrayList<String>() {{
                    add("Calvin Klein");
                    add("Free People");
                }})
                .type(BOGO)
                .value("")
                .build();
    }

    public static OfferModel EditTestModifiedNamePromotion(){
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

    public static OfferModel DuplicatePromotion(){
        return new OfferModel().toBuilder()
                .name("This11 is promotion for duplicate test11")
                .brands(new ArrayList<String>() {{
                    add("Calvin Klein");
                    add("Free People");
                }})
                .type(PERCENT_OFF)
                .value("8%")
                .build();
    }

    public static OfferModel TestCampaignBOGOPromotion(){
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

    public static OfferModel TestCampaignOFFPromotion(){
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

    public boolean isBOGO(){
        return this.getType().equals(BOGO);
    }

}

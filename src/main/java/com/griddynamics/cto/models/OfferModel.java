package com.griddynamics.cto.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class OfferModel {

    private String name;
    private String rule;
    private String type;
    private String value;

    public static OfferModel CalvinKlein7OFF() {
        return new OfferModel().toBuilder()
                .name("Calvin Klein Jeans Spring 7% off")
                .rule("TestRule7")
                .type("ofr_pct_off_amt")
                .value("0.07")
                .build();
    }

    public static OfferModel CalvinKlein5OFF() {
        return new OfferModel().toBuilder()
                .name("Calvin Klein Spring 5% off")
                .rule("TestRule5")
                .type("ofr_pct_off_amt")
                .value("0.07")
                .build();
    }
}

package com.griddynamics.cto;

public enum OfferType {
    PERCENT_OFF("% OFF"), BOGO("Buy One Get One"), PERCENT_OF_AMOUNT("% Of Amount"), FIX_DISCOUNT("$ Fix");

    private String text;

    OfferType(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public static OfferType fromString(String text) {
        for (OfferType b : OfferType.values()) {
            if (b.text.equalsIgnoreCase(text)) {
                return b;
            }
        }
        throw new IllegalArgumentException("No constant with text " + text + " found");
    }
}

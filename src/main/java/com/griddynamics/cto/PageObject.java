package com.griddynamics.cto;

import com.codeborne.selenide.SelenideElement;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.not;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class PageObject {

    final static String SELECTOR_LOADER_SPINNER = ".mat-progress-spinner";

    SelenideElement root;
    long timeout = 20000;

    DateTimeFormatter formatter = DateTimeFormat.forPattern("MM/dd/yyyy");

    public PageObject(SelenideElement root) {
        this.root = root;
    }

    protected void waitForLoader() {
        $(SELECTOR_LOADER_SPINNER).shouldBe(visible);
        $(SELECTOR_LOADER_SPINNER).waitUntil(not(visible), timeout);
    }

}

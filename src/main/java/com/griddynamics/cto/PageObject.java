package com.griddynamics.cto;

import com.codeborne.selenide.SelenideElement;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class PageObject {

    SelenideElement root;
    long timeout = 20000;

    DateTimeFormatter formatter = DateTimeFormat.forPattern("MM/dd/yyyy");


    public PageObject(SelenideElement root) {
        this.root = root;
    }

}

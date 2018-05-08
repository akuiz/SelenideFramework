package com.griddynamics.cto;

import com.codeborne.selenide.SelenideElement;

public class PageObject {

    SelenideElement root;
    long timeout = 20000;

    public PageObject(SelenideElement root) {
        this.root = root;
    }

}

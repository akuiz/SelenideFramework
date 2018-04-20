package com.griddynamics.cto;

import com.codeborne.selenide.SelenideElement;

public class PageObject {

    SelenideElement root;

    public PageObject(SelenideElement root) {
        this.root = root;
    }

}

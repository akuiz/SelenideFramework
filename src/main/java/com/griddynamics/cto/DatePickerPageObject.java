package com.griddynamics.cto;

import com.codeborne.selenide.SelenideElement;
import org.joda.time.DateTime;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byValue;
import static com.codeborne.selenide.Selenide.$;

public class DatePickerPageObject extends PageObject{

    final static String SELECTOR_PREVIOUS_MONTH = ".mat-calendar-previous-button";
    final static String SELECTOR_NEXT_MONTH = ".mat-calendar-next-button";
    final static int defaultYear = 2018;
     int defaultMonth = 5;

    private int yearToPick;
    private String month;
    private int dayToPick;

    SelenideElement previousMonthButton = $(SELECTOR_PREVIOUS_MONTH);
    SelenideElement nextMonthButton = $(SELECTOR_NEXT_MONTH);

    public DatePickerPageObject(SelenideElement root) {
        super(root);
    }

    public void pickDate(DateTime date){
        yearToPick = date.getYear();
        month = date.monthOfYear().getAsText();
        dayToPick = date.getDayOfMonth();
        pickYear(date.getYear());
        pickMonth(date.getMonthOfYear());
        pickDay(date.getDayOfMonth());
    }

    public void pickDate(DateTime date, int defaultMonth){
        this.defaultMonth = defaultMonth;
        yearToPick = date.getYear();
        month = date.monthOfYear().getAsText();
        dayToPick = date.getDayOfMonth();
        pickYear(date.getYear());
        pickMonth(date.getMonthOfYear());
        pickDay(date.getDayOfMonth());
    }

    private void pickDay(int dayOfMonth) {
        String label = month + " " + dayToPick + ", "+yearToPick;
        $(byAttribute("aria-label",label)).click();
    }

    private void pickMonth(int monthOfYear) {
        if(monthOfYear == defaultMonth) return;
        int monthDifference = monthOfYear - defaultMonth;
        if(monthDifference > 0){
            for (int i = 0; i < monthDifference ; i++) {
                nextMonthButton.click();
            }
        }
        else {
            monthDifference *= -1;
            for (int i = 0; i < monthDifference ; i++) {
                previousMonthButton.click();
            }
        }
    }

    private void pickYear(int year) {
        if(year == defaultYear) return;
        int yearDifference = year - defaultYear;
        if(yearDifference > 0){
            for (int i = 0; i < 12 ; i++) {
                nextMonthButton.click();
            }
        }
        else{
            yearDifference *= -1;
            for (int i = 0; i < yearDifference * 12 ; i++) {
                previousMonthButton.click();
            }
        }
    }

}

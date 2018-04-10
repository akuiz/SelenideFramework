
import org.openqa.selenium.By;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class GooglePage extends PageObject {

    @Step("asd")
    public PageObject luckySearch() {
        $(By.name("btnI")).click();
        return page(PageObject.class);
    }

    public SearchResultsGooglePage searchForText(String text) {
        $(By.name("q")).val(text).pressEnter();
        return page(SearchResultsGooglePage.class);
    }

}

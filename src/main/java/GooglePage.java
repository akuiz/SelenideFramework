
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class GooglePage extends PageObject {


    public PageObject luckySearch() {
        $(By.name("btnI")).click();
        return page(PageObject.class);
    }

    public SearchResultsGooglePage searchForText(String text) {
        $(By.name("q")).val(text).pressEnter();
        return page(SearchResultsGooglePage.class);
    }

}

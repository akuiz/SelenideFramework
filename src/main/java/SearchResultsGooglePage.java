import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.page;

public class SearchResultsGooglePage {

    public ElementsCollection getResults() {
        return $$("#ires .g");
    }

    public SelenideElement getResult(int index) {
        return $("#ires .g", index);
    }

    public ImageSearchPage switchToImages(){
        $("#hdtb-msb-vis").$(byXpath("//div[1]//a")).click();
        return page(ImageSearchPage.class);
    }
}

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;


public class GoogleSearchTest {

    @Test
    public void searchWiki() {
        GooglePage googlePage = open("https://google.com/", GooglePage.class);
        SearchResultsGooglePage resultsPage = googlePage.searchForText("wiki");
        resultsPage.getResults().shouldHave(sizeGreaterThan(1));
        resultsPage.getResult(0).shouldHave(text("Wiki - Wikipedia"));
        ImageSearchPage images = resultsPage.switchToImages();
        images.clickFirstImage();
    }

    @Test
    public void luckySearchTest() {
        GooglePage googlePage = open("https://google.com/", GooglePage.class);
        PageObject randomPage = googlePage.luckySearch();
        randomPage.clickLogo();
    }
}

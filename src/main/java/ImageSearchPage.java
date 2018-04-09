import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class ImageSearchPage {
    public PageObject clickFirstImage(){
        $("#rg_s").$(byXpath("//div[0]")).click();
        return page(PageObject.class);
    }
}

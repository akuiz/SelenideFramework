import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class PageObject {
    public PageObject clickLogo(){
        $("#logo").click();
        return page(PageObject.class);
    }
}

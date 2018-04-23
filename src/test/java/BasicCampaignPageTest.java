import com.griddynamics.cto.CreatePromotionsPageObject;
import com.griddynamics.cto.MainPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class BasicCampaignPageTest {

    MainPage mainPage;

    final static String PRODUCTION_URL = "http://35.196.36.23:4200/promo";
    final static String LOCALHOST_URL = "http://localhost:4200/";

    @BeforeClass
    public void init() {
        mainPage = open(LOCALHOST_URL, MainPage.class);
    }

    @Test(description = "Check all campaigns on the page")
    public void demoTest() {
        CreatePromotionsPageObject createPromotionPage = mainPage.navigateToCreatePromotionsPage();
        createPromotionPage.addPromotion();
    }
}

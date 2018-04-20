import com.griddynamics.cto.CampaignListModel;
import com.griddynamics.cto.MainPage;
import com.griddynamics.cto.models.CampaignModel;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class BasicCampaignPageTest {

    MainPage campaignsPage;

    final static String PRODUCTION_URL = "http://35.196.36.23:4200/discounts";
    final static String LOCALHOST_URL = "http://localhost:4200/discounts";

    @BeforeClass
    public void init() {
        campaignsPage = open(LOCALHOST_URL, MainPage.class);
    }

    @Test(description = "Check all campaigns on the page")
    public void demoTest() {
        campaignsPage.addCampaign(CampaignModel.CalvinKleinSpring2018());
        campaignsPage.addCampaign(CampaignModel.CalvinKleinSpring2019());
        campaignsPage.checkCampaignsConfiguration(CampaignListModel.testInitCampaignList());
    }
}

import org.testng.annotations.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.open;

public class BasicCampaignPageTest {

    @Test(description = "Add 3 campaigns. Amount of campaigns should be 4")
    public void addCampaign(){
        CampaignsPage campaignsPage = open("https://discounts-tool.herokuapp.com/discounts", CampaignsPage.class);
        campaignsPage.addCampaign();
        campaignsPage.addCampaign();
        campaignsPage.addCampaign();
        campaignsPage.getCampaigns().shouldHave(size(4));
    }

}

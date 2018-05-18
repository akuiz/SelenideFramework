package com.griddynamics.cto;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.griddynamics.cto.model.CampaignModel;
import com.griddynamics.cto.model.DiscountModel;
import com.griddynamics.cto.model.OfferModel;
import org.joda.time.DateTime;

import java.util.ArrayList;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.griddynamics.cto.assertion.CampaignModelAssert.assertThat;

public class ManageCampaignsPageObject extends PageObject {

    static final String SELECTOR_ADD_CAMPAIGN = ".btn-add-promo";

    SelenideElement addCampaignFirstButton = root.$$(SELECTOR_ADD_CAMPAIGN).first();
    SelenideElement addCampaignSecondButton = root.$$(SELECTOR_ADD_CAMPAIGN).last();

    String SELECTOR_ADD_NEW_CAMPAIGN_WINDOW = ".mat-dialog-container";

    static final String SELECTOR_CAMPAIGNS = "";

    ElementsCollection campaigns = root.$$(SELECTOR_CAMPAIGNS);

    public ManageCampaignsPageObject(SelenideElement root) {
        super(root);
    }

    public CampaignPageObject addCampaign(CampaignModel campaign) {
        Selenide.sleep(3000);
        addCampaignFirstButton.click();
        NewCampaignPageObject createNewCampaignWindow = new NewCampaignPageObject($(SELECTOR_ADD_NEW_CAMPAIGN_WINDOW));
        createNewCampaignWindow.addCampaign(campaign);
        checkCampaignExists(campaign);
        CampaignPageObject campaignPageObject = new CampaignPageObject(root.$(byText(campaign.getName())).parent().parent());
        return campaignPageObject;
    }

    public void checkCampaignExistsTwice(CampaignModel originCampaign) {
        ArrayList<CampaignPageObject> campaignList = findAllCampaignsByName(originCampaign.getName());
        for (int i = 0; i < campaignList.size(); i++) {
            CampaignModel campaign = campaignList.get(i).getCampaignModel();
            assertThat(campaign).isSameCampaignAs(originCampaign);
        }
    }

    public ArrayList<CampaignPageObject> findAllCampaignsByName(String name) {
        $$(byText(name)).shouldHaveSize(2);
        ArrayList campaigns = new ArrayList();
        campaigns.add(new CampaignPageObject(root.$$(byText(name)).get(0).parent().parent()));
        campaigns.add(new CampaignPageObject(root.$$(byText(name)).get(1).parent().parent()));
        return campaigns;
    }

    public void checkCampaignExists(CampaignModel expectedCampaign) {
        CampaignModel actualCampaign = findCampaignByName(expectedCampaign.getName());
        assertThat(actualCampaign).isSameCampaignAs(expectedCampaign);
    }

    private CampaignModel findCampaignByName(String name) {
        CampaignPageObject campaignPageObject = new CampaignPageObject(root.$(byText(name)).parent().parent());
        campaignPageObject.expand();
        CampaignModel campaign = new CampaignModel().toBuilder()
                .name(campaignPageObject.getName())
                .startDate(campaignPageObject.getStartDate())
                .endDate(campaignPageObject.getEndDate())
                .discounts(campaignPageObject.getDiscounts())
                .build();
        return campaign;
    }

    public void deleteCampaignByName(String name) {
        CampaignPageObject campaignPageObject = new CampaignPageObject(root.$(byText(name)).parent().parent());
        campaignPageObject.delete();
        checkCampaingNotExists(name);
    }

    public void checkCampaingNotExists(String name) {
        $(byText(name)).shouldNot(exist);
    }

    public void duplicateCampaign(CampaignModel campaignModel) {
        CampaignPageObject campaignPageObject = new CampaignPageObject(root.$(byText(campaignModel.getName())).parent().parent());
        campaignPageObject.duplicateCampaign();
    }

    public void editCampaign(CampaignModel originCampaign, CampaignModel editedCampaign) {
        CampaignPageObject campaignPageObject = new CampaignPageObject(root.$(byText(originCampaign.getName())).parent().parent());
        campaignPageObject.editCampaign(editedCampaign);
        checkCampaingNotExists(originCampaign.getName());
    }

    public void changeCampaignName(CampaignModel campaignModel, String name) {
        CampaignPageObject campaignPageObject = new CampaignPageObject(root.$(byText(campaignModel.getName())).parent().parent());
        campaignPageObject.changeCampaignName(name);
        checkCampaingNotExists(campaignModel.getName());
    }

    public CampaignPageObject getCampaignByName(String name) {
        CampaignPageObject campaignPageObject = new CampaignPageObject(root.$(byText(name)).parent().parent());
        return campaignPageObject;
    }

    public void addCampaignValidationCheck(CampaignModel campaignModel) {
        Selenide.sleep(1000);
        addCampaignFirstButton.click();
        NewCampaignPageObject createNewCampaignWindow = new NewCampaignPageObject($(SELECTOR_ADD_NEW_CAMPAIGN_WINDOW));
        createNewCampaignWindow.checkAddCampaignValidation(campaignModel);
    }

    public void changeCampaignDates(CampaignModel campaignModel, DateTime startDate, DateTime endDate) {
        CampaignPageObject campaignPageObject = new CampaignPageObject(root.$(byText(campaignModel.getName())).parent().parent());
        campaignPageObject.changeCampaignDates(startDate, endDate);
    }

    public void changeCampaignDiscounts(CampaignModel campaignModel, ArrayList<DiscountModel> discounts) {
        CampaignPageObject campaignPageObject = new CampaignPageObject(root.$(byText(campaignModel.getName())).parent().parent());
        campaignPageObject.changeCampaignDiscounts(discounts);
    }
}

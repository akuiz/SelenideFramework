package com.griddynamics.cto;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.griddynamics.cto.model.CampaignModel;
import com.griddynamics.cto.model.DiscountModel;
import com.griddynamics.cto.model.OfferModel;
import io.qameta.allure.Step;
import org.joda.time.DateTime;

import java.util.ArrayList;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
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

    @Step("Add campaign")
    public CampaignPageObject addCampaign(CampaignModel campaign) {
        waitForLoader();
        addCampaignFirstButton.click();
        NewCampaignPageObject createNewCampaignWindow = new NewCampaignPageObject($(SELECTOR_ADD_NEW_CAMPAIGN_WINDOW));
        createNewCampaignWindow.addCampaign(campaign);
        CampaignPageObject campaignPageObject = new CampaignPageObject(root.$(byText(campaign.getName())).parent().parent());
        return campaignPageObject;
    }

    @Step("Add campaign")
    public CampaignPageObject addCampaignSecondButton(CampaignModel campaign) {
        waitForLoader();
        addCampaignSecondButton.click();
        NewCampaignPageObject createNewCampaignWindow = new NewCampaignPageObject($(SELECTOR_ADD_NEW_CAMPAIGN_WINDOW));
        createNewCampaignWindow.addCampaign(campaign);
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

    @Step("Make sure campaign was successfully created/updated")
    public void checkCampaignExists(CampaignModel expectedCampaign) {
        CampaignModel actualCampaign = findCampaignByName(expectedCampaign.getName());
        assertThat(actualCampaign).isSameCampaignAs(expectedCampaign);
    }

    @Step("Find campaign with name {name}")
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

    @Step("Delete campaign with name {name}")
    public void deleteCampaignByName(String name) {
        CampaignPageObject campaignPageObject = new CampaignPageObject(root.$(byText(name)).parent().parent());
        campaignPageObject.delete();
    }

    @Step("Make sure there is no campaign with name: {name}")
    public void checkCampaingNotExists(String name) {
        $(byText(name)).shouldNot(exist);
    }

    public void duplicateCampaign(CampaignModel campaignModel) {
        CampaignPageObject campaignPageObject = new CampaignPageObject(root.$(byText(campaignModel.getName())).parent().parent());
        campaignPageObject.duplicateCampaign();
    }

    @Step("Replace campaign with another")
    public void editCampaign(CampaignModel originCampaign, CampaignModel editedCampaign) {
        CampaignPageObject campaignPageObject = new CampaignPageObject(root.$(byText(originCampaign.getName())).parent().parent());
        campaignPageObject.editCampaign(editedCampaign);
        checkCampaingNotExists(originCampaign.getName());
    }

    @Step("Change campaign name to {name}")
    public void changeCampaignName(CampaignModel campaignModel, String name) {
        CampaignPageObject campaignPageObject = new CampaignPageObject(root.$(byText(campaignModel.getName())).parent().parent());
        campaignPageObject.changeCampaignName(name);
        checkCampaingNotExists(campaignModel.getName());
    }

    @Step("Find campaign with name {name}")
    public CampaignPageObject getCampaign(String name) {
        CampaignPageObject campaignPageObject = new CampaignPageObject(root.$(byText(name)).parent().parent());
        return campaignPageObject;
    }

    public void addCampaignValidationCheck(CampaignModel campaignModel) {
        waitForLoader();
        addCampaignFirstButton.click();
        NewCampaignPageObject createNewCampaignWindow = new NewCampaignPageObject($(SELECTOR_ADD_NEW_CAMPAIGN_WINDOW));
        createNewCampaignWindow.checkAddCampaignValidation(campaignModel);
    }

    @Step("Change campaign dates")
    public void changeCampaignDates(CampaignModel campaignModel, DateTime startDate, DateTime endDate) {
        CampaignPageObject campaignPageObject = new CampaignPageObject(root.$(byText(campaignModel.getName())).parent().parent());
        campaignPageObject.changeCampaignDates(startDate, endDate);
    }

    @Step("Change campaign dates")
    public void changeCampaignDiscounts(CampaignModel campaignModel, ArrayList<DiscountModel> discounts) {
        CampaignPageObject campaignPageObject = new CampaignPageObject(root.$(byText(campaignModel.getName())).parent().parent());
        campaignPageObject.changeCampaignDiscounts(discounts);
    }

    @Step("Add campaign without name")
    public void addCampaignWithEmptyName(CampaignModel campaignModel) {
        waitForLoader();
        addCampaignFirstButton.click();
        NewCampaignPageObject createNewCampaignWindow = new NewCampaignPageObject($(SELECTOR_ADD_NEW_CAMPAIGN_WINDOW));
        createNewCampaignWindow.addBadCampaign(campaignModel);
    }

    @Step("Add campaign without discounts")
    public void addCampaignWithNoDiscounts(CampaignModel campaignModel) {
        waitForLoader();
        addCampaignFirstButton.click();
        NewCampaignPageObject createNewCampaignWindow = new NewCampaignPageObject($(SELECTOR_ADD_NEW_CAMPAIGN_WINDOW));
        createNewCampaignWindow.addBadCampaign(campaignModel);
    }

    @Step("Delete all test campaigns")
    public void deleteTestCampaigns() {
        CampaignPageObject testCampaign = findTestCampaign();
        while(!(testCampaign==null)){
            testCampaign.delete();
            testCampaign = findTestCampaign();
        }
    }

    private CampaignPageObject findTestCampaign() {
        if(root.$(byXpath("//*[contains(text(), 'at_')]")).exists()){
            return new CampaignPageObject(root.$(byXpath("//*[contains(text(), 'at_')]")).parent().parent());
        }
        return null;
    }

    public void checkNumberOfCampaigns(int numberOfCampaigns) {
        root.$$(".name-column__titile").shouldHaveSize(numberOfCampaigns);

    }
}

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.ArrayList;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class CampaignPageObject extends PageObject {

    static final String SELECTOR_CAMPAIGN_NAME = ".at-campaign-name";
    static final String SELECTOR_CAMPAIGN_START_DATE = ".at-campaign-start-date";
    static final String SELECTOR_CAMPAIGN_END_DATE = ".at-campaign-end-date";

    static final String XPATH_CAMPAIGN_START_DATE = ".//input[@placeholder='Start Date']";
    static final String XPATH_CAMPAIGN_END_DATE = ".//input[@placeholder='End Date']";
    static final String XPATH_CAMPAIGN_NAME = ".//input[@placeholder='Campaign name']";

    final static String XPATH_LAST_OFFER = ".//mat-list/mat-list-item[last()]";
    final static String XPATH_OFFERS = ".//mat-list/mat-list-item";

    static final String SELECTOR_OVERLAY_DATE_PICKER = ".cdk-overlay-backdrop";

    static final String SELECTOR_ADD_OFFER_BUTTON = ".add-offer-icon";


    SelenideElement lastOfferElement = root.$(byXpath(XPATH_LAST_OFFER));
    SelenideElement addOfferButton = root.$(SELECTOR_ADD_OFFER_BUTTON);

    ElementsCollection offerElements = root.$$(byXpath(XPATH_OFFERS));

    SelenideElement startDateInput = root.$(byXpath(XPATH_CAMPAIGN_START_DATE));
    SelenideElement endDateInput = root.$(byXpath(XPATH_CAMPAIGN_END_DATE));
    SelenideElement campaignNameInput = root.$(byXpath(XPATH_CAMPAIGN_NAME));

    public CampaignPageObject(SelenideElement root) {
        super(root);
    }

    public void setValues(CampaignModel campaign) {
        this.setName(campaign.getName());
        this.setStartDate(campaign.getStartDate());
        this.setEndDate(campaign.getEndDate());
        this.setOffers(campaign.getOfferList());
    }

    public void setOffers(ArrayList<OfferModel> offerList) {
        for (int offerNumber = 0; offerNumber < offerList.size(); offerNumber++) {
            this.addOffer(offerList.get(offerNumber));
        }
    }

    @Step("Add offer to campaign")
    public void addOffer(OfferModel offer) {
        addOfferButton.scrollTo().click();
        OfferPageObject offerPageObject = new OfferPageObject(lastOfferElement);
        offerPageObject.setValues(offer);
    }

    public int getAmountOfOffers(){
        return offerElements.size();
    }

    public String getOfferName(int n){
        OfferPageObject offerPageObject = new OfferPageObject(offerElements.get(n));
        return offerPageObject.getName();
    }

    public String getOfferValue(int n){
        OfferPageObject offerPageObject = new OfferPageObject(offerElements.get(n));
        return offerPageObject.getValue();
    }

    public String getOfferRule(int n){
        OfferPageObject offerPageObject = new OfferPageObject(offerElements.get(n));
        return offerPageObject.getRule();
    }

    public String getOfferType(int n){
        OfferPageObject offerPageObject = new OfferPageObject(offerElements.get(n));
        return offerPageObject.getType();
    }

    public CampaignModel getCampaignModel() {
        ArrayList<OfferModel> campaingOffers = getOffersFromCampaign();
        CampaignModel campaign = new CampaignModel().toBuilder()
                .name(getName())
                .endDate(getEndDate())
                .startDate(getStartDate())
                .offerList(campaingOffers)
                .build();
        return campaign;
    }

    public ArrayList<OfferModel> getOffersFromCampaign() {
        ArrayList<OfferModel> offers = new ArrayList<OfferModel>();
        for (int offerNumber = 0; offerNumber <offerElements.size(); offerNumber++) {
            offers.add(new OfferModel().toBuilder()
                    .name(getOfferName(offerNumber))
                    .value(getOfferValue(offerNumber))
                    .type(getOfferType(offerNumber))
                    .rule(getOfferRule(offerNumber))
                    .build());
        }
        return offers;
    }

    public String getName() {
        return campaignNameInput.getValue();
    }

    public String getStartDate() {
        return startDateInput.getValue();
    }

    public String getEndDate() {
        return endDateInput.getValue();
    }

    public void setName(String name) {
        campaignNameInput.setValue(name);
    }

    public void setStartDate(String startDate) {
        startDateInput.setValue(startDate);
        $(SELECTOR_OVERLAY_DATE_PICKER).click();
    }

    public void setEndDate(String endDate) {
        endDateInput.setValue(endDate);
        $(SELECTOR_OVERLAY_DATE_PICKER).click();
    }
}

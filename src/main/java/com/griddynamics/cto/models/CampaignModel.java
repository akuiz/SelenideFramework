package com.griddynamics.cto.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class CampaignModel {
    private String startDate;
    private String endDate;
    private String name;
    private ArrayList<OfferModel> offerList;

    public static CampaignModel CalvinKleinSpring2018() {
        return new CampaignModel().toBuilder()
                .name("Calvin Klein Spring 2018")
                .startDate("1/1/2018")
                .endDate("1/1/2019")
                .offerList(new ArrayList<OfferModel>() {{
                    add(OfferModel.CalvinKlein5OFF());
                }})
                .build();
    }

    public static CampaignModel CalvinKleinSpring2019() {
        return new CampaignModel().toBuilder()
                .name("Calvin Klein Spring 2019")
                .startDate("1/1/2019")
                .endDate("1/1/2020")
                .offerList(new ArrayList<OfferModel>() {{
                    add(OfferModel.CalvinKlein7OFF());
                    add(OfferModel.CalvinKlein7OFF());
                }})
                .build();
    }

}

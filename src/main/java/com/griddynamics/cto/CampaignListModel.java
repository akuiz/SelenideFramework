package com.griddynamics.cto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.griddynamics.cto.models.CampaignModel;

import java.util.ArrayList;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class CampaignListModel {

    private ArrayList<CampaignModel> campaigns;

    public static CampaignListModel testInitCampaignList() {
        return new CampaignListModel().toBuilder().
                campaigns(new ArrayList<CampaignModel>() {{
                    add(CampaignModel.CalvinKleinSpring2018());
                    add(CampaignModel.CalvinKleinSpring2019());
                }})
                .build();
    }

    public int getAmountOfCampaigns(){
        return campaigns.size();
    }
}

package com.trendyolcase.services;

import com.trendyolcase.models.Campaign;
import com.trendyolcase.repositories.CampaignRepo;
import com.trendyolcase.utils.exceptions.CampaignNotFoundException;
import com.trendyolcase.utils.exceptions.CampaignNotValidException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("campaignService")
public class CampaignService {
    @Autowired
    private CampaignRepo campaignRepo;

    public Campaign create(Campaign campaign) {
        if (campaign.hasValidMaxDiscount()) {
            return campaignRepo.insert(campaign);
        } else {
            throw new CampaignNotValidException("Campaign not valid.");
        }
    }

    public List<Campaign> getAll() {
        List<Campaign> campaigns = campaignRepo.findAll();
        if (campaigns.isEmpty()) {
            throw new CampaignNotFoundException("No campaigns found");
        } else {
            return campaigns;
        }
    }

    public Campaign get(String id) {
        Optional<Campaign> maybeCampaign = campaignRepo.findById(id);
        if (maybeCampaign.isPresent()) {
            return maybeCampaign.get();
        } else {
            throw new CampaignNotFoundException("Campaign not found with id=" + id);
        }
    }

    public Campaign update(String id, Campaign campaign) {
        Optional<Campaign> maybeCampaign = campaignRepo.findById(id);
        if (maybeCampaign.isPresent()) {
            String currentCampaignId = maybeCampaign.get().getId();
            campaign.setId(currentCampaignId);
            campaignRepo.deleteById(currentCampaignId);
            return campaignRepo.insert(campaign);
        } else {
            return campaignRepo.insert(campaign);
        }
    }

    public String delete(String id) {
        if (campaignRepo.existsById(id)) {
            campaignRepo.deleteById(id);
            return id;
        } else {
            throw new CampaignNotFoundException("Campaign not found with id=" + id);
        }
    }

    public boolean existsWithTypeId(String typeId) {

        return campaignRepo.findByTypeId(typeId).size() > 0;

    }

    public List<Campaign> findCampaigns(List<String> typeIds) {
        return campaignRepo.findByTypeIdIn(typeIds);
    }

}

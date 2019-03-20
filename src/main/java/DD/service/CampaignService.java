package DD.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DD.entity.Campaign;
import DD.repository.CampaignRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DD.entity.Campaign;
import DD.repository.CampaignRepository;

@Service
public class CampaignService {
	
	@Autowired
	private CampaignRepository cmr;

	public CampaignService() {
	
	}

	public void setCampaignRepository(CampaignRepository cmr) {
		this.cmr = cmr;
	}

	public List<Campaign> getCampaigns() {
		return this.cmr.findAll();
	}
	
	public String addCampaign(Campaign c) {
		return this.cmr.saveAndFlush(c).toString();
	}
}
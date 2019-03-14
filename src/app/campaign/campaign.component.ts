import { Component, OnInit } from '@angular/core';
import {CampaignService} from '../campaign.service';
import {Campaign} from '../campaign'
@Component({
  selector: 'app-campaign',
  templateUrl: './campaign.component.html',
  styleUrls: ['./campaign.component.css']
})
export class CampaignComponent implements OnInit {
campaign:Campaign;
campaignChat: String = '';

  constructor(private campaignService:CampaignService) { 

  }

  ngOnInit() {
    this.campaign = this.campaignService.getCampaignbyId(1);
  }
submitText(form)
{

  this.campaignChat += '\n' + form[0].value;
}
}

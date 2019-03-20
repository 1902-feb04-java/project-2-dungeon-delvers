import { Component, OnInit } from '@angular/core';
import { CampaignService } from '../campaign.service';
import { Profile } from '../profile';
import { LoginService } from '../login.service';
import { Campaign } from '../campaign';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  // public myProfile:Profile;
  // public myCampaigns: Campaign[];
  constructor(public campaignService:CampaignService, public loginService:LoginService) { }

  ngOnInit() {
    // this.myProfile = this.loginService.myProfile;
    // this.myCampaigns = this.campaignService.getCampaigns(); 
    
  }

}

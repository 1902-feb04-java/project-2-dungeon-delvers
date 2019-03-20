import { Component, OnInit } from '@angular/core';
import {Campaign} from '../campaign';
import { CampaignService } from '../campaign.service';
import { LoginService } from '../login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-campaign-creation',
  templateUrl: './campaign-creation.component.html',
  styleUrls: ['./campaign-creation.component.css']

})
export class CampaignCreationComponent implements OnInit {
  public name:String;
  constructor(private campaignService: CampaignService, private loginService: LoginService, private router:Router) { }

  ngOnInit() {
    console.log(this.loginService.myProfile);
  }
  public submitCampaign()
  {
    let c: Campaign = new Campaign(this.loginService.myProfile.id, [], this.name, 0);
    this.loginService.myProfile.campaigns.push(c);
    this.campaignService.submitCampaign(c);
    this.router.navigateByUrl('home');
  }
}

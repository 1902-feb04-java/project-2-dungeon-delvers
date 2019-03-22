import { Component, OnInit } from '@angular/core';
import { CampaignService } from '../campaign.service';
import { Profile } from '../profile';
import { LoginService } from '../login.service';
import { Campaign } from '../campaign';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  // public myProfile:Profile;
  // public myCampaigns: Campaign[];

  constructor(public campaignService:CampaignService, public loginService:LoginService, private router:Router) { }


  ngOnInit() {
    // this.myProfile = this.loginService.myProfile;
    // this.myCampaigns = this.campaignService.getCampaigns(); 
    //console.log(this.loginService.myProfile);
    this.loginService.login(this.loginService.myAccount.username, this.loginService.myAccount.password);
    this.campaignService.getCampaigns();
    //console.log(this.loginService.myProfile.campaigns);
    console.log('init' + JSON.stringify(this.loginService.myProfile));
  }
 public toCampaignCreation()
 {
   this.router.navigateByUrl("campaign/create");
 }
}

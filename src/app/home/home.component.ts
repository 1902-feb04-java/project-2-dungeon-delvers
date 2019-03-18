import { Component, OnInit } from '@angular/core';
import { CampaignService } from '../campaign.service';
import { Profile } from '../profile';
import { LoginService } from '../login.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  public myProfile:Profile;
  constructor(private campaignService:CampaignService, private loginService:LoginService) { }

  ngOnInit() {
    this.myProfile = this.loginService.myProfile;
    
  }

}

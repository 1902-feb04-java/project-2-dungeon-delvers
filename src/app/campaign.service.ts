import { Injectable } from '@angular/core';
import {Campaign} from '../app/campaign';
import { Profile } from './profile';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { LoginService } from './login.service';
import { forEach } from '@angular/router/src/utils/collection';
import { CampaignComponent } from './campaign/campaign.component';


@Injectable({
  providedIn: 'root'
})
export class CampaignService {
  public campaigns:Campaign[] =  [new Campaign(null,null,null,null)];
  constructor(private http: HttpClient, private loginService: LoginService) { }
  public getCampaigns()
  {
   this.http.get<string>("/campaigns/get").subscribe(x=>{
    console.log(x);
     if (x)
     {
       let obj = JSON.parse(JSON.stringify(x));
       this.campaigns = [];
       for(let c of obj)
       {
         let camp:Campaign = new Campaign(null,null,null,null);
          camp.id = c.id;
          camp.name = c.campaignName;

         this.campaigns.push(camp);
       }

     }
   });
  }
      // console.log(JSON.stringify(x) + "in here");
       
  public getCampaignsfromOwner(playerId:number): Campaign[]
  {
    return null;
  }
  public getCampaignbyId(campaignId:number)
  {
    for (let x of this.campaigns)
    {
      if(campaignId = x.id)
      {
        return x;
      }
    }
    return null;
  }
  public joinCampaign( campaign_to_join: number)
  {
    this.http.post("campaigns/join", {campaign_id:campaign_to_join, account_id:this.loginService.myAccount.id}).subscribe(x=>
      {
        console.log("Trying to join campaign");
        this.loginService.login(this.loginService.myAccount.username, this.loginService.myAccount.password);
      });
    
  }
  public setSelectedCampaign(campaign: Campaign)
  {
    this.selectedCampaign = campaign;
    console.log(campaign.name);
  }
  public submitCampaign(a: Campaign)
  {
    let headers = new HttpHeaders();
    headers.append('Content-Type', 'application/json');
    console.log(a.toString());
    this.http.post("/campaigns/post", a, { responseType: "text", headers: headers }).source.subscribe(x=>{
      console.log("campaign sent");
    });
    
  }
  
  selectedCampaign:Campaign;
}

import { Injectable } from '@angular/core';
import {Campaign} from '../app/campaign';
import { Profile } from './profile';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { LoginService } from './login.service';


@Injectable({
  providedIn: 'root'
})
export class CampaignService {

  constructor(private http: HttpClient, private loginService: LoginService) { }
  public getCampaigns(): Campaign[]
  {
    return this.campaigns; //dont use this, use httpclient
  }
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
  campaigns:Campaign[] = [
    new Campaign( 1, ["Adam", "Fredrick", "Spencer"], "John's Campaign", 1),
    new Campaign( 2, ["Fredrick", "Spencer", "John"], "Adam's Campaign", 2),
    new Campaign( 3, ["Spencer", "John", "Adam"], "Fredrick's Campaign", 3),
    new Campaign( 4, ["John", "Adam", "Fredrick"], "Spencer's Campaign", 4)
  ];
  selectedCampaign:Campaign;
}

import { Injectable } from '@angular/core';
import {Campaign} from '../app/campaign';
import { Profile } from './profile';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class CampaignService {

  constructor(private http: HttpClient) { }
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
  public submitCampaign(c: Campaign)
  {
    this.http.post<Campaign>('/campaign', c);
  }
  campaigns:Campaign[] = [
    new Campaign( new Profile(null, null, null, true, "John", 1), ["Adam", "Fredrick", "Spencer"], "John's Campaign", 1),
    new Campaign( new Profile(null, null, null, true, "Adam", 2), ["Fredrick", "Spencer", "John"], "Adam's Campaign", 2),
    new Campaign( new Profile(null, null, null, true, "Fredrick", 3), ["Spencer", "John", "Adam"], "Fredrick's Campaign", 3),
    new Campaign( new Profile(null, null, null, true, "Spencer", 4), ["John", "Adam", "Fredrick"], "Spencer's Campaign", 4)
  ];
  selectedCampaign:Campaign;
}

import { Injectable } from '@angular/core';
import {Campaign} from '../app/campaign';
import { Profile } from './profile';

@Injectable({
  providedIn: 'root'
})
export class CampaignService {

  constructor() { }
  public getCampaigns()
  {
    //get all campaigns
  }
  public getCampaignsfromOwner(playerId:number)
  {

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
  campaigns:Campaign[] = [
    new Campaign( new Profile(null, null, null, true, "John", 1), ["Adam", "Fredrick", "Spencer"], "John's Campaign", 1),
    new Campaign( new Profile(null, null, null, true, "Adam", 2), ["Fredrick", "Spencer", "John"], "Adam's Campaign", 2),
    new Campaign( new Profile(null, null, null, true, "Fredrick", 3), ["Spencer", "John", "Adam"], "Fredrick's Campaign", 3),
    new Campaign( new Profile(null, null, null, true, "Spencer", 4), ["John", "Adam", "Fredrick"], "Spencer's Campaign", 4)
  ];
  selectedCampaign:Campaign;
}

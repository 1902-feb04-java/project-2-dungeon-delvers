import { Component, OnInit } from '@angular/core';
import * as Stomp from '@stomp/stompjs';
import * as SockJS from 'sockjs-client';
import { Message } from '../message';
import { IMMonster } from '../immonster';
import { IMEncounter } from '../imencounter';
import { Turn } from '../turn';
import { LoginService } from '../login.service';
import { IMCharacter } from '../imcharacter';
import { CampaignService } from '../campaign.service';
import { Campaign } from '../campaign';

@Component({
  selector: 'app-encounter-window',
  templateUrl: './encounter-window.component.html',
  styleUrls: ['./encounter-window.component.css']
})

export class EncounterWindowComponent implements OnInit {
  private serverUrl = '/ws';
  private stompClient;

  public campaign_list: Array<Campaign>;
  public model_campaign: Campaign = new Campaign(null, null, null, 0);
  public DM: boolean = false;
  public joined: boolean = false;

  public monsters: Array<IMMonster> = [new IMMonster("Placeholder_Mon1", "Goblin", 6, 14, 10),
      new IMMonster("Placeholder_Mon2", "Goblin", 6, 14, 10)];
  public characters: Array<IMCharacter> = [new IMCharacter(0, 0, 0, "Placeholder_Char", 10, 10, 10)];
  public turn: Turn = new Turn([1,3,3,2,3,4,5],6,0);
  public state: IMEncounter = new IMEncounter(this.monsters, this.characters, this.turn);


  constructor(
      public ls: LoginService,
      private cs: CampaignService) {
    this.initializeWebSocketConnection();
  }

  ngOnInit() {
    if(this.ls.myProfile.campaigns) {
      this.campaign_list = this.ls.myProfile.campaigns;
    } else {
      this.cs.adamGetCampaigns().subscribe(x => this.campaign_list = JSON.parse(x));
    }
    this.model_campaign.id = 0;
  }

  initializeWebSocketConnection() {
    let ws = new SockJS(this.serverUrl);
    this.stompClient = Stomp.Stomp.over(ws);
    let that = this; //this line is horrid
    this.stompClient.connect({}, function(frame) {
      that.stompClient.subscribe("/topic/encounter", (message) => {
        if (message.body) {
          console.log(JSON.parse(JSON.parse(message.body).content));
          that.state = Object.assign(that.state, JSON.parse(JSON.parse(message.body).content));
        }
      });
    });
  }

  sendState(state, typenum=0, user=this.ls.myProfile.id) {
    let obj = {type: typenum, content: JSON.stringify(state), sender: user};
    this.stompClient.send("/app/enc.sendMessage", null, JSON.stringify(obj) );
    console.log('sending message to' + this.stompClient.serverUrl);
    console.log(JSON.stringify(obj));
  }

  sendStateDM(state, typenum=1, user='1') {
    let obj = {type: typenum, content: JSON.stringify(state), sender: user};
    this.stompClient.send("/app/enc.sendMessage", null, JSON.stringify(obj) );
    console.log('sending message to' + this.stompClient.serverUrl);
    console.log(JSON.stringify(obj));
  }

  sendJoin(state, typenum=0, user=this.ls.myProfile.id) {
    if(!this.joined) {
      let obj = {type: typenum, content: JSON.stringify(state), sender: user};
      this.stompClient.send("/app/enc.join", null, JSON.stringify(obj) );
      console.log('sending message to' + this.stompClient.serverUrl);
    }
    this.joined = true;
  }

  sendInit(state, typenum=2, user=this.ls.myProfile.id) {
    let obj = {type: typenum, content: JSON.stringify(state), sender: user};
    this.stompClient.send("/app/enc.sendMessage", null, JSON.stringify(obj) );
    console.log('sending message to' + this.stompClient.serverUrl);
  }

  sendSkip(state, typenum=3, user=this.ls.myProfile.id) {
    let obj = {type: typenum, content: JSON.stringify(state), sender: user};
    this.stompClient.send("/app/enc.sendMessage", null, JSON.stringify(obj) );
    console.log('sending message to' + this.stompClient.serverUrl);
  }

  chooseCampaign(campaign: Campaign) {
    this.model_campaign.id = campaign.id;
    this.model_campaign.name = campaign.name;
    this.model_campaign.owner = null;
    this.model_campaign.players = null;
    if (campaign.saveState.length > 0) {
      this.state = JSON.parse(campaign.saveState.toString());
    } else {
      alert("No encounter found for that campaign -- create one!");
    }
    this.cs.adamIsDm(this.ls.myProfile.id, campaign.id).subscribe(x => {
      console.log(x);
      this.DM = (x === 'true')});
  }

  joinAsPlayer() {
    this.model_campaign.id=1;
    //not meant to change anything, just prompts server for state
    this.sendJoin(this.state);
  }

  writeState() {
    this.model_campaign.saveState = JSON.stringify(this.state);
    this.cs.editCampaign(this.model_campaign);
  }

  get diagnostic() { return JSON.stringify(this.state); }

}

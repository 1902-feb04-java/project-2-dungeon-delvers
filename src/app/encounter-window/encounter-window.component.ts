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
  public messages: Array<Message> = [new Message("CHAT", "woot2", "hardcodetest")];
  public model_campaign: Campaign = new Campaign(null, null, null, 0);
  public monsters: Array<IMMonster> = [new IMMonster("Goblin_1", "Goblin", 6, 14, 10),
      new IMMonster("Goblin_2", "Goblin", 6, 14, 10)];
  public characters: Array<IMCharacter> = [new IMCharacter(0, 0, 0, "blehrg", 10, 10, 10)];
  public turn: Turn = new Turn([1,3,3,2,3,4,5],6,0);
  public campaign_list: Array<Campaign>;
  public state: IMEncounter = new IMEncounter(this.monsters, this.characters, this.turn);

  constructor(public ls: LoginService,
    private cs: CampaignService) {
    this.initializeWebSocketConnection();
  }

  ngOnInit() {
    this.cs.adamGetCampaigns().subscribe(x => this.campaign_list = JSON.parse(x));
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

  sendState(state, typenum=0, user='1') {
    let obj = {type: typenum, content: JSON.stringify(state), sender: user};
    this.stompClient.send("/app/enc.sendMessage", null, JSON.stringify(obj) );
    console.log('sending message to' + this.stompClient.serverUrl);
    console.log(JSON.stringify(obj));
  }

  chooseCampaign(campaign: Campaign) {
    console.log(JSON.stringify(this.ls.myProfile));
    console.log(JSON.stringify(campaign));
    this.model_campaign.id = 3;
  }

  get diagnostic() { return JSON.stringify(this.state); }

}

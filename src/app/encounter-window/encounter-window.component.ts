import { Component, OnInit } from '@angular/core';
import * as Stomp from '@stomp/stompjs';
import * as SockJS from 'sockjs-client';

import { Message } from '../message';
import { Monster } from '../monster';

@Component({
  selector: 'app-encounter-window',
  templateUrl: './encounter-window.component.html',
  styleUrls: ['./encounter-window.component.css']
})
export class EncounterWindowComponent implements OnInit {
  private serverUrl = '/ws';
  private stompClient;

  public messages: Array<Message> = [new Message("CHAT", "woot2", "hardcodetest")];
  public monsters: Array<Monster> = [new Monster(-1,0, "Goblin1", -1, 14, 10),
      new Monster(-1,0, "Goblin2", -1, 14, 10)]; 

  constructor() {
    this.initializeWebSocketConnection();
  }

  ngOnInit() { }

  initializeWebSocketConnection() {
    let ws = new SockJS(this.serverUrl);
    this.stompClient = Stomp.Stomp.over(ws);
    let that = this; //this line is horrid
    this.stompClient.connect({}, function(frame) {
      that.stompClient.subscribe("/topic/encounter", (message) => {
        if (message.body) {
          that.messages.push(JSON.parse(message.body));
        }
      });
    });
  }

  sendState(state, typenum=0, user='DefaultUser') {
    let obj = {type: typenum, content: JSON.stringify(state), sender: user};
    this.stompClient.send("/app/enc.sendMessage", null, JSON.stringify(obj) );
    console.log('sending message to' + this.stompClient.serverUrl);
    console.log(JSON.stringify(obj));
  }

  sendMessage(cont, typenum=0, user='DefaultUser') {
    // kept as basic object because of interaction with enum for type
    let obj = {type: typenum, content: cont, sender: user};
    this.stompClient.send("/app/enc.sendMessage", null, JSON.stringify(obj) );
    console.log('sending message to' + this.stompClient.serverUrl);
    console.log(JSON.stringify(obj));
  }

  get diagnostic() { return JSON.stringify(this.monsters); }

}

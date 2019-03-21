import { Component, OnInit } from '@angular/core';
import * as Stomp from '@stomp/stompjs';
import * as SockJS from 'sockjs-client';

import { Message } from '../message';

@Component({
  selector: 'app-encounter-window',
  templateUrl: './encounter-window.component.html',
  styleUrls: ['./encounter-window.component.css']
})
export class EncounterWindowComponent implements OnInit {
  private serverUrl = '/ws';
  private stompClient;

  public messages: Array<Message> = [];

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

  sendMessage(cont, typenum=0, user='DefaultUser') {
    // kept as basic object because of interaction with enum for type
    let obj = {type: typenum, content: cont, sender: user};
    this.stompClient.send("/app/chat.sendMessage", null, JSON.stringify(obj) );
    console.log('sending message to' + this.stompClient.serverUrl);
    console.log(JSON.stringify(obj));
  }

}

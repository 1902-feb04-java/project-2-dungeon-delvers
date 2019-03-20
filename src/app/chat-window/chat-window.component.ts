import { Component, OnInit } from '@angular/core';
import * as Stomp from '@stomp/stompjs';
import * as SockJS from 'sockjs-client';

@Component({
  selector: 'app-chat-window',
  templateUrl: './chat-window.component.html',
  styleUrls: ['./chat-window.component.css']
})
export class ChatWindowComponent implements OnInit {
  private serverUrl = '/ws';
  private title = 'WebSockets Chat';
  private stompClient;

  public chatStrings = ["first_string", "second_string"];

  constructor() {
    this.initializeWebSocketConnection();
  }

  ngOnInit() { }

  initializeWebSocketConnection() {
    let ws = new SockJS(this.serverUrl);
    this.stompClient = Stomp.Stomp.over(ws);
    let that = this;
    this.stompClient.connect({}, function(frame) {
      that.stompClient.subscribe("/topic/public", (message) => {
        if (message.body) {
          console.log(message.body);
          
        }
      });
    });
  }

  sendMessage(message) {
    
    
    let obj = {type: 0, message, sender: 'me'};
    this.stompClient.send("/app/chat.sendMessage", null, JSON.stringify(obj) );
    console.log('sending message to' + this.stompClient.serverUrl);
  }

}

import { Component, OnInit } from '@angular/core';
import * as Stomp from 'stompjs';
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
    this.stompClient = Stomp.over(ws);
    let that = this;
    this.stompClient.connect({}, function(frame) {
      that.stompClient.subscribe("/topic", (message) => {
        if (message.body) {
          console.log(message.body);
          this.chatStrings.push(message.body);
        }
      });
    });
  }

  sendMessage(message) {
    this.stompClient.send("/app/chat.sendMessage", {}, message);
  }

}

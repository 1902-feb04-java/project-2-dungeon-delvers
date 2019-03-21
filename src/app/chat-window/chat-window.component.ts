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
  public chatUsers = ["test1", "test2"];

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
        console.log(message);
        if (message.body) {
          that.chatStrings.push(JSON.parse(message.body)['content']);
          that.chatUsers.push(message.body['sender']);
        }
      });
    });
  }

  sendMessage(message, user='me') {
    let obj = {type: 0, content: message, sender: user};
    console.log(obj);
    this.stompClient.send("/app/chat.sendMessage", null, JSON.stringify(obj) );
    console.log('sending message to' + this.stompClient.serverUrl);
  }

}

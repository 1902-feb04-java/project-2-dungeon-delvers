import { Component, OnInit } from '@angular/core';
import * as Stomp from '@stomp/stompjs';
import * as SockJS from 'sockjs-client';

import { Message } from '../message';
import { LoginComponent } from '../login/login.component';
import { LoginService } from '../login.service';
import { CharacterCreationService } from '../character-creation.service';

@Component({
  selector: 'app-chat-window',
  templateUrl: './chat-window.component.html',
  styleUrls: ['./chat-window.component.css']
})
export class ChatWindowComponent implements OnInit {
  private serverUrl = '/ws';
  private stompClient;

  public messages: Array<Message> = [new Message("CHAT", "woot", "hardcodetest")];

  public chName;
  

  constructor(private ls: LoginService, private chServe: CharacterCreationService) {
    this.initializeWebSocketConnection();
  }

  ngOnInit() { 
    this.chServe.getCharacterByAccount(this.ls.myProfile.id).subscribe(x => this.chName = JSON.parse(x)[0].characterName)

  }

  initializeWebSocketConnection() {
    let ws = new SockJS(this.serverUrl);
    this.stompClient = Stomp.Stomp.over(ws);
    let that = this; //this line is horrid
    this.stompClient.connect({}, function(frame) {
      that.stompClient.subscribe("/topic/public", (message) => {
        if (message.body) {
          that.messages.push(JSON.parse(message.body));
        }
        if (that.messages.length > 10) {
          that.messages.shift();
        }
      });
    });
  }

   
  sendMessage(cont, typenum=0, user = this.chName) {
    // kept as basic object because of interaction with enum for type
    let obj = {type: typenum, content: cont, sender: user};
    this.stompClient.send("/app/chat.sendMessage", null, JSON.stringify(obj) );
    console.log('sending message to' + this.stompClient.serverUrl);
    console.log(JSON.stringify(obj));
  }

  rollDie(cont, typenum=3, user= this.chName) {
    this.sendMessage("I'm rolling a d" + cont.toString() + "...")
    let obj = {type: typenum, content: cont.toString(), sender: user};
    this.stompClient.send("/app/chat.rollDie", null, JSON.stringify(obj));
    console.log('sending dice message to' + this.stompClient.serverUrl);
    console.log(JSON.stringify(obj));
  }

}

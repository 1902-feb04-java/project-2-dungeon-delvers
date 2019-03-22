import { Component, OnInit } from '@angular/core';
import { CharacterCreationService } from '../character-creation.service';
import { LoginService } from '../login.service';

@Component({
  selector: 'app-character',
  templateUrl: './character.component.html',
  styleUrls: ['./character.component.css']
})
export class CharacterComponent implements OnInit {
  public players;
  constructor(private charSheet: CharacterCreationService, private ls: LoginService) {

  }

  ngOnInit() {
    this.charSheet.getCharacterByAccount(this.ls.myProfile.id).subscribe(x => this.players = JSON.parse(x))
  }

}

import { Component, OnInit } from '@angular/core';
import { CharacterCreationService } from '../character-creation.service';
import { Character } from '../character';

@Component({
  selector: 'app-character-creation',
  templateUrl: './character-creation.component.html',
  styleUrls: ['./character-creation.component.css']
})
export class CharacterCreationComponent implements OnInit {
  model = new Character(1, "Spencer", "Grimlock Graybeard", 50, 14, 12);
  submitted = false;
  post_result: any;

  constructor( private character: CharacterCreationService) { }

  ngOnInit() {
  }

  onSubmit() {
    this.submitted=true;
    this.character.sendCharacter(this.model).subscribe(x => this.post_result = x.toString());
  }

  get diagnostic() { return JSON.stringify(this.model); }


}




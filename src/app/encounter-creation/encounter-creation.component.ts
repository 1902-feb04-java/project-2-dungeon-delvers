import { Component, OnInit } from '@angular/core';
import { IMEncounter } from '../imencounter';
import { EncounterCreationService } from '../encounter-creation.service';
import { Monster } from '../monster';
import { Character } from '../character';
import { IMMonster } from '../immonster';
import { LoginService } from '../login.service';
import { CharacterCreationService } from '../character-creation.service';
import { IMCharacter } from '../imcharacter';
import { CampaignService } from '../campaign.service';

@Component({
  selector: 'app-encounter-creation',
  templateUrl: './encounter-creation.component.html',
  styleUrls: ['./encounter-creation.component.css']
})
export class EncounterCreationComponent implements OnInit {

  monster_list = [new Monster(1, 1, "goblin", 4, 10, 10), new Monster(2, 1,"gablin", 14, 110, 110)];
  character_list = [new Character(0, 0, "Placeholder", 0, 10, 10, 10)];
  model = new IMEncounter([], [], null);
  model_monster = new IMMonster("Monster", "Type", 2, 0, 0);

  submitted = false;
  post_result: any;

  constructor(
      private ecs: EncounterCreationService,
      private ls: LoginService,
      private ccs: CharacterCreationService,
      private cs: CampaignService) { }
  
  ngOnInit() {
    this.ecs.getMonsters().subscribe(x => this.monster_list = JSON.parse(x));
    // this.ls.myProfile.campaigns.players;
    this.ccs.getCharacters().subscribe(x => this.character_list = JSON.parse(x));
  }

  onSubmitCharacter(character: Character) {
    this.model.addCharacter(new IMCharacter(
      character.id,
      character.playerAccount,
      character.campaignId,
      character.characterName,
      character.healthPoints,
      character.armorClass,
      character.damageDie
      ));
  }

  onSubmitMonster() {
    this.submitted=true;
    //this.character.sendEncounter(this.model).subscribe(x => this.post_result = x.toString());

    this.model.addMonster(new IMMonster(
      this.model_monster.name,
      this.model_monster.type,
      this.model_monster.damageDie,
      this.model_monster.ac,
      this.model_monster.hp
      ));
  }

  onSubmitTemplate(monster: Monster) {
    this.model_monster.name = monster.name;
    this.model_monster.type = monster.name;
    this.model_monster.ac = monster.ac;
    this.model_monster.hp = monster.hp;
    this.model_monster.damageDie = monster.damageDie;

  }

  get diagnostic() { return JSON.stringify(this.model); }

}

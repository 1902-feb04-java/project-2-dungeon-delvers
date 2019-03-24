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
import { Campaign } from '../campaign';
import { Turn } from '../turn';

@Component({
  selector: 'app-encounter-creation',
  templateUrl: './encounter-creation.component.html',
  styleUrls: ['./encounter-creation.component.css']
})
export class EncounterCreationComponent implements OnInit {

  monster_list = [new Monster(1, 1, "goblin", 4, 10, 10), new Monster(2, 1,"gablin", 14, 110, 110)];
  character_list = [new Character(0, 0, "Placeholder", 0, 10, 10, 10)];
  campaign_list = [new Campaign(2, ["1","2"], "placeholder_campaign", 2)];
  model = new IMEncounter([], [], new Turn([1, 1], 2, 0));
  model_monster = new IMMonster("Monster", "Type", 2, 0, 0);
  model_campaign: Campaign = new Campaign(0, ["1","2"], "placeholder_campa", 0);

  DM = false;

  constructor(
      private ecs: EncounterCreationService,
      private ls: LoginService,
      private ccs: CharacterCreationService,
      private cs: CampaignService) { }
  
  ngOnInit() {
    this.ecs.getMonsters().subscribe(x => this.monster_list = JSON.parse(x));
    // this.ls.myProfile.campaigns.players;
    this.ccs.getCharacters().subscribe(x => this.character_list = JSON.parse(x));
    this.cs.adamGetCampaigns().subscribe(x => this.campaign_list = JSON.parse(x));
    
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

  onSubmitCampaign(campaign: Campaign) {
    this.model_campaign.id = campaign.id;
    this.model_campaign.name = campaign.name;
    this.model_campaign.owner = campaign.owner;
    this.model_campaign.players = campaign.players;
    this.model_campaign.saveState = campaign.saveState;
    this.cs.adamIsDm(this.ls.myProfile.id, campaign.id).subscribe(x => {
      console.log(x);
      this.DM = (x === 'true')});
  }

  saveEncounter() {
    this.model_campaign.saveState = JSON.stringify(this.model);
    if(this.DM) {
      this.cs.editCampaign(this.model_campaign);
    } else {
      alert("Can't edit campaigns you don't own!");
    }
  }

  get diagnostic() { return JSON.stringify(this.model) + "\n\n" + JSON.stringify(this.model_campaign); }

}

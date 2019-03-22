import { Component, OnInit } from '@angular/core';
import { Encounter } from '../encounter';
import { EncounterCreationService } from '../encounter-creation.service';

@Component({
  selector: 'app-encounter-creation',
  templateUrl: './encounter-creation.component.html',
  styleUrls: ['./encounter-creation.component.css']
})
export class EncounterCreationComponent implements OnInit {
  model = new Encounter(2, "Kobold Ambush",3, 2, 
  "{kobold-1:\"grundl\", kobold-2: \"brigguth\", kobold-3: \"fink\"}" );
  submitted = false;
  post_result: any;

  constructor( private ecs: EncounterCreationService) { }
  

  ngOnInit() {
  }

  onSubmit() {
    this.submitted=true;
    //this.character.sendEncounter(this.model).subscribe(x => this.post_result = x.toString());
  }


}

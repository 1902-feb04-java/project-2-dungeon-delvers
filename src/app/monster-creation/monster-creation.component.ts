import { Component, OnInit } from '@angular/core';
import { MonsterCreationService } from '../monster-creation.service';

import { Monster } from '../monster';
import { LoginService } from '../login.service';

@Component({
  selector: 'app-monster-creation',
  templateUrl: './monster-creation.component.html',
  styleUrls: ['./monster-creation.component.css']
})
export class MonsterCreationComponent implements OnInit {

  model = new Monster(0, this.ls.myProfile.id,"gablin", 4, 14, 7);
  submitted = false;
  post_result: Monster = null;

  constructor(private mcs:MonsterCreationService, private ls:LoginService) { }

  ngOnInit() {
  }

  onSubmit() {
    this.submitted=true;
    this.mcs.sendMonster(this.model).subscribe(x => this.post_result = x);
  }

  get diagnostic() { return JSON.stringify(this.model); }

}


import { Component, OnInit } from '@angular/core';
import { RegisterService } from '../register.service';

import { Account } from '../account';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register-form',
  templateUrl: './register-form.component.html',
  styleUrls: ['./register-form.component.css']
})
export class RegisterFormComponent implements OnInit {

  model = new Account(0, "adking01", "nerva", "adam@dnd.com");
  submitted = false;
  post_result: Account;

  constructor(private register:RegisterService, private router:Router) { }

  ngOnInit() {
  }

  onSubmit() {
    this.submitted=true;
    this.register.sendAccount(this.model).subscribe(x => this.post_result = x);
    this.router.navigateByUrl("/");
  }

  get diagnostic() { return JSON.stringify(this.model); }

}

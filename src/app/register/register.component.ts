import { Component, OnInit } from '@angular/core';
import { RegisterService } from '../register.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  username: String;
  password: String;
  email: String;
  constructor(private register: RegisterService) { }

  ngOnInit() {
    // send a POST to /register2 on init, which returns some text
    try {
      this.register.sendText("adam").subscribe(x => this.username = x.toString());
      console.log("init complete");
    } catch (e) {
      console.log(e);
    }
  }
  public submit()
  {
    window.location.href = "http://google.com/";
    //do something with service.
  }
  
}

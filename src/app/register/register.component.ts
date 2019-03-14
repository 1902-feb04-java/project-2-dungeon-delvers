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
  }
  public submit()
  {
    window.location.href = "http://google.com/";
    //do something with service.
  }
  
}

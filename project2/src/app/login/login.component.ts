import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  username: String;  
  password: String;
  constructor(private service: LoginService) {
    
   }

  ngOnInit() {
    
  }

  public submit()
  {
    window.location.href = "home";
  }
  public register()
  {
    window.location.href = "register";
  }

}

import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Profile } from './profile';
import { Account } from './account';
import {Router} from '@angular/router'
import { routerNgProbeToken } from '@angular/router/src/router_module';
@Injectable({
  providedIn: 'root'
})
export class LoginService {
  public myProfile:Profile = null;
  public myAccount:Account = new Account(null,null,null,null);
  public loggedIn = false;
  constructor(private http:HttpClient, private router:Router) {
    this.myProfile = this.getProfile();
    console.log('wtf');
   }

  public login(username:string, password:string)
  {
    let object:Account = new Account(0, username, password, null);
    this.http.post<Profile>("accounts/login",object).subscribe(x=>{
     // console.log(JSON.stringify(x) + "in here");
      if (x)
      {
        let s = JSON.stringify(x);
        let o = JSON.parse(s);
        this.myProfile.id = o.account.id;
        this.myProfile.campaigns = o.campaigns;
        this.myProfile.characters = o.characters;
        this.myProfile.username = o.account.username;
        this.myProfile.monsters = o.monsters;
        this.myAccount.email = o.account.email;
        this.myAccount.username = o.account.username;
        this.myAccount.password = o.account.password;
        this.myAccount.id = o.account.id;
        //console.log(JSON.stringify(this.myAccount) + '\n' + JSON.stringify(this.myProfile));
        this.loggedIn = true;
        this.router.navigateByUrl('/home');
        
      }
    });
  }
  public getProfile()
  {
    return new Profile([], [], [], false, 'Someone', 0);
  }
}

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
  constructor(private http:HttpClient, private router:Router) {
    this.myProfile = this.getProfile();
    console.log('wtf');
   }

  public login(username:string, password:string)
  {
    let object:Account = new Account(0, username, password, null);
    this.http.post<Profile>("accounts/login",object).subscribe(x=>{
      console.log(x + "in here");
      if (x)
      {
        this.router.navigateByUrl('/home');
      }
    });
  }
  public getProfile()
  {
    return new Profile([], [], [], false, 'Someone', 0);
  }
}

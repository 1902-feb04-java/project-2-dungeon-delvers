import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Profile } from './profile';
@Injectable({
  providedIn: 'root'
})
export class LoginService {
  public myProfile:Profile = null;
  constructor(private http:HttpClient) {
    this.myProfile = this.getProfile();
    console.log('wtf');
   }

  public sendAccount(username:String, password:String)
  {
    let object = {username , password};
    this.http.post<Profile>("/accounts/check",object).subscribe(x=>{
      this.myProfile = x;
    });
  }
  public getProfile()
  {
    return new Profile([], [], [], false, 'Someone', 0);
  }
}

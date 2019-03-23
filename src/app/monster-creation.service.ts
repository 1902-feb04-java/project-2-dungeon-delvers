import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

import { Monster } from './monster';
import { LoginService } from './login.service';

@Injectable({
  providedIn: 'root'
})
export class MonsterCreationService {

  constructor(private http: HttpClient, private loginService:LoginService) { }

  sendMonster(m:Monster): Observable<any> {
    m.account_id = this.loginService.myAccount.id;
    let headers = new HttpHeaders();
    headers.append('Content-Type', 'application/json');
    console.log(m.toString());
    return this.http.post("/monsters/post", m, { responseType: "text", headers: headers });
  }
}

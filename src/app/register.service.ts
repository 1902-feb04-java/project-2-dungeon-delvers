import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

import { Account } from './account';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  constructor(private http: HttpClient) { }

  sendText(s:string): Observable<Object> {
    return this.http.post("/register2", s, { responseType: 'text'});
  }

  sendAccount(a:Account): Observable<any> {
    let headers = new HttpHeaders();
    headers.append('Content-Type', 'application/json');
    console.log(a.toString());
    return this.http.post("/registerAccount", a, { responseType: "text", headers: headers });
  }
}

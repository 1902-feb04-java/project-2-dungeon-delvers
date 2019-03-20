import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

import { Monster } from './monster';

@Injectable({
  providedIn: 'root'
})
export class MonsterCreationService {

  constructor(private http: HttpClient) { }

  sendMonster(m:Monster): Observable<any> {
    let headers = new HttpHeaders();
    headers.append('Content-Type', 'application/json');
    console.log(m.toString());
    return this.http.post("/monsters/post", m, { responseType: "text", headers: headers });
  }
}

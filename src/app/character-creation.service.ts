import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs'
import { Character } from './character';

@Injectable({
  providedIn: 'root'
})
export class CharacterCreationService {
  constructor(private http: HttpClient) { 
    
  }
  
  sendCharacter(c:Character): Observable<any> {
    let headers = new HttpHeaders();
    headers.append('Content-Type', 'application/json');
    console.log(c.toString());
    return this.http.post("/characters/post", c, { responseType: "text", headers: headers });
  }

  getCharacter(c:Character): Observable<any> {
    let headers = new HttpHeaders();
    headers.append('Content-Type', 'application/json');
    console.log(c.toString());
    return this.http.get("characters/get", { responseType: "text", headers: headers });
  }

 
}

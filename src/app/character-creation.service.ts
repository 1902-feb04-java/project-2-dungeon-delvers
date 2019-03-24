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

  getCharacters(): Observable<any> {
    let headers = new HttpHeaders();
    headers.append('Content-Type', 'application/json');
    return this.http.get("/characters", {responseType: "text", headers: headers });
  }
  
  sendCharacter(c:Character): Observable<any> {
    let headers = new HttpHeaders();
    headers.append('Content-Type', 'application/json');
    console.log(c.toString());
    return this.http.post("/characters/post", c, { responseType: "text", headers: headers });
  }

  getCharacter(id): Observable<any> {
    let headers = new HttpHeaders();
    headers.append('Content-Type', 'application/json');
    console.log(id.toString());
    return this.http.get("/characters/" + id , { responseType: "text", headers: headers });
  }

 getCharacterByAccount(id): Observable<any> {
    let headers = new HttpHeaders();
    headers.append('Content-Type', 'application/json');
    console.log(id.toString());
    return this.http.get("/characters/account/" + id , { responseType: "text", headers: headers });
 }
}

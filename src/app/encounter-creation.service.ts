import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs'
import { IMEncounter } from './imencounter';

@Injectable({
  providedIn: 'root'
})
export class EncounterCreationService {

  constructor(private http: HttpClient) { }

  getMonsters(): Observable<any> {
    let headers = new HttpHeaders();
    headers.append('Content-Type', 'application/json');
    return this.http.get("/monsters", { responseType: "text", headers: headers });
  }
}

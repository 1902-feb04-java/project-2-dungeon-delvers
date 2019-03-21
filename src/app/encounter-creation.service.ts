import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs'
import { Encounter } from './encounter';

@Injectable({
  providedIn: 'root'
})
export class EncounterCreationService {

  constructor(private http: HttpClient) { }
  sendEncounter(e:Encounter): Observable<any> {
    let headers = new HttpHeaders();
    headers.append('Content-Type', 'application/json');
    console.log(e.toString());
    return this.http.post("/encounters/post", e, { responseType: "text", headers: headers });
  }

  
}

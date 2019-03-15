import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  constructor(private http: HttpClient) { }

  sendText(s:string): Observable<Object> {
    return this.http.post("/register2", s, { responseType: 'text'});
  }
}
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CharacterCreationService {
  sendCharacter(model: import("./character").Character): any {
    throw new Error("Method not implemented.");
  }

  constructor() { }
}

import { TestBed } from '@angular/core/testing';

import { CharacterCreationService } from './character-creation.service';

describe('CharacterCreationService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CharacterCreationService = TestBed.get(CharacterCreationService);
    expect(service).toBeTruthy();
  });
});

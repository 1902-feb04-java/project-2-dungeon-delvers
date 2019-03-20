import { TestBed } from '@angular/core/testing';

import { EncounterCreationService } from './encounter-creation.service';

describe('EncounterCreationService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: EncounterCreationService = TestBed.get(EncounterCreationService);
    expect(service).toBeTruthy();
  });
});

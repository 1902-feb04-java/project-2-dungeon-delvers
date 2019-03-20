import { TestBed } from '@angular/core/testing';

import { MonsterCreationService } from './monster-creation.service';

describe('MonsterCreationService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: MonsterCreationService = TestBed.get(MonsterCreationService);
    expect(service).toBeTruthy();
  });
});

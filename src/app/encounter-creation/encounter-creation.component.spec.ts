import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EncounterCreationComponent } from './encounter-creation.component';

describe('EncounterCreationComponent', () => {
  let component: EncounterCreationComponent;
  let fixture: ComponentFixture<EncounterCreationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EncounterCreationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EncounterCreationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EncounterWindowComponent } from './encounter-window.component';

describe('EncounterWindowComponent', () => {
  let component: EncounterWindowComponent;
  let fixture: ComponentFixture<EncounterWindowComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EncounterWindowComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EncounterWindowComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

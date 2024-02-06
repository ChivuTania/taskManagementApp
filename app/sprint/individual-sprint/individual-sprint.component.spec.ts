import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IndividualSprintComponent } from './individual-sprint.component';

describe('IndividualSprintComponent', () => {
  let component: IndividualSprintComponent;
  let fixture: ComponentFixture<IndividualSprintComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ IndividualSprintComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(IndividualSprintComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

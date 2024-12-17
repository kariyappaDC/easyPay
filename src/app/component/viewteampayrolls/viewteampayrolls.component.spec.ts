import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewTeamPayrollsComponent } from './viewteampayrolls.component';

describe('ViewteampayrollsComponent', () => {
  let component: ViewTeamPayrollsComponent;
  let fixture: ComponentFixture<ViewTeamPayrollsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewTeamPayrollsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ViewTeamPayrollsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

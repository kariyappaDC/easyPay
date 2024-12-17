import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdatePayrollpolicyComponent } from './update-payrollpolicy.component';

describe('UpdatePayrollpolicyComponent', () => {
  let component: UpdatePayrollpolicyComponent;
  let fixture: ComponentFixture<UpdatePayrollpolicyComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdatePayrollpolicyComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UpdatePayrollpolicyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

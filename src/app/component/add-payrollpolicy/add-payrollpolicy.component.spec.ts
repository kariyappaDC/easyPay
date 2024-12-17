import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddPayrollpolicyComponent } from './add-payrollpolicy.component';

describe('AddPayrollpolicyComponent', () => {
  let component: AddPayrollpolicyComponent;
  let fixture: ComponentFixture<AddPayrollpolicyComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddPayrollpolicyComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddPayrollpolicyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

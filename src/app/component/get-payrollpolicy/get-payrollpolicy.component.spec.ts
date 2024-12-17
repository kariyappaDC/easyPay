import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetPayrollpolicyComponent } from './get-payrollpolicy.component';

describe('GetPayrollpolicyComponent', () => {
  let component: GetPayrollpolicyComponent;
  let fixture: ComponentFixture<GetPayrollpolicyComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GetPayrollpolicyComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GetPayrollpolicyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

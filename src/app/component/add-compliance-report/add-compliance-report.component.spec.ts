import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddComplianceReportComponent } from './add-compliance-report.component';

describe('AddComplianceReportComponent', () => {
  let component: AddComplianceReportComponent;
  let fixture: ComponentFixture<AddComplianceReportComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddComplianceReportComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddComplianceReportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

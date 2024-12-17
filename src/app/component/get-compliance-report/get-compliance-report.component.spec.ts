import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetComplianceReportComponent } from './get-compliance-report.component';

describe('GetComplianceReportComponent', () => {
  let component: GetComplianceReportComponent;
  let fixture: ComponentFixture<GetComplianceReportComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GetComplianceReportComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GetComplianceReportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

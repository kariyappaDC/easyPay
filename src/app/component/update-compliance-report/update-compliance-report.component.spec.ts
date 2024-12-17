import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateComplianceReportComponent } from './update-compliance-report.component';

describe('UpdateComplianceReportComponent', () => {
  let component: UpdateComplianceReportComponent;
  let fixture: ComponentFixture<UpdateComplianceReportComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateComplianceReportComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UpdateComplianceReportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

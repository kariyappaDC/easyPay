import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ComplianceReport } from 'src/app/model/ComplianceReport';
import { AdminHrManagerService } from 'src/app/service/admin-hr-manager.service';


@Component({
  selector: 'app-update-compliance-report',
  templateUrl: './update-compliance-report.component.html',
  styleUrls: ['./update-compliance-report.component.css']
})
export class UpdateComplianceReportComponent implements OnInit {
  complianceReport: ComplianceReport = {
    reportId: 0,
    reportDate: '',
    complianceStatus: '',
    emp_id: 0
  };

  constructor(
    private service: AdminHrManagerService,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    const reportId = +this.route.snapshot.paramMap.get('reportId')!;
    this.service.getComplianceReportById(reportId).subscribe((data) => {
      this.complianceReport = data;
    });
  }

  updateComplianceReport(): void {
    this.service.updateComplianceReport(this.complianceReport.reportId, this.complianceReport).subscribe(() => {
      console.log('Compliance Report updated successfully');
      
    });
  }
}

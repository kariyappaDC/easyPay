import { Component } from '@angular/core';
import { ComplianceReport } from 'src/app/model/ComplianceReport';
import { AdminHrManagerService } from 'src/app/service/admin-hr-manager.service';


@Component({
  selector: 'app-get-compliance-report',
  templateUrl: './get-compliance-report.component.html',
  styleUrls: ['./get-compliance-report.component.css']
})
export class GetComplianceReportComponent {

  reportList: ComplianceReport[] = [];

  selectedReport: ComplianceReport | null = null;
  
  constructor(private  service:AdminHrManagerService){

  }



  getAllComplianceReports(){
    this.service.getAllComplianceReports().subscribe(
      (complianceReport) => { 
        this.reportList = complianceReport;
        console.log(this.reportList);
      },
      (err) => { 
        console.log(err); 
      }
    );
  }



  getComplianceReportById(id: number) {
    this.service.getComplianceReportById(id).subscribe(
      (complianceReport) => {
        this.selectedReport = complianceReport;
        console.log(this.selectedReport);
      },
      (err) => {
        console.error('Error fetching employee by ID:', err);
         // Handle specific error status (e.g., 404 Not Found)
      if (err.status === 404) {
        alert(`compliance with ID ${id} not found.`);
      } else {
        // Handle other errors (e.g., 500 Internal Server Error)
        alert('An unexpected error occurred. Please try again later.');
      }
      }
    );
  }

  
  deleteComplianceReport(reportId: number): void {
    this.service.deleteComplianceReport(reportId).subscribe(
      (response) => {
        // Handle successful deletion (e.g., refresh the list or remove the report from reportList)
        this.reportList = this.reportList.filter(report => report.reportId !== reportId);
        console.log('Report deleted successfully');
      },
      (error) => {
        // Handle error (e.g., show an error message)
        console.error('Error deleting report:', error);

      }
    );
  }
  

}

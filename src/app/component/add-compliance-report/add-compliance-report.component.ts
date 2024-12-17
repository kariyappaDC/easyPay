import { Component } from '@angular/core';
import { ComplianceReport } from 'src/app/model/ComplianceReport';
import { AdminHrManagerService } from 'src/app/service/admin-hr-manager.service';


@Component({
  selector: 'app-add-compliance-report',
  templateUrl: './add-compliance-report.component.html',
  styleUrls: ['./add-compliance-report.component.css']
})
export class AddComplianceReportComponent {


  constructor(private  service:AdminHrManagerService){

  }

  submitCompliance(ComplianceReport:ComplianceReport ){

    console.log(ComplianceReport);
    this.service.submitCompliance(ComplianceReport).subscribe(

      (response)=>{  console.log(response)
  
        alert(" Compliance report  added successfully")
      } ,
  
      (err)=>{ console.log(err)
        if (err.status === 403) {
          alert("Employee ID not found or access is forbidden.");
        } else {
          alert("An unexpected error occurred. Please try again later.");
        }
      }
  
  
  
  );

  }

}

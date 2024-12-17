import { Component } from '@angular/core';
import { PayrollPolicy } from 'src/app/model/PayrollPolicy';
import { AdminHrManagerService } from 'src/app/service/admin-hr-manager.service';


@Component({
  selector: 'app-get-payrollpolicy',
  templateUrl: './get-payrollpolicy.component.html',
  styleUrls: ['./get-payrollpolicy.component.css']
})
export class GetPayrollpolicyComponent {


  policyList: PayrollPolicy[] = [];
  selectedPolicy: PayrollPolicy | null = null;
  constructor(private  service:AdminHrManagerService){

  }

  getAllPayrollPolicies(){
    this.service.getAllPayrollPolicies().subscribe(
      (complianceReport) => { 
        this.policyList = complianceReport;
        console.log(this.policyList);
      },
      (err) => { 
        console.log(err); 
      }
    );
  }



  getPayrollPolicyById(id: number) {
    this.service.getPayrollPolicyById(id).subscribe(
      (payrollPolicy) => {
        this.selectedPolicy = payrollPolicy;
        console.log(this.selectedPolicy);
      },
      (err) => {
        console.error('Error fetching :', err);
               
      if (err.status === 404) {
        alert(`payroll with ID ${id} not found.`);
      } else {
        // Handle other errors (e.g., 500 Internal Server Error)
        alert('An unexpected error occurred. Please try again later.');
      }
      }
    );
  }


  deletePayrollPolicy(policyId: number){
    this.service.deletePayrollPolicy(policyId).subscribe(
      (response) => {

        this.policyList = this.policyList.filter(report => report.policyId !== policyId);
        console.log('Report deleted successfully');
      },
      (error) => {
        // Handle error (e.g., show an error message)
        console.error('Error deleting report:', error);
      }
    );
  }
  


}

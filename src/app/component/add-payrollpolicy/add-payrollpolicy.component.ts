import { Component } from '@angular/core';
import { PayrollPolicy } from 'src/app/model/PayrollPolicy';
import { AdminHrManagerService } from 'src/app/service/admin-hr-manager.service';

@Component({
  selector: 'app-add-payrollpolicy',
  templateUrl: './add-payrollpolicy.component.html',
  styleUrls: ['./add-payrollpolicy.component.css']
})
export class AddPayrollpolicyComponent {

  constructor(private  service:AdminHrManagerService){

  }

  submitPayrollPolicy(payrollPolicy: PayrollPolicy){

    this.service.submitPayrollPolicy(payrollPolicy).subscribe(

      (response)=>{  console.log(response)
  
        alert("payroll policy added successfully")
      } ,
  
      (err)=>{ console.log(err)}
  
  
  
  );

  }

}

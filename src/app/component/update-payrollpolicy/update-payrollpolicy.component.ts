import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { PayrollPolicy } from 'src/app/model/PayrollPolicy'; // Ensure the model exists and is properly defined
import { AdminHrManagerService } from 'src/app/service/admin-hr-manager.service';

@Component({
  selector: 'app-update-payrollpolicy',
  templateUrl: './update-payrollpolicy.component.html',
  styleUrls: ['./update-payrollpolicy.component.css']
})
export class UpdatePayrollpolicyComponent implements OnInit {
  payrollPolicy: PayrollPolicy = {
    policyId: 0,
    policyName: '',
    policyDesc: '',
    baseSalary: 0,
    overtimeRate: 0,
    taxPercentage: 0
  };

  constructor(
    private service: AdminHrManagerService,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    const policyId = +this.route.snapshot.paramMap.get('policyId')!;
    this.service.getPayrollPolicyById(policyId).subscribe((data) => {
      this.payrollPolicy = data;
    });
  }

  updatePayrollPolicy(): void {
    this.service.updatePayrollPolicy(this.payrollPolicy.policyId, this.payrollPolicy).subscribe(() => {
      console.log('Payroll Policy updated successfully');
      
    });
  }
}

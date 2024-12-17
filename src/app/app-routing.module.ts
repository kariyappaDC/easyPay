import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddBenefitsComponent } from './component/add-benefits/add-benefits.component';
import { AddComplianceReportComponent } from './component/add-compliance-report/add-compliance-report.component';
import { AddDeductionComponent } from './component/add-deduction/add-deduction.component';
import { AddEmployeeComponent } from './component/add-employee/add-employee.component';
import { AddPayrollpolicyComponent } from './component/add-payrollpolicy/add-payrollpolicy.component';
import { GetAllEmployeeComponent } from './component/get-all-employee/get-all-employee.component';
import { GetBenefitsComponent } from './component/get-benefits/get-benefits.component';
import { GetComplianceReportComponent } from './component/get-compliance-report/get-compliance-report.component';
import { GetDeductionComponent } from './component/get-deduction/get-deduction.component';
import { GetPayrollpolicyComponent } from './component/get-payrollpolicy/get-payrollpolicy.component';
import { HrDashboardComponent } from './component/hr-dashboard/hr-dashboard.component';
import { PayrollProcessorDashboardComponent } from './component/payroll-processor-dashboard/payroll-processor-dashboard.component';
import { ProcessPaymentComponent } from './component/process-payment/process-payment.component';
import { UpdateBenefitsComponent } from './component/update-benefits/update-benefits.component';
import { UpdateComplianceReportComponent } from './component/update-compliance-report/update-compliance-report.component';
import { UpdateDeductionComponent } from './component/update-deduction/update-deduction.component';
import { UpdateEmployeeComponent } from './component/update-employee/update-employee.component';
import { UpdatePayrollpolicyComponent } from './component/update-payrollpolicy/update-payrollpolicy.component';
import { SecurityComponent } from './component/security/security.component';
import { RegistrationComponent } from './component/registration/registration.component';
import { EmployeeDashboardComponent } from './component/employee-dashboard/employee-dashboard.component';
import { GetPayStubsComponent } from './component/get-paystubs/getpaystubs.component';
import { ManagerDashboardComponent } from './component/manager-dashboard/manager-dashboard.component';
import { RequestLeaveComponent } from './component/requestleave/requestleave.component';
import { SubmitattendanceComponent } from './component/submitattendance/submitattendance.component';
import { UpdateempdetailsComponent } from './component/updateempdetails/updateempdetails.component';
import { UpdateLeaveRequestComponent } from './component/updateleaverequest/updateleaverequest.component';
import { ViewTeamPayrollsComponent } from './component/viewteampayrolls/viewteampayrolls.component';


const routes: Routes = [



  { path: 'login', component: SecurityComponent },
  { path: 'register', component: RegistrationComponent },

  { path: 'hr-dashboard', component: HrDashboardComponent, children: [
    { path: 'add-employee', component: AddEmployeeComponent },
    { path: 'get-all-employee', component: GetAllEmployeeComponent },
    { path: 'edit/:empId', component: UpdateEmployeeComponent },
    { path: 'add-compliance-report', component: AddComplianceReportComponent },
    { path: 'get-compliance-report', component: GetComplianceReportComponent },
    { path: 'editcom/:reportId', component: UpdateComplianceReportComponent },
    { path: 'add-payrollpolicy', component: AddPayrollpolicyComponent },
    { path: 'get-payrollpolicy', component: GetPayrollpolicyComponent },
    { path: 'editpay/:policyId', component: UpdatePayrollpolicyComponent },
]},
{path: 'payroll-processor-dashboard', component: PayrollProcessorDashboardComponent, children:[
  { path: 'add-benefits', component: AddBenefitsComponent },
  { path: 'get-benefits', component: GetBenefitsComponent },
  { path: 'editben/:benifitId', component: UpdateBenefitsComponent},
  { path: 'add-deduction', component: AddDeductionComponent },
  { path: 'get-deduction', component: GetDeductionComponent },
  { path: 'editded/:deductionId', component: UpdateDeductionComponent},
  { path: 'process-payment', component: ProcessPaymentComponent }
]},

//{ path: 'process-payment', component: ProcessPaymentComponent }
{ path: 'employee-dashboard', component: EmployeeDashboardComponent, children:[
  { path:'updateempdetails',component:UpdateempdetailsComponent },
  { path:'getpaystubs',component:GetPayStubsComponent },
  { path:'submitattendance',component:SubmitattendanceComponent },
  { path: 'requestleave',component:RequestLeaveComponent}
]
},

{ path: 'manager-dashboard', component: ManagerDashboardComponent, children:[
  { path:'viewteampayrolls',component:ViewTeamPayrollsComponent },
  { path:'updateleaverequest',component:UpdateLeaveRequestComponent },
  
]
},



];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

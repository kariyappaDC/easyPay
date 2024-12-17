import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';



import { FormsModule } from '@angular/forms';

import {HttpClientModule} from '@angular/common/http';
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
import { AdminHrManagerService } from './service/admin-hr-manager.service';
import { PayrollProcessorService } from './service/payroll-processor.service';
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


@NgModule({
  declarations: [
    AppComponent,
    AddEmployeeComponent,
    UpdateEmployeeComponent,
    GetAllEmployeeComponent,
    AddPayrollpolicyComponent,
    GetPayrollpolicyComponent,
    UpdatePayrollpolicyComponent,
    AddComplianceReportComponent,
    GetComplianceReportComponent,
    UpdateComplianceReportComponent,
    HrDashboardComponent,
    PayrollProcessorDashboardComponent,
    AddBenefitsComponent,
    GetBenefitsComponent,
    UpdateBenefitsComponent,
    UpdateDeductionComponent,
    AddDeductionComponent,
    GetDeductionComponent,
    ProcessPaymentComponent,
    SecurityComponent,
    RegistrationComponent,
    EmployeeDashboardComponent,
    UpdateempdetailsComponent,
    GetPayStubsComponent,
    SubmitattendanceComponent,
    RequestLeaveComponent,
    ManagerDashboardComponent,
    ViewTeamPayrollsComponent,
    UpdateLeaveRequestComponent,
   

    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [AdminHrManagerService,PayrollProcessorService],
  bootstrap: [AppComponent]
})
export class AppModule { }

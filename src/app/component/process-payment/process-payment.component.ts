import { Component } from '@angular/core';
import { PayrollProcessorService } from 'src/app/service/payroll-processor.service';


@Component({
  selector: 'app-process-payment',
  templateUrl: './process-payment.component.html',
  styleUrls: ['./process-payment.component.css']
})
export class ProcessPaymentComponent {

  empId!: number; // Employee ID input from the user
  payrollDate!: string; // Payroll Date input from the user
  message!: string; // Message to display the response or error

  constructor(private  service:PayrollProcessorService){

  }


  processPayment(): void {
    if (!this.empId || !this.payrollDate) {
      this.message = 'Please enter valid Employee ID and Payroll Date.';
      return;
    }

    this.service.processPayment(this.empId, this.payrollDate).subscribe({
      next: (response) => {
        this.message = response;
      },
      error: (err) => {
        this.message = 'Error processing payroll: ' + err.message;
      },
    });
  }


}

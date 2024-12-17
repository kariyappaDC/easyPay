import { Component } from '@angular/core';
import { LeavesDto } from 'src/app/model/LeavesDto';
import { EmployeeService } from 'src/app/service/employee.service';

@Component({
  selector: 'app-requestleave',
  templateUrl: './requestleave.component.html',
  styleUrls: ['./requestleave.component.css']
})
export class RequestLeaveComponent {

  
  leavesdata: LeavesDto={
    empId:0,
    startDate: new Date(),
    endDate:new Date(),
    leaveType: '',
    managerID:{
      managerId:0
    }
  }

  constructor(private employeeService: EmployeeService ) {
  
  }

  onSubmit(): void {
    

    console.log("Request Payload: " , this.leavesdata);
      this.employeeService.requestLeave(this.leavesdata).subscribe({
        next: (response) => {
          alert("Leave Request Submission Succesfull");
          console.log(response);
        },
        error: (error) => {
          alert("Leave Request Submission Unsuccesfull");
          console.log(error);
        }
      });
    }
}


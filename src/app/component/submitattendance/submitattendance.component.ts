import { Component } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { EmployeeService } from '../../service/employee.service';
import { AttendanceDto } from 'src/app/model/AttendanceDto';


@Component({
  selector: 'app-submitattendance',
  templateUrl: './submitattendance.component.html',
  styleUrls: ['./submitattendance.component.css']
})
export class SubmitattendanceComponent {

  attendance:AttendanceDto={
    empId: 0,
    workDate: new Date() ,
    hoursWorked:0,
    status:''
  }

  constructor(private service :EmployeeService){

  }


  submitAttendance(attendance:AttendanceDto){

    this.service.submitAttendance(attendance).subscribe(
      (response)=>{
        console.log(response);
        alert("Attendance Submission Succesfull");
      },
      (err)=>{

        console.log(err);
        alert("Attendance Submission Unsuccesfull !");
      }
    );

  }

  
}


import { JsonPipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { EmpDto } from 'src/app/model/EmpDto';
import { EmployeeService } from 'src/app/service/employee.service';

@Component({
  selector: 'app-updateempdetails',
  templateUrl: './updateempdetails.component.html',
  styleUrls: ['./updateempdetails.component.css']
})
export class UpdateempdetailsComponent {

  empDto:EmpDto={
    empId:0,
    empName:'',
    position:'',
    empDepartment:'',

  };


  constructor(private service:EmployeeService){

  }

  updateEmpPersonalInformation(empDto:EmpDto){

    this.service.updateEmpPersonalInformation(empDto).subscribe(

      (response)=>{
        console.log(response);
        alert("Employee Details Updated Succesfully! ");
      },
      (err)=>{
        console.log(err);
        alert("Employee Update Unsuccesful")
      }
    );

  }

 




}
//   updateForm: FormGroup;
//   successMessage: string = '';
//   errorMessage: string = '';

//   constructor(
//     private fb: FormBuilder,
//     private employeeService: EmployeeService
//   ) {
//     this.updateForm = this.fb.group({
//       empId: ['', [Validators.required, Validators.min(1)]],
//       empName: ['', Validators.required],
//       empDepartment: ['', Validators.required],
//       position: ['', Validators.required]
//     });
//   }

//   ngOnInit(): void {}

//   onSubmit(): void {
//     if (this.updateForm.valid) {
//       const empId = this.updateForm.get('empId')?.value;
//       const updateInfo = {
//         empName: this.updateForm.get('empName')?.value,
//         empDepartment: this.updateForm.get('empDepartment')?.value,
//         position: this.updateForm.get('position')?.value
//       };
      
//       this.employeeService.updateEmpPersonalInformation(empId, updateInfo)
//         .subscribe({
//           next: (response) => {
//             this.successMessage = 'Personal information updated successfully';
//             this.errorMessage = '';
//             this.updateForm.reset();
//             console.log(response);
//             alert(response);
//           },
//           error: (error) => {
//             this.errorMessage = 'Failed to update personal information';
//             this.successMessage = '';
//             console.log(error)
//             alert(error);
//           }
//         });
//     }
//   }
// } 


  


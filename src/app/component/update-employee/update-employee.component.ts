import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Employee } from 'src/app/model/employee';
import { AdminHrManagerService } from 'src/app/service/admin-hr-manager.service';

@Component({
  selector: 'app-update-employee',
  templateUrl: './update-employee.component.html',
  styleUrls: ['./update-employee.component.css']
})
export class UpdateEmployeeComponent implements OnInit {
  employee: Employee = {
    empId: 0,
    empName: '',
    position: '',
    empDepartment: '',
    empsalary: 0,
    joinDate: '',
    userId: 0,
    deductionId: 0,
    benefitId: 0,
    roleId: 0,
    managerId: undefined
  };

  constructor(
    private service: AdminHrManagerService,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    const empId = +this.route.snapshot.paramMap.get('empId')!;
    this.service.getEmployeeById(empId).subscribe((data) => {
      this.employee = data;
    });
  }

  updateEmployee(): void {
    this.service.updateEmployee(this.employee.empId, this.employee).subscribe(() => {
      
    });
  }
}

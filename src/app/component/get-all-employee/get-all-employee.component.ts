import { Component } from '@angular/core';
import { Employee } from 'src/app/model/employee';
import { AdminHrManagerService } from 'src/app/service/admin-hr-manager.service';


@Component({
  selector: 'app-get-all-employee',
  templateUrl: './get-all-employee.component.html',
  styleUrls: ['./get-all-employee.component.css']
})
export class GetAllEmployeeComponent {


  constructor(private  service:AdminHrManagerService){

  }
 

  employeeList: Employee[] = [];
  selectedEmployee: Employee | null = null;

  getAllEmployees(){
    this.service.getAllEmployees().subscribe(
      (employee) => { 
        this.employeeList = employee;
        console.log(this.employeeList);
      },
      (err) => { 
        console.log(err); 
      }
    );
  }



  getEmployeeById(id: number) {
    this.service.getEmployeeById(id).subscribe(
      (employee) => {
        this.selectedEmployee = employee;
        console.log(this.selectedEmployee);
      },
      (err) => {
        console.error('Error fetching employee by ID:', err);
         // Handle specific error status (e.g., 404 Not Found)
      if (err.status === 404) {
        alert(`Employee with ID ${id} not found.`);
      } else {
        // Handle other errors (e.g., 500 Internal Server Error)
        alert('An unexpected error occurred. Please try again later.');
      }
      }
    );
  }


  deleteEmployee(empId: number){
    this.service.deleteEmployee(empId).subscribe(
      (response) => {

        this.employeeList = this.employeeList.filter(report => report.empId !== empId);
        console.log('Report deleted successfully');
      },
      (error) => {
        // Handle error (e.g., show an error message)
        console.error('Error deleting report:', error);
      }
    );
  }




}

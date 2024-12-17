import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Payroll } from '../model/Payroll';
import { EmpDto } from '../model/EmpDto';
import { AttendanceDto } from '../model/AttendanceDto';
import { LeavesDto } from '../model/LeavesDto';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  private baseUrl="http://localhost:8181/api/employeeservice";

  constructor(private http:HttpClient) {
   }

   updateEmpPersonalInformation( updatedInfo: EmpDto):Observable<EmpDto>{ 
    const token = localStorage.getItem('authToken');  // Retrieve token from localStorage
    if (!token) {
      return new Observable(observer => {
        observer.error('No token found'); // Handle case where token is not found
      });
    }

    const headers = new HttpHeaders({
      'Authorization': `Bearer ${token}`, // Add token to the Authorization header
      'Content-Type': 'application/json'
    });

    const url=`${this.baseUrl}/updatepersonalinfo/${updatedInfo.empId}`;

    return this.http.put<EmpDto>(url,updatedInfo,{headers});
    
   }

   getPayStubs(empId:number):Observable<Payroll[]>{
    const token = localStorage.getItem('authToken');  // Retrieve token from localStorage
    if (!token) {
      return new Observable(observer => {
        observer.error('No token found'); // Handle case where token is not found
      });
    }

    const headers = new HttpHeaders({
      'Authorization': `Bearer ${token}`, // Add token to the Authorization header
      'Content-Type': 'application/json'
    });

    const url=`${this.baseUrl}/paystubs/${empId}`;

     return this.http.get<Payroll[]>(url ,{headers});
    
   }

   submitAttendance( attendance:AttendanceDto):Observable<AttendanceDto>{
    const token = localStorage.getItem('authToken');  // Retrieve token from localStorage
    if (!token) {
      return new Observable(observer => {
        observer.error('No token found'); // Handle case where token is not found
      });
    }

    const headers = new HttpHeaders({
      'Authorization': `Bearer ${token}`, // Add token to the Authorization header
      'Content-Type': 'application/json'
    });

    const url=`${this.baseUrl}/submitattendance/${attendance.empId}`;

    return this.http.post<AttendanceDto>(url,attendance,{headers});
   }
  

   requestLeave( leaveRequest:LeavesDto):Observable<LeavesDto>{
    const token = localStorage.getItem('authToken');  // Retrieve token from localStorage
    if (!token) {
      return new Observable(observer => {
        observer.error('No token found'); // Handle case where token is not found
      });
    }

    const headers = new HttpHeaders({
      'Authorization': `Bearer ${token}`, // Add token to the Authorization header
      'Content-Type': 'application/json'
    });

    const url=`${this.baseUrl}/requestleave/${leaveRequest.empId}`;
    return this.http.post<LeavesDto>(url, leaveRequest,{headers});    
   }

}

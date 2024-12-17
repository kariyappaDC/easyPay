import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Payroll } from '../model/Payroll';
import { Leaves } from '../model/Leaves';
import { LeavesDto } from '../model/LeavesDto';
import { LeaveListDto } from '../model/LeaveListDto';
import { PayrollDTO } from '../model/PayrollDTO';



@Injectable({
  providedIn: 'root'
})
export class ManagerService {

  private baseUrl='http://localhost:8181/api/managerservice';

  constructor(private http: HttpClient) {

   }
   
   reviewTeamPayrolls(managerId:number):Observable<PayrollDTO[]>{
    const token = localStorage.getItem('authToken');
    if (!token) {
      return new Observable(observer => {
        observer.error('No token found');
      });
    }

    const headers = new HttpHeaders({
      'Authorization': `Bearer ${token}`,
      'Content-Type': 'application/json'
    });

    const url = `${this.baseUrl}/teampayrolls/${managerId}`;

    return this.http.get<PayrollDTO[]>(url ,{headers});
   }

  

  

  getAllLeavesByManagerId(managerId:number):Observable<LeaveListDto[]>{
    const token = localStorage.getItem('authToken');
    if (!token) {
      return new Observable(observer => {
        observer.error('No token found');
      });
    }

    const headers = new HttpHeaders({
      'Authorization': `Bearer ${token}`,
      'Content-Type': 'application/json'
    });

    const url = `${this.baseUrl}/leaves/${managerId}`;

    return this.http.get<LeaveListDto[]>(url ,{headers})

  } 


  updateLeaveStatus(managerId: number, leaveId: number, status: string): Observable<any> {
    const token = localStorage.getItem('authToken');
    if (!token) {
      return new Observable(observer => {
        observer.error('No token found');
      });
    }

    const headers = new HttpHeaders({
      'Authorization': `Bearer ${token}`,
      'Content-Type': 'application/json'
    });

    const url = `${this.baseUrl}/approveleave/${managerId}/${leaveId}?status=${status}`;
    return this.http.put<any>(url,{}, {headers});
  }
}

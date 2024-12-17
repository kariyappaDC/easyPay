import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { ComplianceReport } from '../model/ComplianceReport';
import { Employee } from '../model/employee';
import { PayrollPolicy } from '../model/PayrollPolicy';


@Injectable({
  providedIn: 'root'
})
export class AdminHrManagerService {

  baseURL = "http://localhost:8181/api/adminhr/";

  constructor(private  http:HttpClient) {

   }

 
  // --------------------------employee service--------------------

  submitEmployee(employee: Employee): Observable<Employee> {
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

    const url = `${this.baseURL}employee/add`;
    return this.http.post<Employee>(url, employee, { headers });
  }


  getAllEmployees(): Observable<Employee[]> {
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

    const url = `${this.baseURL}employees`; 
    return this.http.get<Employee[]>(url, { headers });
  }
     
  getEmployeeById(id: number): Observable<Employee> {
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

    const url = `${this.baseURL}employee/${id}`;
    return this.http.get<Employee>(url, { headers });
  }

    
    
  deleteEmployee(id: number): Observable<void> {
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

    const url = `${this.baseURL}employee/delete/${id}`;
    return this.http.delete<void>(url, { headers });
  }


updateEmployee(empId: number, employee: Employee): Observable<Employee> {
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

  const url = `${this.baseURL}employee/update/${empId}`;
  return this.http.put<Employee>(url, employee, { headers });
}


  // ---------------------------------Compliance report  service----------------------------------

      submitCompliance(complianceReport: ComplianceReport): Observable<ComplianceReport> {
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
      
        return this.http.post<ComplianceReport>(`${this.baseURL}complianceReport/add`, complianceReport, { headers });
      }
      

      getAllComplianceReports(): Observable<ComplianceReport[]> {
        const token = localStorage.getItem('authToken');
        if (!token) {
          return new Observable(observer => {
            observer.error('No token found');
          });
        }
      
        const headers = new HttpHeaders({
          'Authorization': `Bearer ${token}`
        });
      
        return this.http.get<ComplianceReport[]>(`${this.baseURL}complianceReports`, { headers });
      }
     
      getComplianceReportById(id: number): Observable<ComplianceReport> {
        const token = localStorage.getItem('authToken');
        if (!token) {
          return new Observable(observer => {
            observer.error('No token found');
          });
        }
      
        const headers = new HttpHeaders({
          'Authorization': `Bearer ${token}`
        });
      
        const url = `${this.baseURL}complianceReport/${id}`;
        return this.http.get<ComplianceReport>(url, { headers });
      }
    
    
      deleteComplianceReport(id: number): Observable<void> {
        const token = localStorage.getItem('authToken');
        if (!token) {
          return new Observable(observer => {
            observer.error('No token found');
          });
        }
      
        const headers = new HttpHeaders({
          'Authorization': `Bearer ${token}`
        });
      
        const url = `${this.baseURL}complianceReport/delete/${id}`;
        return this.http.delete<void>(url, { headers });
      }


      updateComplianceReport(reportId: number, employee: ComplianceReport): Observable<ComplianceReport> {
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
      
        const url = `${this.baseURL}complianceReport/update${reportId}`;
        return this.http.put<ComplianceReport>(url, employee, { headers });
      }


 //-----------------------------------Payroll policy  service------------------------------------------

 submitPayrollPolicy(payrollPolicy: PayrollPolicy): Observable<PayrollPolicy> {
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

  return this.http.post<PayrollPolicy>(`${this.baseURL}payrollPolicy/add`, payrollPolicy, { headers });
 }


 getAllPayrollPolicies(): Observable<PayrollPolicy[]> {
  const token = localStorage.getItem('authToken');
  if (!token) {
    return new Observable(observer => {
      observer.error('No token found');
    });
  }

  const headers = new HttpHeaders({
    'Authorization': `Bearer ${token}`
  });

  return this.http.get<PayrollPolicy[]>(`${this.baseURL}payrollPolicies`, { headers });
}
    
     
getPayrollPolicyById(id: number): Observable<PayrollPolicy> {
  const token = localStorage.getItem('authToken');
  if (!token) {
    return new Observable(observer => {
      observer.error('No token found');
    });
  }

  const headers = new HttpHeaders({
    'Authorization': `Bearer ${token}`
  });

  const url = `${this.baseURL}payrollPolicy/${id}`;
  return this.http.get<PayrollPolicy>(url, { headers });
}
    
    
deletePayrollPolicy(id: number): Observable<void> {
  const token = localStorage.getItem('authToken');
  if (!token) {
    return new Observable(observer => {
      observer.error('No token found');
    });
  }

  const headers = new HttpHeaders({
    'Authorization': `Bearer ${token}`
  });

  const url = `${this.baseURL}payrollPolicy/delete/${id}`;
  return this.http.delete<void>(url, { headers });
}


updatePayrollPolicy(policyId: number, payrollPolicy: PayrollPolicy): Observable<PayrollPolicy> {
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

  const url = `${this.baseURL}payrollPolicy/update/${policyId}`;
  return this.http.put<PayrollPolicy>(url, payrollPolicy, { headers });
}

}

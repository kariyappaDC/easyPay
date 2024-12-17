package com.hexaware.easyspay.service;

/**
 * Service implementation for managing employee data, including personal information updates, attendance, leave requests, and payroll retrieval.
 * Provides methods for handling employee records, attendance submissions, leave requests, and pay stubs with appropriate exception handling.
 * 
 * Author: Nihar Jachak
 * Date: November 2024
 */


import java.util.List;

import org.apache.logging.slf4j.SLF4JLogger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.easyspay.dto.AttendanceDto;
import com.hexaware.easyspay.dto.EmpDto;
import com.hexaware.easyspay.dto.LeavesDto;
import com.hexaware.easyspay.entities.Attendance;
import com.hexaware.easyspay.entities.Employee;
import com.hexaware.easyspay.entities.Leaves;
import com.hexaware.easyspay.entities.Payroll;
import com.hexaware.easyspay.exception.EmployeeNotFoundException;
import com.hexaware.easyspay.exception.PayrollNotFoundException;
import com.hexaware.easyspay.repository.IAttendanceRepository;
import com.hexaware.easyspay.repository.IEmployeeRepository;
import com.hexaware.easyspay.repository.ILeavesRepository;
import com.hexaware.easyspay.repository.IPayrollRepository;

import jakarta.transaction.Transactional;

@Service

public class EmployeeServiceImpl implements IEmployeeService {
	
	
	@Autowired
	private IEmployeeRepository employeeRepository ;
	
	@Autowired
	private IAttendanceRepository attendanceRepository;
	
	@Autowired
	private ILeavesRepository leavesRepository;
	
	@Autowired
	private IPayrollRepository payrollRepository;
	
	
	
	

	public Employee updatePersonalInformation(int empId, EmpDto updatedInfo) {
        Employee employee = employeeRepository.findById(empId)
                .orElseThrow(()-> new EmployeeNotFoundException("Employee with Id: "+empId+" not found"));
        employee.setEmpName(updatedInfo.getEmpName());
        employee.setEmpDepartment(updatedInfo.getEmpDepartment());
        employee.setPosition(updatedInfo.getPosition());
        return employeeRepository.save(employee);
    }

    @Override
    public List<Payroll> getPayStubs(int empId) {
    	
        List<Payroll> payroll = payrollRepository.findByEmployeeEmpId(empId);
        
        if(payroll.isEmpty()) {
        	throw new PayrollNotFoundException("No Payroll records found for Employee Id:"+empId); 	
        }
        return payroll;
    }

    @Override
    public Attendance submitAttendance(int empId, AttendanceDto attendanceDto) {
        Employee employee = employeeRepository.findById(empId)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee with Id: " + empId + " not found"));
        
        Attendance attendance = new Attendance();
        attendance.setEmployee(employee); 
        attendance.setWorkDate(attendanceDto.getWorkDate());
        attendance.setHoursWorked(attendanceDto.getHoursWorked());
        attendance.setAttendanceStatus(attendanceDto.getStatus());
        return attendanceRepository.save(attendance);
    }

    @Override
    public Leaves requestLeave(int empId, LeavesDto leavesDto) {
        // Fetch the employee
        Employee employee = employeeRepository.findById(empId)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee with Id:" + empId + " not found"));
        
        

        // Fetch the manager
        Employee manager = employeeRepository.findById(leavesDto.getManagerID())
                .orElseThrow(() -> new EmployeeNotFoundException("Manager With Id: " + leavesDto.getManagerID() + " not found"));
        
        // Create and populate the Leaves entity
        Leaves leaves = new Leaves();
        leaves.setStartDate(leavesDto.getStartDate());
        leaves.setEndDate(leavesDto.getEndDate());
        leaves.setLeaveType(leavesDto.getLeaveType());
        leaves.setLeaveStatus("Pending");
        leaves.setEmployee(employee);
        leaves.setManager(manager); // This sets the manager correctly
        
        // Save the leave entity
        return leavesRepository.save(leaves);
    }
}

	

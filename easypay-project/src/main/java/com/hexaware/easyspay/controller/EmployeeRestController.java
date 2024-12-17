package com.hexaware.easyspay.controller;

/**
 * REST controller for managing employee-related operations such as pay stubs, personal information, attendance, and leave requests.
 * All endpoints are secured with 'EMPLOYEE' role authorization.
 * 
 * Author: Nihar Jachak
 * Date: November 2024
 */


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.easyspay.dto.AttendanceDto;
import com.hexaware.easyspay.dto.EmpDto;
import com.hexaware.easyspay.dto.LeavesDto;
import com.hexaware.easyspay.entities.Attendance;
import com.hexaware.easyspay.entities.Employee;
import com.hexaware.easyspay.entities.Leaves;
import com.hexaware.easyspay.entities.Payroll;
import com.hexaware.easyspay.service.IEmployeeService;

@RestController
@RequestMapping("/api/employeeservice")
@CrossOrigin(origins= "http://localhost:4200/")
public class EmployeeRestController {
	
	@Autowired
	IEmployeeService service;
	
	Logger logger = LoggerFactory.getLogger(EmployeeRestController.class);
	
	
	
	@GetMapping("/paystubs/{empid}")
    @PreAuthorize("hasAuthority('EMPLOYEE')")
	public ResponseEntity < List<Payroll>> getPayStubs(@PathVariable int empid){
		
		
		List<Payroll> paystubs= service.getPayStubs(empid);
		logger.info(" Paystubs for Employee: "+empid);
		return new ResponseEntity<List<Payroll>>(paystubs,HttpStatus.ACCEPTED);
		
	}
	
	
	//Update Personal Information
	
	@PutMapping("/updatepersonalinfo/{empId}")
	@PreAuthorize("hasAuthority('EMPLOYEE')")
	public Employee updatePersonalInformation( @PathVariable int empId,  @RequestBody EmpDto updatedInfo){
		
		logger.info("Updated Personal Information");
		return service.updatePersonalInformation(empId, updatedInfo);
		
	}
	
	//Submit Attendance
	
	@PostMapping("/submitattendance/{empId}")
	@PreAuthorize("hasAuthority('EMPLOYEE')")
	public ResponseEntity<Attendance> submitAttendance(@PathVariable int empId, @RequestBody AttendanceDto attendance){
		
		Attendance savedAttendance= service.submitAttendance(empId, attendance);
		ResponseEntity<Attendance>responseEntity = new ResponseEntity<Attendance>(savedAttendance,HttpStatus.CREATED);
		logger.info("Attendance Submission Succesful");
		return responseEntity;
		
	}
	
	
	//RequestForLeaves
	
	@PostMapping("/requestleave/{empId}")
	@PreAuthorize("hasAuthority('EMPLOYEE')")
	public ResponseEntity<Leaves> requestLeave(@PathVariable int empId, @RequestBody LeavesDto leavesDto) {
        // Create a new leave request
        Leaves leavesrequest = service.requestLeave(empId, leavesDto);
        ResponseEntity<Leaves>responseEntity = new ResponseEntity<Leaves>(leavesrequest,HttpStatus.CREATED);
		logger.info("Leave Request Submission Succesful");
		return responseEntity;
        
    }
	

}

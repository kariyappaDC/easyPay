package com.hexaware.easyspay.service;


import java.util.List;

import com.hexaware.easyspay.dto.AttendanceDto;
import com.hexaware.easyspay.dto.EmpDto;
import com.hexaware.easyspay.dto.LeavesDto;
import com.hexaware.easyspay.entities.Attendance;
import com.hexaware.easyspay.entities.Employee;
import com.hexaware.easyspay.entities.Leaves;
import com.hexaware.easyspay.entities.Payroll;

public interface IEmployeeService {

	Employee updatePersonalInformation(int employeeId, EmpDto updatedInfo);

    List<Payroll> getPayStubs(int employeeId);

    Attendance submitAttendance(int employeeId, AttendanceDto attendancedto);

    Leaves requestLeave(int employeeId, LeavesDto leavesDto);

}

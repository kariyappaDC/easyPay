package com.hexaware.easyspay.service;

import java.util.List;

import com.hexaware.easyspay.dto.LeaveListDto;
import com.hexaware.easyspay.dto.PayrollDTO;
import com.hexaware.easyspay.entities.Leaves;
import com.hexaware.easyspay.entities.Payroll;

public interface IManagerService {

	List<PayrollDTO> reviewTeamPayrolls(int managerId);

	LeaveListDto approveLeaveRequest(int managerId, int leaveId, String status);

	List<LeaveListDto> getLeavesByManagerId(int managerId);
    
    
}

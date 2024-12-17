package com.hexaware.easyspay.service;

/**
 * Service implementation for managing manager-specific actions like reviewing team payrolls and approving leave requests.
 * Provides methods for reviewing payroll records and approving or rejecting leave requests, with authorization checks.
 * 
 * Author: Nihar Jachak
 * Date: 17 November 2024
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.easyspay.dto.LeaveListDto;
import com.hexaware.easyspay.dto.PayrollDTO;
import com.hexaware.easyspay.entities.Leaves;
import com.hexaware.easyspay.entities.Payroll;
import com.hexaware.easyspay.exception.LeavesRequestException;
import com.hexaware.easyspay.exception.PayrollNotFoundException;
import com.hexaware.easyspay.exception.UnAuthorizedActionException;
import com.hexaware.easyspay.repository.ILeavesRepository;
import com.hexaware.easyspay.repository.IPayrollRepository;

@Service
public class ManagerServiceImpl implements IManagerService {

	@Autowired
	private IPayrollRepository payrollRepository;

	@Autowired
	private ILeavesRepository leaveRequestRepository;

	
	@Override
	public List<PayrollDTO> reviewTeamPayrolls(int managerId) {
		List<Payroll> payrolls = payrollRepository.findByEmployeeManagerEmpId(managerId);
		if (payrolls.isEmpty()) {
			throw new PayrollNotFoundException("No payroll records found for manager with ID " + managerId);
		}
		List<PayrollDTO> payrollDto = new ArrayList<>();
		for(Payroll payroll: payrolls) {
			payrollDto.add(new PayrollDTO(payroll));
		}
		

		return payrollDto;
	}

	@Override
	public LeaveListDto approveLeaveRequest(int managerId, int leaveId, String status) {

		Leaves leavesRequest = leaveRequestRepository.findByLeaveId(leaveId);
				
		// Check if the manager is authorized
		if (leavesRequest.getManager() == null || leavesRequest.getManager().getEmpId() != managerId) {
			throw new UnAuthorizedActionException(
					"Manager with ID " + managerId + " is not authorized to approve/reject this leave request");
		}

		leavesRequest.setLeaveStatus(status);

		Leaves leave = leaveRequestRepository.save(leavesRequest);
		LeaveListDto leaveDto =  new LeaveListDto(leave.getStartDate(),leave.getEndDate(), leave.getLeaveType(),
				leave.getManager().getEmpId() , leave.getEmployee().getEmpId(),leave.getLeaveStatus(),leave.getLeaveId());

		return leaveDto;
	}

	
	

	@Override
	public List<LeaveListDto> getLeavesByManagerId(int managerId) {

		List<Leaves> leaves = leaveRequestRepository.findByManagerEmpId(managerId);

		List<LeaveListDto> leavesDto = new ArrayList<>();

		leaves.forEach(leave -> {
			LeaveListDto leaveDto =  new LeaveListDto(leave.getStartDate(),leave.getEndDate(), leave.getLeaveType(),
					leave.getManager().getEmpId() , leave.getEmployee().getEmpId(),leave.getLeaveStatus(),leave.getLeaveId() );

			leavesDto.add(leaveDto);

		});

		return leavesDto;
	}

}

package com.hexaware.easyspay.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hexaware.easyspay.dto.LeaveListDto;
import com.hexaware.easyspay.entities.Leaves;

import jakarta.transaction.Transactional;

@Repository

public interface ILeavesRepository extends JpaRepository<Leaves ,Integer>,JpaSpecificationExecutor<Leaves>{ //extra custom queries
	
	@Transactional
//	@Query("select l from Leaves l where l.manager.empId =:managerId")
	List <Leaves> findByManagerEmpId(int managerId);

	 Leaves findByLeaveId(int leaveId);

}

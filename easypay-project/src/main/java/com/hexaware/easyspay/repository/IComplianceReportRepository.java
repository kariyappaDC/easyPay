package com.hexaware.easyspay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.easyspay.entities.ComplianceReport;

@Repository
public interface IComplianceReportRepository extends JpaRepository<ComplianceReport,Integer> {

}

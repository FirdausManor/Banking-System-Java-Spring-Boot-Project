package com.dao.bankingsystem.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.dao.bankingsystem.constant.StatusCode;
import com.dao.bankingsystem.entity.Branch;

@Repository
public interface BranchRepository extends JpaRepository<Branch, String> {
	Branch findByCode(String code);
	
	Branch findByName(String name);
	
	Branch findByBranchType(String branchType);
	
	List<Branch> findByStatus(StatusCode status);
}

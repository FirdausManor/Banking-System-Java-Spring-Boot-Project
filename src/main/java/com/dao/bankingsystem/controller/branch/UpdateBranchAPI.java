package com.dao.bankingsystem.controller.branch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dao.bankingsystem.entity.Branch;
import com.dao.bankingsystem.repository.BranchRepository;

@RestController
@RequestMapping("/api/branch")
public class UpdateBranchAPI {
	@Autowired
	protected BranchRepository branchRepository;
	
	@PutMapping("/update")
	public Branch updateBranch(@RequestBody Branch branch) {
		return branchRepository.save(branch);
	}
}

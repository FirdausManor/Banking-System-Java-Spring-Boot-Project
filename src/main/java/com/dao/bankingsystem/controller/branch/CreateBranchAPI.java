package com.dao.bankingsystem.controller.branch;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dao.bankingsystem.entity.Branch;
import com.dao.bankingsystem.repository.BranchRepository;

@RestController
@RequestMapping("/api/branch")
public class CreateBranchAPI {
	@Autowired
	protected BranchRepository branchRepository;
	
	@PostMapping("/create")
	public Branch createBranch(@RequestBody Branch branch) {
		branch.setId(UUID.randomUUID().toString());
		return branchRepository.save(branch); 
	}
}

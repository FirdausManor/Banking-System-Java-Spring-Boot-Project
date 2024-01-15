package com.dao.bankingsystem.controller.branch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.dao.bankingsystem.entity.Branch;
import com.dao.bankingsystem.repository.BranchRepository;

@RestController
@RequestMapping("/api/branch")
public class DeleteBranchByIdAPI {
	@Autowired
	protected BranchRepository branchRepository;

	@DeleteMapping("/remove-by-id")
	public Branch deleteBranchById(@RequestParam String id) {
		
		Branch branch = branchRepository.findById(id).orElse(null);
		
		if (branch != null) {
			branchRepository.deleteById(id);
		}
		
		return branch;
	}
}

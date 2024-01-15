package com.dao.bankingsystem.controller.branch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.dao.bankingsystem.entity.Branch;
import com.dao.bankingsystem.repository.BranchRepository;

@RestController
@RequestMapping("/api/branch")
public class LoadBranchByCodeAPI {
	@Autowired
	protected BranchRepository branchRepository;
	
	@GetMapping("/search-by-code")
	public Branch loadBranchByCode(@RequestParam String code) {
		return branchRepository.findByCode(code);
	}
}

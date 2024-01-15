package com.dao.bankingsystem.controller.branch;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.dao.bankingsystem.constant.StatusCode;
import com.dao.bankingsystem.entity.Branch;
import com.dao.bankingsystem.repository.BranchRepository;

@RestController
@RequestMapping("/api/branch")
public class LoadBranchByStatusAPI {
	@Autowired
	protected BranchRepository branchRepository;
	
	@GetMapping("/search-by-status")
	public List<Branch> loadBranch(@RequestParam StatusCode status) {
		return branchRepository.findByStatus(status);
	}
}

package com.project.payments.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.payments.model.Beneficiary;
import com.project.payments.service.BeneficiaryService;

@RestController
public class BeneficiaryController {
	
	@Autowired
	BeneficiaryService beneficiaryService;
	
	public Beneficiary getBeneficiaryById(long beneficiaryId) {
		return beneficiaryService.getBeneficiaryById(beneficiaryId);
	}
	@PostMapping("/beneficiary")
	public Beneficiary addBeneficiary(Beneficiary beneficiary) {
		return beneficiaryService.addBeneficiary(beneficiary);
	}
	
	@GetMapping("/get-AlBeneficiary")
	public List<Beneficiary> getAllBeneficaiary() {
		return beneficiaryService.getAllBeneficiary();
	}
	
}

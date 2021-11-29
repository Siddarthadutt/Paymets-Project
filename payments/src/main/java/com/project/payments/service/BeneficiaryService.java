package com.project.payments.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.payments.exception.BeneficiaryNotFoundException;
import com.project.payments.model.Beneficiary;
import com.project.payments.repository.BeneficiaryRepository;

@Service
public class BeneficiaryService {
	
	@Autowired
	BeneficiaryRepository beneficiaryRepository;
	
	public Beneficiary getBeneficiaryById(long beneficiaryId) {
		Optional<Beneficiary> beneficiary = beneficiaryRepository.findById(beneficiaryId);
		if(beneficiary.isPresent()) {
			return beneficiary.get();
		}
		throw new BeneficiaryNotFoundException("The beneficiary does not exist");
	}
	
	public boolean hasBeneficiaryId(long beneficiaryId) {
		Optional<Beneficiary> beneficiary = beneficiaryRepository.findById(beneficiaryId);
		if(beneficiary.isPresent()) {
			return true;
		}
		return false;
	}

	public Beneficiary addBeneficiary(Beneficiary beneficiary) {
		return beneficiaryRepository.save(beneficiary);
	}

	public List<Beneficiary> getAllBeneficiary() {
		// TODO Auto-generated method stub
		return beneficiaryRepository.findAll();
	}
}

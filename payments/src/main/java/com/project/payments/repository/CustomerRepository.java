package com.project.payments.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.payments.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	@Transactional
	@Modifying
	@Query("update Customer c set c.balance =?2 where c.customerId=?1")
	void updateBalanceById(long customerId, double balance);
	
}

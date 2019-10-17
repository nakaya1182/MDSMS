package com.example.demo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CustomerInformationRepository extends JpaRepository<CustomerInformationEntity, String>{
	Page<CustomerInformationEntity> findAll(Pageable pageable);

	CustomerInformationEntity findById(Integer id);
	List<CustomerInformationEntity> findAll();

	//@Query("SELECT COUNT(*) FROM customers Where flag = 0")
	Long countByFlag(int i);


	CustomerInformationEntity findByCustomerName(String pullString);
}

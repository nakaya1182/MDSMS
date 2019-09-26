package com.example.demo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CustomerInformationRepository extends PagingAndSortingRepository<CustomerInformationEntity, String>{
	Page<CustomerInformationEntity> findAll(Pageable pageable);

	CustomerInformationEntity findById(Integer id);
	List<CustomerInformationEntity> findAll();

	CustomerInformationEntity findByCustomerName(String pullString);
}

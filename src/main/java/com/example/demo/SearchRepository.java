/**package com.example.demo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchRepository extends JpaRepository<ItemCustomerStatusEntity, Integer> {


	Page<ItemCustomerStatusEntity> findAll(Pageable pageable);

	Page<ItemCustomerStatusEntity> findByAddressContaining(Pageable pageable,String title,String customerName,String name);
}*/

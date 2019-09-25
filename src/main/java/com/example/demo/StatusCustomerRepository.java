package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StatusCustomerRepository extends JpaRepository<StatusCustomerEntity, Integer>{
	@Query(value="select s.id as id, s.customer_id as customer_id,c.customer_name as customer_name, s.name as name, s.description as description, s.display_order as display_order,s.flag as flag  from statuses s join customers c on s.customer_id = c.id WHERE s.flag = 0 ORDER by s.customer_id  asc , s.display_order asc",
			nativeQuery=true)
	List<StatusCustomerEntity> findAll();
}

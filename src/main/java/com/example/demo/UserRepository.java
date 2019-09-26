package com.example.demo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository  extends JpaRepository<UserEntity, Integer>{


	Page<UserEntity> findAll(Pageable pageable);
	UserEntity findByName(String name);
	Page<UserEntity> findByAddressContaining(Pageable pageable,String Search);
   /** List<UserEntity> findByEmployeeId(Integer employee_number);*/
	//@Query (value = "select count(employee_number) from user where employee_number",nativeQuery = true)
	//List<UserEntity> findAll();
}


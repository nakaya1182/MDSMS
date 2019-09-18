package com.example.demo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<UserEntity, Integer>{

	Page<UserEntity> findAll(Pageable pageable);
	/**UserEntity findByemployee_number(String employee_number);*/
	Page<UserEntity> findByAddressContaining(Pageable pageable,String Search);

}


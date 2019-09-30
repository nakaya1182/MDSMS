package com.example.demo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository  extends JpaRepository<UserEntity, Integer>{


	Page<UserEntity> findAll(Pageable pageable);
	//UserEntity findByName(String name);
	Page<UserEntity> findByAddressContaining(Pageable pageable,String Search);
	/** List<UserEntity> findByEmployeeId(Integer employee_number);*/
	//ログインの社員番号
	@Query (value = "select * from user where employee_number = :employee_number and flag = 0",nativeQuery = true)
	String findByName(@Param("employee_number")String employee_number);
	//ログインのパスワード
	@Query (value = "select password from user where employee_number = :employee_number",nativeQuery = true)
	String findByPass(@Param("employee_number")String employee_number);
}


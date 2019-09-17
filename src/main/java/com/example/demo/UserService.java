package com.example.demo;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Transactional(rollbackOn = Exception.class)

public class UserService {

	@Autowired
	private UserRepository userRepository;

	public Page<UserEntity> selectAll(Pageable pageable) {
		return userRepository.findAll(pageable);
}
	public void create(UserEntity userEntity) {
		userRepository.save(userEntity);
	}
	public UserEntity findById(Integer employee_number) {
		return userRepository.findById(employee_number).get();
	}
	public void editUpdate(UserEntity userEntity) {
		userRepository.save(userEntity);
	}
	public void deleteUpdate(UserEntity userEntity) {
		userRepository.save(userEntity);
	}

}
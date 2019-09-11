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
}
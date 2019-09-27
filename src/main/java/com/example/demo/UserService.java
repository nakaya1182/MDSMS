package com.example.demo;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Transactional(rollbackOn = Exception.class)

public class UserService  {

	@Autowired
	private UserRepository userRepository;

	//一覧表示
	public Page<UserEntity> selectAll(Pageable pageable) {
		return userRepository.findAll(pageable);

    }
	//新規登録
	public void create(UserEntity userEntity) {
		userRepository.save(userEntity);
	}
	//対応した社員番号を選択
	public UserEntity findById(Integer employee_number) {
		return userRepository.findById(employee_number).get();
	}
	//編集
	public void editUpdate(UserEntity userEntity) {
		userRepository.save(userEntity);
	}
	//削除
	public void deleteUpdate(UserEntity userEntity) {
		userRepository.save(userEntity);
	}
	/**public List<UserEntity> selectAll(Integer employee_number) {

		return userRepository.findByEmployeeId(employee_number);

    }*/
}
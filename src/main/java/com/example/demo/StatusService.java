package com.example.demo;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
@Service
@Transactional(rollbackOn = Exception.class)
public class StatusService {
	@Autowired
	StatusRepository statusRepository;

	public Page<StatusEntity> getList(Pageable pageable) {
		Page<StatusEntity> page;
		page = statusRepository.findAll(pageable);
		return page;
	}
}

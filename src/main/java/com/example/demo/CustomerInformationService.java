package com.example.demo;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
@Service
@Transactional(rollbackOn = Exception.class)
public class CustomerInformationService {
	@Autowired
	CustomerInformationRepository customerInformationRepository;
	public Page<CustomerInformationEntity> getList(Pageable pageable) {
		Page<CustomerInformationEntity> page;
		page = customerInformationRepository.findAll(pageable);
		//System.out.println(pageable);
		return page;
	}

}

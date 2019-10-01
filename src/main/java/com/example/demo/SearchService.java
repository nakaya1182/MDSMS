/**package com.example.demo;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@Transactional(rollbackOn = Exception.class)
public class SearchService {

	@Autowired
	private SearchRepository searchRepository;

	//検索処理
		public Page<ItemCustomerStatusEntity> search(Pageable pageable,String title,String customerName,String name) {
			Page<ItemCustomerStatusEntity> page;
			if ("".equals(customerName) ){
				page = searchRepository.findAll(pageable);
			}else {
				page = searchRepository.findByAddressContaining(pageable,title,customerName,name);
			}
			return page;
		}

}*/

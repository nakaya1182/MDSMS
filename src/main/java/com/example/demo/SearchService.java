
package com.example.demo;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@Transactional(rollbackOn = Exception.class)
public class SearchService {

	@Autowired
	private ItemCustomerStatusRepository itemCustomerStatusRepository;

	//検索処理
		public Page<ItemCustomerStatusEntity> search(Pageable pageable,String title,String customerName,String name) {
			Page<ItemCustomerStatusEntity> page = null;
			if ("".equals(customerName) ){
				page = itemCustomerStatusRepository.findAll(pageable);
			}//else {
				//page = itemCustomerStatusRepository.findByAddressContaining(pageable,title,customerName,name);
			//}
			return page;
		}

}
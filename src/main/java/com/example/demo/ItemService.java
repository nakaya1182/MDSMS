package com.example.demo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Transactional(rollbackOn = Exception.class)
public class ItemService {
	@Autowired
	private ItemRepository itemRepository;
	@Autowired
	ItemCustomerStatusRepository itemCustomerStatusRepository;
	@Autowired
	CustomerInformationRepository customerInformationRepository;
	@Autowired
	StatusRepository statusRepository;
	@Autowired
	StatusCustomerRepository statusCustomerRepository;
	//一覧表示
	public Page<ItemCustomerStatusEntity> findAll(Pageable pageable) {
		return itemCustomerStatusRepository.findAll(pageable);
	}
	///新規登録
	public void create(ItemEntity itemEntity) {
		itemRepository.save(itemEntity);
	}
	///対応した社員番号を選択
	public ItemEntity findById(Integer id) {
		return itemRepository.findById(id).get();
	}
	///編集
	public void editUpdate(ItemEntity itemEntity) {
		itemRepository.save(itemEntity);
	}
	///削除
	public void deleteUpdate(ItemEntity itemEntity) {
		itemRepository.save(itemEntity);
	}

	///customerIdから顧客名取得
	public CustomerInformationEntity findByCustomerId(Integer customerId) {
		return customerInformationRepository.findById(customerId);
	}
	///statusIdからステータス名取得
	public StatusEntity findByStatusId(Integer statusId) {
		return statusRepository.findById(statusId);
	}
	//customerIdからその顧客のステータスの一覧を取得
	public List<StatusCustomerEntity> findByCustmerId(Integer customerId) {
		return statusCustomerRepository.findByCustmerId(customerId);
	}
	public Page<ItemCustomerStatusEntity> search(Pageable pageable, String Search, Integer customerId, Integer statusId) {
		Page<ItemCustomerStatusEntity> page = null;
		System.out.println("aaaaaaaaaaaaaaaaaaa");
		if(customerId != null && statusId != null){
			System.out.println("b");
			page = itemCustomerStatusRepository.searchCS(pageable,Search,customerId,statusId);
			System.out.println("c");
		} else if(customerId != null){
			System.out.println("d");
			page = itemCustomerStatusRepository.searchC(pageable,Search,customerId);
			System.out.println("f");
		} else if(statusId != null) {
			System.out.println("g");
			page = itemCustomerStatusRepository.searchS(pageable,Search,statusId);
			System.out.println("h");
		}else {
			System.out.println("j");
			page = itemCustomerStatusRepository.search(pageable,Search);
			System.out.println("k");
		}
		return  page;
	}

}


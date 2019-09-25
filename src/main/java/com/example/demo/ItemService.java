package com.example.demo;

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
	//一覧表示
	public Page<ItemEntity> selectAll(Pageable pageable) {
		return itemRepository.findAll(pageable);
	}
	//新規登録
	public void create(ItemEntity itemEntity) {
		itemRepository.save(itemEntity);
	}
	//対応した社員番号を選択
	public ItemEntity findById(Integer id) {
		return itemRepository.findById(id).get();
	}
	//編集
	public void editUpdate(ItemEntity itemEntity) {
		itemRepository.save(itemEntity);
	}
}

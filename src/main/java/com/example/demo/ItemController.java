package com.example.demo;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ItemController {

	@Autowired
	ItemService itemService;



	/**
	 * 一覧表示を表示
	 */
	@RequestMapping(value = "ItemList", method=RequestMethod.GET)
	public String itemList(Model model, @PageableDefault(page = 0, value = 10)Pageable pageable) {
		Page<ItemEntity> itemList = itemService.selectAll(pageable);
		model.addAttribute("page", itemList);
		model.addAttribute("ItemList", itemList.getContent());
		return "ItemList";
	}
	/**
	 * 案件新規登録
	 */
	@GetMapping(value = "/ItemRegistration")
	public String itemRegistration(Model model) {
		return "ItemRegistration";
	}
	/**
	 * 新規登録の確認画面
	 */
	@RequestMapping(value ="/ItemRegistrationConfirmation", method = RequestMethod.POST)
	public String itemRegistration(@ModelAttribute @Validated ItemEntity itemEntity, Model model) {
		Timestamp nowTime = new Timestamp(System.currentTimeMillis());
		model.addAttribute("nowTime", nowTime);
		return "ItemRegistrationConfirmation";
	}
	/**
	 * 新規登録から一覧画面に戻る
	 */
	@PostMapping("/ItemList")
	public String create(@ModelAttribute ItemEntity itemEntity, Model model) {
		itemService.create(itemEntity);
		return "redirect:ItemList";
	}
	/**
	 * ユーザー編集画面
	}*/
	@GetMapping("/{id}/ItemEdit")
	public String edit(@PathVariable Integer id, Model model) {
		ItemEntity itemEntity = itemService.findById(id);
		model.addAttribute("itemEntity", itemEntity);
		return "ItemEdit";
	}/**
	 * 編集,削除戻るボタン
	 */
	@GetMapping(value = "/ListBack")
	public String listBack(Model model) {
		return "redirect:ItemList";
	}
	/**
	 * 編集の確認画面
	}*/
	@RequestMapping(value = "{id}/ItemEditConfirmation" ,method = RequestMethod.POST)
	public String editConfirmation(@ModelAttribute @Validated ItemEntity itemEntity, Model model) {
		Timestamp nowTime = new Timestamp(System.currentTimeMillis());
		model.addAttribute("nowTime", nowTime);
		return "ItemEditConfirmation";
	}
	/**
	 * 編集確認から一覧画面に戻る
	 */
	@PostMapping("IE{id}")
	public String editUpdate(@PathVariable Integer id, @ModelAttribute ItemEntity itemEntity) {
		itemEntity.setId(id);
		itemService.editUpdate(itemEntity);
		return "redirect:ItemList";
	}
	/**
	 * ユーザー削除画面
	 */
	@GetMapping("/{id}/ItemDelete")
	public String delete(@PathVariable Integer id, Model model) {
		ItemEntity itemEntity = itemService.findById(id);
		Timestamp nowTime = new Timestamp(System.currentTimeMillis());
		model.addAttribute("nowTime", nowTime);
		model.addAttribute("itemEntity", itemEntity);

		return "ItemDeletion";
	}
	/**
	 * 削除から一覧画面に戻る
	 */
	@PostMapping("ID{id}")
	public String deleteUpdate(@PathVariable Integer id, @ModelAttribute ItemEntity itemEntity) {
		itemEntity.setId(id);
		itemService.deleteUpdate(itemEntity);
		return "redirect:ItemList";
	}

}

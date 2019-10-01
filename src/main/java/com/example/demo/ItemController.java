package com.example.demo;

import java.sql.Timestamp;
import java.util.List;

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
	@Autowired
	CustomerInformationService customerInformationService;
	@Autowired
	StatusService statusService;
	@Autowired
	SearchService searchService;
	/**
	 * 一覧表示を表示
	 */
	@GetMapping(value = "ItemList")
	public String itemList(Model model, @PageableDefault(page = 0, value = 10)Pageable pageable) {
		Page<ItemCustomerStatusEntity> itemList = itemService.findAll(pageable);
		List<CustomerInformationEntity> pullDownList=customerInformationService.findAll();
		List<StatusCustomerEntity> StatusPullDownList=statusService.findAll();
		model.addAttribute("page", itemList);
		model.addAttribute("pullDownList", pullDownList);
		model.addAttribute("StatusPullDownList", StatusPullDownList);
		return "ItemList";
	}
	/**
	 * 検索フォーム
	 */
	@GetMapping("/search")
	public String Search(Model model, @PageableDefault(page = 0, value = 10 )Pageable pageable,String title,String customerName,String name) {
		Page<ItemCustomerStatusEntity> page = searchService.search(pageable,title,customerName,name);
		List<CustomerInformationEntity> pullDownList=customerInformationService.findAll();
		List<StatusCustomerEntity> StatusPullDownList=statusService.findAll();
		model.addAttribute("pullDownList", pullDownList);
		model.addAttribute("StatusPullDownList", StatusPullDownList);
		model.addAttribute("page", page);
		model.addAttribute("Search", title);
		return "ItemList";
	}
	/**
	 * 案件新規登録
	 */
	@PostMapping(value = "/ItemRegistration")
	public String itemRegistration(Model model,Integer customerId) {
		CustomerInformationEntity customerInformationEntity=customerInformationService.findByCustomerId(customerId);
		List<StatusCustomerEntity> statusCustomerEntity=statusService.findByCustmerId(customerId);
		model.addAttribute("customerInformationEntity", customerInformationEntity);
		model.addAttribute("statusCustomerEntity", statusCustomerEntity);
		model.addAttribute("customerId", customerId);
		return "ItemRegistration";
	}
	/**
	 * 新規登録の確認画面
	 */
	@RequestMapping(value ="/ItemRegistrationConfirmation", method = RequestMethod.POST)
	public String itemRegistration(ItemEntity itemEntity, Model model,Integer customerId, Integer statusId) {
		CustomerInformationEntity customerInformationEntity=customerInformationService.findByCustomerId(customerId);
		StatusEntity statusEntity=statusService.findByStatusId(statusId);
		Timestamp nowTime = new Timestamp(System.currentTimeMillis());
		model.addAttribute("itemEntity", itemEntity);
		model.addAttribute("customerInformationEntity", customerInformationEntity);
		model.addAttribute("statusEntity", statusEntity);
		model.addAttribute("customerId", customerId);
		model.addAttribute("statusId", statusId);
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
	 * 編集画面
	}*/
	@GetMapping("/ItemEdit/{id}/{customerId}/{statusId}")
	public String edit(@PathVariable Integer id, @PathVariable Integer customerId,@PathVariable Integer statusId,Model model) {
		CustomerInformationEntity customerInformationEntity=itemService.findByCustomerId(customerId);
		//StatusEntity statusEntity = itemService.findByStatusId(statusId);
		List<StatusCustomerEntity> statusEntity = itemService.findByCustmerId(customerId);
		ItemEntity itemEntity = itemService.findById(id);
		model.addAttribute("customerInformationEntity", customerInformationEntity);
		model.addAttribute("statusEntity", statusEntity);
		model.addAttribute("itemEntity", itemEntity);
		model.addAttribute("id", id);
		model.addAttribute("customerId", customerId);
		model.addAttribute("statusId", statusId);
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
	@RequestMapping(value = "/ItemEditConfirmation" ,method = RequestMethod.POST)
	public String editConfirmation(@Validated ItemEntity itemEntity, Model model,Integer id,Integer customerId,Integer statusId) {
		CustomerInformationEntity customerInformationEntity=itemService.findByCustomerId(customerId);
		StatusEntity statusEntity = itemService.findByStatusId(statusId);
		Timestamp nowTime = new Timestamp(System.currentTimeMillis());
		model.addAttribute("nowTime", nowTime);
		model.addAttribute("customerInformationEntity", customerInformationEntity);
		model.addAttribute("statusEntity", statusEntity);
		model.addAttribute("itemEntity", itemEntity);
		model.addAttribute("id", id);
		model.addAttribute("customerId", customerId);
		model.addAttribute("statusId", statusId);

		return "ItemEditConfirmation";
	}
	/**
	 * 編集確認からあぷでーと
	 */
	@PostMapping("IE")
	public String editUpdate(Integer id, ItemEntity itemEntity) {
		itemEntity.setId(id);
		itemService.editUpdate(itemEntity);
		return "redirect:ItemList";
	}
	/**
	 * 削除画面
	 */
	@GetMapping("/ItemDelete/{id}/{customerId}/{statusId}")
	public String delete(@PathVariable Integer id,@PathVariable Integer customerId,@PathVariable Integer statusId, Model model) {
		CustomerInformationEntity customerInformationEntity=itemService.findByCustomerId(customerId);
		StatusEntity statusEntity = itemService.findByStatusId(statusId);
		ItemEntity itemEntity = itemService.findById(id);
		Timestamp nowTime = new Timestamp(System.currentTimeMillis());
		model.addAttribute("nowTime", nowTime);
		model.addAttribute("customerInformationEntity", customerInformationEntity);
		model.addAttribute("statusEntity", statusEntity);

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

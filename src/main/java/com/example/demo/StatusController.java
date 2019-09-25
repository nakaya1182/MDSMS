package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StatusController {
	@Autowired
	StatusService statusService;
	@Autowired
	CustomerInformationService customerInformationService;

	//一覧表示
	@GetMapping("StatusList")
	public String StatusList(Model model) {
		List<StatusCustomerEntity> tableList=statusService.findAll();
		List<CustomerInformationEntity> pullDownList=customerInformationService.findAll();
		model.addAttribute("tableList", tableList);
		model.addAttribute("pullDownList", pullDownList);
	    return "StatusList";
	}
	//新規登録画面へ遷移
	@PostMapping("/StatusRegistration")
	public String StatusRegistration(Model model,Integer customerId) {
		CustomerInformationEntity customerInformationEntity=statusService.findById(customerId);
		StatusEntity statusEntity=null;
		model.addAttribute("customerInformationEntity", customerInformationEntity);
		model.addAttribute("statusEntity", statusEntity);
		model.addAttribute("customerId", customerId);
		return "StatusRegistration";
	}

	//登録確認画面へ遷移
	@PostMapping("/StatusRegistrationConfirmation")
	public String StatusRegistrationConfirmation(@ModelAttribute StatusEntity statusEntity,Model model,Integer customerId) {
		CustomerInformationEntity customerInformationEntity=statusService.findById(customerId);
		model.addAttribute("customerInformationEntity", customerInformationEntity);
		model.addAttribute("statusEntity", statusEntity);
		model.addAttribute("customerId", customerId);
		return "StatusRegistrationConfirmation";
	}

	//登録処理
	@PostMapping("/StatusInsert")
	public String StatusInsert(@ModelAttribute StatusEntity statusEntity,Model model) {

		statusService.Insert(statusEntity);

		return "redirect:StatusList";
	}

	//編集画面に遷移
	@GetMapping("/StatusEdit/{id}/{customerId}")
    public String edit(@PathVariable Integer id,@PathVariable Integer customerId, Model model) {
		CustomerInformationEntity customerInformationEntity=statusService.findById(customerId);
		StatusEntity statusEntity=statusService.findByIdEdit(id);
		model.addAttribute("customerInformationEntity", customerInformationEntity);
		model.addAttribute("statusEntity", statusEntity);
		return "StatusEdit";
	}

	//編集確認画面へ遷移
	@PostMapping("/StatusEditConfirmation")
	public String StatusEditConfirmation(@ModelAttribute StatusEntity statusEntity,Model model,Integer customerId) {
		CustomerInformationEntity customerInformationEntity=statusService.findById(customerId);
		model.addAttribute("customerInformationEntity", customerInformationEntity);
		model.addAttribute("statusEntity", statusEntity);
		model.addAttribute("customerId", customerId);
		return "StatusEditConfirmation";
	}

	//削除画面に遷移
	@GetMapping("/StatusDelete/{id}/{customerId}")
    public String StatusDelete(@PathVariable Integer id,@PathVariable Integer customerId, Model model) {
		CustomerInformationEntity customerInformationEntity=statusService.findById(customerId);
		StatusEntity statusEntity=statusService.findByIdEdit(id);
		model.addAttribute("customerInformationEntity", customerInformationEntity);
		model.addAttribute("statusEntity", statusEntity);
		return "StatusDelete";
	}

	//ソート画面へ遷移
	@PostMapping("/StatusSort")
	public String StatusSort(Model model,Integer customerId) {
		CustomerInformationEntity customerInformationEntity=statusService.findById(customerId);
		List<StatusEntity> statusEntity=statusService.findByCustomerId(customerId);
		model.addAttribute("customerInformationEntity", customerInformationEntity);
		model.addAttribute("statusEntity", statusEntity);
		model.addAttribute("customerId", customerId);
		int i=1;
		model.addAttribute("i", i);
		return "StatusSort";
	}

	//ソートリセットボタン処理
	@PostMapping("/StatusSortReset")
	public String StatusSortReset(Model model,Integer customerId) {
		System.out.println(customerId);
		statusService.SortReset(customerId);
		CustomerInformationEntity customerInformationEntity=statusService.findById(customerId);
		List<StatusEntity> statusEntity=statusService.findByCustomerId(customerId);
		model.addAttribute("customerInformationEntity", customerInformationEntity);
		model.addAttribute("statusEntity", statusEntity);
		model.addAttribute("customerId", customerId);
		int i=1;
		model.addAttribute("i", i);
		return "StatusSort";
	}

	//ソート処理
	@PostMapping("/StatusSorting")
	public String StatusSorting(Model model,Integer customerId,Integer id,Integer displayOrder,int i) {
		if(displayOrder == null) {
			statusService.Sorting(id,i);
			i++;
		}
		CustomerInformationEntity customerInformationEntity=statusService.findById(customerId);
		List<StatusEntity> statusEntity=statusService.findByCustomerId(customerId);
		model.addAttribute("customerInformationEntity", customerInformationEntity);
		model.addAttribute("statusEntity", statusEntity);
		model.addAttribute("customerId", customerId);
		model.addAttribute("i", i);
		return "StatusSort";
	}

}

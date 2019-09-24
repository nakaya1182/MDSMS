package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
		System.out.println(statusEntity);
		statusService.Insert(statusEntity);
		System.out.println("statusEntity");
		return "redirect:StatusList";
	}
}

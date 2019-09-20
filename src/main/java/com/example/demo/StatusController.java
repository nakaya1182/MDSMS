package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
	@GetMapping("/StatusRegistration/{pullString}")
	public String StatusRegistration(Model model,String pullString) {
		int pullId = Integer.parseInt(pullString);
		CustomerInformationEntity StatusRegistrationList=statusService.findById(pullId);
		System.out.println("pullId");
		System.out.println(pullId);
		model.addAttribute("StatusRegistrationList", StatusRegistrationList);
		return "StatusRegistration";
	}
}

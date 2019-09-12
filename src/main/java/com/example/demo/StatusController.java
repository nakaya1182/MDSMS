package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
	public String StatusList(Model model, @PageableDefault(page = 0, size = 10,sort= {"customerId"})Pageable pageable) {
		Page<StatusEntity> page=statusService.getList(pageable);
		//Page<CustomerInformationEntity> customer = customerInformationService.findAll(pageable);

		model.addAttribute("page", page);
		//model.addAttribute("customer", customer);
	    return "StatusList";
	}
}

package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerInformationController {
	@Autowired
	CustomerInformationService customerInformationService;

	//一覧表示
	@GetMapping("CustomerInformationList")
	public String setId(Model model, @PageableDefault(page = 0, size = 10)Pageable pageable) {
		Page<CustomerInformationEntity> page=customerInformationService.getList(pageable);
		model.addAttribute("page", page);
	    return "CustomerInformationList";
	}
}

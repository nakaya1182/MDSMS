package com.example.demo;

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

@Controller
public class CustomerInformationController {
	@Autowired
	CustomerInformationService customerInformationService;

	//一覧表示
	@GetMapping("CustomerInformationList")
	public String setList(Model model, @PageableDefault(page = 0, size = 10)Pageable pageable) {
		Page<CustomerInformationEntity> page=customerInformationService.findAll(pageable);
		model.addAttribute("page", page);
	    return "CustomerInformationList";
	}
	//新規登録画面遷移
	@GetMapping("CustomerInformationRegistration")
	public String setRegistration(Model model) {
	    return "CustomerInformationRegistration";
	}
	//新規登録確認画面遷移
	@PostMapping("CustomerInformationRegistrationConfirmation")
	public String setRegistrationConfirmation(Model model,CustomerInformationEntity customerInformationEntity) {
		model.addAttribute("customerInformationEntity", customerInformationEntity);
		return "CustomerInformationRegistrationConfirmation";
	}
	//確認からの値をインサート
	@PostMapping("/CustomerInsert")
	public String Insert(Model model,@Validated CustomerInformationEntity customerInformationEntity) {
		customerInformationService.insert(customerInformationEntity);
		return "redirect:CustomerInformationList";
	}
	//編集画面に移動
	@GetMapping("/CustomerInformationEdit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
		CustomerInformationEntity customerInformationEntity = customerInformationService.findById(id);
	    model.addAttribute("customerInformationEntity", customerInformationEntity);
	    return "CustomerInformationEdit";
	}
	//編集確認
	@PostMapping("/CustomerInformationEditConfirmation")
		public String editConfirmation(@ModelAttribute CustomerInformationEntity customerInformationEntity,Model model) {
		model.addAttribute("customerInformationEntity", customerInformationEntity);
		return "CustomerInformationEditConfirmation";
	}
	//削除画面に移動
	@GetMapping("/CustomerInformationDelete/{id}")
	 public String delete(@PathVariable Integer id, Model model) {
		CustomerInformationEntity customerInformationEntity = customerInformationService.findById(id);
	    model.addAttribute("customerInformationEntity", customerInformationEntity);
	    return "CustomerInformationDelete";
	}

}

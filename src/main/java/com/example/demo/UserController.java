package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class UserController {

	@Autowired
	UserService userService;


	@RequestMapping(value = "UserList", method=RequestMethod.GET)
	public String UserList(Model model, @PageableDefault(page = 0, value = 10)Pageable pageable) {
		Page<UserEntity> UserList = userService.selectAll(pageable);
		model.addAttribute("page", UserList);
		model.addAttribute("AddList", UserList.getContent());
		return "UserList";
}
}
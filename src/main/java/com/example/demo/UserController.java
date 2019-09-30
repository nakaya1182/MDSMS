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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class UserController {

	@Autowired
	UserService userService;



	/**
	 * 一覧表示を表示
	 */
	@RequestMapping(value = "UserList", method=RequestMethod.GET)
	public String userList(Model model, @PageableDefault(page = 0, value = 10)Pageable pageable) {
		Page<UserEntity> userList = userService.selectAll(pageable);
		model.addAttribute("page", userList);
		model.addAttribute("UserList", userList.getContent());
		return "UserList";
}

	/**
	 * ユーザー新規登録
	 * @param userRequest リクエストデータ
	 * @param model Model
	 */
	@GetMapping(value = "/UserRegistration")
	public String userRegistration(Model model) {
		return "UserRegistration";
}
	/**
	 * 新規登録の確認画面
	 */
	@RequestMapping(value ="/UserRegistrationConfirmation", method = RequestMethod.POST)
	public String userRegistration(@ModelAttribute @Validated UserEntity userEntity, Model model) {
		return "UserRegistrationConfirmation";
	}
	/**
	 * 新規登録から一覧画面に戻る
	 */
	@PostMapping("/UserList")
	public String create(@ModelAttribute UserEntity userEntity, Model model) {
		userService.create(userEntity);
		return "redirect:UserList";
	}
	/**
	 * ユーザー編集画面
	}*/
	@GetMapping("/{employee_number}/UserEdit")
	public String edit(@PathVariable Integer employee_number, Model model) {
		UserEntity userEntity = userService.findById(employee_number);
		model.addAttribute("userEntity", userEntity);
		return "UserEdit";
	}
	/**
	 * 編集の確認画面
	}*/
	@RequestMapping(value = "{employee_number}/UserEditConfirmation" ,method = RequestMethod.POST)
	public String editConfirmation(@ModelAttribute @Validated UserEntity userEntity, Model model) {
		return "UserEditConfirmation";
	}
	/**
	 * 編集確認から一覧画面に戻る
	 */
	@PostMapping("UE{employee_number}")
	public String editUpdate(@PathVariable Integer employee_number, @ModelAttribute UserEntity userEntity) {
		userEntity.setId(employee_number);
		userService.editUpdate(userEntity);
		return "redirect:UserList";
	}
	/**
	 * ユーザー削除画面
	 */
	@GetMapping("/{employee_number}/UserDelete")
	public String delete(@PathVariable Integer employee_number, Model model) {
		UserEntity userEntity = userService.findById(employee_number);
		model.addAttribute("userEntity", userEntity);
		return "UserDelete";
	}
	/**
	 * 削除から一覧画面に戻る
	 */
	@PostMapping("UD{employee_number}")
	public String deleteUpdate(@PathVariable Integer employee_number, @ModelAttribute UserEntity userEntity) {
		userEntity.setId(employee_number);
		userService.deleteUpdate(userEntity);
		return "redirect:UserList";
	}
	@GetMapping("/addback")
	public String addBack(Model model) {
		return "redirect:UserList";
	}
	/**
	 * 初期画面
	 */
	@RequestMapping(value="login")
	String loginForm() {
		return "login";
	}

	@RequestMapping(value="/test")
	String login() {
		return "redirect:ItemList";
	}
	@RequestMapping(value="/logout")
	String logout() {
		return "redirect:login";
	}

}
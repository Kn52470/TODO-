package com.example.demo.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.form.ItemForm;
import com.example.demo.model.Item;
import com.example.demo.model.User;
import com.example.demo.service.ItemService;
import com.example.demo.service.UserService;

@Controller
public class ItemController {

	@Autowired
	private UserService userService;

	@Autowired
	private ItemService itemService;

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping("/register")
	public String register(Model model, @ModelAttribute ItemForm itemForm) {

		List<User> users = userService.getNames();
		model.addAttribute("users", users);

		model.addAttribute("itemForm", itemForm);

		return "register";
	}

	@PostMapping("/register")
	public String getItem(@ModelAttribute @Validated ItemForm itemForm, BindingResult result, Model model,
			@RequestParam(name = "complete", required = false) String checkboxValue) {

		Calendar calendar = Calendar.getInstance();
		Date currentDate = calendar.getTime();

		if (result.hasErrors()) {
			// バリデーションエラーがある場合の処理
			return register(model, itemForm);
		}

		Item items = new Item();
		items.setId(itemForm.getId());
		items.setUserId(itemForm.getUserId());
		items.setItemName(itemForm.getItemName());
		items.setExpireDate(itemForm.getExpireDate());

		if (checkboxValue != null && checkboxValue.equals("true")) {
			// チェックボックスが選択されている場合の処理
			items.setFinishedDate(currentDate);
		}

		items.setRegistrationDate(currentDate);

		//登録
		itemService.insertTodo(items);

		return "redirect:/list";
	}

	@GetMapping("/edit")
	public String getEdit(@RequestParam int id, @ModelAttribute ItemForm itemForm, Model model) {

		List<User> users = userService.getNames();
		model.addAttribute("users", users);

		Item items = userService.getUserOne(id);

		itemForm = modelMapper.map(items, ItemForm.class);

		model.addAttribute("itemForm", itemForm);

		return "/correction";
	}

	@PostMapping("/correction")
	public String correction(@ModelAttribute @Validated ItemForm itemForm, BindingResult result, Model model,
			@RequestParam(name = "complete", required = false) String checkboxValue) {

		Calendar calendar = Calendar.getInstance();
		Date currentDate = calendar.getTime();

		if (result.hasErrors()) {
			// バリデーションエラーがある場合の処理
			return "/correction";
		}

		Item items = new Item();
		items.setId(itemForm.getId());
		items.setUserId(itemForm.getUserId());
		items.setItemName(itemForm.getItemName());
		items.setExpireDate(itemForm.getExpireDate());

		if (checkboxValue != null && checkboxValue.equals("true")) {
			// チェックボックスが選択されている場合の処理
			items.setFinishedDate(currentDate);
		}

		items.setRegistrationDate(currentDate);

		//修正
		itemService.update(items);

		return "redirect:/list";
	}

	@PostMapping("/delete")
	public String getDelete(@RequestParam int id) {

		itemService.deleteOne(id);

		return "redirect:/list";
	}

	@PostMapping("/complete")
	public String getComplete(@ModelAttribute ItemForm itemForm, @RequestParam int id) {

		itemService.update(itemService.finished(id));

		return "redirect:/list";
	}
}

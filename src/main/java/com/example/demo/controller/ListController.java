package com.example.demo.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.form.UserListForm;
import com.example.demo.model.Item;
import com.example.demo.model.User;
import com.example.demo.service.ItemService;
import com.example.demo.service.UserService;

@Controller
public class ListController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private ItemService itemService;
	
	//一覧画面
			@GetMapping("/list")
			public String getList(@ModelAttribute UserListForm form, Model model) {
				
				Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			    String user = authentication.getName();
			    User name = userService.getLoginUser(user);
			    
			    model.addAttribute("name", name);
			    
			    Item items = modelMapper.map(form, Item.class);
			    
			    List<Item> userList = itemService.getItems(items);
			    
			    model.addAttribute("userList", userList);
			    
				return "list";
			}
}

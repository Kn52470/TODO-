package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Item;
import com.example.demo.model.User;

public interface UserService {

	//ログインユーザー情報取得
		public User getLoginUser(String user);
		
	
	//ユーザ情報1件取得
		public Item getUserOne(int id);
	
	
	
	//ユーザ名取得
		public List<User> getNames();

}

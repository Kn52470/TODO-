package com.example.demo.service.impl; 

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Item;
import com.example.demo.model.User;
import com.example.demo.repository.ItemsMapper;
import com.example.demo.repository.UsersMapper;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UsersMapper usersMapper;
	
	@Autowired
	private ItemsMapper itemsMapper;
	
	//ログインユーザー情報取得
		@Override
		public User getLoginUser(String user) {
			
			return usersMapper.findByUser(user);
		}
		
	//ユーザ情報1件取得
		@Override
		public Item getUserOne(int id) {
			
			return itemsMapper.findOne(id);
		}
	
	
		
	//ユーザ名取得
		@Override
		public List<User> getNames() {
			
			return usersMapper.findUserName();
		}
}


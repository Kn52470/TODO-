package com.example.demo.service.impl;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.service.UserService;


@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String user) throws UsernameNotFoundException {
		
		
		//ユーザー情報取得
		com.example.demo.model.User loginUser = userService.getLoginUser(user);
		
		//ユーザーが存在しない場合
		if(loginUser == null) {
			throw new UsernameNotFoundException("user not found");
		}
				
		//UeserDetails生成
		UserDetails userDetails = (UserDetails) new User(loginUser.getUser(),loginUser.getPass(),Collections.emptyList());

			return userDetails;
	
	}
}
package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.User;

@Mapper
public interface UsersMapper {
		
		//ログインユーザー取得
		public User findByUser(String user);
		
		//ユーザ名取得
		public List<User> findUserName();
}


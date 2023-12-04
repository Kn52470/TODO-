package com.example.demo.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Item;
import com.example.demo.repository.ItemsMapper;
import com.example.demo.service.ItemService;
import com.example.demo.service.UserService;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private UserService userService;
	
	@Autowired
	private ItemsMapper itemsMapper;

	//項目追加
	@Override
	public int insertTodo(Item items) {

		return itemsMapper.insertTodo(items);
	}

	//修正
	@Override
	public void update(Item items) {

		itemsMapper.correction(items);

	}

	//ユーザ情報複数取得
	@Override
	public List<Item> getItems(Item items) {

		return itemsMapper.findAll(items);
	}

	//項目削除
	@Override
	public void deleteOne(int id) {

		itemsMapper.deleteItem(id);
	}

	public Item finished(int id) {
		
		Calendar calendar = Calendar.getInstance();
		Date currentDate = calendar.getTime();
		
		 Item items = userService.getUserOne(id);
		 
		 items.setFinishedDate(currentDate);
		 
		 return items;
	}
}

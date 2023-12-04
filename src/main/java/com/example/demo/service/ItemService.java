package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Item;

public interface ItemService {

	//項目追加
	public int insertTodo(Item items);

	//修正
	public void update(Item items);

	//項目削除
	public void deleteOne(int id);

	//ユーザ情報複数取得
	public List<Item> getItems(Item items);
	
	public Item finished(int id);

}

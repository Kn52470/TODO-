package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.model.Item;

@Mapper
public interface ItemsMapper {

	//項目追加
	public int insertTodo(Item items);
	
	//ユーザ情報1件取得
	public Item findOne(int id);

	//ユーザ情報複数取得
	public List<Item> findAll(Item items);
	
	//修正
	public void correction(@Param("item") Item items);
	
	//項目削除
	public void deleteItem(int id);
}

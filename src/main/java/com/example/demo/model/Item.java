package com.example.demo.model;

import java.util.Date;

import lombok.Data;

@Data
public class Item {

	private String user;
	
	private int id;
	
	private int userId;
	
	private String itemName;
	
	private Date registrationDate;
	
	private Date expireDate;
	
	private Date finishedDate;
	
	private boolean isDeleted;
	
	private Date createDatetime;
	
	private Date updateDatetime;
}

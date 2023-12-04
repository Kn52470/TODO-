package com.example.demo.form;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ItemForm {

	private String user;
	
	private int id;
	
	@NotNull
	private Integer userId;
	
	@NotNull
	private String itemName;
	
	private Date registrationDate;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@NotNull
	private Date expireDate;
	
	private Date finishedDate;
	
	private boolean isDeleted;
	
	private Date createDatetime;
	
	private Date updateDatetime;
	
	@DateTimeFormat
	private Date currentDate;
	
	private String complete;
}

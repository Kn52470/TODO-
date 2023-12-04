package com.example.demo.model;

import lombok.Data;

@Data
public class User {

	private int id;
	private String user;
	private String pass;
	private String familyname;
	private String firstname;
	private String isadmin;
	private String isdeleted;
	private String createdatetime;
	private String updatedatetime;
}

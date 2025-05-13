package com.yi_college.bookmanager.model;

import lombok.Data;

@Data

public class Users {

	private Integer id;
	private String username;
	private String password;
	private String role;
	private boolean enabled;

}

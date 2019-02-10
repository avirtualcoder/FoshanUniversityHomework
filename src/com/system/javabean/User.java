package com.system.javabean;

public class User {
	private String username;
	private String password;
	private String type;
	private int id;

	public String getName() {
		return username;
	}

	public String getPass() {
		return password;
	}

	public String getType() {
		return type;
	}

	public int getId() {
		return id;
	}

	public void setPass(String password) {
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setId(int id) {
		this.id = id;

	}

	public void setType(String type) {
		this.type = type;

	}

}

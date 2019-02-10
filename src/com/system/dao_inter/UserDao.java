package com.system.dao_inter;

import com.system.javabean.User;

public interface UserDao {
	boolean Login(String username, String password);

	boolean UpdatePass(String name, String oldpass, String newpass);

	String getType(String username);

	User getUser(String username);
}

package com.system.util;

import com.system.javabean.User;

public class Session {
	private static User user;

	public static User getUser() {
		return user;
	}

	public static void setUser(User user) {
		Session.user = user;
	}
}

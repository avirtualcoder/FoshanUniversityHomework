package com.system.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.system.dao_inter.UserDao;
import com.system.javabean.User;
import com.system.util.Jdbc_connect;

public class UserImpl implements UserDao {

	public boolean Login(String username, String password) {

		boolean flag = false;
		String TruePass = null;

		String sql = "select password from user where username=?";
		String[] info = { username };

		Jdbc_connect db = new Jdbc_connect();
		ResultSet rs = db.executeQuery(sql, info);

		try {
			while (rs.next()) {
				TruePass = rs.getString("password");
			}
		} catch (SQLException e) {
			System.out.print("密码结果集异常");
			e.printStackTrace();
		} finally {
			db.close();
		}

		// System.out.println(TruePass + " " + password);
		if (TruePass.equals(password)) {
			flag = true;
			System.out.println("密码正确");
		} else if (TruePass == null) {
			System.out.println("用户不存在");
		} else {
			System.out.println("密码错误");
		}

		return flag;
	}

	public boolean UpdatePass(String name, String oldpass, String newpass) {
		boolean flag = false;
		String realpass = null;

		String sql = "select password from user where username=?";
		String[] info = { name };

		Jdbc_connect db = new Jdbc_connect();
		ResultSet rs = db.executeQuery(sql, info);
		try {
			while (rs.next()) {
				realpass = rs.getString("password");
			}
			System.out.println("正确密码为 " + realpass + "   新密码为" + oldpass);
		} catch (SQLException e) {
			System.out.println("学生信息结果集出错");
			e.printStackTrace();
		}

		if (oldpass.equals(realpass)) {
			System.out.println("密码正确");

			sql = "update user set password=? where username=?";
			String[] info1 = { newpass, name };
			int row = db.executeUpdate(sql, info1);
			if (row > 0)
				flag = true;
		}
		return flag;
	}

	public String getType(String username) {
		String type = null;
		Jdbc_connect db = new Jdbc_connect();

		String sql = "select type from user where username=?";
		String[] info = { username };

		ResultSet rs = db.executeQuery(sql, info);

		try {
			while (rs.next()) {
				type = rs.getString("type");
			}
		} catch (SQLException e) {
			System.out.println("身份结果集");
			e.printStackTrace();
		} finally {
			db.close();
		}

		return type;
	}

	public User getUser(String username) {
		User user = new User();
		Jdbc_connect db = new Jdbc_connect();

		String sql = "select * from user where username=?";
		String[] info = { username };

		ResultSet rs = db.executeQuery(sql, info);

		try {
			while (rs.next()) {
				user.setType(rs.getString("type"));
				user.setId(rs.getInt("id"));
				user.setUsername(username);
				user.setPass(rs.getString("password"));
			}
		} catch (SQLException e) {
			System.out.println("身份结果集出错");
			e.printStackTrace();
		} finally {
			db.close();
		}
		return user;
	}
}

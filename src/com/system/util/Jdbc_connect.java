package com.system.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Jdbc_connect {
	private Connection con;
	private String user = "root";
	private String password = null;
	private static String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/student_system";
	private Connection ct = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.print("加载driver失败");
			e.printStackTrace();
		}
	}

	public Connection get_connect() {
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			System.out.println("创建数据库连接失败！");
			con = null;
			e.printStackTrace();
		}
		return con;
	}

	public void close() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			System.out.println("关闭数据库连接失败！");
		}

	}

	public ResultSet executeQuery(String sql, String[] info) {
		ct = get_connect();
		try {
			ps = ct.prepareStatement(sql);
		} catch (SQLException e) {
			System.out.println("创建此sql的声明失败");
			e.printStackTrace();
		}

		if (info != null) {
			for (int i = 0; i < info.length; i++) {
				try {
					ps.setString(i + 1, info[i]);
				} catch (SQLException e) {
					System.out.printf("占位符设置sql参数失败");
					e.printStackTrace();
				}
			}
		}
		try {
			rs = ps.executeQuery();
		} catch (SQLException e) {
			System.out.println("发送执行sql语句失败");
			e.printStackTrace();
		}

		return rs;
	}

	public int executeUpdate(String sql, String[] info) {
		ct = get_connect();
		int row = 0;
		try {
			ps = ct.prepareStatement(sql);
		} catch (SQLException e) {
			System.out.printf("创建sal声明失败");
			e.printStackTrace();
		}
		if (info != null) {
			for (int i = 0; i < info.length; i++) {
				try {
					ps.setString(i + 1, info[i]);
				} catch (SQLException e) {
					System.out.println("占位参数设置失败");
					e.printStackTrace();
				}
			}
		}
		try {
			row = ps.executeUpdate();
			if (row > 0) {
				System.out.print("更新成功，更新了" + row + "条记录");
			} else {
				System.out.println("更新失败！");
			}
			return row;
		} catch (SQLException e) {
			System.out.println("更新异常");
			e.printStackTrace();
		}
		return row;
	}
}

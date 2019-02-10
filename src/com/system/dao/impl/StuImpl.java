package com.system.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.system.dao_inter.StuDao;
import com.system.javabean.Student;
import com.system.util.Jdbc_connect;

public class StuImpl implements StuDao {
	public Student getStudent(String Sno) {
		Student stu = new Student();

		String sql = "select * from student where Sno=?";
		String[] info = { Sno };

		Jdbc_connect db = new Jdbc_connect();
		ResultSet rs = db.executeQuery(sql, info);
		try {
			while (rs.next()) {
				stu.setSno(rs.getString("Sno"));
				stu.setSname(rs.getString("Sname"));
				stu.setSsex(rs.getString("Ssex"));
				stu.setSage(rs.getInt("Sage"));
				stu.setClname(rs.getString("Clname"));
				stu.setSbirth(rs.getString("Sbirth"));
				stu.setScredit(rs.getInt("Scredit"));
			}
		} catch (SQLException e) {
			System.out.println("学生信息结果集出错");
			e.printStackTrace();
		}

		db.close();
		return stu;

	}

	public Object[][] findBySno(String Sno) {
		System.out.println(Sno);
		List<Student> stu_list = new ArrayList<Student>();// 实例一个学生为元素的列表类

		String sql = "select * from student where Sno=?";
		String[] info = { Sno };

		Jdbc_connect db = new Jdbc_connect();
		ResultSet rs = db.executeQuery(sql, info);
		int count = 0;
		try {
			while (rs.next()) {
				count++;
			}
		} catch (SQLException e) {
			System.out.println("学生查询结果统计出错");
			e.printStackTrace();
		}

		Object[][] stu_obj = new Object[count][7];
		rs = db.executeQuery(sql, info);

		try {
			while (rs.next()) {
				count = 0;
				stu_obj[count][0] = rs.getString("Sno");
				stu_obj[count][1] = rs.getString("Sname");
				stu_obj[count][2] = rs.getString("Ssex");
				stu_obj[count][3] = rs.getInt("Sage");
				stu_obj[count][4] = rs.getString("Clname");
				stu_obj[count][5] = rs.getString("Sbirth");
				stu_obj[count][6] = rs.getInt("Scredit");

				// Student stu = new Student();
				// stu.setSno(Sno);
				// stu.setSname(rs.getString("Sname"));
				// stu.setSsex(rs.getString("Ssex"));
				// stu.setSage(rs.getInt("Sage"));
				// stu.setClname(rs.getString("Clname"));
				// stu.setSbirth(rs.getString("Sbirth"));
				// stu.setScredit(rs.getInt("Scredit"));
				// stu_list.add(stu);
			}
			// for (Object[] pri : stu_obj) {// 左边变量迭代传进右边列表
			// System.out.println(pri);
			// }
		} catch (SQLException e) {
			System.out.println("学生查询结果集出错");
			e.printStackTrace();
		}

		return stu_obj;
	}

}

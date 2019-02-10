package com.system.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.system.dao_inter.StuCourDao;
import com.system.javabean.Stu_Cour;
import com.system.util.Jdbc_connect;

public class StuCourImpl implements StuCourDao {

	public Stu_Cour find_grade_by_Sno_Cno(String Sno, String Cno) {
		Stu_Cour sc = new Stu_Cour();
		Jdbc_connect db = new Jdbc_connect();
		String sql = "select * from stu_cour where Sno = ? and Cno=?";
		String[] info = { Sno, Cno };
		ResultSet rs = db.executeQuery(sql, info);
		rs = db.executeQuery(sql, info);

		try {
			while (rs.next()) {
				sc.setSno(rs.getString("Sno"));
				sc.setCno(rs.getString("Cno"));
				sc.setGrade(rs.getFloat("grade"));

			}
		} catch (SQLException e) {
			System.out.println("学生查询成绩结果集出错");
			e.printStackTrace();
		}
		return sc;
	}

	public Object[][] find_grade_by_Sno(String Sno) {
		Object[][] sc_obj;
		Jdbc_connect db = new Jdbc_connect();
		String sql = "select * from stu_cour where Sno = ?";
		String[] info = { Sno };
		ResultSet rs = db.executeQuery(sql, info);
		int count = 0;
		try {
			while (rs.next()) {
				count++;
			}
		} catch (SQLException e) {
			System.out.println("学生查询成绩结果集出错");
			e.printStackTrace();
		}
		sc_obj = new Object[count][3];
		sql = "SELECT stu_cour.`Cno` ,Cname,grade FROM course,stu_cour WHERE course.`Cno`=stu_cour.`Cno` AND Sno=?";
		rs = db.executeQuery(sql, info);
		count = 0;

		try {
			while (rs.next()) {
				sc_obj[count][0] = rs.getString("Cno");
				sc_obj[count][1] = rs.getString("Cname");
				sc_obj[count][2] = rs.getString("grade");
				count++;
			}
		} catch (SQLException e) {
			System.out.println("学生查询成绩结果集出错");
			e.printStackTrace();
		}
		return sc_obj;
	}

	public Object[][] find_grade_by_Cno(String Cname) {
		Object[][] sc_obj;
		Jdbc_connect db = new Jdbc_connect();
		String sql = "SELECT  * FROM stu_cour WHERE Cno IN (SELECT Cno FROM course WHERE Cname=?)";
		String[] info = { Cname };
		ResultSet rs = db.executeQuery(sql, info);
		int count = 0;
		try {
			while (rs.next()) {
				count++;
			}
		} catch (SQLException e) {
			System.out.println("学生查询成绩结果集出错");
			e.printStackTrace();
		}
		sc_obj = new Object[count][3];

		rs = db.executeQuery(sql, info);
		count = 0;

		try {
			while (rs.next()) {
				sc_obj[count][0] = rs.getString("Sno");
				sc_obj[count][1] = rs.getString("Cno");
				sc_obj[count][2] = rs.getString("grade");
				count++;
			}
		} catch (SQLException e) {
			System.out.println("学生查询成绩结果集出错");
			e.printStackTrace();
		}
		return sc_obj;
	}

	public Object[][] find_grade_by_class(String Clname) {
		Object[][] sc_obj;
		Jdbc_connect db = new Jdbc_connect();
		String sql = " SELECT Clname,Cname,AVG(grade) AS 'aver',MAX(grade)  AS 'max',MIN(grade) AS 'min',SUM(CASE WHEN grade>=60 THEN 1 ELSE 0 END)/COUNT(*)   'pass'"
				+ " FROM stu_cour,student,course"
				+ " WHERE stu_cour.`Sno`=student.`Sno` AND stu_cour.`Cno`=course.`Cno` AND Clname=?"
				+ " GROUP BY stu_cour.`Cno`";
		String[] info = { Clname };
		ResultSet rs = db.executeQuery(sql, info);
		int count = 0;
		try {
			while (rs.next()) {
				count++;
			}
		} catch (SQLException e) {
			System.out.println("班级查询成绩集语句执行出错");
			e.printStackTrace();
		}
		System.out.println(count);
		sc_obj = new Object[count][6];
		count = 0;
		rs = db.executeQuery(sql, info);
		try {
			while (rs.next()) {
				System.out.println(rs.getMetaData().getColumnName(count + 1));
				sc_obj[count][0] = rs.getString("Clname");
				sc_obj[count][1] = rs.getString("Cname");
				sc_obj[count][2] = rs.getDouble("aver");
				sc_obj[count][3] = rs.getDouble("max");
				sc_obj[count][4] = rs.getDouble("min");
				sc_obj[count][5] = rs.getDouble("pass");
				count++;
			}
		} catch (SQLException e) {
			System.out.println("班级查询成绩集语句执行出错");
			e.printStackTrace();
		}
		db.close();

		return sc_obj;
	}

	public Object[][] find_grade_by_course(String Cname) {
		Object[][] sc_obj;
		Jdbc_connect db = new Jdbc_connect();
		String sql = "SELECT  Cname,Clname,AVG(grade) AS 'aver',MAX(grade)  AS 'max',MIN(grade) AS 'min',SUM(CASE WHEN grade>=60 THEN 1 ELSE 0 END)/COUNT(*)   'pass' FROM stu_cour,student,course WHERE stu_cour.`Sno`=student.`Sno` AND stu_cour.`Cno`=course.`Cno`   AND course.`Cname`=? GROUP BY student.`Clname`";
		String[] info = { Cname };
		ResultSet rs = db.executeQuery(sql, info);
		int count = 0;
		try {
			while (rs.next()) {
				count++;
			}
		} catch (SQLException e) {
			System.out.println("课程查询成绩集语句执行出错");
			e.printStackTrace();
		}
		System.out.println(count);
		sc_obj = new Object[count][6];
		count = 0;
		rs = db.executeQuery(sql, info);
		try {
			while (rs.next()) {
				System.out.println(rs.getMetaData().getColumnName(count + 1));
				sc_obj[count][0] = rs.getString("Clname");
				sc_obj[count][1] = rs.getString("Cname");
				sc_obj[count][2] = rs.getDouble("aver");
				sc_obj[count][3] = rs.getDouble("max");
				sc_obj[count][4] = rs.getDouble("min");
				sc_obj[count][5] = rs.getDouble("pass");
				count++;
			}
		} catch (SQLException e) {
			System.out.println("课程查询成绩集语句执行出错");
			e.printStackTrace();
		}
		db.close();

		return sc_obj;
	}

	public Object[][] find_grade_by_class_course(String Clname, String Cname) {
		Object[][] sc_obj;
		Jdbc_connect db = new Jdbc_connect();
		System.out.println(Clname + Cname);
		String sql = "  SELECT Clname,Cname,AVG(grade) 'aver',MAX(grade)  AS 'max',MIN(grade) AS 'min',SUM(CASE WHEN grade>=60 THEN 1 ELSE 0 END)/COUNT(*)   'pass' "
				+ " FROM stu_cour,student,course"
				+ " WHERE stu_cour.`Sno`=student.`Sno` AND stu_cour.`Cno`=course.`Cno` AND Clname=?  AND course.`Cname`=?"
				+ " GROUP BY stu_cour.`Cno`";
		String[] info = { Clname, Cname };
		ResultSet rs = db.executeQuery(sql, info);
		int count = 0;
		try {
			while (rs.next()) {
				count++;
			}
		} catch (SQLException e) {
			System.out.println("班级查询成绩集语句执行出错");
			e.printStackTrace();
		}
		System.out.println(count);
		sc_obj = new Object[count][6];
		count = 0;
		rs = db.executeQuery(sql, info);
		try {
			while (rs.next()) {
				System.out.println(rs.getMetaData().getColumnName(count + 1));
				sc_obj[count][0] = rs.getString("Clname");
				sc_obj[count][1] = rs.getString("Cname");
				sc_obj[count][2] = rs.getDouble("aver");
				sc_obj[count][3] = rs.getDouble("max");
				sc_obj[count][4] = rs.getDouble("min");
				sc_obj[count][5] = rs.getDouble("pass");
				count++;
			}
		} catch (SQLException e) {
			System.out.println("班级课程查询成绩集语句执行出错");
			e.printStackTrace();
		}
		db.close();

		return sc_obj;
	}

	public void updateScore(Stu_Cour score) {
		Jdbc_connect db = new Jdbc_connect();
		String sql = "update stu_cour set grade='" + score.getGrade() + "' where Sno = ? and Cno=?";
		String[] info = { score.getSno(), score.getCno() };
		int row = db.executeUpdate(sql, info);

	}

	public void deleteScore(String sno, String cno) {

	}
}

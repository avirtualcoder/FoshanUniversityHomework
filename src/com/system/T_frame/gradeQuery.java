package com.system.T_frame;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.system.F_frame.Frame;
import com.system.dao.impl.StuCourImpl;
import com.system.javabean.Student;

public class gradeQuery {
	public gradeQuery(Student student) {
		Frame f = new Frame("课程成绩查询", 600, 300, 500, 250);
		System.out.println("跳转到课程查询界面--学生");
		StuCourImpl scImpl = new StuCourImpl();
		Object[][] stu_cour_obj = scImpl.find_grade_by_Sno(student.getSno());
		Object[] columnTitle = { "课号", "课名", "成绩" };
		JTable grade = new JTable(stu_cour_obj, columnTitle);
		JScrollPane jsp = new JScrollPane(grade);
		jsp.setBounds(50, 20, 400, 100);
		f.add(jsp);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}

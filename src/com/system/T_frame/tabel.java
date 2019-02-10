package com.system.T_frame;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.system.dao.impl.StuCourImpl;

public class tabel {
	public tabel(String clname) {
		StuCourImpl stu_cour = new StuCourImpl();
		Object[][] stu_cour_obj = stu_cour.find_grade_by_class(clname);
		Object[] columnTitle = { "Clname", "Cno", "平均分", "最高分", "最低分", "及格率" };
		JTable grade = new JTable(stu_cour_obj, columnTitle);
		JScrollPane jsp = new JScrollPane(grade);
		jsp.setBounds(50, 200, 600, 100);

	}
}

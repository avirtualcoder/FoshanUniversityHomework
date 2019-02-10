package com.system.dao_inter;

import com.system.javabean.Stu_Cour;

public interface StuCourDao {
	public Object[][] find_grade_by_Sno(String Sno);

	public Stu_Cour find_grade_by_Sno_Cno(String Sno, String Cno);

	public Object[][] find_grade_by_Cno(String Cname);

	public Object[][] find_grade_by_class(String Clname);

	public Object[][] find_grade_by_course(String Cname);

	public Object[][] find_grade_by_class_course(String Clname, String Cname);
}

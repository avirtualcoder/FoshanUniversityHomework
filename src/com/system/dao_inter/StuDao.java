package com.system.dao_inter;

import com.system.javabean.Student;

public interface StuDao {
	public Student getStudent(String Sno);

	public Object[][] findBySno(String Sno);
}

package com.system.javabean;

public class Course {
	private String Cno;
	private String Cname;
	private float grade;

	public void setCno(String Cno) {
		this.Cno = Cno;
	}

	public void setCname(String Cname) {
		this.Cname = Cname;
	}

	public void setGrade(float grade) {
		this.grade = grade;
	}

	public String getCno() {
		return Cno;
	}

	public String getCname() {
		return Cname;
	}

	public float getGrade() {
		return grade;
	}
}

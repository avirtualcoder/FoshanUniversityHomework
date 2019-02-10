package com.system.T_frame;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.system.F_frame.Frame;
import com.system.dao.impl.StuImpl;
import com.system.javabean.Student;

public class InfoQuery extends JFrame {
	private JTable stu_info;

	public InfoQuery(Student student) {
		StuImpl stuimpl = new StuImpl();
		Font font = new Font("宋体", Font.BOLD, 17);
		System.out.println("跳转个人信息页面");
		Frame f = new Frame("个人信息", 600, 300, 900, 300);
		Object[][] stu_obj = stuimpl.findBySno(student.getSno());// 得到二维数组，数据库数据
		Object[] columnTitle = { "学号", "姓名", "性别", "年龄", "班级", "出生日期", "学分" };
		stu_info = new JTable(stu_obj, columnTitle);
		stu_info.setFont(font);
		JScrollPane jsp = new JScrollPane(stu_info);
		jsp.setBounds(50, 100, 800, 100);
		f.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		f.add(jsp);// 将数组放进JScrollPane中并在窗口显示
		// f.pack();// 窗口自适应组件大小

	}
}

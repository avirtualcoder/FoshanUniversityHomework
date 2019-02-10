package com.system.S_frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.system.F_frame.F_Frame;
import com.system.F_frame.Frame;
import com.system.T_frame.InfoQuery;
import com.system.T_frame.Update_frame;
import com.system.T_frame.courseGradeQuery;
import com.system.T_frame.gradeInsert;
import com.system.T_frame.gradeQuery;
import com.system.dao.impl.StuImpl;
import com.system.javabean.Student;
import com.system.javabean.User;

public class S_frame extends JFrame {
	private JButton infoQuery, gradeQuery, exit1, gradeInsert, courseGradeQuery, exit;
	Frame f;
	Student student = new Student();
	StuImpl stuimpl = new StuImpl();

	public S_frame(User user) {
		System.out.println("跳转成功" + user.getType());
		JPanel user_panel = User_panel(user);// 用户信息画板

		if (user.getType().equals("student")) {
			JPanel p = StuPanel();
			student = stuimpl.getStudent(user.getName());// 用户名等同与学号，工号
			f = new Frame(user.getType(), 500, 200, 900, 700);
			f.add(user_panel);
			f.add(p);

		} else {
			JPanel p = TeaPanel();
			f = new Frame(user.getType(), 500, 200, 900, 700);
			f.add(user_panel);
			f.add(p);
		}
	}

	private JPanel User_panel(User user) {
		JPanel p = new JPanel();
		p.setBounds(20, 20, 840, 300);
		p.setBackground(new Color(204, 204, 255));
		p.setLayout(null);
		Font font_title = new Font("宋体", Font.BOLD, 40);
		Font font_user_info = new Font("宋体", Font.BOLD, 25);
		JLabel title = new JLabel("**  欢迎使用  **");
		title.setBounds(250, 40, 400, 50);
		title.setFont(font_title);
		JLabel l1 = new JLabel("用户名：" + user.getName());
		l1.setBounds(20, 120, 200, 50);
		l1.setFont(font_user_info);
		JLabel l2 = new JLabel("身份：" + user.getType());
		l2.setBounds(270, 120, 200, 50);
		l2.setFont(font_user_info);
		JButton update_pass = new JButton("修改密码");
		update_pass.setBounds(520, 120, 150, 50);
		update_pass.setFont(font_user_info);
		update_pass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Update_frame(user);
			}
		});

		JButton logout = new JButton("注销用户");
		logout.setBounds(680, 120, 150, 50);
		logout.setFont(font_user_info);
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				new F_Frame();
			}
		});
		p.add(title);
		p.add(l1);
		p.add(l2);
		p.add(update_pass);
		p.add(logout);
		return p;
	}

	public JPanel StuPanel() {
		JPanel p = new JPanel();
		JButton infoQuery = new JButton("个人信息查询");
		JButton gradeQuery = new JButton("课程成绩查询");
		JButton exit1 = new JButton("退出");
		p.setBounds(20, 20, 840, 600);
		p.setBackground(new Color(204, 204, 255));
		p.setLayout(null);
		gradeQuery.setBounds(300, 400, 300, 50);
		gradeQuery.setFont(new Font("宋体", Font.BOLD, 26));
		infoQuery.setBounds(300, 300, 300, 50);
		infoQuery.setFont(new Font("宋体", Font.BOLD, 26));
		exit1.setBounds(520, 500, 100, 50);
		exit1.setFont(new Font("宋体", Font.BOLD, 26));

		exit1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.print("学生用户退出");
				System.exit(0);
			}
		});

		gradeQuery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.print("成绩查询页面");
				new gradeQuery(student);
			}
		});
		infoQuery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("个人信息查询页面");
				new InfoQuery(student);
			}
		});
		p.add(infoQuery);
		p.add(gradeQuery);
		p.add(exit1);
		return p;
	}

	public JPanel TeaPanel() {
		JPanel p = new JPanel();
		JButton gradeInsert = new JButton("学生成绩登记");
		JButton courseGradeQuery = new JButton("课程成绩查询");
		JButton exit = new JButton("退出");
		p.setBounds(20, 20, 840, 600);
		p.setBackground(new Color(204, 204, 255));
		p.setLayout(null);
		gradeInsert.setBounds(300, 300, 300, 50);
		gradeInsert.setFont(new Font("宋体", Font.BOLD, 26));
		courseGradeQuery.setBounds(300, 400, 300, 50);
		courseGradeQuery.setFont(new Font("宋体", Font.BOLD, 26));
		exit.setBounds(520, 500, 100, 50);
		exit.setFont(new Font("宋体", Font.BOLD, 26));
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.print("教师用户退出");
				System.exit(0);
			}
		});
		gradeInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("点击成绩登记界面");
				new gradeInsert();
			}
		});
		courseGradeQuery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("点击课程成绩查询界面");
				new courseGradeQuery();
			}
		});
		p.add(courseGradeQuery);
		p.add(gradeInsert);
		p.add(exit);
		return p;
	}

	public JPanel useState(User user) {
		JPanel p = new JPanel();
		p.setBounds(20, 20, 800, 200);
		p.setBackground(new Color(2, 232, 255));
		p.setLayout(null);
		return p;
	}

}

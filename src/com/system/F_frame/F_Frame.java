package com.system.F_frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.system.S_frame.S_frame;
import com.system.dao.impl.UserImpl;
import com.system.javabean.User;

public class F_Frame implements ActionListener {

	Frame f;
	JLabel title = new JLabel("学生成绩管理系统");
	JLabel l1 = new JLabel("用户名：");
	JLabel l2 = new JLabel("密码：");

	JTextField username = new JTextField();
	JTextField pass = new JTextField();

	JButton login = new JButton("登录");
	JButton exit = new JButton("退出");

	// Frame f = new Frame("登录窗口", 600, 300, 700, 500);//用于监听关闭不结束

	public F_Frame() {
		JPanel p1 = Panel();
		f = new Frame("登录窗口", 600, 300, 700, 500);
		f.add(p1);
	}

	public JPanel Panel() {
		JPanel p = new JPanel();
		p.setBounds(20, 20, 640, 400);
		p.setBackground(new Color(204, 204, 255));
		p.setLayout(null);

		title.setBounds(200, 40, 280, 50);
		title.setFont(new Font("宋体", Font.BOLD, 30));
		l1.setBounds(20, 120, 200, 50);
		l1.setFont(new Font("宋体", Font.BOLD, 26));
		l2.setBounds(20, 200, 200, 50);
		l2.setFont(new Font("宋体", Font.BOLD, 26));
		username.setBounds(120, 120, 500, 50);
		username.setFont(new Font("宋体", Font.BOLD, 26));
		pass.setBounds(120, 200, 500, 50);
		pass.setFont(new Font("宋体", Font.BOLD, 26));
		login.setBounds(370, 300, 100, 50);
		login.setFont(new Font("宋体", Font.BOLD, 26));
		exit.setBounds(520, 300, 100, 50);
		exit.setFont(new Font("宋体", Font.BOLD, 26));
		login.addActionListener(this);
		exit.addActionListener(this);

		p.add(title);
		p.add(l1);
		p.add(l2);
		p.add(username);
		p.add(pass);
		p.add(login);
		p.add(exit);

		return p;
	}

	public void actionPerformed(ActionEvent e) {
		User user = new User();
		UserImpl userimpl = new UserImpl();
		user = userimpl.getUser(username.getText());
		if (e.getSource() == login) {
			if ((username.getText()).equals("") || (pass.getText()).equals("")) {
				new panel("用户名与密码不能为空！！");
			} else if (userimpl.Login(username.getText(), pass.getText())) {
				System.out.println("登录成功");
				f.dispose();// 用于监听关闭不结束
				new S_frame(user);
			}
		} else if (e.getSource() == exit) {
			System.out.println("退出成功");
			System.exit(0);
		}
	}

	public static void main(String args[]) {

		new F_Frame();

	}
}

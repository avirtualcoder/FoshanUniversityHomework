package com.system.S_frame;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;

public class StuPanel extends JPanel {
	JButton login = new JButton("登录");
	JButton exit = new JButton("退出");

	public JPanel StuPanel() {
		JPanel p = new JPanel();
		p.setBounds(20, 20, 640, 400);
		p.setBackground(new Color(204, 204, 255));
		p.setLayout(null);
		login.setBounds(370, 300, 100, 50);
		login.setFont(new Font("宋体", Font.BOLD, 26));
		exit.setBounds(520, 300, 100, 50);
		exit.setFont(new Font("宋体", Font.BOLD, 26));
		p.add(login);
		p.add(exit);
		return p;
	}
}

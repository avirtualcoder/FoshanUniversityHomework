package com.system.F_frame;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class panel implements ActionListener {

	Frame f = new Frame("提示", 650, 350, 400, 250);
	JButton sure = new JButton("确定");

	public panel(String text) {
		JLabel tips = new JLabel(text);
		f.setLayout(null);
		tips.setBounds(20, 20, 400, 50);
		tips.setFont(new Font("宋体", Font.BOLD, 20));
		sure.setBounds(100, 120, 150, 50);
		sure.setFont(new Font("宋体", Font.BOLD, 20));
		f.add(tips);
		f.add(sure);
		sure.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == sure) {
			f.dispose();
		}
	}

}

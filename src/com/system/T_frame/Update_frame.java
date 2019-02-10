package com.system.T_frame;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.system.F_frame.Frame;
import com.system.F_frame.panel;
import com.system.dao.impl.UserImpl;
import com.system.javabean.User;

public class Update_frame {
	public Update_frame(User user) {
		UserImpl userimpl = new UserImpl();
		Frame f = new Frame("更改密码", 200, 200, 500, 400);
		Font label_font = new Font("宋体", Font.BOLD, 20);
		JLabel old_label = new JLabel("输入旧密码：");
		old_label.setBounds(50, 50, 150, 60);
		old_label.setFont(label_font);
		JLabel new_label = new JLabel("输入新密码：");
		new_label.setBounds(50, 120, 150, 60);
		new_label.setFont(label_font);
		JLabel sure_label = new JLabel("新密码确认：");
		sure_label.setBounds(50, 190, 150, 60);
		sure_label.setFont(label_font);
		JTextField old_text = new JTextField();
		old_text.setBounds(200, 50, 250, 50);
		old_text.setFont(label_font);
		JTextField new_text = new JTextField();
		new_text.setBounds(200, 120, 250, 50);
		new_text.setFont(label_font);
		JTextField sure_text = new JTextField();
		sure_text.setBounds(200, 190, 250, 50);
		sure_text.setFont(label_font);
		JButton sure = new JButton("确定");
		sure.setBounds(190, 270, 100, 50);
		sure.setFont(label_font);
		sure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (new_text.getText().equals(sure_text.getText())) {
					if (userimpl.UpdatePass(user.getName(), old_text.getText(), new_text.getText())) {
						new panel("修改成功");
						f.dispose();
					} else {
						new panel("原密码错误");
					}
				} else {
					new panel("两次密码不一致");
				}

			}
		});
		f.add(old_label);
		f.add(new_label);
		f.add(sure_label);
		f.add(old_text);
		f.add(new_text);
		f.add(sure_text);
		f.add(sure);

	}
}

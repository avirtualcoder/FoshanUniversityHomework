package com.system.Four_Frame;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.system.F_frame.Frame;
import com.system.T_frame.tabel;

public class Query_grade_by_ccg {
	Frame f;
	private JTextField class_text, cour_text, grade_text;
	private Font font;
	private JButton sure;

	public Query_grade_by_ccg(String metux) {
		font = new Font("宋体", Font.BOLD, 26);
		JPanel cl_p = Clp();
		JPanel co_p = Cop();
		JPanel gr_p = Grp();
		sure = new JButton("确定");
		sure = new JButton("确定");
		sure.setBounds(50, 250, 100, 50);
		sure.setFont(font);
		sure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

		f = new Frame("成绩查询", 500, 200, 900, 700);
		if (metux.equals("100")) {
			f.add(cl_p);
			new tabel(class_text.getText());
		}
		if (metux.equals("010")) {
			f.add(co_p);
		}
		if (metux.equals("001")) {
			f.add(gr_p);
		}
		if (metux.equals("101")) {
			f.add(cl_p);
			f.add(gr_p);
		}
		if (metux.equals("011")) {
			f.add(co_p);
			f.add(gr_p);
		}
		if (metux.equals("111")) {
			f.add(cl_p);
			f.add(co_p);
			f.add(gr_p);
		}

	}

	private JPanel Clp() {
		JPanel cl_p = new JPanel();
		cl_p.setBounds(0, 10, 400, 70);
		cl_p.setLayout(null);
		JLabel tips = new JLabel("输入查询的分数：");
		tips.setBounds(0, 0, 250, 50);
		tips.setFont(font);
		class_text = new JTextField();
		class_text.setBounds(250, 0, 100, 50);
		class_text.setFont(font);
		cl_p.add(tips);
		cl_p.add(class_text);
		return cl_p;
	}

	private JPanel Cop() {
		JPanel Cop = new JPanel();
		Cop.setBounds(0, 80, 400, 70);
		Cop.setLayout(null);
		JLabel tips = new JLabel("输入查询的课程：");
		tips.setBounds(0, 0, 250, 50);
		tips.setFont(font);
		cour_text = new JTextField();
		cour_text.setBounds(250, 0, 100, 50);
		cour_text.setFont(font);
		Cop.add(tips);
		Cop.add(cour_text);
		return Cop;
	}

	public JPanel Grp() {
		JPanel gr_p = new JPanel();
		gr_p.setBounds(0, 150, 400, 70);
		gr_p.setLayout(null);
		JLabel tips = new JLabel("输入查询的班级：");
		tips.setBounds(0, 0, 250, 50);
		tips.setFont(font);
		grade_text = new JTextField();
		grade_text.setBounds(250, 0, 100, 50);
		grade_text.setFont(font);
		gr_p.add(tips);
		gr_p.add(grade_text);
		return gr_p;

	}
}

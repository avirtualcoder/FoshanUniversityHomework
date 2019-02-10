package com.system.T_frame;

//import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.system.dao.impl.StuCourImpl;
import com.system.javabean.Stu_Cour;

public class UpdateScoreFrame extends JFrame {
	private JLabel snoLabel, cnoLabel, gradeLabel;
	private JTextField snoText, cnoText, gradeText;
	private JButton insertscore, tuichu;

	Stu_Cour score = new Stu_Cour();
	StuCourImpl scoreDao = new StuCourImpl();

	public UpdateScoreFrame() {
		super("修学改学生成绩窗口");
		init();

		setSize(300, 250);
		// 登录窗口屏幕正中
		int windowWidth = this.getWidth(); // 获得窗口宽
		int windowHeight = this.getHeight(); // 获得窗口高
		Toolkit kit = Toolkit.getDefaultToolkit(); // 定义工具包
		Dimension screenSize = kit.getScreenSize(); // 获取屏幕的尺寸
		int screenWidth = screenSize.width; // 获取屏幕的宽
		int screenHeight = screenSize.height; // 获取屏幕的高
		this.setLocation(screenWidth / 2 - windowWidth / 2, screenHeight / 2 - windowHeight / 2);// 设置窗口居中显示

		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void init() {
		setLayout(null);
		ImageIcon title_pic = new ImageIcon(getClass().getResource("/com/student/images/title.png"));
		this.setIconImage(title_pic.getImage());
		// 将文件中的学号和 课程号取出来
		String sno = null;
		String cno = null;
		try {
			File file = new File("file.txt");
			file.createNewFile();
			FileReader in = new FileReader(file);
			BufferedReader fin = new BufferedReader(in);
			sno = fin.readLine();
			System.out.print("sno" + sno);
			cno = fin.readLine();
			System.out.print("cno" + cno);
			fin.close();
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		score = scoreDao.find_grade_by_Sno_Cno(sno, cno);// 按学号、课程号查询成绩信息

		snoLabel = new JLabel("学  号");
		snoLabel.setBounds(59, 43, 72, 15);
		add(snoLabel);
		snoText = new JTextField(score.getSno());
		snoText.setBounds(100, 40, 100, 20);
		add(snoText);
		snoText.setColumns(10);
		snoText.setEnabled(false);

		cnoLabel = new JLabel("课程号");
		cnoLabel.setBounds(59, 83, 72, 15);
		add(cnoLabel);

		cnoText = new JTextField(score.getCno());
		cnoText.setColumns(10);
		cnoText.setBounds(100, 80, 100, 20);
		add(cnoText);
		cnoText.setEnabled(false);

		gradeLabel = new JLabel("成  绩");
		gradeLabel.setBounds(59, 123, 72, 15);
		add(gradeLabel);
		gradeText = new JTextField(new Float(score.getGrade()).toString());
		gradeText.setColumns(10);
		gradeText.setBounds(100, 120, 100, 20);
		add(gradeText);

		insertscore = new JButton("修改");
		insertscore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (snoText.getText().equals("") && cnoText.getText().equals("")) {
					JOptionPane.showMessageDialog(getParent(), "学号、姓名必填！", "信息提示框", JOptionPane.INFORMATION_MESSAGE);
					return;
				} else {

					score.setGrade(Float.parseFloat(gradeText.getText()));
					System.out.print("cj" + Float.parseFloat(gradeText.getText()));
					scoreDao.updateScore(score);
					JOptionPane.showMessageDialog(getParent(), "修改学生成绩成功！", "信息提示框", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		insertscore.setBounds(60, 170, 60, 20);
		add(insertscore);

		tuichu = new JButton("退出");
		tuichu.setBounds(140, 170, 60, 20);
		tuichu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateScoreFrame.this.dispose();
			}
		});
		add(tuichu);

	}
}

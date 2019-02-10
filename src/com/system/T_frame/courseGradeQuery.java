package com.system.T_frame;

import static javax.swing.BorderFactory.createTitledBorder;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.system.F_frame.Frame;
import com.system.dao.impl.StuCourImpl;

public class courseGradeQuery {
	// 声明面板，标识，表格，功能接口
	private JPanel message;
	private JTextField ClnameTextField;
	private JTable table;
	private JTextField CnameTextField;
	StuCourImpl stucourimpl = new StuCourImpl();
	Object[][] sc_obj;
	// Object[] column;
	// scoreTableModel model = new scoreTableModel();
	String Clname;
	String Cname;
	Frame f;
	JTable table1;

	/**
	 * Create the panel.
	 */
	public courseGradeQuery() {
		JPanel p = getMessage();
		f = new Frame("查课程成绩", 600, 300, 500, 500);
		f.add(p);
	}

	public JPanel getMessage() {

		message = new JPanel();
		message.setBorder(createTitledBorder(null, "成绩基本信息", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.TOP,
				new Font("sansserif", Font.BOLD, 12), new Color(59, 59, 59)));
		message.setBackground(new Color(71, 201, 223));
		message.setBounds(0, 40, 500, 370);
		message.setLayout(null);
		JLabel snoLabel = new JLabel("班级");
		snoLabel.setBounds(50, 34, 54, 15);
		message.add(snoLabel);

		ClnameTextField = new JTextField();
		ClnameTextField.setBounds(82, 31, 97, 20);
		message.add(ClnameTextField);
		ClnameTextField.setColumns(10);

		JLabel cnoLlabel = new JLabel("课程");
		cnoLlabel.setBounds(195, 34, 60, 15);
		message.add(cnoLlabel);

		CnameTextField = new JTextField();
		CnameTextField.setBounds(244, 31, 97, 20);
		message.add(CnameTextField);
		CnameTextField.setColumns(10);

		JButton findButton = new JButton("搜索");
		findButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Clname = ClnameTextField.getText();
				Cname = CnameTextField.getText();
				System.out.println(Clname + Cname);
				if ((Clname.equals("")) && (Cname.equals(""))) {
					System.out.print("请输入课程或班级！！");
					return;
				}
				if ((!Clname.equals("")) && (Cname.equals(""))) {
					System.out.println("按班级查");
					sc_obj = stucourimpl.find_grade_by_class(Clname);
				}

				if ((Clname.equals("")) && (!Cname.equals(""))) {
					System.out.println("按课程查");
					System.out.println(Cname);
					sc_obj = stucourimpl.find_grade_by_course(Cname);
				}

				if ((!Clname.equals("")) && (!Cname.equals(""))) {
					System.out.println("按班级，课程查");
					sc_obj = stucourimpl.find_grade_by_class_course(Clname, Cname);
				}
				table1 = new JTable(sc_obj, new Object[] { "班级", "课程", "平均分", "最高分", "最低分", "及格率" });
				JScrollPane scrollPane_2 = new JScrollPane(table1);
				scrollPane_2.setBounds(10, 60, 480, 200);
				message.add(scrollPane_2);
			}
		});
		findButton.setBounds(373, 30, 65, 23);
		message.add(findButton);
		JButton insertButton = new JButton("添加");
		insertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.print("添加学生信息");
			}
		});
		insertButton.setBounds(71, 280, 65, 23);
		message.add(insertButton);

		JButton updateButton = new JButton("修改");
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();

				if (row < 0) {
					System.out.println("请选择要修改的数据");
					return;
				} else {
					File file = new File("file.txt");
					try {
						// 将字符串学号、课程号到file.txt文件中
						String clname = table.getValueAt(row, 0).toString();
						String cname = table.getValueAt(row, 1).toString();
						file.createNewFile();
						FileWriter out = new FileWriter(file);
						out.write(clname);
						out.write("\n");// 行分隔
						out.write(cname);
						out.flush();
						out.close();
						UpdateScoreFrame updatescore = new UpdateScoreFrame();
						updatescore.setVisible(true);
						message.repaint();
					} catch (Exception ee) {
						ee.printStackTrace();
					}
				}
			}
		});
		updateButton.setBounds(209, 280, 65, 23);
		message.add(updateButton);
		JButton deleteButton = new JButton("删除");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				String sno = table.getValueAt(row, 0).toString();
				String cno = table.getValueAt(row, 1).toString();
				if (sno.equals("")) {
					System.out.println("没有选择要刪除的数据！");
					return;
				} else {
					stucourimpl.deleteScore(sno, cno);
					System.out.println("删除成绩成功！");
				}
			}
		});
		deleteButton.setBounds(335, 280, 65, 23);
		message.add(deleteButton);
		return message;

	}

	// private JCheckBox Class, Course, Grade;
	// private JLabel chose_tips;
	// private JTextField class_text, cour_text, grade_text;
	// private JButton sure;
	// JPanel p;
	// private Font font;
	// Frame f;
	//
	// public courseGradeQuery() {
	// f = new Frame("教师查询成绩页面", 600, 250, 300, 400);
	// p = new JPanel();
	// p.setBounds(10, 20, 300, 400);
	// p.setLayout(null);
	// System.out.println("跳转教师查成绩页面");
	// font = new Font("宋体", Font.BOLD, 26);
	// Class = new JCheckBox("班级");
	// Class.setBounds(50, 50, 100, 50);
	// Class.setFont(font);
	// Course = new JCheckBox("课程");
	// Course.setBounds(50, 100, 100, 50);
	// Course.setFont(font);
	// Grade = new JCheckBox("成绩");
	// Grade.setBounds(50, 150, 100, 50);
	// Grade.setFont(font);
	// chose_tips = new JLabel("请选择查询方式:");
	// chose_tips.setBounds(20, 00, 250, 50);
	// chose_tips.setFont(font);
	// sure = new JButton("确定");
	// sure.setBounds(50, 250, 100, 50);
	// sure.setFont(font);
	// sure.addActionListener(new ActionListener() {
	// public void actionPerformed(ActionEvent e) {
	// if (Class.isSelected() && (!Course.isSelected()) && (!Grade.isSelected())) {
	// System.out.println("按班查");
	// new Query_grade_by_ccg("100");
	// } else if (Class.isSelected() && (Course.isSelected()) &&
	// (!Grade.isSelected())) {
	// System.out.println("按班与课程查");
	// new Query_grade_by_ccg("110");
	// } else if (Class.isSelected() && (Course.isSelected()) &&
	// (Grade.isSelected())) {
	// System.out.println("按班与课程与成绩查");
	// new Query_grade_by_ccg("111");
	// } else if ((!Class.isSelected()) && (Course.isSelected()) &&
	// (Grade.isSelected())) {
	// System.out.println("按课程与成绩查");
	// new Query_grade_by_ccg("011");
	// } else if ((!Class.isSelected()) && (Course.isSelected()) &&
	// (!Grade.isSelected())) {
	// System.out.println("按课程查");
	// new Query_grade_by_ccg("010");
	// } else if ((Class.isSelected()) && (!Course.isSelected()) &&
	// (Grade.isSelected())) {
	// System.out.println("按班与成绩查");
	// new Query_grade_by_ccg("101");
	// } else if ((!Class.isSelected()) && (Course.isSelected()) &&
	// (!Grade.isSelected())) {
	// System.out.println("按课程查");
	// new Query_grade_by_ccg("010");
	// }
	// }
	// });
	// p.add(Class);
	// p.add(Course);
	// p.add(Grade);
	// p.add(chose_tips);
	// p.add(sure);
	// f.add(p);
	// f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	//
	// }
	//
	// public JPanel class_panel() {
	// JPanel cl_p = new JPanel();
	// cl_p.setBounds(20, 20, 300, 400);
	// cl_p.setLayout(null);
	// JLabel tips = new JLabel("输入查询的班级：");
	// tips.setBounds(50, 50, 250, 50);
	// tips.setFont(font);
	// class_text = new JTextField();
	// class_text.setBounds(50, 50, 250, 50);
	// class_text.setFont(font);
	// cl_p.add(tips);
	// cl_p.add(class_text);
	// return cl_p;
	// }
}

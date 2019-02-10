package com.system.F_frame;

import java.awt.Color;

import javax.swing.JFrame;

public class Frame extends JFrame {
	public Frame(String name, int x, int y, int w, int h) {
		this.setTitle(name);
		this.setLocation(x, y);
		this.setSize(w, h);
		this.setVisible(true);
		this.setLayout(null);
		this.setBackground(new Color(0, 90, 102));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	// public static void main(String args[]) {
	// // new Frame("登录窗口", 200, 200, 900, 700);
	// Frame f = new Frame("登录窗口", 600, 300, 700, 500);
	// F_Panel p1 = new F_Panel();
	// f.setLayout(null);
	// f.setBackground(new Color(0, 90, 102));
	// f.add(p1);
	// }
}

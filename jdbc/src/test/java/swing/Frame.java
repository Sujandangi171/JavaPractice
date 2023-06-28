package swing;

import java.awt.Toolkit;

import javax.swing.JFrame;

public class Frame extends JFrame {
	public Frame() {
		setBounds(350, 200, 800, 500);
		setTitle("JFrame Example");
		setIconImage(Toolkit.getDefaultToolkit().createImage("right.png"));
		setDefaultCloseOperation(3);
	}
	public static void main(String[] args) {
		Frame frame = new Frame();
		frame.setVisible(true);
	}
}

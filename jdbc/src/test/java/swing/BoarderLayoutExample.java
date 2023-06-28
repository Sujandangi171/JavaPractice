package swing;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class BoarderLayoutExample {
	public static void main(String[] args) {
		Frame frame = new Frame();
//		frame.setLayout(new BorderLayout());
		JButton header = new JButton ("NORTH");
//		JButton leftSideBar = new JButton ("WEST");
		JPanel leftSideBar = new JPanel();
		leftSideBar.setLayout(new BoxLayout(leftSideBar, BoxLayout.Y_AXIS));
		
//		JButton content = new JButton ("CENTRE");
		
		JPanel content = new JPanel();
		JButton btn1 = new JButton();
		JButton btn2 = new JButton();
		JButton btn3 = new JButton();
		JButton btn4 = new JButton();
		JButton btn5 = new JButton();
		JButton btn6 = new JButton();
		JButton btn7 = new JButton();
		JButton btn8 = new JButton();
		JButton btn9 = new JButton();
		content.add(btn1);
		content.add(btn2);
		content.add(btn3);
		content.add(btn4);
		content.add(btn5);
		content.add(btn6);
		content.add(btn7);
		content.add(btn8);
		content.add(btn9);
		
		JButton rightSideBar  = new JButton ("EAST");
		JButton footer = new JButton ("SOUTH");
		
		frame.add(header ,BorderLayout.NORTH);
		frame.add(leftSideBar ,"West" );
		frame.add(content ,BorderLayout.CENTER );
		frame.add(rightSideBar ,BorderLayout.EAST );
		frame.add(footer ,"South" );
		frame.setVisible(true);
		
	}

}

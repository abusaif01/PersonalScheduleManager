import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class A{
	public A(){
		JFrame frame = new JFrame("Hello World");
		JPanel panel = new JPanel();
		panel.setBackground(Color.RED);
		panel.setLayout(new BorderLayout());
		JComponent heading = new JLabel("NORTH");
		heading.setBackground(Color.YELLOW);
		frame.add(heading,BorderLayout.NORTH);
		
		JLabel heading1 = new JLabel("SOUTH");
		frame.add(heading1,BorderLayout.SOUTH);
		
		JLabel heading2 = new JLabel("WEST");
		frame.add(heading2,BorderLayout.WEST);
		
		JLabel heading3 = new JLabel("EAST");
		frame.add(heading3,BorderLayout.EAST);
		
		JPanel panel1 = new JPanel();
		GridLayout gr = new GridLayout(3,2);
		gr.setRows(4);
		panel1.setLayout(gr);
		panel1.setBackground(Color.GREEN);
		
		JButton butt1 = new JButton("Button1");
		panel1.add(butt1);
		
		JButton butt3 = new JButton("Button3");
		panel1.add(butt3);
		JButton butt2 = new JButton("Button2");
		panel1.add(butt2);
		JButton butt4 = new JButton("Button4");
		panel1.add(butt4);
		JButton butt5 = new JButton("Button5");
		panel1.add(butt5);
		JButton butt6 = new JButton("Button6");
		panel1.add(butt6);
		
		JLabel heading4 = new JLabel("NORTH");
		panel.add(heading4,BorderLayout.NORTH);
		
		JLabel heading11 = new JLabel("SOUTH");
		panel.add(heading11,BorderLayout.SOUTH);
		
		JLabel heading22 = new JLabel("WEST");
		panel.add(heading22,BorderLayout.WEST);
		
		JLabel heading33 = new JLabel("EAST");
		panel.add(heading33,BorderLayout.EAST);
		
		panel.add(panel1,BorderLayout.CENTER);
		
		frame.add(panel,BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,300);
		frame.setLocation(300,300);
		frame.setVisible(true);
		//System.out.println(panel);
	}
	
	public static void main(String args[]){
		A a = new A();
	}
}
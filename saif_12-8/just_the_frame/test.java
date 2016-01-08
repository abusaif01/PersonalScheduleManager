import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class test
{
	public test()
	{
		JFrame frl=new JFrame("test");
		frl.setSize(300,400);
		frl.setLocation(50,100);
		frl.setVisible(true);
		frl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		Container cnt=frl.getContentPane();
		JButton btn=new JButton("abt");
		btn.addActionListener(new action)
		
		frl.add(btn);
		
		
		}
		public static void main(String arg[])
		{
			new test();
			}


	}
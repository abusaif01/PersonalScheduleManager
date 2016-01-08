import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class uin
{
	String title;
	public uin(String com)
	{	
//ui start;		
		JFrame fr=new JFrame(com);
		Container cnt=fr.getContentPane();	
		fr.setLayout(new GridLayout(6,2));
		JButton bt=new JButton("ok");
		bt.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent f)
			{
				 String lines =new String();
				 try{
				 File abt_minips=new File("about_minips.txt");
				 RandomAccessFile accfl= new RandomAccessFile(abt_minips,"rws");
				 JFrame frl=new JFrame("balchal");
				 JTextArea tx=new JTextArea();;
				while((lines=accfl.readLine())!=null)
				{
					tx.append(lines+"\n");
				}
					frl.add(tx);
					frl.setSize(300,400);
					frl.setLocation(50,100);
					frl.setVisible(true);
				//	frl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							
				
				 }
				catch(IOException e)
				{
				System.out.println ("error during file read.");
				}
			}
		}
			);
			
		fr.add(bt);
		fr.	setSize(300,400);
		fr.setLocation(50,100);
		fr.setVisible(true);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main (String[] args) {
		new uin("no");
		}
}
import java.sql.*;
import javax.swing.*;
import java.awt.*;
public class main_chk
{
	public main_chk()
	{
//	try
//	{

		recent_time rct=new recent_time();
		java.sql.Timestamp dt=rct.get_recent_time();
		System.out.println (dt);
		 String a,b;
		 mainf mainWindow =new mainf();
		 
	//	while(true)	
	//	{
			a=rct.todays_date();
			b=rct.time_now();
		 JTextArea ta=new JTextArea("Date : "+a+"       Time : "+b);
		// System.out.println ("a and b  :"+a+"  "+b);
			ta.setEditable(false);
			ta.setBackground(new Color(209, 209, 238));
		 mainWindow.main_frame.add(ta,BorderLayout.SOUTH);
		// mainWindow.main_frame.pack();
		 mainWindow.main_frame.setVisible(true);
	
	//	}
//	}catch(SQLException e)
//	{
//		System.err.println(e);
	//	}

		
		
		}
		public static void main (String[] args) {
			new main_chk();
}	
		 
	}

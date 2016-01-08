import java.sql.*;
import javax.swing.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class insetr_with_ui
{
	JFrame fr= new JFrame("Input_Entry");
	JTextField day=new JTextField(2);
 		JTextField month=new JTextField(2);
 		JTextField year =new JTextField(4);
 		JTextField oc=new JTextField(10);
 		java.sql.Date date;
 		handle_table_with_java new_data;
	
	public insetr_with_ui()
	{
		new_data=new handle_table_with_java();
		Container container=fr.getContentPane();
		FlowLayout lout=new FlowLayout();
		fr.setLayout(lout);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setSize(500,500);
		fr.setLocation(200,100);
		
		
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setSize(500,500);
 		fr.setLocation(200,100);
		fr.setVisible(true);
		
		
		//entry choser.
		Choice entry_choser = new Choice();
		entry_choser.add("Daily");
 		entry_choser.add("Weakly");
 		entry_choser.add("Monthly");
 		entry_choser.add("Yearly");
 		entry_choser.add("Once");
 		fr.add(entry_choser);
 		
 		//date & oc input;
 		JLabel l1=new JLabel();
 			
 		fr.add(day);
 		fr.add(month);
 		fr.add(year);
 		fr.add(oc);
 		//get valuse;
 		JButton b1=new JButton("OK");
 		b1.addActionListener(new ActionListener()
 		{
 			
 			public void actionPerformed(ActionEvent ac)
 			{
 				String day_s,month_s,year_s,oc_s,date_s;
 				int day_in,month_in,year_in;
 				day_s=day.getText();
 				month_s=month.getText();
 				year_s=year.getText();
 				oc_s=oc.getText();
 				month_in=Integer.parseInt(month_s);
 				year_in=Integer.parseInt(year_s);
 				date_s=year_s+"-"+month_s+"-"+day_s;
 				date=java.sql.Date.valueOf(date_s);
 				
 				System.out.println ("the date is : "+date);
 				System.out.println ("the oc is : "+oc_s);
 				
 			new_data.execute_querey(date,oc_s);
 				}
 		}
 			);
 		
 		fr.add(b1);
 	//	fr.pack();
 		fr.setVisible(true);	
	}
	
	
	
	public static void main (String[] args) {
		
		new insetr_with_ui();
		}
	
	
	
}


	
	
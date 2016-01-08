import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class InsertEntries
{
	database_connection connection=new database_connection();
	PreparedStatement prs;
	JFrame fr= new JFrame("Input_Entry");
	JPanel head=new JPanel();
	JPanel time_P=new JPanel(new GridLayout(1,2));
	JPanel date_p=new JPanel(new GridLayout(1,2));
	JPanel buton_p=new JPanel(new FlowLayout());
	
//	JPanel timeIn=new JPanel(new GridLayout(2,3));	
	JPanel dateIn=new JPanel(new GridLayout(2,3));
	JPanel oc_p=new JPanel(new GridLayout(1,2));
	
	JLabel time_head=new JLabel("Give The Entry Time");
	JLabel label=new JLabel("Give New Input");
	JLabel timeHrIn=new JLabel("Hr (hh)");
	JLabel timeMnIn=new JLabel("Min (mm)");
	JLabel dateMonthIn=new JLabel("Month");
	JLabel dateYearIn=new JLabel("Year (yyyy)");
	JLabel dateDayIn=new JLabel("Day");
	JLabel ocInT=new JLabel("Ocation");
	JComboBox date_day=new JComboBox();
	JComboBox date_month=new JComboBox();

	JTextField time_hr=new JTextField(2);
	JTextField time_min=new JTextField(2);
	JTextField	date_year=new JTextField(4);
	JTextField	ocation=new JTextField(50);
	
	JButton ok=new JButton("OK");
	JButton cancel=new JButton("Cancel");
	
	Time time;
	String date;
	String d_d,d_m,d_y,t_h,t_m;
	boolean test=false;
	
	public InsertEntries()
	{
		Container container=fr.getContentPane();
		GridLayout lout=new GridLayout(5,1);
		fr.setLayout(lout);
		fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		fr.setSize(500,500);
		fr.setLocation(800,200);
		//fr.removeAll();
		//time set.
		Box time_Ibox=Box.createHorizontalBox();
		time_Ibox.add(timeHrIn);
		time_Ibox.add(Box.createHorizontalStrut(65));
		time_Ibox.add(new JLabel(":"));
		time_Ibox.add(Box.createHorizontalStrut(50));
		time_Ibox.add(timeMnIn);
		
		Box time_box1=Box.createHorizontalBox();
		time_box1.add(time_hr);
		time_box1.add(Box.createHorizontalStrut(50));
		time_box1.add(new JLabel(":"));
		time_box1.add(Box.createHorizontalStrut(50));
		time_box1.add(time_min);
		
		Box time_box=Box.createVerticalBox();
		time_box.add(time_Ibox);
		time_box.add(Box.createVerticalStrut(10));
		time_box.add(time_box1);
		time_box.add(Box.createVerticalStrut(40));
		
		
	//	label.setHorizontalTextPosition(10);
	//	label.setVerticalTextPosition(3);
		head.add(label); 
		fr.add(head);
		time_P.add(time_head);
		time_P.add(time_box);
		fr.add(time_P);
		
		
		oc_p.add(ocInT);
		oc_p.add(ocation);
		
		Box b_box=Box.createHorizontalBox();
	//	b_box.add(Box.createHorizontalStrut(20));
		b_box.add(ok);
		b_box.add(Box.createHorizontalStrut(100));
		b_box.add(cancel);
		buton_p.add(b_box);
		time_hr.setText(null);
		time_min.setText(null);
		date_year.setText(null);
		}
		//once
	public void InsertIntoOnce()
	{
		date_p.removeAll();
		date_p.add(new JLabel("Give The Entry Date"));
		Box dateBox1=Box.createHorizontalBox();
		dateBox1.add(dateDayIn);
		dateBox1.add(Box.createHorizontalStrut(40));
		dateBox1.add(dateMonthIn);
		dateBox1.add(Box.createHorizontalStrut(50));
		dateBox1.add(dateYearIn);
		
		date_day.setName("day");
		for(int i=1;i<32;i++)
		date_day.addItem(i);
		
		Box dateBox2=Box.createHorizontalBox();
		for(int i=1;i<13;i++)
		date_month.addItem(i);
		dateBox2.add(date_day);
		dateBox2.add(Box.createHorizontalStrut(15));
		dateBox2.add(new JLabel(" - "));
		dateBox2.add(Box.createHorizontalStrut(15));
		dateBox2.add(date_month);
		dateBox2.add(Box.createHorizontalStrut(15));
		dateBox2.add(new JLabel(" - "));
		dateBox2.add(Box.createHorizontalStrut(15));
		dateBox2.add(date_year);
		
		Box dateBox=Box.createVerticalBox();
		dateBox.add(dateBox1);
		dateBox.add(Box.createVerticalStrut(10));
		dateBox.add(dateBox2);
		dateBox.add(Box.createVerticalStrut(40));
		date_p.add(dateBox);
		fr.add(date_p);
		fr.add(oc_p);
		fr.add(buton_p);
		
		fr.setVisible(true);
		ok.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				Object a;
				a=date_day.getSelectedItem();
				d_d=a.toString();
				a=date_month.getSelectedItem();
				d_m=a.toString();
				d_y=date_year.getText();
				 date=d_y+"-"+d_m+"-"+d_d;
				 time=Time.valueOf(time_hr.getText()+":"+time_min.getText()+":00");
				 System.out.println ("date :"+date+" time "+time);
				 try
				{
				PreparedStatement prs;
				prs=connection.con.prepareStatement("INSERT INTO once (date,time,ocation) VALUES(?,?,?)");
				prs.setString(1,date);
				prs.setTime(2,time);
				prs.setString(3,ocation.getText());
				prs.execute();
				connection.con.close();
			}catch(SQLException se)
			{
				System.err.println(se);
			}
				 JOptionPane.showMessageDialog(null,"Iserted Successully");
				 fr.dispose();
				new mainf();
				}
			}
			
			);
			
		cancel.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				new mainf();
			fr.dispose();
				}
			}
			);
			
		
		
			
	}
	
	// yearly
	public void InsertYealy()
	{
		date_p.removeAll();
		date_p.add(new JLabel("Give The Day And Month Of The Enrty"));
		Box dateBox1=Box.createHorizontalBox();
		dateBox1.add(dateDayIn);
		dateBox1.add(Box.createHorizontalStrut(110));
		dateBox1.add(dateMonthIn);
		dateBox1.add(Box.createHorizontalStrut(40));
		
		date_day.setName("day");
		for(int i=1;i<32;i++)
		date_day.addItem(i);
		
		Box dateBox2=Box.createHorizontalBox();
		for(int i=1;i<13;i++)
		date_month.addItem(i);
		dateBox2.add(date_day);
		dateBox2.add(Box.createHorizontalStrut(30));
		dateBox2.add(new JLabel(" - "));
		dateBox2.add(Box.createHorizontalStrut(30));
		dateBox2.add(date_month);
		dateBox2.add(Box.createHorizontalStrut(50));
		
		Box dateBox=Box.createVerticalBox();
		dateBox.add(dateBox1);
		dateBox.add(Box.createVerticalStrut(10));
		dateBox.add(dateBox2);
		dateBox.add(Box.createVerticalStrut(40));
		date_p.add(dateBox);
		fr.add(date_p);
		fr.add(oc_p);
		fr.add(buton_p);
		
		fr.setVisible(true);
		ok.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
   				Object a;
				a=date_day.getSelectedItem();
				d_d=a.toString();
				a=date_month.getSelectedItem();
				d_m=a.toString();
				 date=d_m+"-"+d_d;
				 time=Time.valueOf(time_hr.getText()+":"+time_min.getText()+":00");
				 System.out.println ("date :"+date+" time "+time);
				 try
				{
				PreparedStatement prs;
				prs=connection.con.prepareStatement("INSERT INTO yearly (date,time,ocation) VALUES(?,?,?)");
				prs.setString(1,date);
				prs.setTime(2,time);
				prs.setString(3,ocation.getText());
				prs.execute();
				connection.con.close();
			}catch(SQLException se)
			{
				System.err.println(se);
			}
				 JOptionPane.showMessageDialog(null,"Iserted Successully");
				 fr.dispose();
				new mainf();
				}
			}
			
			);
		
		
		cancel.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				new mainf();
			fr.dispose();
				}
			}
			);
	
		}
		
		//monthly
	public void InsertMonthly()
	{
		date_p.removeAll();
		date_p.add(new JLabel("Give The Day Of The Enrty"));
		Box dateBox1=Box.createHorizontalBox();
		dateBox1.add(dateDayIn);
		dateBox1.add(Box.createHorizontalStrut(175));
		
		date_day.setName("day");
		for(int i=1;i<32;i++)
		date_day.addItem(i);
		
		Box dateBox2=Box.createHorizontalBox();
		dateBox2.add(date_day);	
		dateBox2.add(Box.createHorizontalStrut(175));
		
		Box dateBox=Box.createVerticalBox();
		dateBox.add(dateBox1);
		dateBox.add(Box.createVerticalStrut(10));
		dateBox.add(dateBox2);
		dateBox.add(Box.createVerticalStrut(40));
		date_p.add(dateBox);
		fr.add(date_p);
		fr.add(oc_p);
		fr.add(buton_p);
		
		fr.setVisible(true);
		ok.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				Object a;
				a=date_day.getSelectedItem();
				d_d=a.toString();
				 date=d_d;
				 time=Time.valueOf(time_hr.getText()+":"+time_min.getText()+":00");
				 System.out.println ("date :"+date+" time "+time);
				 try
				{
				PreparedStatement prs;
				prs=connection.con.prepareStatement("INSERT INTO monthly (date,time,ocation) VALUES(?,?,?)");
				prs.setString(1,date);
				prs.setTime(2,time);
				prs.setString(3,ocation.getText());
				prs.execute();
				connection.con.close();
			}catch(SQLException se)
			{
				System.err.println(se);
			}
				 JOptionPane.showMessageDialog(null,"Iserted Successully");
				 fr.dispose();
				new mainf();
				}
			}
			
			);
		cancel.addActionListener(new ActionListener()
		{
			
			public void actionPerformed(ActionEvent ae)
			{
				new mainf();
			fr.dispose();
				}
			}
			);
		}
	public void InsertWeakly()
	{
		date_p.removeAll();
		date_p.add(new JLabel("Give The Day Of The Enrty"));
		Box dateBox1=Box.createHorizontalBox();
		dateBox1.add(dateDayIn);
		dateBox1.add(Box.createHorizontalStrut(175));
		
		date_day.setName("day");
		
		date_day.addItem("Sunday");
		date_day.addItem("Monday");
		date_day.addItem("Tuesday");
		date_day.addItem("Wednesday");
		date_day.addItem("Thursday");
		date_day.addItem("Friday");
		date_day.addItem("Satarday");
		
		Box dateBox2=Box.createHorizontalBox();
		dateBox2.add(date_day);	
		dateBox2.add(Box.createHorizontalStrut(175));
		
		Box dateBox=Box.createVerticalBox();
		dateBox.add(dateBox1);
		dateBox.add(Box.createVerticalStrut(10));
		dateBox.add(dateBox2);
		dateBox.add(Box.createVerticalStrut(40));
		date_p.add(dateBox);
		fr.add(date_p);
		fr.add(oc_p);
		fr.add(buton_p);
		
		fr.setVisible(true);
		}
		
		
	public void InsertDaily()
	{
		date_p.removeAll();
		fr.add(date_p);
		fr.add(oc_p);
		fr.add(buton_p);
		
		fr.setVisible(true);
		ok.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				 time=Time.valueOf(time_hr.getText()+":"+time_min.getText()+":00");
				 try
				{
				PreparedStatement prs;
				prs=connection.con.prepareStatement("INSERT INTO daily (time,ocation) VALUES(?,?)");
				prs.setTime(1,time);
				prs.setString(2,ocation.getText());
				prs.execute();
				connection.con.close();
			}catch(SQLException se)
			{
				System.err.println(se);
			}
			
			JOptionPane.showMessageDialog(null,"Iserted Successully");
			new mainf();
			fr.dispose();
			test=true;
			}
		});
		cancel.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				new mainf();
				fr.dispose();
				}
			}
			);
		fr.setVisible(true);
	
		}
	
	
	public static void main (String[] args) {
		InsertEntries a=	new InsertEntries();
		a.InsertIntoOnce();
}
}
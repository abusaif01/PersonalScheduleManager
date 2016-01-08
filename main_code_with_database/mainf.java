import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.BoxLayout;
import java.io.*;
import javax.swing.border.*;
public class mainf
{
	InsertEntries insertData;
	JFrame main_frame=new JFrame("Mini-Ps");
	Container main_container = main_frame.getContentPane();
	JPanel menu_pane=new JPanel();
		void main_menu()
		{
			
			menu_pane.setLayout(new GridLayout());
		//	menu_pane.setBackground(Color.BLUE);

			JMenuBar menu_bar=new JMenuBar();
			JMenu newentry,tool,help;
			menu_pane.add(menu_bar);

			newentry=new JMenu("New Entry");
			JMenuItem daily,weakly,monthly,yearly,once;

			daily =new JMenuItem("Daily");
			daily.addActionListener(new ActionListener(){
			public	void actionPerformed(ActionEvent a)
			{
				//add a action;
				insertData=new InsertEntries();
				insertData.InsertDaily();
				main_frame.dispose();
			//	addingDataInFrame();
				}
			});
		/*
			weakly =new JMenuItem("Weakly");
			weakly.addActionListener(new ActionListener(){
			public	void actionPerformed(ActionEvent a)
			{
				//add a action;
				JOptionPane.showMessageDialog(null,"under construction");
				}
			}); */

			monthly =new JMenuItem("Monthly");
			monthly.addActionListener(new ActionListener(){
			public	void actionPerformed(ActionEvent a)
			{
				//add a action;
				insertData=new InsertEntries();
				insertData.InsertMonthly();
				main_frame.dispose();
				}
			});


			yearly =new JMenuItem("Yearly");
			yearly.addActionListener(new ActionListener(){
			public	void actionPerformed(ActionEvent a)
			{
				//add a action;
				insertData=new InsertEntries();
				insertData.InsertYealy();
				main_frame.dispose();
				}
			});

			once =new JMenuItem("Once");
			once.addActionListener(new ActionListener(){
			public	void actionPerformed(ActionEvent a)
			{
				//add a action;
				insertData=new InsertEntries();
				insertData.InsertIntoOnce();
				main_frame.dispose();
				}
			});
			menu_bar.add(newentry);

			newentry.add(daily);
		//	newentry.add(weakly);
			newentry.add(monthly);
			newentry.add(yearly);
			newentry.add(once);

			tool=new JMenu("Tool");
			menu_bar.add(tool);
			JMenuItem cngclr,cngtxclr;
			cngclr=new JMenuItem("Change Color");
			cngclr.addActionListener(new ActionListener(){
			public	void actionPerformed(ActionEvent a)
			{
				//add a action;
				JOptionPane.showMessageDialog(null,"under construction");
				}
			});
			tool.add(cngclr);
			cngtxclr=new JMenuItem("Change Text Color");
			cngtxclr.addActionListener(new ActionListener(){
			public	void actionPerformed(ActionEvent a)
			{
				//add a action;
				JOptionPane.showMessageDialog(null,"under construction");
				}
			});
			tool.add(cngtxclr);

			help=new JMenu("HELP");
			menu_bar.add(help);
			JMenuItem hwus,abt;
			hwus=new JMenuItem("How To Use");
			hwus.addActionListener(new ActionListener(){
			public	void actionPerformed(ActionEvent a)
			{
				//add a action;
				JOptionPane.showMessageDialog(null,"under construction");
				}
			});
			help.add(hwus);

			abt=new JMenuItem("About Mini_PS");
			abt.addActionListener(new ActionListener(){
			public	void actionPerformed(ActionEvent a)
			{
				//add a action;
				JOptionPane.showMessageDialog(null,"under construction");
				}
			});
			help.add(abt);

			addingDataInFrame();					
			}
			
			
			//
			public void addingDataInFrame()
			{
				
				JPanel east,west,centr,contain_upcomming;
				east=new JPanel();
				east.setBackground(new Color(161, 203, 235));
				west=new JPanel();
				west.setBackground(new Color(161, 203, 235));
				centr= new JPanel();
				centr.setBackground(new Color(200, 203, 235));
//				centr.setLayout();
				TitledBorder br=new TitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED,Color.green,Color.RED),"Upcomming  Activities",TitledBorder.CENTER,TitledBorder.CENTER,new Font("Algerian", Font.ITALIC, 20),Color.RED);
				Box bForHd=Box.createHorizontalBox();
				JPanel heading=new JPanel(new FlowLayout());
				JLabel today=new JLabel("this day int the history");
				today.setFont( new Font("Algerian", Font.ITALIC, 25));
				TitledBorder br1=new TitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED,Color.green,Color.RED),"about this day",TitledBorder.CENTER,TitledBorder.CENTER,new Font("Algerian", Font.ITALIC, 10),Color.RED);
				
				today.setBorder(br1);
				JLabel txa0=new JLabel();
				ImageIcon iic= new ImageIcon("Saif.PNG");
				System.out.println (iic.getDescription());
				Icon ic=iic;
			//	txa0.setIcon(ic);			
				Font font = new Font("Algerian", Font.ITALIC, 30);
				bForHd.add(txa0);
				bForHd.add(Box.createHorizontalStrut(80));
				bForHd.add(today);
			//	txa0.setFont(font);
			//	txa0.setForeground(Color.BLUE);
				//System.out.println (s.toString());
				contain_upcomming=new JPanel();
				////creating object for getting todays data;
				
				
				GetDataFromTodayForGui todayData=new GetDataFromTodayForGui();
					int jobs_no= todayData.t_row;

				Box left=Box.createVerticalBox();
				Color bcl=new Color(220, 215, 236);
				for(int i=0;i<jobs_no;i++)
				{
					JPanel p1=new JPanel();
					p1.setBackground(bcl);
					JLabel yhv=new JLabel("You Have : ");
					yhv.setFont(new Font("Imprint MT Shadow",Font.PLAIN,15));
					p1.add(yhv);
					left.add(Box.createVerticalStrut(30));
					left.add(p1);
				
					}
					left.add(Box.createVerticalStrut(30));
			//	left.add(Box.createVerticalStrut(500));

				Box midle=Box.createVerticalBox();
				for(int i=0;i<jobs_no;i++)
				{
					JPanel p2=new JPanel();
					p2.setBackground(bcl);
					JLabel txa1=new JLabel(todayData.model.getValueAt(i,3));
					txa1.setFont(new Font("Copperplate Gothic Light",Font.ITALIC,15));
					txa1.setForeground(new Color(90, 10, 10));
					//txa1.setBackground(Color.BLUE);
					midle.add(Box.createVerticalStrut(30));
					p2.add(txa1);
					midle.add(p2);
					}
					midle.add(Box.createVerticalStrut(30));
				Box right=Box.createVerticalBox();

				for(int i=0;i<jobs_no;i++)
				{
					JLabel l=new JLabel("AT :   ");
					l.setFont(new Font("Imprint MT Shadow",Font.PLAIN,15));

					JPanel p=new JPanel();
					p.setBackground(bcl);
					JLabel txa1=new JLabel(todayData.model.getValueAt(i,2));
					txa1.setFont(new Font("Copperplate Gothic Light",Font.PLAIN,15));
					txa1.setForeground(new Color(90, 10, 10));
					p.add(l);
					p.add(txa1);
					right.add(Box.createVerticalStrut(30));
					right.add(p);
					}
					right.add(Box.createVerticalStrut(30));
				//	right.add(Box.createVerticalStrut(500));
					Box top=Box.createHorizontalBox();
					top.setBorder(br);
					top.add(left);
					top.add(Box.createHorizontalStrut(40));
					top.add(midle);	
					top.add(Box.createHorizontalStrut(45));
					top.add(right);
					JScrollBar scbr=new JScrollBar();
				//	top.add(scbr);
				main_frame.setVisible(false);
					centr.removeAll();
					centr.add(bForHd);
					centr.add(top);
			//	JPanel dttm =new JPanel(new GridLayout());
			//	main_frame.r
				main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				main_frame.setSize(600,800);
				main_frame.setLocation(200,0);
				main_frame.setLayout(new BorderLayout());
				main_frame.add(menu_pane,BorderLayout.NORTH);			
				main_frame.add(east,BorderLayout.EAST);
				main_frame.add(west,BorderLayout.WEST);
				main_frame.add(centr,BorderLayout.CENTER);
				main_frame.setVisible(true);
			//	while(true)
				
				}
			
			
			public mainf()
			{
				main_menu();
				}

			public static void main (String[] args) {

				new mainf();
			
}



		}
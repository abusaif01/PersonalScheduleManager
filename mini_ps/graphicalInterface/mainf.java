import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class mainf
{
	JFrame main_frame=new JFrame("Mini-Ps");
	Container main_container = main_frame.getContentPane();
	void make_frame()
	{
		main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main_frame.setSize(500,500);
		main_frame.setLocation(200,100);
		main_frame.setVisible(true);
		}


		void main_menu()
		{
			JPanel menu_pane=new JPanel();
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
				JOptionPane.showMessageDialog(null,"under construction");
				}
			});

			weakly =new JMenuItem("Weakly");
			weakly.addActionListener(new ActionListener(){
			public	void actionPerformed(ActionEvent a)
			{
				//add a action;
				JOptionPane.showMessageDialog(null,"under construction");
				}
			});

			monthly =new JMenuItem("Monthly");
			monthly.addActionListener(new ActionListener(){
			public	void actionPerformed(ActionEvent a)
			{
				//add a action;
				JOptionPane.showMessageDialog(null,"under construction");
				}
			});


			yearly =new JMenuItem("Yearly");
			yearly.addActionListener(new ActionListener(){
			public	void actionPerformed(ActionEvent a)
			{
				//add a action;
				JOptionPane.showMessageDialog(null,"under construction");
				}
			});

			once =new JMenuItem("Once");
			once.addActionListener(new ActionListener(){
			public	void actionPerformed(ActionEvent a)
			{
				//add a action;
				JOptionPane.showMessageDialog(null,"under construction");
				}
			});
			menu_bar.add(newentry);

			newentry.add(daily);
			newentry.add(weakly);
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

			
				JPanel east,west,centr;
				east=new JPanel();
				east.setBackground(Color.BLACK);
				west=new JPanel();
				west.setBackground(Color.BLACK);
				centr= new JPanel();
				centr.setLayout(new GridLayout(6,1));
				JLabel txa0=new JLabel("Upcomming  Activities");
				txa0.setForeground(Color.RED);
				JLabel txa1=new JLabel("act: one time: date");
				JLabel txa2=new JLabel("act: two time: date");
				JLabel txa3=new JLabel("act: three time: date");
				JLabel txa4=new JLabel("act: four time: date");
				JLabel txa5=new JLabel("act: five time: date");
				
				centr.add(txa0);
				centr.add(txa1);
				centr.add(txa2);
				centr.add(txa3);
				centr.add(txa4);
				centr.add(txa5);
				
				
				
			//	JPanel dttm =new JPanel(new GridLayout());
				JTextArea txa=new JTextArea("Date: dd-mm-yy       time:- hr:min am/pm");
				txa.setBackground(Color.GRAY);
				txa.setEditable(false);
				//dttm.add(txa) ;
				main_frame.setLayout(new BorderLayout());		
				main_frame.add(txa,BorderLayout.SOUTH);
				main_frame.add(menu_pane,BorderLayout.NORTH);
				main_frame.add(east,BorderLayout.EAST);
				main_frame.add(west,BorderLayout.WEST);
				main_frame.add(centr,BorderLayout.CENTER);
			}


			public static void main (String[] args) {

				mainf ab=new mainf();
				ab.main_menu();
				ab.make_frame();
}



		}
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class window extends JFrame //implements ActionListener
{
		JLabel L1,L2,L3;
		JTextField T1,T2,T3;
		JButton B1,B2,B3,B4;
	public window()
	{
		super ("test Frame");
		Container con=getContentPane();
		setLayout(new GridLayout(6,2));
		L1=new JLabel("number1");
		con.add(L1);
		T1=new JTextField(10);
		con.add(T1);
		L2=new JLabel("number2");
		con.add(L2);
		T2=new JTextField(15);
		con.add(T2);
		L3=new JLabel("sum");
		con.add(L3);
		T3=new JTextField(10);
		con.add(T3);
		T3.setEditable(false);


		B1=new JButton("saif");

		B1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
						//JOptionPane.showMessageDialog(null,"be happy");
						JOptionPane.showMessageDialog(null,"sukhe thako");
				}
			}
		);
		B2=new JButton("afreen");
		//con.add(B2);
		B2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent f)
			{
				JOptionPane.showMessageDialog(null,"valo thako");
				}
			});
		B4=new JButton("sum");
		con.add(B4);
		B4.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent l)
			{
			String s1,s2;
			int n1,n2;
			s1=T1.getText();
			n1=Integer.parseInt(s1);

			s2=T2.getText();
			n2=Integer.parseInt(s2);
			int sum;
			sum=n1+n2;
			T3.setText(Integer.toString(sum));

			}
				});



		B3=new JButton("Exit");
		con.add(B3);
		B3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
						System.exit(0);
				}
			}
		);
		con.add(B1);
		con.add(B2);

		setSize(300,400);
		setLocation(50,100);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}


		public static void main(String arg[])
		{
			new window();
			}


	}
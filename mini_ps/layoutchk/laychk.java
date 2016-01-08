import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class laychk extends JFrame
{
	public laychk()
	{
		super("test");
		Container con=getContentPane();
		JButton b1,b2,b3,b4;
		JTextField t1,t2,t3,t4;
		b1=new JButton("1");
		b2=new JButton("2");
		b3=new JButton("3");
		b4=new JButton("4");

		t1=new JTextField(14);
		t2=new JTextField(14);
		t3=new JTextField(14);
		t4=new JTextField(14);
		con.add(b1);
		con.add(t1);
		con.add(b2);
		con.add(t2);
		con.add(b3);
		con.add(t3);
		con.add(b4);
		con.add(t4);

		GroupLayout gl=new GroupLayout(con);
		con.setLayout(gl);
		gl.setAutoCreateContainerGaps(true);
		gl.setAutoCreateGaps(true);
		GroupLayout.SequentialGroup hor= gl.createSequentialGroup();
		hor.addGroup(gl.createParallelGroup().addComponent(b1));
		hor.addGroup(gl.createParallelGroup().addComponent(t1));
		gl.setHorizontalGroup(hor);
		GroupLayout.SequentialGroup vr=gl.createSequentialGroup();
		vr.addGroup(gl.createParallelGroup().addComponent(b1));
		vr.addGroup(gl.createParallelGroup().addComponent(t1));
	//	vr.addGroup(gl.createParallelGroup().addComponent(b3).addComponent(t3));
		gl.setVerticalGroup(vr);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,300);
		setLocation(50,100);
		setVisible(true);
		}

		public static void main (String[] args) {
			new laychk();
}

	}
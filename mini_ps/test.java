import javax.swing.JOptionPane;

public class test
{
	public static void main (String[] args)
		{
			int num;
			//num=5;
			//System.out.println("the num is :"+num);
			//String keyboard;
			//keyboard=JOptionPane.showInputDialog("input integer");
			//num=Integer.parseInt(keyboard);
			//JOptionPane.showMessageDialog(null, "massage", "error", JOptionPane.ERROR_MESSAGE);
			//JOptionPane.showMessageDialog(null, "massage", "informatio", JOptionPane.INFORMATION_MESSAGE);
			//JOptionPane.showMessageDialog(null, "massage", "wrnning", JOptionPane.WARNING_MESSAGE);
			//JOptionPane.showMessageDialog(null, "massage", "quistion", JOptionPane.QUESTION_MESSAGE);
			JOptionPane.showMessageDialog(null, "massage", "normal", JOptionPane.PLAIN_MESSAGE);

			Object[] options={"ok","cancel","wait"};
			num=JOptionPane.showConfirmDialog(null,"select one","hudai",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.WARNING_MESSAGE);
			System.out.println ("num is "+num);
			num=JOptionPane.showOptionDialog(null, "Click OK to continue", "Warning",JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,null, options, options[0]);
			
			//JOptionPane


			}
	}
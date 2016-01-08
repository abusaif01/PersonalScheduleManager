import java.io.*;
import javax.swing.*;
class frame
{			
	JFrame  fr=new JFrame("input panel");

	}

public class wrokwithfile
{
	public static void main (String[] args) {		
		
		try
		{
		RandomAccessFile fl=new RandomAccessFile("file.txt","rws");
		
		fl.close();
		}
		catch(IOException ex)
		{
			System.out.println ("erooe");
			}
}
	}
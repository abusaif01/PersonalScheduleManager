import java.io.*;
import java.util.*;
public class read_multiple_line
{
	public static void main(String arg[])
	{
		try{
			RandomAccessFile ffl=new RandomAccessFile("file_read_multiple_line.txt","rws");
			long len=ffl.length();
			System.out.println("The length of the file : "+len);
			String line=ffl.readLine();
			//System.out.println ("the first line : "+line);
			line=ffl.readLine();
			System.out.println ("the first line : "+line);
		//	ffl.
			
			ffl.close();
			}
			catch(IOException er)
			{
				System.out.println ("error .........");
				}
		}
	}
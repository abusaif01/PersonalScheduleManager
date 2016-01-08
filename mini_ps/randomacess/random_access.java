import java.io.*;
import java.util.*;
public class random_access
{
	static String sen;
	public static void main(String arg[])
	{
		try
		{
			RandomAccessFile fl=new RandomAccessFile("file_r.txt","rws");

			long len=fl.length();
			System.out.println ("the length of the file is : "+len);
			long pointer=fl.getFilePointer();
			System.out.println ("pointer pos::"+pointer);
			String lin;
			while((lin=fl.readLine())!=null)
			{
				System.out.println (lin);
				System.out.println ("code runnig");
				}
			
			fl.seek(len);
			//this read.   read the next char from the ponter.
			System.out.println ("give the string to be written");
			String str;
			Scanner sc=new Scanner(System.in);
			str=sc.nextLine();
			fl.writeChars(str);
			XMLUtils ut=new XMLUtils();
			fl.close();
			}
			catch(IOException e)
			{
				System.out.println("Error");
				}
		}
	}